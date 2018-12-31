/*
 * CS479 - Ethical Leadership in Computer Science
 * @author Derick Peterson
 */
package community.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
    
    public AccountTest() {
    }

    @Test
    public void testValidate() {
        Account account = new Account();
        boolean result = account.validate();
        assertFalse(result);
        account.setFirstName("John");
        result = account.validate();
        assertFalse(result);
        account.setLastName("Doe");
        result = account.validate();
        assertFalse(result);
        Login login = new Login();
        login.setUsername("admin");
        login.setPassword("password");
        account.setLogin(login);
        result = account.validate();
        assertTrue(result);
    }
    
}
