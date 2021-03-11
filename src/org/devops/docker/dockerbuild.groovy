
```
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
```