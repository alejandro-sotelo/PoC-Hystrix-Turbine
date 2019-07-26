# Spring Boot Chasis App

Este proyecto contiene la estructura básica para implementar un microservicio utilizando SpringBoot.

## Comenzando

Estas instrucciones le permitirán configurar el proyecto en su máquina local, permitiéndole utilizarlo como base para la construcción de su aplicación. Diríjase a la la sección **Deployment** para conocer cómo desplegar el proyecto.

### Pre-requisitos e instalación

Se recomienda para fines de desarrollo contar con las siguientes herramientas:

- [Java 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Gradle 5.4.1](https://gradle.org/releases/)
- Un IDE para la edición del código

Con el fin de construir y ejecutar la aplicación como un contenedor, se requiere contar con [Docker CE]( https://hub.docker.com/editions/community/docker-ce-desktop-windows)



### Construido con

El proyecto hace uso de las siguientes tecnologías, librerías y/o frameworks:

- [Java v1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Lenguaje de programación
- [Gradle v5.4.1](https://gradle.org/releases/) - Manejador de dependencias
- [SpringBoot v2.1.5.RELEASE](https://spring.io/projects/spring-boot) Framework de aplicación
- [Tinylog v2.0.0-RC1](https://tinylog.org/v2/) - Manejo de logs
- [Junit 4.12](https://junit.org/junit4/) - Framework para pruebas unitarias

### Arquitectura de referencia

El proyecto hace uso de la arquitectura hexagonal, también conocida como puertos y adaptadores, la estructura de paquetes es la siguiente:
 ```     
   application

   domain
       exception
       model
       port
       service

   infrastructure
       adapter
       configuration
       restcontroller
       apifeatures
 ```

### Deployment

Para descargar el proyecto y utilizarlo como base para su propio proyecto siga los siguientes pasos:

* Descargue el [código del repositorio](https://github.com/alejandro-sotelo/SpringBootChasis.git)
* Importe el proyecto como tipo **Gradle** en su IDE favorito (utilice la versión 5.4.1 o la suministrada en el wrapper)
* Adapte la estructura de paquetes y demás propiedades a las necesidades de su proyecto, verifiqué:
 - paquete general --> co.com.company
 - propiedades del archivo Dockerfile (description, version, manitiner, appUser, port)
 - propiedades del archivo build.gradle (group, version)
 - propiedades del archivo settings.gradle (rootProject.name)

#### Construccion
Para la construcción del proyecto en su ambiente local ejecute los comandos:
 ```
   gradle clean
   gradle build
 ```

#### Ejecución de pruebas
Para la ejecución de los test del proyecto en su ambiente local ejecute:
 ```
   gradle test
 ```

Para la generación del reporte de cobertura de las pruebas ejecute:

 ```
   gradle jacocoTestReport
 ```
 *Nota: Una vez ejecutado el anterior comando, el reporte de cobertura lo encontrará en **build/test-results/jacocoHtml/index.html**.*

#### Generación de artefactos (JAR y POM)
El despliegue y la generación de artefactos pueden realizarse de manera manual o de manera automática (haciendo uso de alguna herramienta de IC como Jenkins).

* Para el primer caso:
   - Ejecute los comandos para la **construcción del proyecto**
   - Ejecute los comandos para la **ejecución de pruebas del proyecto**
   - A continuación ejecute:

     ```
     gradle createPom
     ```

Una vez realizado lo anterior, proceda a realizar la carga de los artefactos (JAR y POM) al repositorio de artefactos, tenga presente que deberá gestionar el control de versiones al momento de realizar la carga al repositorio de artefactos, los artefactos generados se ubicaran en la carpeta **build/libs/**.

#### Despliegue de la aplicación como JAR

Para ejecutar la aplicación fuera de su IDE, una vez generado el JAR, desde su línea de comandos, ubíquese en la carpeta **build/libs/** y ejecute:


```    
 java -jar microservice-chasis-1.0.0.jar
```

*Nota: reemplace **microservice-chasis-1.0.0.jar** por el nombre y la versión definida para su aplicación*

#### Generación de artefactos (Imagen Docker)
Para la generación de la imagen de Docker realicé lo siguiente:

- Ejecute los comandos para la **construcción del proyecto**
- Ejecute los comandos para la **ejecución de pruebas del proyecto**
- A continuación ejecute:

```
 gradle moveBootExplodedLib
```

Este comando prepará su aplicación (el JAR) en una estructura de carpetas, lo que permitirá aprovechar al máximo la cache y el manejo de capas de docker.

Una vez preparada la aplicación, se deberá proceder a generar la imagen, para esto:

- Verifique que Docker este corriendo en su máquina
- Desde la línea de comandos, ubíquese en el directorio raíz de la aplicación, donde se encuentra el archivo Dockerfile
- A continuación ejecute:

```
 docker build -t nombre-de-la-imagen:tag .
```

*Nota: reemplace **nombre-de-la-imagen:tag** por el nombre y la versión o TAG definido para la imagen de su aplicación*

#### Despliegue de la aplicación como contenedor
Para ejecutar la aplicación a partir de la imagen generada en el ítem anterior ejecute:

```
 docker run -p 8080:8080 nombre-de-la-imagen:tag
```
*Nota: reemplace **nombre-de-la-imagen:tag** por el nombre y la versión o TAG definido para la imagen de su aplicación, así como los puertos utilizados*

### Guia de Estilo

Por convención para la codificación se hace uso de las guías de estilo definidas para Java y para la definición de nombres de paquetes, clases, métodos, atributos y demás elementos se hace uso del idioma inglés.

### Versionado

Para el versionamiento se hace uso de [SemVer](https://semver.org/lang/es/).

### Autores
Al desarrollo de este proyecto han contribuido:

* **Alejandro Sotelo** - alejandrosotelo.ie@gmail.com