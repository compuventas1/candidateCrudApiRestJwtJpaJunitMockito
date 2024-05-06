# candidateCrudApiRestJwtJpaJunitMockito

<!-- ===============================================-->
<!--  Guia de instalación y configuración    -->
<!-- ===============================================-->

Crear la base de datos en mysql reto_codificacion.

Ejecutar los siguiente scripts de inicialización o tambien puede ser ejecutado automáticamente con flyway al momento de levantar la api.
    
    CREATE TABLE candidates (
    id INT NOT NULL AUTO_INCREMENT,
    name varchar(255),
    email varchar(255),
    gender varchar(255),
    salary_expected varchar(255),
    PRIMARY KEY (id)
    );

	INSERT INTO candidates (id, name, email, gender, salary_expected) VALUES
	(1, 'Juan Garcia','jgarcia@gmail.com','Masculino','1300'),
	(2, 'Carlos Aravena','caravena@gmail.com','Masculino','1100'),
	(3, 'Ricardo Mogollon','rmogollon@hotmail.com','Masculino','2300'),
	(4, 'Fredy Zapata','fzapata001@outlook.com','Masculino','1750'),
	(5, 'Carmen Prado','cprado@gmail.com','Femenino','1900');

Ejecutar ambos scripts por separado.

Realizar un clean install para que descargue los repositorios maven desde el pom.xml.

De preferencia poner la configuración de maven la carpeta m2 en el diso C:\.m2 para que no tenga conflictos de permisos al descargar o espacio de disco.

Levantar el proyecto con IntelliJ en mi caso en opciones de arranque Run as Maven y poner comando spring-boot:run en mi caso estoy usando JDK20.
    y apache-maven-3.9.3-bin

Una vez el proyecto este levantado utilizar postman para testear las apis.

Utilizo 2 tipos de apis la primera localhost:8080/user para obtener el token.
    
    POST http://localhost:8080/user

    En la pestaña Body en postman poner Key user, Value jerjes luego Key password, value pwd, ojo poner los parámetros
        con esos nombres.

	Me genera un token de authenticacion en JSON 
	{
		"user": "jerjes",
		"token": "Bearer  eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJKV1QiLCJzdWIiOiJqZXJqZXMiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNzE0OTc2NTI2LCJleHAiOjMwODY5NTc3NDc1OH0.wr8nr_yWmlb5to0isomOeSNF-cEidQTc4n-30CBiOGRdy1Mdf5ixml8qrREqEWDwqpYHYvYaHhorvQ_SN5XT6A"
	}

Una vez obtenido el token paso a testear las apis.

    GET http://localhost:8080/api/candidates/listar 
    
    En la pestaña Headers de postman ingreso en Key Authorization y en value el valor del token generado arriba
        lo mismo se tendrá que poner a todas las apis, el token esta configurado para vencer en 1 hora.

	POST http://localhost:8080/api/candidates/registrar
		{
			"id": 7,
			"name": "Andres García",
			"email": "rgarcia@gmail.com",
			"gender": "Masculino",
			"salaryExpected": "1200"
		}
	
	GET http://localhost:8080/api/candidates/obtenerPorId/7
	
	PUT http://localhost:8080/api/candidates/modificar
		{
			"id": 7,
			"name": "Andres Garcia Huamanga",
			"email": "agarcia2024@gmail.com",
			"gender": "Masculino",
			"salaryExpected": "1500"
		}
	
	DELETE http://localhost:8080/api/candidates/eliminar/6


Luego para poder visualizar la documentación de la api escribimos lo siguiente en el navegador.
    
    http://localhost:8080/swagger-ui/index.html

Finalmente revisamos los test unitarios con Junit y Mockito me dirijo a la carpeta Test en la parte inferior del proyecto y busco el archivo
    Service01ImplTest selecciono el archivo y doy click derecho Run Service01ImplTest o sino lo ejecuto con cobertura Run Service01ImplTest with Coverage.
	