Archivo README de configuracion.

Proyecto Dockerizado
Para correr el proyecto en un servidor de docker es necesario aplicar el siguiente comando en la ruta donde se clone el proyecto.
- docker compose -f  docker-compose.yml up

NOTA:
    Cuando se ejecute el comando, el servidor levantará el proyecto de Spring y la base de datos de MySQL
si el proyecto no se ejecuta, eso se debe a que el proyecto se levanta antes que la base de datos y por lo tanto el proyecto de spring se detiene.
por lo tanto se debe ntrar al docker desktop, especificamente en el contenedor e iniciar el servicio del proyecto de spring.
