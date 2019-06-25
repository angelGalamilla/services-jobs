# Proyecto de administracion de Jobs de Control-M

## About

Proyecto encargado de gestionar la jobs de Control-M

## Stack tecnologico

- Java 1.8+
- Maven 3.5+
- Spring boot 2.1.2.RELEASE+
- Lombok abstraction 1.18.4+
- JPA 2+
- Swagger 2 API para documentacion 2.9.2+
- REST API model validation 
- Junit and Spring Boot test para pruebas de integracion


## Pre-requisitos
- Tener instalado jdk 1.8+ y tener ambientada la variable JAVA_HOME
- Tener instalado maven 3.5+ y tener ambientada la variable de M2_HOME

## Ejecucion de aplicacion
Para poder ejecutar la aplicacion lo podemos hacer 3 formas

### IDE
Puede ejecutar una aplicación Spring Boot desde su IDE como una aplicación Java. Sin embargo, lo primero que se tiene que hacer es importar el proyecto al IDE. Los pasos de importación pueden varíar según el IDE . La mayoría de los IDE pueden importar proyectos de Maven directamente. Ejemplo, los usuarios de Eclipse pueden seleccionar __Import…​ → Existing Maven Projects from the File__.

Despues de haber importado el proyecto debemos dar click derecho sobre el proyecto y seleccionar __run as ->Spring Boot app__ 

### Plugin de Maven
Para despleguar con el plugin de maven tenemos que ejecutar el siguiente comando dentro de la carpeta principal del proyectos

```sh
$ mvn spring-boot:run
```

### Aplicación empaquetada(jar)
Lo primero que tenemos que hacer el compilar la aplicación 

```sh
$ mvn clean install
```

Ahora tenemos que ejecutar el siguiente comando para iniciar la aplicación

```sh
$ java -jar .\target\jobServices-1.0.0-SNAPSHOT.jar
```

#### Ejemplo de Rest. 
~~~~
@RequestMapping(method = RequestMethod.GET, produces = "application/json"
	,value={"/getAllAlerts"})
    @ResponseBody
    @ApiOperation(value = "view the list of ALL current active created stored appllication items", response = ApplicationEntry.class)
    public List<ApplicationEntry> getAllAlerts() {
        log.debug("Trying to retrieve all alerts");
        return applicationService.getApplicationItems();

    }
~~~~

#### Ejemplo de Excepción. 
~~~~
@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create a client into the application ")
	public Void createClient(@RequestBody Client client) {
		throw new BusinessException(5);
		return clienteDb;
	}

RESPUESTA HTTP
   {
	  "status": 5,
	  "errorMessage": "Name required"
	}
~~~~
`Ejemplo de invocación a un error de negocio, se genero un BusinessException que se encargará de que todas las excepciones de negocio se envuelvan en un HTTP 409 que indica un conflicto en el servicio y puede volver a invocarse`

##Archivo de excepciones

TODOS LOS MENSAJES EXCEPCIONES SE DEBEN AGREGAR EN EL ARCHIVO __messages.properties__

~~~~
Messages
messages.jobServices.1= Items not found
messages.jobServices.2= unknown error
messages.jobServices.3= Description business exception
messages.jobServices.4= Description system exception
messages.jobServices.5= Name required
~~~~

#### Ejemplo de pruebas de integracion. 
~~~~
    @Test
    public void contextLoads() {
        assertTrue(template.getForEntity("/actuator/health", String.class).getStatusCode().is2xxSuccessful());
    }

~~~~
