/*
 * (C) 2018 Derick Peterson, All rights reserved
 * Unauthorized duplication or distriubution without
 * the author's permission is strictly forbidden.
 * 
 * CS479 - Ethical Leadership in Computer Science
 */
package community.domain;

import community.EncryptionMgr;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.annotation.*;

@XmlRootElement (name = "Login")
@XmlAccessorType(XmlAccessType.FIELD)
public class Login {
    @XmlAttribute
    private String username;
    
    @XmlAttribute
    private String password;

    /**
     * getUsername() returns username
     * @return String username
     */
    public String getUsername() {
        return username;
    }

    /**
     * setUsername(String) sets username to String
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * getPassword() returns password
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setPassword(String) sets password to md5 hashed String
     * @param password
     */
    public void setPassword(String password) {
        EncryptionMgr mgr = new EncryptionMgr();
        String md5Password = null;
        try {
            md5Password = mgr.md5(password);
        } catch (NoSuchAlgorithmException e) {
            System.out.print("NoSuchAlgorithm");
        } catch (UnsupportedEncodingException e){
            System.out.print("UnsupportedEncoding");
        }
        
        this.password = md5Password;
    }
    
    /**
     * equals(Object) validates Object to Login object
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (! (obj instanceof Login)) return false;
        Login login = (Login)obj;
        if (!this.username.equals(login.getUsername())) return false;
        if (!this.password.equals(login.getPassword())) return false;
        return true;
    }
    
    /**
     * validate() verifies that username and password are not null or empty
     * @return boolean
     */
    public boolean validate() {
        if (username == null || username.equals("")) return false;
        if (password == null || password.equals("")) return false;
        return true;
    }
}