cd ../dubbo-api
call mvn clean install -Dmaven.test.skip=true

cd ../dubbo-service
call mvn clean install -Dmaven.test.skip=true

cd ../dubbo-provider
call mvn clean install -Dmaven.test.skip=true

cd ../dubbo-consumer
call mvn clean install -Dmaven.test.skip=true
pause