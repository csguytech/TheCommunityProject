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


public class CommunityDiscussionDetailsView extends javax.swing.JFrame {
    
    private static final CommunityDiscussionDetailsView SINGLETON;
    
    static {
        SINGLETON = new CommunityDiscussionDetailsView();
    }
    
    /**
     * instance() returns instance of CommunityDiscussionDetailsView
     * @return CommunityDiscussionDetailsView instance
     */
    public static CommunityDiscussionDetailsView instance() {
        return SINGLETON;
    }
    
    private Account account = null;
    private Discussion discussion = null;
    private CommentTableModel model = new CommentTableModel();

    /**
     * setAccount(Account) sets account to Account
     * @param account
     */
    public void setAccount (Account account) {
        this.account = account;
    }

    /**
     * setDiscussion(Discussion) sets Discussion and changes visibility for
     *      CommunityDiscussionDetailsView
     * @param discussion
     */
    public void setDiscussion (Discussion discussion) {
        this.discussion = discussion;
        model.setComments(discussion.getComments());
        discussionAuthorFld.setText(discussion.getUsername());
        discussionTitleFld.setText(discussion.getTitle());
        problemFld.setText(discussion.getProblem());
        
        CommunityDiscussionDetailsView.instance().setVisible(true);
    }
    
    /**
     * getDiscussion() returns Discussion
     * @return Discussion
     */
    public Discussion getDiscussion() {
        return discussion;
    }

    /**
     * Creates new form NewJFrame
     */
    public CommunityDiscussionDetailsView() {
        initComponents();
        
        commentsTbl.setModel(model);
    }

    /**
     * initComponents() initializes GUI components
     */
    @SuppressWarnings("unchecked")                      
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        topBar = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        backToDiscussionList = new javax.swing.JButton();
        discussionTitle = new javax.swing.JLabel();
        discussionTitleFld = new javax.swing.JTextField();
        problem = new javax.swing.JLabel();
        problemFld = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentsTbl = new javax.swing.JTable();
        commentLbl = new javax.swing.JLabel();
        newCommentFld = new javax.swing.JTextField();
        addCommentBtn = new javax.swing.JButton();
        discussionAuthor = new javax.swing.JLabel();
        discussionAuthorFld = new javax.swing.JTextField();
        
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
        backToDiscussionList.setNextFocusableComponent(newCommentFld);
        backToDiscussionList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToDiscussionListActionPerformed(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backToDiscussionList)
                    .addComponent(title))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        title.getAccessibleContext().setAccessibleDescription(mgr.string("discDetTitleAccName"));
        backToDiscussionList.getAccessibleContext().setAccessibleName(mgr.string("backBtnAccName"));

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
        problemFld.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        problemFld.setLineWrap(true);
        problemFld.setWrapStyleWord(true);

        commentsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                mgr.string("tblColComments")
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        commentsTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(commentsTbl);
        if (commentsTbl.getColumnModel().getColumnCount() > 0) {
            commentsTbl.getColumnModel().getColumn(0).setResizable(false);
        }
        commentsTbl.getAccessibleContext().setAccessibleName("");

        commentLbl.setText(mgr.string("comment"));
        commentLbl.setLabelFor(newCommentFld);

        newCommentFld.setNextFocusableComponent(addCommentBtn);

        addCommentBtn.setText(mgr.string("addBtn"));
        addCommentBtn.setToolTipText(mgr.string("addComBtnTT"));
        addCommentBtn.setNextFocusableComponent(backToDiscussionList);
        addCommentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCommentBtnActionPerformed(evt);
            }
        });

        discussionAuthor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        discussionAuthor.setText(mgr.string("author"));
        discussionAuthor.setLabelFor(discussionAuthorFld);

        discussionAuthorFld.setEditable(false);
        discussionAuthorFld.setBackground(new java.awt.Color(204, 204, 204));
        discussionAuthorFld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        discussionAuthorFld.setNextFocusableComponent(problemFld);

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGroundLayout.createSequentialGroup()
                        .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(problemFld, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BackGroundLayout.createSequentialGroup()
                                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(discussionTitle)
                                    .addComponent(discussionTitleFld, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(discussionAuthorFld)
                                    .addGroup(BackGroundLayout.createSequentialGroup()
                                        .addComponent(discussionAuthor)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BackGroundLayout.createSequentialGroup()
                                .addComponent(commentLbl)
                                .addGap(555, 555, 555))
                            .addGroup(BackGroundLayout.createSequentialGroup()
                                .addComponent(newCommentFld)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addCommentBtn)))
                        .addGap(103, 103, 103))))
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addComponent(discussionTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(discussionTitleFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addComponent(discussionAuthor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(discussionAuthorFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(problem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(problemFld, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(commentLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newCommentFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCommentBtn))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        discussionTitle.getAccessibleContext().setAccessibleName(mgr.string("detDiscTitleFldAccName"));
        discussionTitleFld.getAccessibleContext().setAccessibleName(mgr.string("detDiscTitleFldAccName"));
        problem.getAccessibleContext().setAccessibleName(mgr.string("detDiscProbFldAccName"));
        problemFld.getAccessibleContext().setAccessibleName(mgr.string("detDiscProbFldAccName"));
        problemFld.getAccessibleContext().setAccessibleDescription(mgr.string("detDiscProbFldAccDes"));
        jScrollPane1.getAccessibleContext().setAccessibleName(mgr.string("commentTblAccName"));
        commentLbl.getAccessibleContext().setAccessibleName(mgr.string("comment"));
        newCommentFld.getAccessibleContext().setAccessibleName(mgr.string("commentFldAccName"));
        newCommentFld.getAccessibleContext().setAccessibleDescription(mgr.string("commentFldAccDes"));
        addCommentBtn.getAccessibleContext().setAccessibleName(mgr.string("addBtnAccName"));
        discussionAuthor.getAccessibleContext().setAccessibleName(mgr.string("tblAuthor"));
        discussionAuthorFld.getAccessibleContext().setAccessibleName(mgr.string("tblAuthor"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );

        pack();
    }                        

    /**
     * backtoDiscussionListActionPerformed(ActionEvent) hides 
     *      CommunityDiscussionDetailsView and shows CommunityDiscussionListView
     * @param evt 
     */
    private void backToDiscussionListActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        this.setVisible(false);
        CommunityDiscussionListView.instance().setAccount(account);
    }                                                    

    /**
     * addCommentBtnActionPerformed(ActionEvent) Adds Comment to Discussion
     * @param evt 
     */
    private void addCommentBtnActionPerformed(java.awt.event.ActionEvent evt) {                                              
        Comment comment = new Comment(newCommentFld.getText());
        comment.setUsername(account.getLogin().getUsername());
        discussion.addComment(comment);
        newCommentFld.setText("");
        
        model.fireTableDataChanged();
    }                                             

    // Variables declaration - do not modify                     
    private javax.swing.JPanel BackGround;
    private javax.swing.JButton addCommentBtn;
    private javax.swing.JButton backToDiscussionList;
    private javax.swing.JTable commentsTbl;
    private javax.swing.JLabel discussionAuthor;
    private javax.swing.JTextField discussionAuthorFld;
    private javax.swing.JLabel discussionTitle;
    private javax.swing.JTextField discussionTitleFld;
    private javax.swing.JLabel commentLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField newCommentFld;
    private javax.swing.JLabel problem;
    private javax.swing.JTextArea problemFld;
    private javax.swing.JLabel title;
    private javax.swing.JPanel topBar;
    // End of variables declaration                   
}
