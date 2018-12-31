/*
 * (C) 2018 Derick Peterson, All rights reserved
 * Unauthorized duplication or distriubution without
 * the author's permission is strictly forbidden.
 * 
 * CS479 - Ethical Leadership in Computer Science
 */

package community;

import community.overwatch.Overwatch;
import community.presentation.LoginView;

public class Community {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        /**
         * Launches Resource Manager to modify language settings
         */
        ResourceMgr.instance();
        
        /**
         * Creates Overwatch Object to Scan discussions and Comments
         */
        Overwatch overwatch = new Overwatch();
        
        /**
         * Launches the LoginView to start the GUI interface
         */
        LoginView.instance().run();
    }
    
}
