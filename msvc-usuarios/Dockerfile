FROM openjdk:11.0.13-jdk
#dentro del dockerfile estamos en la raiz del proyecto

#carpeta de trabajo, ahora copiamos el pom de msvc-usuarios(build.gradle
WORKDIR /app/msvc-usuarios

#se copiara en la carpeta app que es estructura base de las imagenes
            #/ruta en nuestra maquina local   #. ruta en la imagen/contenedor

#desde curso-kubernetes copiamos el pom.xml a la carpeta app
COPY ./pom.xml /app

#desde la raiz curso-kubernetes copiamos el proyecto completo, desde la raiz (./
COPY ./msvc-usuarios/.mvn ./.mvn
# o ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar/app
COPY ./msvc-usuarios/mvnw .

COPY ./msvc-usuarios/pom.xml .

#compilamos
#empaque sin el codigo fuente y skipea los tests
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

#copia la carpeta src en la imagen docker
COPY ./msvc-usuarios/src ./src

RUN ./mvnw clean package -DskipTests

#el puerto de la app es el 8001
EXPOSE 8001

#levantar la app cuando se le velanta un contenedor, busca un entry poiny
#comandos separados por coma
#estamos en la raiz ./
ENTRYPOINT ["java", "-jar", "./target/msvc-usuarios-0.0.1-SNAPSHOT.jar"]


