/*
 * (C) 2018 Derick Peterson, All rights reserved
 * Unauthorized duplication or distriubution without
 * the author's permission is strictly forbidden.
 * 
 * CS479 - Ethical Leadership in Computer Science
 */
package community.services;

import community.dao.XmlMgr;
import community.domain.*;
import java.util.*;

public class AccountSvcXmlImpl implements IAccountSvc {
    
    private AccountSvcXmlImpl() {
    }
    
    private static final AccountSvcXmlImpl INSTANCE = new AccountSvcXmlImpl();
    
    /**
     * getInstance() returns instance of AccountSvcXmlImpl
     * @return AccountSvcXmlImpl instance
     */
    public static AccountSvcXmlImpl getInstance() {
        return INSTANCE;
    }
    
    private final CommunityClass community = XmlMgr.getInstance().loadXml();

    /**
     * getCommunity() returns CommunityClass community
     * @return CommunityClass community
     */
    public CommunityClass getCommunity() {
        return community;
    }
    
    /**
     * save() saves CommunityClass community to xml
     */
    @Override
    public void save() {
        XmlMgr.getInstance().saveXml(community);
    }
    
    /**
     * create(Account) adds Account to CommunityClass community
     * @param account
     * @return Account account
     */
    @Override
    public Account create(Account account) {
        account.setId((community.getNextId()));
        community.setNextId(community.getNextId() + 1);
        community.addAccount(account);
        return account;
    }
    
    /**
     * update(Account) updates Account
     * @param account
     * @return Account account
     */
    @Override
    public Account update(Account account) {
        for(int i = 0; i < community.getAccounts().size(); i++) {
            Account next = community.getAccounts().get(i);
            if (next.getId() == account.getId()) {
                community.getAccounts().set(i, account);
                break;
            }
        }
        return account;
    }
    
    /**
     * delete(Account) searches Community for Account and deletes Account if 
     *      found
     * @param account
     * @return
     */
    @Override
    public Account delete(Account account) {
        for(int i = 0; i < community.getAccounts().size(); i++) {
            Account next = community.getAccounts().get(i);
            if (next.getId() == account.getId()) {
                community.getAccounts().remove(i);
                break;
            }
        }
        return account;
    }
    
    /**
     * authenticate(Login) Searches Community for Account and returns account
     *      if login is verified
     * @param login
     * @return Account account
     */
    @Override
    public Account authenticate(Login login) {
        Account account = null;
        for(int i = 0; i < community.getAccounts().size(); i++) {
            account = community.getAccounts().get(i);
            Login accountLogin = account.getLogin();
            if (login.equals(accountLogin)) return account;
        }
        account = null;
        return account;
    }

    /**
     * retrieveAll() returns List of Accounts
     * @return List of Accounts
     */
    @Override
    public List<Account> retrieveAll() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}