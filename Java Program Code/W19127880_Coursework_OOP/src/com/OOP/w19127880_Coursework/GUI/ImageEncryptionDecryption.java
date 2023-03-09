package com.OOP.w19127880_Coursework.GUI;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ImageEncryptionDecryption {
    /*Title: Java String Encryption Decryption Example
    Author: Ramesh Fadatare
    Date: 29/12/2022
    Code Version: 1.0
    Availability: https://www.javaguides.net/2020/02/java-string-encryption-decryption-example.html*/
    private static SecretKeySpec secretKey;// key to be formed into a byte array
    private static byte[] key;//constant to define the algorithm used in the process
    private static final String ALGORITHM = "AES";//secret to be used for encryption using "AES Algorithm"

    public void prepareSecretKey(String myKey){
        //secret key is prepared for encryption and decryption processes
        MessageDigest sha = null;
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
    public byte[] encrypt(BufferedImage image, String secret) {
        try {
            prepareSecretKey(secret);//prepare key with method call
            Cipher cipher = Cipher.getInstance(ALGORITHM);//set the algorithm
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            baos.flush();
            byte[] imageInByteArray = baos.toByteArray();
            baos.close();

            return cipher.doFinal(imageInByteArray);
        } catch (Exception exception) {//exception handler for unexpected error occurrences
        }
        return null;
    }

    public BufferedImage decrypt(byte[] encryptedImage, String secret) {
        try {
            prepareSecretKey(secret);//prepare key with method call
            Cipher cipher = Cipher.getInstance(ALGORITHM);//set the algorithm
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decryptedImage = cipher.doFinal(encryptedImage);
            return ImageIO.read(new ByteArrayInputStream(decryptedImage));
        } catch (Exception exception) {//exception handler for unexpected error occurrences
        }
        return null;
    }

}
