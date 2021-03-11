package org.nexus

import groovy.json.*
/*
1.查询并获取nexus中所有的仓库名称
*/
def getAllRepository(NEXUS_URL){ 
    log.info("获取nexus所有的仓库名称!")
    response = httpRequest consoleLogResponseBody: true, quiet: true,
               wrapAsMultipart: false ,
               contentType: 'APPLICATION_JSON', responseHandle: 'NONE', 
               url: "${NEXUS_URL}/service/rest/v1/repositories"                  
    def jsonSlurper = new JsonSlurper()
    def JsonObject = jsonSlurper.parseText(response.content)
    def Item_List =[]
    for(item in JsonObject){          
        Item_List << item.name
    }   
    return Item_List
}

/*
2.根据nexus仓库名称,以及项目的group名称查询包的相信信息
*/