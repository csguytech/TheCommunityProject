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

public class CommentTableModel extends AbstractTableModel {
    private String [] columnNames = {"Comments", "Author", "Time"};
  
    private List<Comment> comments = new LinkedList<>();
    
    /**
     * setComments(List) sets comments to List
     * @param comments
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
    /**
     * getComment(int) returns Comment at index int
     * @param index
     * @return Comment at index int
     */
    public Comment getComment(int index) {
        return comments.get(index);
    }

    /**
     * getRowCount() returns number of rows in commentTbl
     * @return int 
     */
    @Override
    public int getRowCount() {
        return comments.size();
    }

    /**
     * getColumnCount() returns number of columns in commentTbl
     * @return int
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * getValueAt(int, int) returns Comment at (int,int)
     * @param row
     * @param column
     * @return Comment object
     */
    @Override
    public Object getValueAt(int row, int column) {
        Comment comment = comments.get(row);
        switch (column) {
            case 0:
                return comment.getCommentDetails();
            case 1:
                return comment.getUsername();
            case 2:
                return comment.getDate();
        }
        return "";
    }
    
    /**
     * getColumnName(int) returns columnName at int index
     * @param column
     * @return String columnNames[int]
     */
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    
}