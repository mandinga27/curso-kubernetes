FROM openjdk:11.0.13-jdk-slim-buster as builder
#dentro del dockerfile estamos en la raiz del proyecto

#carpeta de trabajo, ahora copiamos el pom de msvc-usuarios(build.gradle
WORKDIR /app/msvc-cursos
#se copiara en la carpeta app que es estructura base de las imagenes
            #/ruta en nuestra maquina local   #. ruta en la imagen/contenedor

#desde curso-kubernetes copiamos el pom.xml a la carpeta app
COPY ./pom.xml /app

#desde la raiz curso-kubernetes copiamos el proyecto completo, desde la raiz (./
COPY ./msvc-cursos/.mvn ./.mvn
# o ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar/app
COPY ./msvc-cursos/mvnw .

COPY ./msvc-cursos/pom.xml .

#compilamos
#empaque sin el codigo fuente y skipea los tests
#RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#con modo offline descarga la dependencia
RUN ./mvnw dependency:go-offline

#copia la carpeta src en la imagen docker
COPY ./msvc-cursos/src ./src

#maven clean elimina carpeta del build
RUN ./mvnw clean package -DskipTests

#aca creamos una imagen a partir de una imagen
FROM openjdk:11.0.13-jdk-slim-buster

WORKDIR /app

COPY --from=builder /app/msvc-cursos/target/msvc-cursos-0.0.1-SNAPSHOT.jar .

#el puerto de la app es el 8001
EXPOSE 8001

#levantar la app cuando se le velanta un contenedor, busca un entry poiny
#comandos separados por coma
#estamos en la raiz ./
ENTRYPOINT ["java", "-jar", "msvc-cursos-0.0.1-SNAPSHOT.jar"]


