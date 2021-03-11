
/*
1.设置当前构建记录的名称currentBuild.displayName
*/
def setCurrendBuildDisplayName(PROJECT_NAME,SERVICE_NAME){
    
    currentBuild.displayName = "#" + BUILD_NUMBER + " 项目名称：" + PROJECT_NAME + " 服务名称: " + SERVICE_NAME

}

/*
2.设置当前构建记录的描述currentBuild.description
*/

def setCurrendBuildDescription(BRANCH_NAME){
    
    currentBuild.description = "分支名称: " + BRANCH_NAME

}

/*
3.获取当前项目构建时间.
 */
def getBuildTime(){
    def build_time = new Date().format("yyyyMMddHHmm")
    return build_time
}

def getLabel(PROJECT_NAME){
    
    return label
}