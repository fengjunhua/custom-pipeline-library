package org.devops

/*
1.下载普通代码,参数说明:
gitRepoUrl:gitlab远程仓库名称,branchName:分支名称,credentialsId:jenkins中配置的下载私钥值。
*/
def checkoutCode(gitRepoUrl,branchName,credentialsId){

    checkout([$class: 'GitSCM', branches: [[name: "${branchName}"]],
              doGenerateSubmoduleConfigurations: false,
              extensions: [], submoduleCfg: [],
              userRemoteConfigs: [[credentialsId: "${credentialsId}",
                                   url: "${gitRepoUrl}"]]])

}

/*
2.下载具有git子模块的代码,参数说明:
gitRepoUrl:gitlab远程仓库名称,branchName:分支名称,credentialsId:jenkins中配置的下载私钥值。
*/
def checkoutCodeSubmodule(gitRepoUrl,branchName,credentialsId){

    checkout([$class: 'GitSCM', branches: [[name: "${branchName}"]],
              doGenerateSubmoduleConfigurations: false,
              extensions: [[$class: 'CleanBeforeCheckout'],
                           [$class: 'SubmoduleOption', disableSubmodules: false, parentCredentials: true,
                            recursiveSubmodules: true, reference: '', timeout: 3, trackingSubmodules: false]],
              submoduleCfg: [],
              userRemoteConfigs: [[credentialsId: "${credentialsId}",
                                   url: "${gitRepoUrl}"]]])

}

/*
3.下载具有目录关联关系的代码,参数说明:
gitRepoUrl:gitlab远程仓库名称,branchName:分支名称,credentialsId:jenkins中配置的下载私钥值。
*/
def checkoutCodeRelative(gitRepoUrl,branchName,credentialsId,RelativeDirectory){

    checkout([$class: 'GitSCM', branches: [[name: "${branchName}"]],
              doGenerateSubmoduleConfigurations: false,
              extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: "${RelativeDirectory}"]],
              submoduleCfg: [],
              userRemoteConfigs: [[credentialsId: "${credentialsId}",
                                   url: "${gitRepoUrl}"]]])

}
