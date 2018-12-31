/*
 * (C) 2018 Derick Peterson, All rights reserved
 * Unauthorized duplication or distriubution without
 * the author's permission is strictly forbidden.
 * 
 * CS479 - Ethical Leadership in Computer Science
 */
package community.presentation;

import community.ResourceMgr;
import community.services.*;
import community.domain.*;
import javax.swing.JOptionPane;

public class AddDiscussionView extends javax.swing.JFrame {
    
    private static final AddDiscussionView SINGLETON;
    
    static {
        SINGLETON = new AddDiscussionView();
    }
    
    /**
     * instance() returns instance of AddDiscussionView
     * @return AddDiscussionView SINGLETON
     */
    public static AddDiscussionView instance() {
        return SINGLETON;
    }
    
    private Account account = null;
    
    /**
     * setAccount(Account) sets account to Account
     * @param account
     */
    public void setAccount (Account account) {
        this.account = account;
        
        AddDiscussionView.instance().setVisible(true);
    }
    
    /**
     * Creates new form NewJFrame
     */
    public AddDiscussionView() {
        initComponents();
    }

    /**
     * initComponents() initialize components of GUI interface
     */
    @SuppressWarnings("unchecked")                         
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        topBar = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        backToDiscussionList = new javax.swing.JButton();
        addDiscussion = new javax.swing.JButton();
        discussionTitle = new javax.swing.JLabel();
        discussionTitleFld = new javax.swing.JTextField();
        problem = new javax.swing.JLabel();
        problemFld = new javax.swing.JTextArea();
        
        ResourceMgr mgr = ResourceMgr.instance();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));

        BackGround.setBackground(new java.awt.Color(102, 102, 102));
        BackGround.setPreferredSize(new java.awt.Dimension(800, 600));

        topBar.setBackground(new java.awt.Color(204, 204, 204));

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setText(mgr.string("AddDiscTitle"));
        title.setAlignmentX(0.5F);

        backToDiscussionList.setText(mgr.string("backBtn"));
        backToDiscussionList.setToolTipText(mgr.string("backToDiscList"));
        backToDiscussionList.setNextFocusableComponent(discussionTitleFld);
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
                .addGap(250, 250, 250)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backToDiscussionList)
                    .addComponent(title))
                .addContainerGap())
        );


        addDiscussion.setText(mgr.string("addBtn"));
        addDiscussion.setToolTipText(mgr.string("addDiscBtnTT"));
        addDiscussion.setAlignmentX(0.5F);
        addDiscussion.setNextFocusableComponent(backToDiscussionList);
        addDiscussion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDiscussionActionPerformed(evt);
            }
        });

        discussionTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        discussionTitle.setText(mgr.string("discTitle"));
        discussionTitle.setLabelFor(discussionTitleFld);

        discussionTitleFld.setBackground(new java.awt.Color(204, 204, 204));
        discussionTitleFld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        discussionTitleFld.setNextFocusableComponent(problemFld);

        problem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        problem.setText(mgr.string("discProb"));
        problem.setLabelFor(problemFld);

        problemFld.setBackground(new java.awt.Color(204, 204, 204));
        problemFld.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        problemFld.setLineWrap(true);
        problemFld.setWrapStyleWord(true);
        problemFld.setNextFocusableComponent(addDiscussion);

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, 
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGap(371, 371, 371)
                .addComponent(addDiscussion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addComponent(discussionTitle)
                        .addGap(103, 681, Short.MAX_VALUE))
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(problem, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(discussionTitleFld, javax.swing.GroupLayout.Alignment.LEADING, 
                                    javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                            .addComponent(problemFld, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(discussionTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(discussionTitleFld, javax.swing.GroupLayout.PREFERRED_SIZE, 
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(problem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(problemFld, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(41, 41, 41)
                .addComponent(addDiscussion)
                .addGap(109, 109, 109))
        );

        title.getAccessibleContext().setAccessibleName(mgr.string("AddDiscTitleAccName"));
        backToDiscussionList.getAccessibleContext().setAccessibleName(mgr.string("backBtnAccName"));
        addDiscussion.getAccessibleContext().setAccessibleName(mgr.string("addBtnAccName"));
        discussionTitleFld.getAccessibleContext().setAccessibleName(mgr.string("discTitleFldAccName"));
        discussionTitleFld.getAccessibleContext().setAccessibleDescription(mgr.string("discTitleFldAccDes"));
        problemFld.getAccessibleContext().setAccessibleName(mgr.string("problemFldAccName"));
        problemFld.getAccessibleContext().setAccessibleDescription(mgr.string("problemFldAccDes"));

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
     * backToDiscussionListActionPerformed(ActionEvent) hides current view
     *      and shows DiscussionListView
     * @param evt 
     */
    private void backToDiscussionListActionPerformed(java.awt.event.ActionEvent evt) {                                                     
            this.setVisible(false);
            DiscussionListView.instance().setAccount(account);
    }                                                    

    /**
     * addDiscussionActionPerformed(ActionEvent) creates Discussion from text
     *      fields and adds Discussion to Account
     * @param evt 
     */
    private void addDiscussionActionPerformed(java.awt.event.ActionEvent evt) {                                              
        ResourceMgr mgr = ResourceMgr.instance();
        
        Discussion discussion = new Discussion(discussionTitleFld.getText(), 
                problemFld.getText());
        discussion.setUsername(account.getLogin().getUsername());
        
        boolean isValid = discussion.validate();
        if (!isValid) {
            JOptionPane.showMessageDialog(this, 
                    mgr.string("titleProblemReq"), mgr.string("error"), 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        account.addDiscussion(discussion);
        IAccountSvc impl = AccountSvcXmlImpl.getInstance();
        account = impl.update(account);
        if (account == null) {
            JOptionPane.showMessageDialog(this, 
                    mgr.string("discNotSaved"), mgr.string("error"), 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(this, mgr.string("discSaved"),
                mgr.string("saved"), JOptionPane.INFORMATION_MESSAGE);
        
        this.setVisible(false);
        discussionTitleFld.setText("");
        problemFld.setText("");
        DiscussionListView.instance().setAccount(account);
    }                                                                                  


    // Variables declaration                 
    private javax.swing.JPanel BackGround;
    private javax.swing.JButton addDiscussion;
    private javax.swing.JButton backToDiscussionList;
    private javax.swing.JLabel discussionTitle;
    private javax.swing.JTextField discussionTitleFld;
    private javax.swing.JLabel problem;
    private javax.swing.JTextArea problemFld;
    private javax.swing.JLabel title;
    private javax.swing.JPanel topBar;
    // End of variables declaration                   
}
