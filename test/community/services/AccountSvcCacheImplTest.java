/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package community.services;

import org.junit.Test;
import static org.junit.Assert.*;
import community.domain.*;
import java.util.*;

/**
 *
 * @author dpeterson
 */
public class AccountSvcCacheImplTest {
    
    public AccountSvcCacheImplTest() {
    }

    @Test
    public void testCRUD() {
        
        AccountSvcXmlImpl impl = AccountSvcXmlImpl.getInstance();
        List<Account> accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 0);
        
        Account account = new Account();
        account.setFirstName("John");
        account.setLastName("Doe");
        Login login = new Login();
        login.setUsername("admin");
        login.setPassword("password");
        account.setLogin(login);
        // Test create
        account = impl.create(account);
        assertNotNull(account);
        assertNotEquals(account.getId(), 0);
        // Test retrieveAll
        accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 1);
        // Test update
        account.setFirstName("Jane");
        account = impl.update(account);
        accounts = impl.retrieveAll();
        assertEquals(accounts.size(), 1);
        assertEquals(account.getFirstName(), "Jane");
        // Test delete
        account = impl.delete(account);
        assertEquals(accounts.size(), 0);
        
        // Test Authenticate
        Account account1 = new Account();
        account1.setFirstName("John");
        account1.setLastName("Doe");
        Login login1 = new Login();
        login1.setUsername("jdoe");
        login1.setPassword("password");
        account1.setLogin(login1);
        account1 = impl.create(account1);
        assertNotNull(account1);
        
        Account account2 = new Account();
        account2.setFirstName("Jane");
        account2.setLastName("McDoe");
        Login login2 = new Login();
        login2.setUsername("jmcdoe");
        login2.setPassword("drowssap");
        account2.setLogin(login2);
        account2 = impl.create(account2);
        assertNotNull(account2);
        
        Login login3 = new Login();
        login3.setUsername("yoda");
        login3.setPassword("force");
        Account authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);
        login3.setUsername("jdoe");
        authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);
        login3.setPassword("password");
        authenticatedAccount = impl.authenticate(login3);
        assertNotNull(authenticatedAccount);
        
        login3.setUsername("jmcdoe");
        authenticatedAccount = impl.authenticate(login3);
        assertNull(authenticatedAccount);
        login3.setPassword("drowssap");
        authenticatedAccount = impl.authenticate(login3);
        assertNotNull(authenticatedAccount);
        
        
    }
    
}
