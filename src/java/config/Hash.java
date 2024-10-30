/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author joels
 */
public class Hash {
    
    public static String encriptar(String clave){
        String clave1 = sha256(clave);
        String clave2 = AES(clave1);
        return clave2;
    }
    
    public static String sha256(final String base) {
    try{
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        final byte[] hash = digest.digest(base.getBytes("UTF-8"));
        final StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            final String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) 
              hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    } catch(Exception ex){
       throw new RuntimeException(ex);
        }
    }

     public static SecretKeySpec CrearCalve(String llave) {
        try {
            byte[] cadena = llave.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(cadena, "AES");
            return secretKeySpec;
        } catch (Exception e) {
            return null;
        }

    }

    // Encriptar
    public static String AES(String encriptar) {
        String LLAVE = "SomosProgramadores";
        try {
            SecretKeySpec secretKeySpec = CrearCalve(LLAVE);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] cadena = encriptar.getBytes("UTF-8");
            byte[] encriptada = cipher.doFinal(cadena);
            String cadena_encriptada = Base64.getEncoder().encodeToString(cadena);
            return cadena_encriptada;

        } catch (Exception e) {
            return "";
        }
    }
}
