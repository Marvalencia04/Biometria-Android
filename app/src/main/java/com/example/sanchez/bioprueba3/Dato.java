package com.example.sanchez.bioprueba3;

// Clase modelo que representa los datos que enviarás
public class Dato {
    private String minor;  // Cambia estos campos según los datos que quieras enviar
    private String otroCampo;

    // Constructor
    public Dato(String minor, String otroCampo) {
        this.minor = minor;
        this.otroCampo = otroCampo;
    }

    // Getters y Setters
    public String getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = String.valueOf(minor);
    }

    public String getOtroCampo() {
        return otroCampo;
    }

    public void setOtroCampo(String otroCampo) {
        this.otroCampo = otroCampo;
    }
}
