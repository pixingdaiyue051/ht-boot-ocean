cd ../../ssm/
cd ocean-api
call mvn clean install -Dmaven.test.skip=true

cd ../boot-assembly
call mvn clean install -Dmaven.test.skip=true

cd ../boot-ssm
call mvn clean install -Dmaven.test.skip=true
pause