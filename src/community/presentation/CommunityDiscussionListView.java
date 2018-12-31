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
import java.util.LinkedList;
import java.util.List;

public class CommunityDiscussionListView extends javax.swing.JFrame {

    private static final CommunityDiscussionListView SINGLETON;
    
    static {
        SINGLETON = new CommunityDiscussionListView();
    }
    
    /**
     * instance() returns instance of CommunityDiscussionListView
     * @return CommunityDiscussionListView instance
     */
    public static CommunityDiscussionListView instance() {
        return SINGLETON;
    }
    
    private Account account = null;
    private DiscussionTableModel model = new DiscussionTableModel();
    
    /**
     * setAccount(Account) sets Account for CommunityDiscussionListView
     * @param account
     */
    public void setAccount (Account account) {
        this.account = account;
        AccountSvcXmlImpl impl = AccountSvcXmlImpl.getInstance();
        CommunityClass community = impl.getCommunity();
        List<Discussion> discussions = new LinkedList<>();
        for(Account acc : community.getAccounts()) {
            for(Discussion discussion : acc.getDiscussions()) {
                discussions.add(discussion);
            }
        }
        
        model.setDiscussions(discussions);
        CommunityDiscussionListView.instance().setVisible(true);
    }
    
    /**
     * Creates new form NewJFrame
     */
    public CommunityDiscussionListView() {
        initComponents();
        
        discussionTbl.setModel(model);
    }

    /**
     * initComponents() - initializes GUI components
     */
    @SuppressWarnings("unchecked")                      
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        topBar = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        discussionTbl = new javax.swing.JTable();
        
        ResourceMgr mgr = ResourceMgr.instance();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));

        BackGround.setBackground(new java.awt.Color(102, 102, 102));
        BackGround.setPreferredSize(new java.awt.Dimension(800, 600));

        topBar.setBackground(new java.awt.Color(204, 204, 204));

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setText(mgr.string("ComDiscTitle"));
        title.setAlignmentX(0.5F);

        backBtn.setText(mgr.string("backBtn"));
        backBtn.setToolTipText(mgr.string("ComDiscBackBtnTT"));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addGap(205, 205, 205)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn)
                    .addComponent(title))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        title.getAccessibleContext().setAccessibleName(mgr.string("ComDiscTitleAccName"));
        backBtn.getAccessibleContext().setAccessibleName(mgr.string("backBtnAccName"));

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
        discussionTbl.setColumnSelectionAllowed(true);
        discussionTbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        discussionTbl.setIntercellSpacing(new java.awt.Dimension(3, 3));
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
        discussionTbl.getAccessibleContext().setAccessibleName(mgr.string("ComDiscTitle"));
        discussionTbl.setToolTipText(mgr.string("discTblTT"));

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                .addContainerGap())
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

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
     * backBtnActionPerformed(ActionEvent) hides CommunityDiscussionListView and
     *      displays DicussionListView
     * @param evt 
     */
    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        this.setVisible(false);
        DiscussionListView.instance().setAccount(account);
    }                                       
    
    /**
     * discussionTblMouseClicked(MouseEvent) Opens selected Discussion in 
     *      CommunityDiscussionDetailsView and hides current View
     * @param evt 
     */
    private void discussionTblMouseClicked(java.awt.event.MouseEvent evt) {                                           
        int index = discussionTbl.getSelectedRow();
        
        Discussion discussion = model.getDiscussion(discussionTbl.convertRowIndexToModel(index));
        
        this.setVisible(false);
        CommunityDiscussionDetailsView.instance().setAccount(account);
        CommunityDiscussionDetailsView.instance().setDiscussion(discussion);
    }                                          



    // Variables declaration - do not modify                     
    private javax.swing.JPanel BackGround;
    private javax.swing.JButton backBtn;
    private javax.swing.JTable discussionTbl;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel title;
    private javax.swing.JPanel topBar;
    // End of variables declaration                   
}
