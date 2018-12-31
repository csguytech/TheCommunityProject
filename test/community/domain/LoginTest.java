/*
 * CS479 - Ethical Leadership in Computer Science
 * @author Derick Peterson
 */
package community.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
    
    public LoginTest() {
    }

    @Test
    public void testValidate() {
        Login login = new Login();
        boolean result = login.validate();
        assertFalse(result);
        login.setUsername("admin");
        result = login.validate();
        assertFalse(result);
        login.setPassword("password");
        result = login.validate();
        assertTrue(result);
    }
    
    @Test
    public void testEquals() {
        Login login1 = new Login();
        login1.setUsername("jdoe");
        login1.setPassword("password");
        
        Login login2 = new Login();
        login2.setUsername("jbuck");
        login2.setPassword("drowssap");
        
        assertFalse(login1.equals(login2));
        login2.setUsername("jdoe");
        assertFalse(login1.equals(login2));
        login2.setPassword("password");
        assertTrue(login1.equals(login2));
    }
}
