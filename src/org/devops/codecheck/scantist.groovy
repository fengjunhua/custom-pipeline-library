/*
1.执行代码检查
*/


def scantist(){


    sh """
         
        export SCANTISTTOKEN=e588a1b7-2962-4043-bf1d-01eb586ce128
        export SCANTIST_IMPORT_URL=http://100.5.6.58:8237/ci-scan/
        java -jar /opt/scantist/scantist-bom-detect.jar
    
    """



}