/*
 * (C) 2018 Derick Peterson, All rights reserved
 * Unauthorized duplication or distriubution without
 * the author's permission is strictly forbidden.
 * 
 * CS479 - Ethical Leadership in Computer Science
 */
package community.domain;
import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement( name = "Community")
@XmlAccessorType(XmlAccessType.FIELD)
public class CommunityClass {
    @XmlElement(name = "Accounts")
    private final List<Account> accounts = new LinkedList<>();

    @XmlAttribute
    private int nextId;
    
    /**
     * CommunityClass() - empty constructor
     */
    public CommunityClass() {
    } 
    
    /**
     * addAccount(Account) adds Account to Community
     * @param account
     */
    public void addAccount(Account account) {
        accounts.add(account);
    }
    
    /**
     * deleteAccount(Account) deletes Account from Community
     * @param account
     */
    public void deleteAccount(Account account) {
        if(accounts.contains(account)) {
            accounts.remove(account);
        }
    }
    
    /**
     * getAccounts() returns accounts
     * @return List of accounts
     */
    public List<Account> getAccounts() {
        return accounts;
    }
    
    /**
     * setNextId(int) sets nextId to int
     * @param nextId
     */
    public void setNextId(int nextId) {
        this.nextId = nextId;
    }
    
    /**
     * getNextId() returns nextId
     * @return int nextId
     */
    public int getNextId() {
        return nextId;
    }
}