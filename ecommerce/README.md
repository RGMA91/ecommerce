## Demo de precio de producto de comercio electrónico
<hr>

### Intro:
El presente proyecto es una aplicación de Spring boot 3.2, compilado con JDK 17 y realizado con Java hasta el nivel 11 (variables locales en lambdas).
 Tal como se solicitó en el fichero con los requerimientos de la prueba técnica, consiste en un endpoint que al ser consultado mediante una petición REST, devuelve como datos de salida el identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar, segun el id del producto, el id de la marca y la fecha de aplicación del precio en la solicitud. Adicionalmente a lo solicitado, se ha agregado un logger a nivel info en la capa controller y a nivel debug en la capa service para poder observar los datos de entrada y salida en la consola.
<hr>

### Acerca de los datos en la BBDD y el formato de las fechas:
Debido a que los datos de los campos de fechas (START_DATE y END_DATE) provistos en el fichero con los requerimientos no están en un formato de fecha standard, estos tuvieron que ser guardados como VARCHAR en la base de datos (se puede observar en el fichero schema.sql). Debido a esto, la query en la capa de repositorio que consulta la base de datos (PriceRepository.java) no puede filtrar según fecha, así que ésta obtiene toda la lista de precios de un producto segun su id e id de marca y luego el filtrado por fecha se ha hecho en la capa de service (PriceServiceImpl.java), el cual consiste en una funcion lambda la cual, para filtrar los valores, recorre la lista de precios obtenida y hace la comparacion con la fecha de aplicacion de entrada y el resultado de la transformacion (hecha con una funcion "formatter" previamente declarada) de la fecha inicial y fecha final obtenida de cada registro de la base de datos, para luego obtener el del prioridad con valor más alto.
<hr>

### Otras notas
* Se ha implementado una clase para tests unitarios para la capa de service y una clase con test de integracion, el cual prueba desde el endpoint del controller y solo "mockea" el repositorio.
* Para el manejo de excepciones custom se ha creado una clase para mensaje de error, una clase para manejar errores con @ControllerAdvice y una clase de excepcion (dentro de exception).
<hr>

### Tests solicitados:

#### Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1:
> **GET** http://localhost:8080/price/2020-06-14T10:00:00/35455/1

#### Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1:
> **GET** http://localhost:8080/price/2020-06-14T16:00:00/35455/1

#### Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1:
> **GET** http://localhost:8080/price/2020-06-14T21:00:00/35455/1

#### Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1:
> **GET** http://localhost:8080/price/2020-06-15T10:00:00/35455/1

#### Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1:
> **GET** http://localhost:8080/price/2020-06-16T21:00:00/35455/1
<hr>

### Otros tests:

#### Registro no encontrado
> **GET** http://localhost:8080/price/2020-06-14T16:00:00/42/1

