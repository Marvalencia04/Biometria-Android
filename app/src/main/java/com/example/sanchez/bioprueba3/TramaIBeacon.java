package com.example.sanchez.bioprueba3;

import java.util.Arrays;

// -----------------------------------------------------------------------------------
// @author: Jordi Bataller i Mascarell
// -----------------------------------------------------------------------------------
import java.util.Arrays;

/**
 * @brief Clase que representa una trama iBeacon, que contiene información para la comunicación Bluetooth.
 *
 * Esta clase se utiliza para almacenar y gestionar datos específicos de un iBeacon,
 * como el prefijo, UUID, major, minor, y otros parámetros relacionados.
 */
public class TramaIBeacon {
    private byte[] prefijo = null;      // 9 bytes
    private byte[] uuid = null;         // 16 bytes
    private byte[] major = null;        // 2 bytes
    private byte[] minor = null;        // 2 bytes
    private byte txPower = 0;           // 1 byte
    private byte[] losBytes;             // Datos crudos recibidos

    private byte[] advFlags = null;     // 3 bytes
    private byte[] advHeader = null;    // 2 bytes
    private byte[] companyID = new byte[2]; // 2 bytes
    private byte iBeaconType = 0;       // 1 byte
    private byte iBeaconLength = 0;     // 1 byte

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Método que obtiene el prefijo del iBeacon.
     *
     * @return prefijo: byte[] que representa el prefijo del iBeacon.
     */
    public byte[] getPrefijo() {
        return prefijo;
    }

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Método que obtiene el UUID del iBeacon.
     *
     * @return uuid: byte[] que representa el UUID del iBeacon.
     */
    public byte[] getUUID() {
        return uuid;
    }

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Método que obtiene el valor del Major del iBeacon.
     *
     * @return major: byte[] que representa el valor del Major.
     */
    public byte[] getMajor() {
        return major;
    }

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Método que obtiene el valor del Minor del iBeacon.
     *
     * @return minor: byte[] que representa el valor del Minor.
     */
    public byte[] getMinor() {
        return minor;
    }

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Método que obtiene el valor de txPower del iBeacon.
     *
     * @return txPower: byte que representa el nivel de potencia de transmisión.
     */
    public byte getTxPower() {
        return txPower;
    }

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Método que obtiene los bytes crudos de la trama.
     *
     * @return losBytes: byte[] que contiene los datos crudos recibidos.
     */
    public byte[] getLosBytes() {
        return losBytes;
    }

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Método que obtiene las banderas de publicidad del iBeacon.
     *
     * @return advFlags: byte[] que representa las banderas de publicidad.
     */
    public byte[] getAdvFlags() {
        return advFlags;
    }

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Método que obtiene el encabezado de publicidad del iBeacon.
     *
     * @return advHeader: byte[] que representa el encabezado de publicidad.
     */
    public byte[] getAdvHeader() {
        return advHeader;
    }

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Método que obtiene el ID de la compañía del iBeacon.
     *
     * @return companyID: byte[] que representa el ID de la compañía.
     */
    public byte[] getCompanyID() {
        return companyID;
    }

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Método que obtiene el tipo de iBeacon.
     *
     * @return iBeaconType: byte que representa el tipo de iBeacon.
     */
    public byte getiBeaconType() {
        return iBeaconType;
    }

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Método que obtiene la longitud de la trama iBeacon.
     *
     * @return iBeaconLength: byte que representa la longitud de la trama.
     */
    public byte getiBeaconLength() {
        return iBeaconLength;
    }

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Constructor de la clase TramaIBeacon.
     *
     * @param bytes byte[] que contiene los datos crudos recibidos del iBeacon.
     */
    public TramaIBeacon(byte[] bytes) {
        this.losBytes = bytes;

        prefijo = Arrays.copyOfRange(losBytes, 0, 8 + 1); // 9 bytes
        uuid = Arrays.copyOfRange(losBytes, 9, 24 + 1);   // 16 bytes
        major = Arrays.copyOfRange(losBytes, 25, 26 + 1); // 2 bytes
        minor = Arrays.copyOfRange(losBytes, 27, 28 + 1); // 2 bytes
        txPower = losBytes[29];                             // 1 byte

        advFlags = Arrays.copyOfRange(prefijo, 0, 2 + 1);  // 3 bytes
        advHeader = Arrays.copyOfRange(prefijo, 3, 4 + 1); // 2 bytes
        companyID = Arrays.copyOfRange(prefijo, 5, 6 + 1); // 2 bytes
        iBeaconType = prefijo[7];                           // 1 byte
        iBeaconLength = prefijo[8];                         // 1 byte
    } // ()
} // class





