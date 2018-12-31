/*
 * (C) 2018 Derick Peterson, All rights reserved
 * Unauthorized duplication or distriubution without
 * the author's permission is strictly forbidden.
 * 
 * CS479 - Ethical Leadership in Computer Science
 */
package community.presentation;

import community.ResourceMgr;
import community.domain.*;
import javax.swing.JOptionPane;

public class DiscussionDetailsView extends javax.swing.JFrame {
    
    private static final DiscussionDetailsView SINGLETON;
    
    static {
        SINGLETON = new DiscussionDetailsView();
    }
    
    /**
     * instance() returns instance of DiscussionDetailsView
     * @return DiscussionDetailsView instance
     */
    public static DiscussionDetailsView instance() {
        return SINGLETON;
    }
    
    private Account account = null;
    private Discussion discussion = null;
    private final CommentTableModel model = new CommentTableModel();

    /**
     * setAccount(Account) sets account to Account
     * @param account
     */
    public void setAccount (Account account) {
        this.account = account;
    }

    /**
     * setDiscussion(Discussion) sets discussion to Discussion
     * @param discussion
     */
    public void setDiscussion (Discussion discussion) {
        this.discussion = discussion;
        model.setComments(discussion.getComments());
        discussionTitleFld.setText(discussion.getTitle());
        problemFld.setText(discussion.getProblem());
        lockedCheckbox.setSelected(true);
        
        DiscussionDetailsView.instance().setVisible(true);
    }
    
    /**
     * getDiscussion() returns discussion
     * @return Discussion discussion
     */
    public Discussion getDiscussion () {
        return discussion;
    }

    /**
     * Creates new form NewJFrame
     */
    public DiscussionDetailsView() {
        initComponents();
        
        commentsTbl.setModel(model);
    }

    /**
     * initComponents() - initializes GUI interface
     */
    @SuppressWarnings("unchecked")                         
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        topBar = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        backToDiscussionList = new javax.swing.JButton();
        lockedCheckbox = new javax.swing.JCheckBox();
        discussionTitle = new javax.swing.JLabel();
        discussionTitleFld = new javax.swing.JTextField();
        problem = new javax.swing.JLabel();
        problemFld = new javax.swing.JTextArea();
        deleteDiscussion = new javax.swing.JButton();
        updateDiscussion = new javax.swing.JButton();
        unlockMessageLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentsTbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        newCommentFld = new javax.swing.JTextField();
        addCommentBtn = new javax.swing.JButton();
        
