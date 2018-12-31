/*
 * (C) 2018 Derick Peterson, All rights reserved
 * Unauthorized duplication or distriubution without
 * the author's permission is strictly forbidden.
 * 
 * CS479 - Ethical Leadership in Computer Science
 */
package community.overwatch;

import community.domain.*;

/**
 * Public class Overwatch is designed to validate Discussions and Comments
 * for explicit content and replace it.
 */
public class Overwatch {
    private final String CHANGED = "Your post has been changed due to possible "
            + "explicit content.";
    private final String[] badWords;
    
    /**
     * Constructor for Overwatch
     */
    public Overwatch() {
        this.badWords = readList();
    }
    
    private static final Overwatch INSTANCE = new Overwatch();
    
    /**
     * @return INSTANCE of Overwatch
     */
    public static Overwatch getInstance() {
        return INSTANCE;
    }
    
    /**
     * readList() reads in a list of blocked words
     * @return String[] of blocked words
     */
    private String[] readList() {
        //Read csv file into String Array
        String[] badWordList = {"Ass", "Bitch", "Sex", "Traffiking", "Shit"};
        
        return badWordList;
    }
    
    /**
     * validate() scans discussion object for words read by readList()
     * @param discussion
     * @return Discussion with readList() words modified
     */
    public Discussion validate(Discussion discussion) {
        // Scan Discussion for poor langague against csv 
        
        for(String badWord : badWords) {
            if(discussion.getTitle().contains(badWord) || 
                    discussion.getProblem().contains(badWord)) {
                discussion.setTitle(CHANGED);
                discussion.setProblem(CHANGED);
            }
        }
        return discussion;
    }
    
    /**
     * validate() scans comment object for words read by readList()
     * @param comment
     * @return Comment with readList() words modified
     */
    public Comment validate(Comment comment) {
        // Scan Comment for poor langage agaist csv
        for(String badWord : badWords) {
            if(comment.getCommentDetails().contains(badWord)) {
                comment.setCommentDetails(CHANGED);
            }
        }
        return comment;
    }

}