package com.example.sanchez.bioprueba3;

/**
 * @brief Clase modelo que representa los datos que serán enviados al servidor.
 *
 * Esta clase encapsula la información relacionada con la medición de gas, como el tipo de gas,
 * el valor medido, la hora en que se tomó la medición y el lugar donde se realizó.
 */
public class Dato {

    private String gas;     // Tipo de gas medido, p.ej. "H2O"
    private double valor;   // Valor de la medición
    private String hora;    // Hora en la que se tomó la medición
    private String lugar;   // Lugar donde se tomó la medición

    /**
     * @brief Constructor de la clase Dato.
     *
     * Inicializa los atributos de la clase con los valores proporcionados.
     *
     * @param gas   Tipo de gas medido (por ejemplo, "H2O").
     * @param valor Valor de la medición del gas.
     * @param hora  Hora exacta de la medición en formato "yyyy-MM-dd HH:mm:ss".
     * @param lugar Lugar donde se realizó la medición.
     */
    public Dato(String gas, double valor, String hora, String lugar) {
        this.gas = gas;
        this.valor = valor;
        this.hora = hora;
        this.lugar = lugar;
    }

    /**
     * @brief Obtiene el tipo de gas medido.
     * @return El tipo de gas como una cadena de texto.
     */
    public String getGas() {
        return gas;
    }

    /**
     * @brief Establece el tipo de gas medido.
     * @param gas El tipo de gas a establecer.
     */
    public void setGas(String gas) {
        this.gas = gas;
    }

    /**
     * @brief Obtiene el valor de la medición.
     * @return El valor de la medición como un número decimal.
     */
    public double getValor() {
        return valor;
    }

    /**
     * @brief Establece el valor de la medición.
     * @param valor El valor de la medición a establecer.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @brief Obtiene la hora en que se realizó la medición.
     * @return La hora de la medición en formato de cadena.
     */
    public String getHora() {
        return hora;
    }

    /**
     * @brief Establece la hora de la medición.
     * @param hora La hora a establecer en formato "yyyy-MM-dd HH:mm:ss".
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @brief Obtiene el lugar donde se realizó la medición.
     * @return El lugar de la medición como una cadena de texto.
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @brief Establece el lugar donde se realizó la medición.
     * @param lugar El lugar de la medición a establecer.
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
