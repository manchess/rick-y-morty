## Prueba - Consumiendo API de Rick y Morty
Este repositorio contiene una aplicación que consume la API de Rick y Morty utilizando tecnologías de Spring. A continuación, se describen los pasos necesarios para ejecutar la aplicación en tu entorno local.

### Requisitos previos
Antes de comenzar, asegúrate de tener instalados los siguientes elementos en tu sistema:

* Java Development Kit (JDK) 11 o superior
* Maven

### Pasos para ejecutar la aplicación
### 1. Clonar el repositorio:

Clona este repositorio en tu máquina local utilizando el siguiente comando:

```
  git clone https://github.com/manchess/rick-y-morty.git
```

### 2. Navegar al directorio del proyecto:

Accede al directorio de la aplicación que has clonado:

```
cd prueba
```

### 3. Compilar y empaquetar la aplicación:

Utiliza Maven para compilar y empaquetar la aplicación en un archivo JAR ejecutable:

```
mvn clean package
```
### 4. Ejecutar la aplicación:

Una vez que el proceso de empaquetado haya finalizado, puedes ejecutar la aplicación usando el siguiente comando:

```
java -jar target/prueba-1.0.jar
```
### 5. Acceder a la aplicación:

La aplicación estará disponible en ***http://localhost:9001***. Puedes acceder a diferentes rutas de la API siguiendo la documentación de la API de Rick y Morty.

## Notas adicionales
La aplicación utiliza Spring Boot y Spring Data JPA para gestionar la interacción con la base de datos MySQL.

Lombok se utiliza para simplificar la generación de código boilerplate.
