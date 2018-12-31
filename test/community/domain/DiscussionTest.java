/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package community.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dpeterson
 */
public class DiscussionTest {
    
    public DiscussionTest() {
    }

    @Test
    public void testValidate() {
        Discussion discussion = new Discussion();
        boolean result = discussion.validate();
        assertFalse(result);
        discussion.setTitle("Test Title");
        result = discussion.validate();
        assertFalse(result);
        discussion.setProblem("Test Problem");
        result = discussion.validate();
        assertTrue(result);
    }
    
}
