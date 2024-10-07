package com.example.sanchez.bioprueba3;
import android.util.Log;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @brief Clase encargada de gestionar la subida de datos al servidor y comprobar la conexión.
 *
 * Esta clase utiliza Retrofit para realizar peticiones HTTP hacia un servidor. Permite subir
 * datos de tipo Dato y comprobar si el servidor está en línea.
 */
public class SubidaDato {

    // URL base del servidor (cambiar según sea necesario)
    //private static final String BASE_URL = "http://192.168.1.22:4000/";
    //private static final String BASE_URL = "http://10.236.35.77:4000/";
    //private static final String BASE_URL = "http://host.docker.internal:4000/";
    private static final String BASE_URL = "http://192.168.75.193:4000/";
    private ApiService apiService;  // Servicio API configurado con Retrofit
    private Dato dato;              // Variable para almacenar el dato que se va a subir

    /**
     * @brief Constructor de la clase SubidaDato.
     *
     * Configura la instancia de Retrofit para la comunicación con el servidor
     * y crea la implementación del servicio de la API.
     */
    public SubidaDato() {
        // Configurar Retrofit con la URL base y un convertidor JSON
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())  // Convertidor para transformar objetos Java en JSON
                .build();

        // Crear la implementación de la API con Retrofit
        apiService = retrofit.create(ApiService.class);
    }

    /**
     * @brief Método para subir un dato al servidor.
     *
     * Este método realiza una petición POST asíncrona utilizando Retrofit para
     * enviar un objeto Dato al servidor.
     *
     * @param dato Objeto de tipo Dato que contiene la información a subir.
     */
    public void SubirDato(Dato dato) {
        // Crear la llamada HTTP para subir el dato
        Call<Dato> call = apiService.subirDato(dato);

        // Ejecutar la llamada de manera asíncrona
        call.enqueue(new Callback<Dato>() {
            @Override
            public void onResponse(Call<Dato> call, Response<Dato> response) {
                if (response.isSuccessful()) {
                    // Si la respuesta es exitosa, loguea un mensaje de éxito
                    Log.d("SubidaDato", "Dato enviado correctamente.");
                } else {
                    // Si hay un error en la respuesta, muestra el código de error
                    Log.e("SubidaDato", "Error en la respuesta: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Dato> call, Throwable t) {
                // Si la petición falla, muestra el mensaje de error
                Log.e("SubidaDato", "Error en la petición: " + t.getMessage());
            }
        });
    }

    /**
     * @brief Método para comprobar el estado de la conexión con el servidor.
     *
     * Este método realiza una petición GET para verificar si el servidor está en línea.
     *
     * @return Mensaje que indica si la conexión fue exito+sa o fallida.
     */
    public String ComprobarConexion() {
        final String[] responseMessage = {null};  // Array para almacenar el mensaje de respuesta

        // Crear la llamada HTTP para verificar el estado del servidor
        Call<ResponseBody> call = apiService.checkServerStatus();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    // Si la respuesta es exitosa, loguea que el servidor está en línea
                    Log.d("ComprobarConexion", "Conexión exitosa. El servidor está en línea.");
                    responseMessage[0] = "Conexión exitosa. El servidor está en línea.";
                } else {
                    // Si hay un error, muestra el código de error
                    Log.e("ComprobarConexion", "Error en la conexión: " + response.code());
                    responseMessage[0] = "Error en la conexión: " + response.code();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // Si la petición falla, muestra el mensaje de error
                Log.e("ComprobarConexion", "Error en la petición: " + t.getMessage());
                responseMessage[0] = "Error en la petición: " + t.getMessage();
            }
        });

        return responseMessage[0];  // Retorna el mensaje de respuesta
    }
}
