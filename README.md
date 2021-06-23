To run cloud test create file token.properties in dir src/test/java/resources/ and put parameter token= {your mobilecloud token}
### Run Test


###### Native
`mvn clean test -Pnative`
###### Web
`mvn clean test -Pweb`

###### Cloud Android Web
`mvn clean test -PcloudAndroidWeb`
###### Cloud iOs Web
`mvn clean test -PcloudIOSWeb`
###### Cloud Android Native
`mvn clean test -PcloudAndroidNative`
###### Cloud iOs Native
`mvn clean test -PcloudIOSNative`