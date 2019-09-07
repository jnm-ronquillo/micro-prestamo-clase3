#En database
docker image build -t jcabelloc/postgres .

docker container run -it -p 5432:5432 jcabelloc/postgres

#En configuration server
set ENCRYPT_KEY=MUYSECRETO

mvn spring-boot:run

#En servicioprestamo
mvn spring-boot:run

#En lugar de usar "mvn spring-boot:run" se ejecuta directamente el archivo jar generado por maven
mvn clean package

java -Dspring.cloud.config.uri=http://localhost:8888 -Dspring.profiles.active=desa -jar target/servicio-prestamo-0.0.1-SNAPSHOT.jar
