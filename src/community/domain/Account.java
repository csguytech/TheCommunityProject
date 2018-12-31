/*
 * (C) 2018 Derick Peterson, All rights reserved
 * Unauthorized duplication or distriubution without
 * the author's permission is strictly forbidden.
 * 
 * CS479 - Ethical Leadership in Computer Science
 */
package community.domain;
import community.overwatch.Overwatch;
import community.services.AccountSvcXmlImpl;
import community.services.IAccountSvc;
import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement (name = "Account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {
    @XmlAttribute
    private String firstName;
    
    @XmlAttribute
    private String lastName;
    
    @XmlElement
    private Login login;
    
    @XmlAttribute
    private int id;
    
    @XmlElement(name = "Discussions")
    private List<Discussion> discussions = new LinkedList<>();
    
    @XmlElement
    private int nextId;
    
    /**
     * addDiscussion(Discussion) validates and adds Discussion to Account
     * @param discussion
     * @return Discussion object
     */
    public Discussion addDiscussion(Discussion discussion) {
        discussion = Overwatch.getInstance().validate(discussion);
        
        discussions.add(discussion);
        IAccountSvc impl = AccountSvcXmlImpl.getInstance();
        impl.save();
        return discussion;
    }
    
    /**
     * deleteDiscussion(Discussion) deletes Discussion from Account
     * @param discussion
     */
    public void deleteDiscussion(Discussion discussion) {
        if (discussions.contains(discussion)) {
            discussions.remove(discussion);
        }
        IAccountSvc impl = AccountSvcXmlImpl.getInstance();
        impl.save();
    }
    
    /**
     * updateDiscussion(Discussion, Discussion) updates Discussion
     * @param newDiscussion
     * @param discussion
     */
    public void updateDiscussion(Discussion newDiscussion, Discussion discussion) {
        Discussion oldDiscussion = discussion;
        oldDiscussion.setTitle(newDiscussion.getTitle());
        oldDiscussion.setProblem(newDiscussion.getProblem());
        IAccountSvc impl = AccountSvcXmlImpl.getInstance();
        impl.save();
    } 

    /**
     * getFirstName() returns firstName
     * @return String firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setFirstName(String) sets firstName to String
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getLastName() returns lastName
     * @return String lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setLastName(String) sets lastName to String
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getLogin() returns login
     * @return Login login
     */
    public Login getLogin() {
        return login;
    }

    /**
     * setLogin(Login) sets login to Login
     * @param login
     */
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     * getId() return id
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * setId(int) sets id to int
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getDiscussions() returns Account Discussions
     * @return List of Discussions
     */
    public List<Discussion> getDiscussions() {
        return discussions;
    }

    /**
     * setDiscussions(List) sets discussions to List
     * @param discussions
     */
    public void setDiscussions(List<Discussion> discussions) {
        this.discussions = discussions;
    }
    
    /**
     * validate() verifies that firstName, lastName, and login are not null
     * @return boolean
     */
    public boolean validate() {
        if (firstName == null || firstName.equals("")) return false;
        if (lastName == null || lastName.equals("")) return false;
        if (login == null) return false;
        return true;
    }
    
}