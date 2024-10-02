package com.example.sanchez.bioprueba3;

// Clase modelo que representa los datos que enviarás
public class Dato {
    private String gas;
    private double valor;
    private String hora;
    private String lugar;

    // Constructor
    public Dato(String gas, double valor, String hora, String lugar) {
        this.gas = gas;
        this.valor = valor;
        this.hora = hora;
        this.lugar = lugar;
    }

    // Getters y setters
    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