        ResourceMgr mgr = ResourceMgr.instance();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));

        BackGround.setBackground(new java.awt.Color(102, 102, 102));
        BackGround.setPreferredSize(new java.awt.Dimension(800, 600));

        topBar.setBackground(new java.awt.Color(204, 204, 204));

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setText(mgr.string("discDetTitle"));
        title.setAlignmentX(0.5F);

        backToDiscussionList.setText(mgr.string("backBtn"));
        backToDiscussionList.setToolTipText(mgr.string("backToDiscList"));
        backToDiscussionList.setNextFocusableComponent(lockedCheckbox);
        backToDiscussionList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToDiscussionListActionPerformed(evt);
            }
        });

        lockedCheckbox.setBackground(new java.awt.Color(204, 204, 204));
        lockedCheckbox.setSelected(true);
        lockedCheckbox.setText(mgr.string("locked"));
        lockedCheckbox.setToolTipText(mgr.string("lockedTT"));
        lockedCheckbox.setNextFocusableComponent(discussionTitleFld);
        lockedCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lockedCheckboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backToDiscussionList)
                .addGap(239, 239, 239)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lockedCheckbox)
                .addContainerGap())
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lockedCheckbox)
                    .addComponent(backToDiscussionList)
                    .addComponent(title))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        title.getAccessibleContext().setAccessibleName(mgr.string("discDetTitleAccName"));
        backToDiscussionList.getAccessibleContext().setAccessibleName(mgr.string("backBtnAccName"));
        backToDiscussionList.getAccessibleContext().setAccessibleDescription(mgr.string("backToDiscList"));
        lockedCheckbox.getAccessibleContext().setAccessibleName(mgr.string("lockedAccName"));
        lockedCheckbox.getAccessibleContext().setAccessibleDescription(mgr.string("lockedAccDes"));

        discussionTitle.setFont(new java.awt.Font("Tahoma", 0, 14));
        discussionTitle.setText(mgr.string("discTitle"));
        discussionTitle.setLabelFor(discussionTitleFld);

        discussionTitleFld.setEditable(false);
        discussionTitleFld.setBackground(new java.awt.Color(204, 204, 204));
        discussionTitleFld.setFont(new java.awt.Font("Tahoma", 0, 14));
        discussionTitleFld.setNextFocusableComponent(problemFld);

        problem.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        problem.setText(mgr.string("discProb"));
        problem.setLabelFor(problemFld);

        problemFld.setEditable(false);
        problemFld.setBackground(new java.awt.Color(204, 204, 204));
        problemFld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        problemFld.setLineWrap(true);
        problemFld.setWrapStyleWord(true);
        problemFld.setNextFocusableComponent(commentsTbl);

        deleteDiscussion.setText(mgr.string("deleteBtn"));
        deleteDiscussion.setToolTipText(mgr.string("deleteBtnTT"));
        deleteDiscussion.setAlignmentX(0.5F);
        deleteDiscussion.setEnabled(false);
        deleteDiscussion.setNextFocusableComponent(backToDiscussionList);
        deleteDiscussion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDiscussionActionPerformed(evt);
            }
        });

        updateDiscussion.setText(mgr.string("updateBtn"));
        updateDiscussion.setToolTipText(mgr.string("updateBtnTT"));
        updateDiscussion.setAlignmentX(0.5F);
        updateDiscussion.setEnabled(false);
        updateDiscussion.setNextFocusableComponent(deleteDiscussion);
        updateDiscussion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDiscussionActionPerformed(evt);
            }
        });

        unlockMessageLbl.setText(mgr.string("unlockMsg"));

        commentsTbl.setBackground(new java.awt.Color(204, 204, 204));
        commentsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                mgr.string("tblColComments"), mgr.string("tblAuthor"), 
                mgr.string("tblColTitle")
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        commentsTbl.setNextFocusableComponent(newCommentFld);
        commentsTbl.setSelectionBackground(new java.awt.Color(102, 102, 102));
        commentsTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(commentsTbl);
        if (commentsTbl.getColumnModel().getColumnCount() > 0) {
            commentsTbl.getColumnModel().getColumn(0).setMinWidth(300);
            commentsTbl.getColumnModel().getColumn(0).setPreferredWidth(500);
            commentsTbl.getColumnModel().getColumn(0).setMaxWidth(600);
        }
        commentsTbl.getAccessibleContext().setAccessibleName(mgr.string("commentTblAccName"));
        commentsTbl.getAccessibleContext().setAccessibleDescription(mgr.string("commentTblAccDes"));

        jLabel1.setText(mgr.string("commentLbl"));
        jLabel1.setLabelFor(newCommentFld);

        newCommentFld.setNextFocusableComponent(addCommentBtn);

        addCommentBtn.setText(mgr.string("addBtn"));
        addCommentBtn.setToolTipText(mgr.string("addComBtnTT"));
        addCommentBtn.setNextFocusableComponent(updateDiscussion);
        addCommentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCommentBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addComponent(problem)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGroundLayout.createSequentialGroup()
                        .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(problemFld, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(discussionTitleFld)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BackGroundLayout.createSequentialGroup()
                                .addComponent(discussionTitle)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(BackGroundLayout.createSequentialGroup()
                                .addComponent(newCommentFld)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addCommentBtn)))
                        .addGap(103, 103, 103))))
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addComponent(updateDiscussion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteDiscussion))
                    .addComponent(unlockMessageLbl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BackGroundLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteDiscussion, updateDiscussion});

        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(discussionTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(discussionTitleFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(problem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(problemFld, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newCommentFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCommentBtn))
                .addGap(4, 4, 4)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateDiscussion)
                    .addComponent(deleteDiscussion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unlockMessageLbl)
                .addGap(20, 20, 20))
        );

        BackGroundLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {deleteDiscussion, updateDiscussion});

        discussionTitleFld.getAccessibleContext().setAccessibleName(mgr.string("detDiscTitleFldAccName"));
        problemFld.getAccessibleContext().setAccessibleName(mgr.string("detDiscProbFldAccName"));
        problemFld.getAccessibleContext().setAccessibleDescription(mgr.string("detDiscProbFldAccDes"));
        deleteDiscussion.getAccessibleContext().setAccessibleName(mgr.string("deleteBtnAccName"));
        updateDiscussion.getAccessibleContext().setAccessibleName(mgr.string("updateBtnAccName"));
        unlockMessageLbl.getAccessibleContext().setAccessibleDescription(mgr.string("unlockMsg"));
        newCommentFld.getAccessibleContext().setAccessibleName(mgr.string("commentFldAccName"));
        newCommentFld.getAccessibleContext().setAccessibleDescription(mgr.string("commentFldAccDes"));
        addCommentBtn.getAccessibleContext().setAccessibleName(mgr.string("addBtnAccName"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );


        pack();
    }                      

    /**
     * backToDiscussionListActionPerformed(ActionEvent) hides 
     *      DiscussionDetialsView and displays DiscussionListView
     * @param evt 
     */
    private void backToDiscussionListActionPerformed(java.awt.event.ActionEvent evt) {                                                     
            this.setVisible(false);
            DiscussionListView.instance().setAccount(account);

    }                                                    

    /**
     * lockedCheckboxActionPerformed(ActionEvent) enables editable fields and 
     *      delete and update buttons
     * @param evt 
     */
    private void lockedCheckboxActionPerformed(java.awt.event.ActionEvent evt) {                                               
        ResourceMgr mgr = ResourceMgr.instance();
        if (!lockedCheckbox.isSelected()) {
            discussionTitleFld.setEditable(true);
            problemFld.setEditable(true);
            updateDiscussion.setEnabled(true);
            deleteDiscussion.setEnabled(true);
            unlockMessageLbl.setVisible(false);
            JOptionPane.showMessageDialog(this,
                    mgr.string("mayMakeChanges"), mgr.string("unlock"), JOptionPane.INFORMATION_MESSAGE);
        } else if (lockedCheckbox.isSelected()) {
            discussionTitleFld.setEditable(false);
            problemFld.setEditable(false);
            updateDiscussion.setEnabled(false);
            deleteDiscussion.setEnabled(false);
            unlockMessageLbl.setVisible(true);
        }

    }                                              

    /**
     * updateDiscussionActionPerformed(ActionEvent) creates new Discussion from
     *      text fields and replaces formerly displayed Discussion
     * @param evt 
     */
    private void updateDiscussionActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        Discussion newDiscussion = new Discussion();
        newDiscussion.setTitle(discussionTitleFld.getText());
        newDiscussion.setProblem(problemFld.getText());
        
        ResourceMgr mgr = ResourceMgr.instance();
        
        account.updateDiscussion(newDiscussion, getDiscussion());
        JOptionPane.showMessageDialog(this, mgr.string("discUpdatedMsg"), mgr.string("discUpdatedTitle"), JOptionPane.INFORMATION_MESSAGE);
    }                                                

    /**
     * deletDiscussionActionPerformed(ActionEvent) hides DiscussionDetailsView
     *      and displays DeleteDiscussionView
     * @param evt 
     */
    private void deleteDiscussionActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        this.setVisible(false);
        DeleteDiscussionView.instance().setAccount(account);
        DeleteDiscussionView.instance().setDiscussion(discussion);
    }                                                

    /**
     * addCommentBtnActionPerformed(ActionEvent) creates a Comment from the text
     *      field, adds the Comment to the Discussion, and updates table
     * @param evt 
     */
    private void addCommentBtnActionPerformed(java.awt.event.ActionEvent evt) {                                              
        Comment comment = new Comment(newCommentFld.getText());
        comment.setUsername(account.getLogin().getUsername());
        discussion.addComment(comment);
        newCommentFld.setText("");
        
        model.fireTableDataChanged();
    }                                             


    // Variables declaration                 
    private javax.swing.JPanel BackGround;
    private javax.swing.JButton addCommentBtn;
    private javax.swing.JButton backToDiscussionList;
    private javax.swing.JTable commentsTbl;
    private javax.swing.JButton deleteDiscussion;
    private javax.swing.JLabel discussionTitle;
    private javax.swing.JTextField discussionTitleFld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox lockedCheckbox;
    private javax.swing.JTextField newCommentFld;
    private javax.swing.JLabel problem;
    private javax.swing.JTextArea problemFld;
    private javax.swing.JLabel title;
    private javax.swing.JPanel topBar;
    private javax.swing.JLabel unlockMessageLbl;
    private javax.swing.JButton updateDiscussion;
    // End of variables declaration                   
}
