package com.OOP.w19127880_Coursework.GUI;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class NotesEncryptionDecryption {
    /*Title: Java String Encryption Decryption Example
    Author: Ramesh Fadatare
    Date: 29/12/2022
    Code Version: 1.0
    Availability: https://www.javaguides.net/2020/02/java-string-encryption-decryption-example.html*/
    private static SecretKeySpec secretKey;//secret to be used for encryption using "AES Algorithm"
    private static byte[] key;// key to be formed into a byte array
    private static final String ALGORITHM = "AES";//constant to define the algorithm used in the process

    public void prepareSecretKey(String myKey){
        //secret key is prepared for encryption and decryption processes
        MessageDigest sha;
        try{
            key = myKey.getBytes(StandardCharsets.UTF_8);//convert the secret key into byte array
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key,16);
            secretKey = new SecretKeySpec(key, ALGORITHM);
        } catch (NoSuchAlgorithmException exception) {//exception handler for unexpected error occurrences
            exception.printStackTrace();
        }
    }
    public String encrypt(String strToEncrypt, String secret){
        try{
            prepareSecretKey(secret);//prepare key with method call
            Cipher cipher = Cipher.getInstance(ALGORITHM);//set the algorithm
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));//encoding system used in the process
        } catch (Exception exception) {//exception handler for unexpected error occurrences
            System.out.println("Error while decrypting data: "+exception.toString());
        }
        return null;
    }
    public String decrypt(String strToDecrypt, String secret){
        try{
            prepareSecretKey(secret);//prepare key with method call
            Cipher cipher = Cipher.getInstance(ALGORITHM);//set the algorithm
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception exception) {//exception handler for unexpected error occurrences
            System.out.println("Error while decrypting data: "+exception.toString());
        }
        return null;
    }
}
