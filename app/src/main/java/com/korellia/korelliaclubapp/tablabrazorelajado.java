package com.korellia.korelliaclubapp;

public class tablabrazorelajado {

    private String fecha;
    private String medida;




    public void tabla (String fecha, String medida){
        this.fecha=fecha;
        this.medida=medida;

    }

    public String getFecha () {
        return fecha;
    }

    public String getMedida () {
        return medida;

    }


}
