FROM openjdk:11.0.13-jdk

#carpeta de trabajo
WORKDIR /app

#se copiara en la carpeta app que es estructura base de las imagenes
            #/ruta en nuestra maquina local   #. ruta en la imagen/contenedor
COPY ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar .
# o ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar/app

#el puerto de la app es el 8001
EXPOSE 8001

#levantar la app cuando se le velanta un contenedor, busca un entry poiny
#comandos separados por coma
ENTRYPOINT ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]


