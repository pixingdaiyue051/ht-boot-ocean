cd ../tequeno-base-api
call mvn clean install -Dmaven.test.skip=true

cd ../tequeno-api
call mvn clean install -Dmaven.test.skip=true

cd ../tequeno-jdbc-service
call mvn clean install -Dmaven.test.skip=true

cd ../tequeno-redis-service
call mvn clean install -Dmaven.test.skip=true

cd ../tequeno-service
call mvn clean install -Dmaven.test.skip=true

cd ../tequeno-view
call mvn clean install -Dmaven.test.skip=true
pause