@Library('custom-pipeline-library@develop') _

def checkoutCode = new org.devops.git.checkoutCode()


String GIT_REPO_URL = "git@192.101.10.9:"+"${PROJECT_NAME}"+"/${SERVICE_NAME}"+".git"
String GIT_DEVOPS_URL = "git@192.101.10.9:"+"${PROJECT_NAME}"+"/${PROJECT_NAME}"+"-devops.git"


node("devops-jenkins-S102"){
      
      stage("checkout code"){

         log.info("下载代码!")
         utils.setCurrendBuildDisplayName(PROJECT_NAME,SERVICE_NAME)
         utils.setCurrendBuildDescription(BRANCH_NAME)

         //1.下载项目代码
         checkoutCode.checkoutCode(GIT_REPO_URL,BRANCH_NAME,"fengjunhua")

         //2.下载项目代码
         sh "mkdir -p devops-tools"
         checkoutCode.checkoutCodeRelative(GIT_DEVOPS_URL,"master","fengjunhua","devops-tools")

      }
      
      stage("build"){

         log.info("执行项目构建！")
         sh """
         cd ${COMPONENT_NAME}
         sh compile.commands
         """

      }
      
      stage("codesafe"){

         log.info("打包项目到代码安全审计平台!")
         codesafe (
            audit: true, 
            excludedDir: '', 
            excludedFile: '', 
            language: [
              $class: 'Java', 
              bugTemplate: [pkTemplate: 18], 
              checkBug: true, 
              checkReference: false, 
              checkStandard: false, 
              hasBugAim: false, 
              hasStandardAim: false, 
              isJ2ee: 'Y', 
              jdkVersion: 4, 
              pjType: [$class: 'MavenProject']
            ], 
            mybug: false, 
            pjPermOther: false, 
            useOwnServerCredentials: false, 
            waitForResults: false,
            
            credentialsId: 'devops-codesafe', 
            projectName: "${serviceName}",
            projectDesc: 'mirsp代码审计', 
            pjLeader: 'fengjunhua',
            pjPermUserList: 'guodashuang'
          )
        
      }

      stage("scantist"){

         log.info("打包项目到代码安全审计平台!")

         sh """
         export SCANTISTTOKEN=e588a1b7-2962-4043-bf1d-01eb586ce128
         export SCANTIST_IMPORT_URL=http://100.5.6.58:8237/ci-scan/
         java -jar /opt/scantist/scantist-bom-detect.jar
         """

      }

      stage("sonnar"){

         log.info("执行sonar代码扫描!")
         def scanHome = "/opt/soft/sonar-scanner"
         
         sh """
         cd post-oss
         ${scanHome}/bin/sonar-scanner -Dsonar.projectKey=${serviceName}  \
                -Dsonar.projectName=${serviceName} \
                -Dsonar.projectDescription='cpsdcdevops' \
                -Dsonar.sources=.  \
                -Dsonar.sourceEncoding=UTF-8 \
                -Dsonar.language=java \
                -Dsonar.java.binaries=target/classes \
                -Dsonar.java.coveragePlugin=jacoco  \
                -Dsonar.jacoco.reportPath=target/jacoco.exec \
                -Dsonar.junit.reportsPath=target/surefire-reports \
                -Dsonar.surefire.reportsPath=target/surefire-reports 

         """
      }
      
      stage("docker"){

         def ImageName = "192.101.10.113/mirsp/post-oss:${BUILD_ID}"
         
         sh """
         cd post-oss
      
         docker build -t ${ImageName} .
         docker push ${ImageName}
         docker rmi ${ImageName}
         """
         
         /*
         script {
              docker.withServer('tcp://192.101.11.192:2375') {
              def myImage = docker.build("192.101.10.113/mirsp/post-oss:${BUILD_ID}","./post-oss/")
                  docker.withRegistry("http://192.101.10.113","docker.harbor"){
                   myImage.push()
                  }
              }  
         }
         */
      }

      stage("deploy"){
      
         log.info("执行项目部署!")
         sh """

         ansible k8s-manager -m script  -a "/root/shell-scripts/service-deploy.sh -O deploy -P mirsp -S mirsp-oss -T ${BUILD_ID}"
         
         """

      }
      
 }