cd iou-api
call mvn clean install -Dmaven.test.skip=true

cd ../iou-service
call mvn clean install -Dmaven.test.skip=true

cd ../iou-view
call mvn clean install -Dmaven.test.skip=true
pause