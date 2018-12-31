/*
 * (C) 2018 Derick Peterson, All rights reserved
 * Unauthorized duplication or distriubution without
 * the author's permission is strictly forbidden.
 * 
 * CS479 - Ethical Leadership in Computer Science
 */
package community.err;

public class MissingPropertyException extends Exception {
    
    /**
     * MissingPropertyException(String) Constructor
     * @param property
     */
    public MissingPropertyException(String property) {
        super("Missing property " + property);
    }
    
    /**
     * MissingPropertyException(String, Throwable) Constructor
     * @param property
     * @param cause
     */
    public MissingPropertyException(String property, Throwable cause) {
        super(("Missing property " + property), cause);
    }
}