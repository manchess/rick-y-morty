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




# Documentación de Endpoints - API de Personajes de Rick y Morty

Esta documentación proporciona información sobre los endpoints disponibles en la API.

 A continuación se detallan los endpoints junto con su descripción y ejemplos de uso.

## Tabla de Contenido

1. [Obtener personajes de la API de Rick y Morty](#1-obtener-personajes-de-la-api-externa)
2. [Obtener UN personaje dela API de Rick y Morty](#2-obtener-un-personaje-de-la-api-de-rick-y-morty)
3. [Obtener Personajes Locales](#3-obtener-personajes-locales)
4. [Obtener un Personaje Local por ID](#4-obtener-un-personaje-local-por-id)
5. [Guardar un Personaje Local](#5-guardar-un-personaje-local)
6. [Actualizar un Personaje Local](#6-actualizar-un-personaje-local)
7. [Eliminar un Personaje Local](#7-eliminar-un-personaje-local)

---

## 1. Obtener personajes de la API de Rick y Morty

Endpoint: `GET /api/rm/ext/character`

Descripción: Obtiene una lista de personajes de la serie Rick y Morty.

Parámetros:
- `page` (opcional): Número de página. Valor predeterminado: 1.

Ejemplo de solicitud:

GET `localhost:9001/api/rm/ext/character?page=1`

Respuesta exitosa:

```json
{
    "info": {
    "count": 826,
    "pages": 42,
    "next": "https://rickandmortyapi.com/api/character/?page=2",
    "prev": null
  },
    "results": [ 
        {
            "id": 1,
            "name": "Rick Sanchez",
            "status": "Alive",
            "species": "Human",
            "gender": "Male",
            "origin": {
                "name": "Earth",
                "url": "https://rickandmortyapi.com/api/location/1"
            },
            "image": "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
        }
    ]
}
```

## 2. Obtener UN personaje dela API de Rick y Morty

Endpoint: `GET /api/rm/ext/character/{id}`

Descripción: Obtiene los detalles de un personaje desde la API externa de Rick y Morty utilizando su ID.

Ejemplo de solicitud:

GET `localhost:9001/api/rm/ext/character/1`

Respuesta exitosa:

```json
{
    "id": 1,
    // Detalles del personaje...
}
```

## 3. Obtener Personajes Locales

Endpoint: `GET /api/rm/character`

Descripción: Obtiene una lista de personajes almacenados localmente.

Parámetros:

* **page** (opcional): Número de página. Valor predeterminado: 0.
* **size** (opcional): Tamaño de la página. Valor predeterminado: 3.

Ejemplo de solicitud:

GET `localhost:9001/api/rm/character?page=0&size=3`

Respuesta exitosa:

```json
[
    {
        "id": 1,
        // Detalles del personaje...
    },
    {
        "id": 2,
        // Detalles del personaje...
    },
    // Otros personajes...
]
```

## 4. Obtener un Personaje Local por ID

Endpoint: GET `/api/rm/character/{id}`

Descripción: Obtiene los detalles de un personaje almacenado localmente utilizando su ID.

Ejemplo de solicitud:


GET `localhost:9001/api/rm/character/1`

Respuesta exitosa:

```json
{
    "id": 1,
    // Detalles del personaje...
}
```

## 5. Guardar un Personaje Local

Endpoint: POST `/api/rm/character/{id}`

Descripción: Guarda un personaje localmente utilizando su ID.

Ejemplo de solicitud:


POST `localhost:9001/api/rm/character/1`

Respuesta exitosa:

```json
{
    "id": 1,
    // Detalles del personaje guardado...
}
```

## 6. Actualizar un Personaje Local
Endpoint: PUT `/api/rm/character`

Descripción: Actualiza los detalles de un personaje almacenado localmente.

Ejemplo de solicitud:

PUT `localhost:9001/api/rm/character`

Respuesta exitosa:

```
200 OK
```
