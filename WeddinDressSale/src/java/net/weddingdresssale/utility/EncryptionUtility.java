/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.weddingdresssale.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Nargiz
 */
public class EncryptionUtility {
    
 public static String sha1(String input) {
        String hash = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");            
            digest.update(input.getBytes());
            hash = new String(digest.digest());
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        
        return hash;

    }
}

