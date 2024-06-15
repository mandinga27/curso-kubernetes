ARG MSVC_NAME=msvc-usuarios

FROM openjdk:17-jdk-alpine as builder
#dentro del dockerfile estamos en la raiz del proyecto

ARG MSVC_NAME

#carpeta de trabajo, ahora copiamos el pom de msvc-usuarios(build.gradle
WORKDIR /app/$MSVC_NAME
#se copiara en la carpeta app que es estructura base de las imagenes
            #/ruta en nuestra maquina local   #. ruta en la imagen/contenedor

#desde curso-kubernetes copiamos el pom.xml a la carpeta app
COPY ./pom.xml /app

#desde la raiz curso-kubernetes copiamos el proyecto completo, desde la raiz (./
COPY ./$MSVC_NAME/.mvn ./.mvn
# o ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar/app
COPY ./$MSVC_NAME/mvnw .

COPY ./$MSVC_NAME/pom.xml .

#compilamos
#empaque sin el codigo fuente y skipea los tests
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

#copia la carpeta src en la imagen docker
COPY ./$MSVC_NAME/src ./src

RUN ./mvnw clean package -DskipTests

#aca creamos una imagen a partir de una imagen
FROM openjdk:17-jdk-alpine

ARG MSVC_NAME

WORKDIR /app

RUN mkdir ./logs

ARG TARGET_FOLDER=/app/$MSVC_NAME/target

COPY --from=builder /app/$MSVC_NAME/target/msvc-usuarios-0.0.1-SNAPSHOT.jar .

ARG PORT_APP=8000
ENV PORT $PORT_APP
#el puerto de la app es el 8001
EXPOSE $PORT

#levantar la app cuando se le velanta un contenedor, busca un entry poiny
#comandos separados por coma
#estamos en la raiz ./
ENTRYPOINT ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]


