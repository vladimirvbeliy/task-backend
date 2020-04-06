# task-backend

DB used - MariaDB

to setup DB:

cd db-docker
docker build -t test .
docker run -p 3308:3306 test

DT payments will be created automatically by flyway script on client ms start

project uses: spring boot, mariadb, docker, hibernate, flyway, open-feign

NOTICE: has no previous experience with XML, so XML-parsing/unmarshalling is far from perfect.
UnitTests were not created to fasten tesk completion
MariaBD was used instead of Postgres just because the same reason  - no experience with usein it, and had troubled when
projcet to docker image with Postgress
Had to update XML file since it vas failing to pass every online XML validator I tried
