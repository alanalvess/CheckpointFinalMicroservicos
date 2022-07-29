## !/bin/bash

echo "docker-compose down"
docker-compose down
echo "docker-compose rm -f"
docker-compose rm -f

echo "building packages before docker img build"
cd gateway
mvn clean package -DskipTests
cd ..
cd catalogService
mvn clean package -DskipTests
cd ..
cd configServer
mvn clean package -DskipTests
cd ..
cd EurekaServer
mvn clean package -DskipTests
cd ..
cd movieService
mvn clean package -DskipTests
cd ..
cd serieService
mvn clean package -DskipTests
cd ..

echo "docker-compose build and up"
docker-compose up -d --build

#echo "docker-compose up"
#docker-compose up