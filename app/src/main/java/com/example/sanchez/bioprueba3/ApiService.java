package com.example.sanchez.bioprueba3;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
/**
 * @brief Interfaz ApiService para definir los endpoints de la API de gases.
 */
public interface ApiService {

    /**
     * @brief Verifica el estado del servidor.
     *
     * @return Call<ResponseBody>: llamada a la respuesta del servidor.
     */
    @GET("/api/gases")  // Asegúrate de que esta ruta sea válida en tu API
    Call<ResponseBody> checkServerStatus();

    /**
     * @brief Envía datos a la API.
     *
     * @param dato: objeto Dato que se va a enviar.
     * @return Call<Dato>: llamada con el objeto Dato.
     */
    @POST("/api/gases")  // Cambiar a la ruta correcta
    Call<Dato> subirDato(@Body Dato dato);
} // interface

