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

public class DiscussionListView extends javax.swing.JFrame {
    
    private static final DiscussionListView SINGLETON;
    
    static {
        SINGLETON = new DiscussionListView();
    }
    
    /**
     * instance() returns instance of DiscussionListView
     * @return DiscussionListView instance
     */
    public static DiscussionListView instance() {
        return SINGLETON;
    }
    
    private Account account = null;
    private DiscussionTableModel model = new DiscussionTableModel();
    
    /**
     * setAccount(Account) sets account to Account, updates model
     * @param account
     */
    public void setAccount (Account account) {
        this.account = account;
        model.setDiscussions(account.getDiscussions());
        if (account.getDiscussions().isEmpty()) {
            discussionListEmptyLbl.setVisible(true);
        } else {
            discussionListEmptyLbl.setVisible(false);
        }
        DiscussionListView.instance().setVisible(true);
        
        model.fireTableDataChanged();
    }
    
    /**
     * Creates new form NewJFrame
     */
    public DiscussionListView() {

        initComponents();
        
        discussionTbl.setModel(model);
    }

    /**
     * initComponents() - initializes GUI interface
     */
    @SuppressWarnings("unchecked")                          
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        topBar = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        logOutBtn = new javax.swing.JButton();
        communityBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        discussionTbl = new javax.swing.JTable();
        addDiscussionBtn = new javax.swing.JButton();
        discussionListEmptyLbl = new javax.swing.JLabel();
        
        ResourceMgr mgr = ResourceMgr.instance();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));

        BackGround.setBackground(new java.awt.Color(102, 102, 102));
        BackGround.setPreferredSize(new java.awt.Dimension(800, 600));

        topBar.setBackground(new java.awt.Color(204, 204, 204));

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setText(mgr.string("discListTitle"));
        title.setAlignmentX(0.5F);

        logOutBtn.setText(mgr.string("logOutBtn"));
        logOutBtn.setToolTipText(mgr.string("LogOutBtnTT"));
        logOutBtn.setNextFocusableComponent(communityBtn);
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        communityBtn.setText(mgr.string("commBtn"));
        communityBtn.setToolTipText(mgr.string("commBtnTT"));
        communityBtn.setNextFocusableComponent(discussionTbl);
        communityBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                communityBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logOutBtn)
                .addGap(217, 217, 217)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(communityBtn)
                .addContainerGap())
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(communityBtn)
                    .addComponent(logOutBtn)
                    .addComponent(title))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        title.getAccessibleContext().setAccessibleName(mgr.string("discTitleAccName"));
        logOutBtn.getAccessibleContext().setAccessibleName(mgr.string("logOutBtnAccName"));
        logOutBtn.getAccessibleContext().setAccessibleDescription(mgr.string("logOutBtnAccDes"));
        communityBtn.getAccessibleContext().setAccessibleName(mgr.string("commBtnAccName"));
        communityBtn.getAccessibleContext().setAccessibleDescription(mgr.string("commBtnAccDes"));

        discussionTbl.setBackground(new java.awt.Color(204, 204, 204));
        discussionTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                mgr.string("tblColTitle"), mgr.string("tblColProblem"), 
                mgr.string("tblColTime")
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        discussionTbl.setToolTipText(mgr.string("discTblTT"));
        discussionTbl.setColumnSelectionAllowed(true);
        discussionTbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        discussionTbl.setIntercellSpacing(new java.awt.Dimension(3, 3));
        discussionTbl.setNextFocusableComponent(addDiscussionBtn);
        discussionTbl.setSelectionBackground(new java.awt.Color(102, 102, 102));
        discussionTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                discussionTblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(discussionTbl);
        discussionTbl.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (discussionTbl.getColumnModel().getColumnCount() > 0) {
            discussionTbl.getColumnModel().getColumn(0).setPreferredWidth(200);
            discussionTbl.getColumnModel().getColumn(1).setPreferredWidth(750);
        }
        discussionTbl.getAccessibleContext().setAccessibleName(mgr.string("discTblAccName"));

        addDiscussionBtn.setText(mgr.string("addDiscBtn"));
        addDiscussionBtn.setToolTipText(mgr.string("addDiscBtnTT"));
        addDiscussionBtn.setAlignmentX(0.5F);
        addDiscussionBtn.setNextFocusableComponent(logOutBtn);
        addDiscussionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDiscussionBtnActionPerformed(evt);
            }
        });

        discussionListEmptyLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        discussionListEmptyLbl.setText(mgr.string("discListEmpty"));

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(discussionListEmptyLbl)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(addDiscussionBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(discussionListEmptyLbl)
                .addGap(19, 19, 19)
                .addComponent(addDiscussionBtn)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        addDiscussionBtn.getAccessibleContext().setAccessibleName(mgr.string("addDiscBtnAccName"));
        addDiscussionBtn.getAccessibleContext().setAccessibleDescription(mgr.string("addDiscBtnAccDes"));
        discussionListEmptyLbl.getAccessibleContext().setAccessibleDescription(mgr.string("discListEmptyAccDes"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }                       

    /**
     * logOutBtnActionPerformed(ActionEvent) logs user out of the system,
     *      hides DiscussionListView and displays LoginView
     * @param evt 
     */
    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        IAccountSvc impl = AccountSvcXmlImpl.getInstance();
        impl.save();
        this.setVisible(false);
        LoginView.instance().resetPasswordFld();
        LoginView.instance().run();
    }                                         

    /**
     * addDiscussionBtnActionPerformed(ActionEvent) hides DiscussionListView
     *      and displays AddDiscussionView
     * @param evt 
     */
    private void addDiscussionBtnActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        this.setVisible(false);
        AddDiscussionView.instance().setAccount(account);
    }                                                

    /**
     * discussionTblMouseClicked(MouseEvent) hides DiscussionListView, loads 
     *      selected Discussion to and displays DiscussionDetailsView
     * @param evt 
     */
    private void discussionTblMouseClicked(java.awt.event.MouseEvent evt) {                                           
        int index = discussionTbl.getSelectedRow();
        
        Discussion discussion = model.getDiscussion(discussionTbl.convertRowIndexToModel(index));
        
        this.setVisible(false);
        DiscussionDetailsView.instance().setAccount(account);
        DiscussionDetailsView.instance().setDiscussion(discussion);
    }                                          

    /**
     * communityBtnActionPerformed(ActionEvent) hides DiscussionListView and 
     *      displays CommunityDiscussionListView
     * @param evt 
     */
    private void communityBtnActionPerformed(java.awt.event.ActionEvent evt) {                                             
        this.setVisible(false);
        CommunityDiscussionListView.instance().setAccount(account);
    }                                            


    // Variables declaration                  
    private javax.swing.JPanel BackGround;
    private javax.swing.JButton addDiscussionBtn;
    private javax.swing.JButton communityBtn;
    private javax.swing.JLabel discussionListEmptyLbl;
    private javax.swing.JTable discussionTbl;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JLabel title;
    private javax.swing.JPanel topBar;
               
}
