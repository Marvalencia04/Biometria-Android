# Biometria Android
## Descripción

Este proyecto permite la recopilación y envío de datos sobre diferentes tipos de gases a un servidor a través de una API REST. La aplicación está diseñada para dispositivos móviles, utilizando Retrofit para manejar las solicitudes HTTP. Se enfoca en la recopilación de información en tiempo real, lo que puede ser útil para monitorear la calidad del aire y realizar análisis relacionados.

## Problema que Resuelve

En muchos entornos, es crucial monitorear la calidad del aire y los niveles de diferentes gases. Este proyecto proporciona una solución sencilla y eficaz para enviar datos sobre estos gases a un servidor, donde se pueden procesar y analizar. La aplicación permite a los usuarios enviar información sobre el tipo de gas, su valor, el lugar y la hora de la medición.

## Instrucciones de Instalación

1. Clona el repositorio:
git clone https://github.com/tu_usuariotu_repositorio.git
cd tu_repositorio

2. Abre el proyecto en tu IDE preferido (por ejemplo, Android Studio).

3. Asegúrate de tener las dependencias necesarias en tu archivo build.gradle:
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

4. Para el funcionamiento correcto de la subida de datos se debera cambiar la URL,IP y UID a los correspondientes.

5. Se debera añadir el IP a network_security_config.xml en caso de que el servidor no sea HTTPS.

6. Se deberan otorgar los permisos de ubicacion y Bluetooth a la aplicacion.

