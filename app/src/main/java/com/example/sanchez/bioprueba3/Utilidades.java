package com.example.sanchez.bioprueba3;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.UUID;

// -----------------------------------------------------------------------------------
// @author: Jordi Bataller i Mascarell
// -----------------------------------------------------------------------------------
/**
 * @brief Clase Utilidades que contiene métodos estáticos para la manipulación de datos
 * como conversiones entre cadenas, bytes y UUIDs.
 */
public class Utilidades {

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Convierte un String en un arreglo de bytes.
     *
     * @param texto: String que se va a convertir.
     * @return byte[]: arreglo de bytes que representa el String.
     */
    public static byte[] stringToBytes(String texto) {
        return texto.getBytes();
        // byte[] b = string.getBytes(StandardCharsets.UTF_8); // Ja
    } // ()

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Convierte un String en un UUID.
     *
     * @param uuid: String que representa un UUID en formato hexadecimal (16 caracteres).
     * @return UUID: objeto UUID resultante.
     * @throws Error: si la longitud del string no es 16 caracteres.
     */
    public static UUID stringToUUID(String uuid) {
        if (uuid.length() != 16) {
            throw new Error("stringUUID: string no tiene 16 caracteres ");
        }
        byte[] comoBytes = uuid.getBytes();

        String masSignificativo = uuid.substring(0, 8);
        String menosSignificativo = uuid.substring(8, 16);
        UUID res = new UUID(Utilidades.bytesToLong(masSignificativo.getBytes()),
                Utilidades.bytesToLong(menosSignificativo.getBytes()));

        return res;
    } // ()

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Convierte un UUID en un String.
     *
     * @param uuid: objeto UUID que se va a convertir.
     * @return String: representación en cadena del UUID.
     */
    public static String uuidToString(UUID uuid) {
        return bytesToString(dosLongToBytes(uuid.getMostSignificantBits(),
                uuid.getLeastSignificantBits()));
    } // ()

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Convierte un UUID en un String hexadecimal.
     *
     * @param uuid: objeto UUID que se va a convertir.
     * @return String: representación en cadena hexadecimal del UUID.
     */
    public static String uuidToHexString(UUID uuid) {
        return bytesToHexString(dosLongToBytes(uuid.getMostSignificantBits(),
                uuid.getLeastSignificantBits()));
    } // ()

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Convierte un arreglo de bytes en un String.
     *
     * @param bytes: byte[] que se va a convertir.
     * @return String: representación en cadena de los bytes.
     */
    public static String bytesToString(byte[] bytes) {
        if (bytes == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append((char) b);
        }
        return sb.toString();
    } // ()

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Convierte dos longitudes en un arreglo de bytes.
     *
     * @param masSignificativos: long que representa la parte más significativa.
     * @param menosSignificativos: long que representa la parte menos significativa.
     * @return byte[]: arreglo de bytes que representa ambos longitudes.
     */
    public static byte[] dosLongToBytes(long masSignificativos, long menosSignificativos) {
        ByteBuffer buffer = ByteBuffer.allocate(2 * Long.BYTES);
        buffer.putLong(masSignificativos);
        buffer.putLong(menosSignificativos);
        return buffer.array();
    } // ()

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Convierte un arreglo de bytes en un entero.
     *
     * @param bytes: byte[] que se va a convertir.
     * @return int: representación entera de los bytes.
     */
    public static int bytesToInt(byte[] bytes) {
        return new BigInteger(bytes).intValue();
    } // ()

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Convierte un arreglo de bytes en un long.
     *
     * @param bytes: byte[] que se va a convertir.
     * @return long: representación larga de los bytes.
     */
    public static long bytesToLong(byte[] bytes) {
        return new BigInteger(bytes).longValue();
    } // ()

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Convierte un arreglo de bytes en un entero con control de errores.
     *
     * @param bytes: byte[] que se va a convertir.
     * @return int: representación entera de los bytes.
     * @throws Error: si los bytes son nulos o tienen más de 4 elementos.
     */
    public static int bytesToIntOK(byte[] bytes) {
        if (bytes == null) {
            return 0;
        }

        if (bytes.length > 4) {
            throw new Error("demasiados bytes para pasar a int ");
        }
        int res = 0;

        for (byte b : bytes) {
            res = (res << 8) // * 16
                    + (b & 0xFF); // para quedarse con 1 byte (2 cuartetos) de lo que haya en b
        } // for

        if ((bytes[0] & 0x8) != 0) {
            // si tiene signo negativo (un 1 a la izquierda del primer byte
            res = -(~(byte) res) - 1; // complemento a 2 (~) de res pero como byte, -1
        }

        return res;
    } // ()

    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------
    /**
     * @brief Convierte un arreglo de bytes en un String hexadecimal.
     *
     * @param bytes: byte[] que se va a convertir.
     * @return String: representación en cadena hexadecimal de los bytes.
     */
    public static String bytesToHexString(byte[] bytes) {
        if (bytes == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
            sb.append(':');
        }
        return sb.toString();
    } // ()
} // class
