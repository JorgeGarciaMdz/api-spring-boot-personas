# Api de Personas
Backend de curso Java y Spring Boot.

## Documentación
Se implementa **Swagger**.

## Correr el Proyecto

###  Ejecución normal
1. Clonar repositorio.
2. Cambiar host, base de datos, usuario y contraseña de base de datos en properties.
3. En la raíz del proyecto ejecutar "**`mvn spring-boot:run`**".

### Ejecución mediante Docker

``Primordial: tener instaldo docker y docker-compose``

1. Clonar el repositorio.
2. En la raíz del proyecto crear la imagen con "**`docker-compose build`**" .
3. Levantar el contenedor con "**`docker-compose up`**".
4. El contenedor del proyecto ya tiene la conexión al contenedor de base de datos con datos.
5. Los puertos `8080 y 3306 no deben` estar en uso.
