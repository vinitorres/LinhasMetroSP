package com.example.logonrm.linhasmetrosp.model;

import com.example.logonrm.linhasmetrosp.api.APIUtils;

/**
 * Created by logonrm on 21/06/2017.
 */

public class LinhasMetro {

    private String cor;
    private String numero;
    private String urlImage;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUrlImage() {
        return  APIUtils.URL_BASE_CLIENTE + urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
