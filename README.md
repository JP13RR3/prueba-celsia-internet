# prueba-celsia-internet
2.2. ¿Qué mecanismos de seguridad incluirías en la aplicación para garantizar la protección del acceso a los datos?

RTA: Recomendaría un login donde las contraseñas cuenten con políticas de combinación de caracteres, que cuenten con un periodo de cambio de contraseña, que el Loguin cuente con un captcha, y autenticación de doble factor.

2.3. ¿Qué estrategia de escalabilidad recomendarías para la aplicación considerando que el crecimiento proyectado será de 1,000,000 de clientes por año?

RTA: Viendo que es un crecimiento grande yo considero que a nivel de infraestructura se debe tener un escalabilidad horizontal, en manejo de datos una base de datos en nube escalable que cuente con una optimización periódica de consultas, y ya a hoy en día se están utilizando y aprovechando mucho los servicios en nube.

2.4. ¿Qué patrón o patrones de diseño recomendarías para esta solución y cómo se implementarían? (Justifique)

RTA:

2.5. ¿Qué recomendaciones harías para optimizar el manejo y la persistencia de datos de la aplicación, teniendo en cuenta que esta aplicación tiene una alta transaccionalidad?

RTA: Seria implementar un plan donde se realicen reconstrucciones de indices, se realicen estadísticas de las tablas, que se escale la data mas vieja en tablas de backup con el fin de disminuir el tiempo de las consultas, programar una tarea para no dejar sesiones inactivas en la DB, optimización de consultas.

3. Redes
3.1. Explica la diferencia entre un router y un switch. ¿Cuándo usarías cada uno?

RTA: La diferencia entre un router y un switch es que el switch nos sirve para conectar multiples dispositivos en una red, como lo pueden ser impresoras, camaras, computadores, servidores y demás, en cambio un router me sirve para crear y establecer una red y conectar diferentes redes entre si.

Es decir un swicth me sirve para conectar dispositivos en una red local y el router para establecer conexión con diferentes redes.

3.2. Describe las siete capas del modelo OSI y menciona brevemente la función principal de cada una

RTA:
Red: Es la que realiza el enrutamiento de los paquetes la cual viaja por una red y uno de sus protocolos es la IPv4.
Sesión: Administra las sesiones de los dispositivos.
Transporte: Aquella que define una ruta confiable de los datos entre dispositivos.
Aplicación: Ya es aquella que interactúa con la aplicación y el cliente final proporcionando diferentes servicios.
Enlace: Aquella que realiza una conexión o enlace en dispositivos locales como lo puede ser en un switch
Presentación: Es aquella que me traduce los datos en el formato que este realizada la aplicación.
Fisica: Es aquella que realiza la conexiones físicas como cables.

3.3. Explica las diferencias entre los protocolos TCP y UDP. Dar un ejemplo de cuándo usarías cada uno?

RTA: Ambos son protocolos que pertenecen a una capa del modelo OSI en transporte de datos la diferencia es que la TCP es mas confiable valida si el destino esta ok para el envió, viaja entre redes por lo cual puede ser un poco mas lenta que la UDP, en cambio la UDP envía los datos sin dan una respuesta de recibido o si el destino esta ok, no es muy seguro y es utilizada en redes locales.

3.4. ¿Qué es una máscara de subred y cómo se utiliza para dividir una red en subredes más pequeñas?

RTA: Una mascara podría decir que es aquella que me define a que red pertenece mi IP ya que van acompañadas, se puede utilizar para dividir redes grandes en redes mas pequeñas, para dividir una red en subredes lo que se hace es utilizar el subneting, con el fin de tomar una red grande y proporcionarle una mascara en especifica a un grupo de IP que esto ayuda mucho en la gestion de dispositivos y tener un mejor manejo de las redes.

3.5. ¿Puedes mencionar algunos protocolos de enrutamiento dinámico y explicar brevemente cómo funcionan?

RTA: