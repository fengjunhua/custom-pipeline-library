import groovy.json.JsonSlurper

/*
1.获取代码审计平台项目部门名称
*/

def getCodeSafeDepartmentName(FILE_PATH,PROJECT_NAME,SERVICE_NAME){

    def jsonString = readFile(FILE_PATH)
    def jsonObject = new JsonSlurper().parseText(jsonString)
    def departmentName = jsonObject.(PROJECT_NAME +"."+ SERVICE_NAME).Department
    
    return departmentName

} 
 
/*
2.获取项目在代码审计平台中配置的项目详细名称
*/
def getCodeSafeProjectName(FILE_PATH,PROJECT_NAME,SERVICE_NAME){

    def jsonString = readFile(FILE_PATH)
    def jsonObject = new JsonSlurper().parseText(jsonString)
    def codeSafeProjectName = jsonObject.(PROJECT_NAME +"."+ SERVICE_NAME).ProjectName
    
    return codeSafeProjectName

}

/*
3.获取项目在代码审计平台中配置的项目详细描述
*/
def getCodeSafeProjectDescription(FILE_PATH,PROJECT_NAME,SERVICE_NAME){

    def jsonString = readFile(FILE_PATH)
    def jsonObject = new JsonSlurper().parseText(jsonString)
    def codeSafeProjectDescription = jsonObject.(PROJECT_NAME +"."+ SERVICE_NAME).Description
    
    return codeSafeProjectDescription

}


/*
4.获取项目在代码审计平台中配置的项目Leader
*/
def getCodeSafeProjectLeader(FILE_PATH,PROJECT_NAME,SERVICE_NAME){

    def jsonString = readFile(FILE_PATH)
    def jsonObject = new JsonSlurper().parseText(jsonString)
    def codeSafeProjectLeader = jsonObject.(PROJECT_NAME +"."+ SERVICE_NAME).ProjectLeader
    
    return codeSafeProjectLeader

}


/*
5.获取项目在代码审计平台中配置的项目组员
*/
def getCodeSafeProjectMembers(FILE_PATH,PROJECT_NAME,SERVICE_NAME){

    def jsonString = readFile(FILE_PATH)
    def jsonObject = new JsonSlurper().parseText(jsonString)
    def codeSafeProjectMembers = jsonObject.(PROJECT_NAME +"."+ SERVICE_NAME).ProjectMembers
    
    return codeSafeProjectMembers

}

/*
6.获取项目在代码审计平台中配置的项目邮件通知列表emailList
*/
def getCodeSafeProjectEmailList(FILE_PATH,PROJECT_NAME,SERVICE_NAME){

    def jsonString = readFile(FILE_PATH)
    def jsonObject = new JsonSlurper().parseText(jsonString)
    def codeSafeProjectEmailList = jsonObject.(PROJECT_NAME +"."+ SERVICE_NAME).EmailList
    
    return codeSafeProjectEmailList

}


/*
7.执行360代码审计平台代码扫描
*/

            
def codesafe(FILE_PATH,PROJECT_NAME,SERVICE_NAME,credentialsId){

    def codeSafeDepartmentName = getCodeSafeDepartmentName(FILE_PATH,PROJECT_NAME,SERVICE_NAME)
    def codeSafeProjectName = getCodeSafeProjectName(FILE_PATH,PROJECT_NAME,SERVICE_NAME)
    def codeSafeProjectDescription = getCodeSafeProjectDescription(FILE_PATH,PROJECT_NAME,SERVICE_NAME)
    def codeSafeProjectLeader = getCodeSafeProjectLeader(FILE_PATH,PROJECT_NAME,SERVICE_NAME)
    def codeSafeProjectMembers = getCodeSafeProjectMembers(FILE_PATH,PROJECT_NAME,SERVICE_NAME)
    def codeSafeProjectEmailList = getCodeSafeProjectEmailList(FILE_PATH,PROJECT_NAME,SERVICE_NAME)



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
            
            credentialsId: "${credentialsId}", 
            projectName: "${codeSafeProjectName}",
            projectDesc: "${codeSafeProjectDescription}", 
            pjLeader: "${codeSafeProjectLeader}",
            pjPermUserList: "${codeSafeProjectMembers}"
          )


}