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

public class DeleteDiscussionView extends javax.swing.JFrame {

    private static final DeleteDiscussionView SINGLETON;
    
    static {
        SINGLETON = new DeleteDiscussionView();
    }
    
    /**
     * instance() returns instance of DeleteDiscussionView
     * @return DeleteDiscussionView instance
     */
    public static DeleteDiscussionView instance() {
        return SINGLETON;
    }
    
    private Account account = null;
    private Discussion discussion = null;
    
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
        discussionTitle.setText(discussion.getTitle());
        
        DeleteDiscussionView.instance().setVisible(true);
    }

    /**
     * Creates new form NewJFrame
     */
    public DeleteDiscussionView() {
        initComponents();
    }

    /**
     * initComponents() - initializes GUI interface
     */
    @SuppressWarnings("unchecked")                         
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        topBar = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        deleteDiscussion = new javax.swing.JButton();
        cancelDelete = new javax.swing.JButton();
        verifyDelete = new javax.swing.JLabel();
        discussionTitle = new javax.swing.JLabel();
        
        ResourceMgr mgr = ResourceMgr.instance();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 360));

        BackGround.setBackground(new java.awt.Color(102, 102, 102));

        topBar.setBackground(new java.awt.Color(204, 204, 204));

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setText(mgr.string("deleteDiscTitle"));

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(155, 155, 155))
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        title.getAccessibleContext().setAccessibleName(mgr.string("deleteDiscTitleAccName"));

        deleteDiscussion.setBackground(new java.awt.Color(204, 204, 204));
        deleteDiscussion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteDiscussion.setText(mgr.string("deleteBtn"));
        deleteDiscussion.setToolTipText(mgr.string("deleteDiscBtnTT"));
        deleteDiscussion.setNextFocusableComponent(cancelDelete);
        deleteDiscussion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDiscussionActionPerformed(evt);
            }
        });

        cancelDelete.setBackground(new java.awt.Color(204, 204, 204));
        cancelDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelDelete.setText(mgr.string("cancelBtn"));
        cancelDelete.setToolTipText(mgr.string("cancelDelBtnTT"));
        cancelDelete.setNextFocusableComponent(deleteDiscussion);
        cancelDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelDeleteActionPerformed(evt);
            }
        });

        verifyDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        verifyDelete.setText(mgr.string("verifyDelete"));

        discussionTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        discussionTitle.setText("Discussion Title");

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(cancelDelete)
                        .addGap(18, 18, 18)
                        .addComponent(deleteDiscussion))
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(discussionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGroundLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(verifyDelete)
                .addGap(85, 85, 85))
        );

        BackGroundLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelDelete, deleteDiscussion});

        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(verifyDelete)
                .addGap(18, 18, 18)
                .addComponent(discussionTitle)
                .addGap(69, 69, 69)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelDelete)
                    .addComponent(deleteDiscussion))
                .addGap(0, 111, Short.MAX_VALUE))
        );

        BackGroundLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelDelete, deleteDiscussion});

        deleteDiscussion.getAccessibleContext().setAccessibleName(mgr.string("deleteBtnAccName"));
        cancelDelete.getAccessibleContext().setAccessibleName(mgr.string("cancelBtnAccName"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                      

    /**
     * cancelDeleteActionPerformed(ActionEvent) hides DeleteDiscussionView and 
     *      displays DiscussionDetailsView
     * @param evt 
     */
    private void cancelDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                             
        this.setVisible(false);
        DiscussionDetailsView.instance().setAccount(account);
        DiscussionDetailsView.instance().setDiscussion(discussion);
    }                                            

    /**
     * deleteDiscussionActionPerformed(ActionEvent) deletes discussion, hides 
     *      DeleteDiscussionView, displays DiscussionListView
     * @param evt 
     */
    private void deleteDiscussionActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        account.deleteDiscussion(discussion);
        this.setVisible(false);
        DiscussionListView.instance().setAccount(account);
    }                                                

    // Variables declaration - do not modify                     
    private javax.swing.JPanel BackGround;
    private javax.swing.JButton cancelDelete;
    private javax.swing.JButton deleteDiscussion;
    private javax.swing.JLabel discussionTitle;
    private javax.swing.JLabel title;
    private javax.swing.JPanel topBar;
    private javax.swing.JLabel verifyDelete;
    // End of variables declaration                   
}
