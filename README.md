# Java Servlet con JDBC Connector

Práctica con Servlets en Java, muestra la información almacenada en una base de datos *MySQL* sobre alumnos y sus respectivas **asignaturas** y **tutorías**,también se usará un **enlace JAXB** para mostrar el código *XML* de cada alumno si se desea.

Este proyecto se compondrá de los siguientes componentes:
  * _index.jsp_ - Página html principal.
  * _Alumnes.java_ - Clase utilizada para cargar los datos de la BD.
  * _DbDataHandler.java_ - Clase utilizada para manejar la transferencia de datos entre la BD y la aplicación.
  * _DbServlet.java_ - Clase utilizada para manejar las peticiones de _index.jsp_ referentes a la BD.
  * _MySQLConnection.java_ - Clase utilizada para manejar la conexión a la BD.
  * _XmlDataHandler.java_ - Clase utilizada para manejar el código _XML_ de los alumnos.
  * _XmlServlet.java_ - Clase utilizada para manejar las peticiones de _index.jsp_ referentes al _XML_.

###Resumen de funcionamiento

La página principal, *index.jsp*, realizará las peticiones necesarias mediante código *jQuery*. 

Para ello dispone de un método *$(document).ready(function {...});* que ejecutará el código que contiene al cargar la página.

Se incluirá una petición asíncrona al archivo *DbServlet.java*, que contestará con un array de objetos *JSON* conteniendo el listado de alumnos que será usado por *jQuery* para rellenar las opciones de la Combo Box.

Así mismo, se colocará el disparador de cambio de la *Combo Box* mediante el método *$('**id del combo box**').change(function (event) {...});*. Este método realizará una petición asíncrona (*AJAX*) al archivo *DbServlet.java*, que contestará con toda la información del alumno que se seleccione en forma de objeto *JSON*. 

También incluye el disparador de click del botón para obtener el *XML* del alumno seleccionado, mediante el método *$('**id del botón**').click(function (event) {...});*. Este método realizará una petición asíncrona al archivo *XmlServlet.java*, que contestará con una cadena con el código *XML*.
