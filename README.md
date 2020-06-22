# TP-Redes-Cliente-Servidor :sparkles:

## Built With 🛠️

* [Java](https://www.java.com/es/) - The programming language
* [Maven](https://maven.apache.org/) - Dependency Management

### Authors ✒️

* **Ivan Graciarena** - *Initial work* - [ivanmdq22](https://github.com/IGraciarena)
* **Jorge Villordo** - *Initial work* - [georgie](https://github.com/villordo)

## Preguntas TP ⚙️
* 1. ¿Que es un puerto?
Los puertos son asignados por el sistema operativo de tu dispositivo cada vez que un proceso va a hacer un pedido por el internet. Por ejemplo, cuando abres una página web, tu navegador le pide al sistema operativo un puerto para poder recibir la respuesta del pedido que va a enviar.
Un puerto es un numero de 16 bits, por lo que existen 216=65536 numeros de puerto posibles, en cada ordenador.Las aplicaciones  utilizan  estos puertos  para enviar y recibir mensajes.
* 2. ¿Como estan formados los endpoints?
Los EndPoints estan formados por la ip+el puerto.
* 3. ¿Que es un socket?
Socket designa un concepto abstracto por el cual dos programas (posiblemente situados en computadoras distintas) pueden intercambiar cualquier flujo de datos, generalmente de manera fiable y ordenada.
Principio de funcionamiento. Un socket queda definido por un par de direcciones IP local y remota, un protocolo de transporte y un par de números de puerto local y remoto. Para que dos programas puedan comunicarse entre sí es necesario que se cumplan ciertos requisitos: Que un programa sea capaz de localizar al otro.
* 4. ¿A qué capa del modelo TPC/IP pertenecen los sockets? ¿Porque?
Aparte del concepto de puerto,la capa de tranporte, usa el concepto de socket.Los Sockets  son los puntos terminales  de una comunicacion, que pueden ser nombrados y direccionados en una red.Un Socket esta formado por la direccion IP del host y numero de puerto.
* 5. ¿Cómo funciona el modelo cliente-servidor con TCP/IP Sockets?
El TCP/IP y los sockets permiten la comunicaciónentredos aplicaciones de forma local o remota.Las aplicaciones deben establecer la forma en la que van a distribuir el trabajo entre las máquinas participantes.El modelo Cliente-Servidor define la estructura de las aplicaciones comunicantes y su sincronización.Las aplicaciones se dividen en dos partes: El cliente y el servidor.La sincronización se resuelve haciendo que el servidor se ejecute de forma indefinida, esperando al cliente.
* 6. ¿Cuales son las causas comunes por la que la conexión entre cliente/servidor falle?
El cliente no encuentra al servidor: sin solucion, unicamente tratadocon excepciones.
La petici´on del cliente se pierde: no ocurre en entornos TCP. Se retransmite la petici´on tras cierto tiempo. Se deben detectar las peticiones duplicadas en el servidor para descartarlas.
El servidor falla:
** 1. Al recibir la peticion.
** 2. Al procesar la peticion
** 3. Al responder
La respuesta del servidor se pierde: retrasmitir el mensaje del cliente, que el servidor debe identificar para responderle con los resultados previos.
Cliente falla antes de recibir respuesta: peticion huerfana. 
* 7. Diferencias entre sockets UDP y TCP
La principal diferencia entre ambos es que el UDP necesita que le entregemos paquetes de datos que el usuario debe construir, mientras el TCP admite bloques de datos (cuyo tamaño puede ir desde 1 bytes hasta muchos K bytes, dependiendo de la implementación) que serán empaquetados de forma transparente antes de ser transmitidos. 
Existe además otra diferencia importante. Tanto los paquetes de datos UDP como los segmentos TCP (este es el nombre que reciben los paquetes TCP) pueden perderse (muy rara vez llegan al destino correcto con errores). Si un paquete se pierde el UDP no hace nada. Por el contrario, si un segmento se pierde el TCP lo retransmitirá, y este proceso durará hasta que el segmento ha sido correctamente entregado al host receptor, o se produzca un número máximo de retransmisiones. 
Finalmente, en aplicaciones en tiempo real es necesario también tener en cuenta una cosa. En el UDP controlamos qué datos viajan en cada paquete. En el TCP esto no es posible porque el empaquetamiento es automático. De hecho, el TCP espera un tiempo prudencial a tener bastantes datos que transmitir antes de enviar un segmento ya que esto ahorra ancho de banda. Si es importante que los datos tarden el mínimo tiempo posible en llegar al receptor el UDP es la mejor opción. En este sentido se dice que el UDP tiene una menor latencia que el TCP.
* 8. Diferencia entre sync & async sockets?
** Socket sincriono:
-sockets que se bloquean hasta que han recibido toda la información  
-En este tipo de socket, cuando haces una llamada para recibir, por ejemplo, la llamada a la funcion no termina hasta que recibe los datos, esto puede cogelar tu aplicacion.
 Tu aplicación irá ejecutando hasta que espere información, luego de lo cual se detendrá y quedará a la espera de recibir esa información.
** Socket asincrono
-Sockets que no se bloquean y tenemos que ver si nuestro buffer se ha llenado.
En el primer caso(Sincrono), la aplicación se bloquea y no sigue hasta bien reciba toda la información. En el segundo caso(Asincrono), la aplicación sigue y va actuando a medida que recibe la información. Una "dice" ... "espero a recibir la información para seguir", y la otra ... "a medida que llegue la información, me vas avisando".
Las diferencias es que uno es un proceso bloqueante y el otro no. La asincronía es esencial para las actividades que son potencialmente bloqueantes, por ejemplo cuando su aplicación accede a la web.  El acceso a un recurso web a veces es lento o con retrasos.  Si esta actividad está bloqueada dentro de un proceso sincrónico, la aplicación completa debe esperar.  En cambio con un proceso asíncrono, la aplicación puede continuar con otro trabajo que no depende del recurso web hasta que la tarea potencialmente bloqueante o síncrona finaliza.



![Screenshot del ejemplo con Powershell JAR](https://github.com/IGraciarena/TP-Redes-Cliente-Servidor/blob/master/Screenshot%20del%20ejemplo%20con%20Powershell%20JAR.png)
![Screenshot del ejemplo con telnet - JAR.png](https://github.com/IGraciarena/TP-Redes-Cliente-Servidor/blob/master/Screenshot%20del%20ejemplo%20con%20telnet%20-%20JAR.png)
