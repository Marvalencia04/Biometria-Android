package com.example.sanchez.bioprueba3;

import android.util.Log;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubidaDato {

    //private static final String BASE_URL = "http://192.168.1.22:4000/";
    //private static final String BASE_URL = "http://10.236.35.77:4000/";
    //private static final String BASE_URL = "http://host.docker.internal:4000/";
    private static final String BASE_URL = "http://192.168.75.193:4000/";
    private ApiService apiService;
    private Dato dato; // Variable para almacenar el dato que se va a subir

    // Constructor
    public SubidaDato() {
        // Configurar Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) // Convertidor para JSON
                .build();

        // Crear la implementación de la API
        apiService = retrofit.create(ApiService.class);
    }

    // Método para subir un dato
    public void SubirDato(Dato dato) {
        Call<Dato> call = apiService.subirDato(dato);

        // Ejecutar la petición de manera asíncrona
        call.enqueue(new Callback<Dato>() {
            @Override
            public void onResponse(Call<Dato> call, Response<Dato> response) {
                if (response.isSuccessful()) {
                    Log.d("SubidaDato", "Dato enviado correctamente.");
                } else {
                    Log.e("SubidaDato", "Error en la respuesta: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Dato> call, Throwable t) {
                Log.e("SubidaDato", "Error en la petición: " + t.getMessage());
            }
        });
    }


    // Método para comprobar la conexión
    public String ComprobarConexion() {
        final String[] responseMessage = {null}; // Array para almacenar el mensaje de respuesta

        Call<ResponseBody> call = apiService.checkServerStatus();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.d("ComprobarConexion", "Conexión exitosa. El servidor está en línea.");
                    responseMessage[0] = "Conexión exitosa. El servidor está en línea.";
                } else {
                    Log.e("ComprobarConexion", "Error en la conexión: " + response.code());
                    responseMessage[0] = "Error en la conexión: " + response.code();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("ComprobarConexion", "Error en la petición: " + t.getMessage());
                responseMessage[0] = "Error en la petición: " + t.getMessage();
            }
        });

        return responseMessage[0]; // Retorna el mensaje de respuesta
    }
}
