/*
 * (C) 2018 Derick Peterson, All rights reserved
 * Unauthorized duplication or distriubution without
 * the author's permission is strictly forbidden.
 * 
 * CS479 - Ethical Leadership in Computer Science
 */
package community.presentation;

import community.domain.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;


public class DiscussionTableModel extends AbstractTableModel {
    private String [] columnNames = {"Title", "Problem", "Time"};
    
    private List<Discussion> discussions = new LinkedList<>();

    /**
     * setDiscussions(List) sets discussions to List
     * @param discussions
     */
    public void setDiscussions(List<Discussion> discussions) {
        this.discussions = discussions;
    }
    
    /**
     * getDiscussion(int) returns Discussion at index int
     * @param index
     * @return Discussion at index
     */
    public Discussion getDiscussion(int index) {
        return discussions.get(index);
    }
    
    /**
     * getRowCount() returns number of rows in tbl
     * @return int rows in tbl
     */
    @Override
    public int getRowCount() {
        return discussions.size();
    }
    
    /**
     * getColumnCount() returns number of cols in tbl
     * @return int columns in tbl
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    /**
     * getValueAt(int, int) returns String of Discussion at (int,int)
     * @param row
     * @param column
     * @return Object String
     */
    @Override
    public Object getValueAt(int row, int column) {
        Discussion discussion = discussions.get(row);
        switch (column) {
            case 0:
                return discussion.getTitle();
            case 1:
                return discussion.getProblem();
            case 2:
                return discussion.getId();
        }
        return "";
    }
    
    /**
     * getColumnName(int) returns name of column at int
     * @param column
     * @return String columnName[int]
     */
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
}
