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
import java.time.*;
import javax.xml.bind.annotation.*;

@XmlRootElement (name = "Discussion")
@XmlAccessorType(XmlAccessType.FIELD)
public class Discussion {
    @XmlAttribute
    private String title;
    
    @XmlAttribute
    private String problem;
    
    @XmlAttribute
    private String username;
    
    @XmlAttribute
    private String id;
    
    @XmlElement
    private List<Comment> comments = new LinkedList<>();

    /**
     * Discussion() - empty constructor
     */
    public Discussion() {
        this.id = Instant.now().toString();
    }
    
    /**
     * Discussion(String, String) - constructor for Discussion object
     * @param title
     * @param problem
     */
    public Discussion(String title, String problem) {
        this.title = title;
        this.problem = problem;
        this.id = Instant.now().toString();
    }
    
    /**
     * getTitle() returns title
     * @return String title
     */
    public String getTitle() {
        return title;
    }

    /**
     * setTitle(String) sets title to String
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * getProblem() returns problem
     * @return String problem
     */
    public String getProblem() {
        return problem;
    }

    /**
     * setProblem(String) sets problem to String
     * @param problem
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }
    
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
     * getId() returns id
     * @return String id
     */
    public String getId() {
        return id;
    }

    /**
     * setId(String) sets id to String
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getComments returns List of Comments
     * @return List of Comments
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * setComments(List) sets comments to List
     * @param comments
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
    /**
     * addComment(Comment) adds Comment to Discussion Comments
     * @param comment
     */
    public void addComment(Comment comment) {
        comment = Overwatch.getInstance().validate(comment);
        comments.add(comment);
        IAccountSvc impl = AccountSvcXmlImpl.getInstance();
        impl.save();
    }
    
    /**
     * deleteComment(Comment) finds and deletes Comment from Discussion
     * @param comment
     */
    public void deleteComment(Comment comment) {
        if (comments.contains(comment)) {
            comments.remove(comment);
        }
        IAccountSvc impl = AccountSvcXmlImpl.getInstance();
        impl.save();
    }

    /**
     * validate() validates that title and problem are not null or empty
     * @return boolean
     */
    public boolean validate() {
        if (title == null || title.equals("")) return false;
        if (problem == null || problem.equals("")) return false;
        return true;
    }
}