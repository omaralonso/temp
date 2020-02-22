# SistemaGestionNegocio  

## Dependencias:  

### Back:  

* Spring Framework 4.3.12.RELEASE
* Hibernate 4.3.11.Final
* mysql-connector-java 5.1.43
* javax.servlet-api 3.1.0
* javax.servlet.jsp-api 2.3.1
* jstl 1.2
* jackson v2.9.2

### Front:  

* Bootstrap 4
* jQuery v3.2.1
* Chart.js

## Demo  

### Usuarios

#### Iniciar sesión
![iniciarsesion](https://user-images.githubusercontent.com/26644850/33000529-a4e57dc0-cd76-11e7-8a65-13d2309bd6c5.PNG)

#### Registrar usuario
![registrarusuario](https://user-images.githubusercontent.com/26644850/33000535-b27765fc-cd76-11e7-89ff-c38a27301508.PNG)

#### Gestionar usuarios
![usuarios](https://user-images.githubusercontent.com/26644850/33000544-ce82beae-cd76-11e7-866a-62a3ccebd3a6.PNG)

#### Perfil usuario
![perfil](https://user-images.githubusercontent.com/26644850/33000587-13e7c6ce-cd77-11e7-97b9-c0b3be15663d.PNG)

#### Actualizar contraseña
![actualizarcontrasena](https://user-images.githubusercontent.com/26644850/33000604-22b43fde-cd77-11e7-8cd4-cc7b07f91b93.PNG)


### Productos

#### Gestionar productos
![productos](https://user-images.githubusercontent.com/26644850/33000799-26668c94-cd78-11e7-951a-7897f45d0a05.PNG)

#### Añadir un producto
![agregarproducto](https://user-images.githubusercontent.com/26644850/33000608-3517669c-cd77-11e7-8afe-5b79c3491996.PNG)

#### Editar un producto
![editarproducto](https://user-images.githubusercontent.com/26644850/33000641-5ce3d098-cd77-11e7-9d21-e7f755b46799.PNG)


### Categorías

#### Gestionar categorías
![categorias](https://user-images.githubusercontent.com/26644850/33000632-51949fec-cd77-11e7-8312-98911c8ff19a.PNG)


## Instrucciones para el team desarrollador:

### Archivos fuente:

* Tener presente la nomenclatura por cada paquete (Ejm: en el paquete pe.com.sunshineandina.service -> ClaseService y ClaseServiceImpl)

* Comentar los métodos (al menos para saber que hace y retorna)

### Para ejecutar la aplicación:

* Ejecutar los scripts de la base de datos (ubicados en la carpeta BD), en el orden indicado por su nombre, utilizando el gestor MySQL

* Tener algun servidor donde poder deployar el .war (Apache Tomcat, JBoss, Glassfish)

* Construir el .war, ya sea con Maven desde línea de comandos o desde un IDE (puede ser cualquiera)

* Deployar el .war en el servidor y arrancar la aplicación (Si se hizo la construcción desde el IDE probablemente ya esté deployado)


&copy; Sunshine Andina S.A.
