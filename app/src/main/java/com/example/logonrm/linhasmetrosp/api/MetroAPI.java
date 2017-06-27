package com.example.logonrm.linhasmetrosp.api;

import com.example.logonrm.linhasmetrosp.model.LinhasMetro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by logonrm on 21/06/2017.
 */

public interface MetroAPI {

    @GET("/linhas")
    Call<List<LinhasMetro>> getLinhas();

}
