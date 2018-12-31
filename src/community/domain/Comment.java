/*
 * (C) 2018 Derick Peterson, All rights reserved
 * Unauthorized duplication or distriubution without
 * the author's permission is strictly forbidden.
 * 
 * CS479 - Ethical Leadership in Computer Science
 */
package community.domain;

import java.time.*;
import javax.xml.bind.annotation.*;

@XmlRootElement (name = "Comment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Comment {
    @XmlAttribute
    private String commentDetails;
    
    @XmlAttribute
    private String username;
    
    @XmlAttribute
    private String date;
    
    @XmlAttribute
    private int index;

    /**
     * Comment() - Empty constructor
     */
    public Comment() {}
    
    /**
     * Comment(String) - constructor
     * @param commentDetails
     */
    public Comment(String commentDetails) {
        this.commentDetails = commentDetails;
        this.date = Instant.now().toString();
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
     * getCommentDetails() returns commentDetails
     * @return String commentDetails
     */
    public String getCommentDetails() {
        return commentDetails;
    }

    /**
     * setCommentDetails(String) sets commentDetails to String
     * @param commentDetails
     */
    public void setCommentDetails(String commentDetails) {
        this.commentDetails = commentDetails;
    }

    /**
     * getDate() returns date
     * @return String date
     */
    public String getDate() {
        return date;
    }

    /**
     * setDate(String) sets date to String
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }
}