# Registro Social Backend App

## Requisitos:
- Instalar java versión 17.0.12
- Instalar gradle versión 8.12.0
- Git version 2.35.1
- Sistema Operativo windows 10 (64 bits)
- IntelliJ IDEA versión 11.0.14

## Levantar proyecto:
- Abrir una terminal (cmd)
- Clonar el proyecto con el siguiente comando `git clone https://github.com/ralba97/provincias-app-backend.git`
- Cargar el proyecto desde IntelliJ IDEA instalado previamente
- Ubicarse en la ruta del proyecto clonado y ejecutar en una terminal el comando `gradle clean build` para construir el proyecto
- Una vez construido el proyecto buscar la ruta `provincias-app-backend\build\libs` y ejecutar el comando `java -jar -Dspring.profiles.active=CONSOLA -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8789 provincias-app-backend-0.0.1-SNAPSHOT.jar`, para levantar los servicios web de la API
