<b>En database</b>

docker image build -t jcabelloc/postgres .

docker container run -it -p 5432:5432 jcabelloc/postgres

<b>En configuration server</b>

set ENCRYPT_KEY=MUYSECRETO

mvn spring-boot:run

<b>En servicioprestamo</b>

mvn spring-boot:run

<b>En lugar de usar "mvn spring-boot:run" se ejecuta directamente el archivo jar generado por maven</b>

mvn clean package

java -Dspring.cloud.config.uri=http://localhost:8888 -Dspring.profiles.active=desa -jar target/servicio-prestamo-0.0.1-SNAPSHOT.jar
