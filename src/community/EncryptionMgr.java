/*
 * (C) 2018 Derick Peterson, All rights reserved
 * Unauthorized duplication or distriubution without
 * the author's permission is strictly forbidden.
 * 
 * CS479 - Ethical Leadership in Computer Science
 */

package community;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionMgr {

    /**
     * md5(String) converts a String to md5 Hash
     * @param input
     * @return String md5 Hash Value
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public String md5(final String input) 
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        final MessageDigest md = MessageDigest.getInstance("MD5");
        final byte[] messageDigest = md.digest(input.getBytes("UTF-8"));
        final BigInteger number = new BigInteger(1, messageDigest);
        return String.format("%032x", number);
    }
    
    /**
     * verify(String, String) verifies hash and hashed string match
     * @param hash
     * @param string
     * @return boolean whether hashes match
     */
    public boolean verify(String hash, String string) {
        String md5Password = null;
        try {
            md5Password = md5(string);
        } catch (NoSuchAlgorithmException e) {
            System.out.print("NoSuchAlgorithm");
        } catch (UnsupportedEncodingException e){
            System.out.print("UnsupportedEncoding");
        }
        
        return hash.equals(md5Password);
    }
}