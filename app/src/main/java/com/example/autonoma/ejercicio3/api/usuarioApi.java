package com.example.autonoma.ejercicio3.api;

import com.example.autonoma.ejercicio3.model.Usuario;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface usuarioApi {

    @GET("users")
    Call<List<Usuario>> getALLusuarios();
}
