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
import community.services.*;
import javax.swing.JOptionPane;

public class LoginView extends javax.swing.JFrame {

    private static final LoginView SINGLETON;
    
    static {
        SINGLETON = new LoginView();
    }
    
    /**
     * instance() returns instance of LoginView
     * @return LoginView instance
     */
    public static LoginView instance() {
        return SINGLETON;
    }
    
    /**
     * Creates new form NewJFrame
     */
    public LoginView() {
        initComponents();
    }
    
    /**
     * initComponents - initializes GUI interface
     */
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        topBar = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        registerBtn = new javax.swing.JButton();
        username = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        usernameFld = new javax.swing.JTextField();
        passwordFld = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        
        ResourceMgr mgr = ResourceMgr.instance();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 360));

        BackGround.setBackground(new java.awt.Color(102, 102, 102));
        BackGround.setPreferredSize(new java.awt.Dimension(500, 360));

        topBar.setBackground(new java.awt.Color(204, 204, 204));

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setText(mgr.string("loginTitle"));

        exitBtn.setBackground(new java.awt.Color(204, 204, 204));
        exitBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        exitBtn.setText(mgr.string("exitBtn"));
        exitBtn.setToolTipText(mgr.string("exitBtnTT"));
        exitBtn.setNextFocusableComponent(registerBtn);
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        registerBtn.setBackground(new java.awt.Color(204, 204, 204));
        registerBtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        registerBtn.setText(mgr.string("registerBtn"));
        registerBtn.setToolTipText(mgr.string("registerBtnTT"));
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exitBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(127, 127, 127)
                .addComponent(registerBtn)
                .addContainerGap())
        );

        topBarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {exitBtn, registerBtn});

        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitBtn)
                    .addComponent(title)
                    .addComponent(registerBtn))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        title.getAccessibleContext().setAccessibleName(mgr.string("loginTitleAccName"));
        exitBtn.getAccessibleContext().setAccessibleName(mgr.string("exitBtnAccName"));
        registerBtn.getAccessibleContext().setAccessibleName(mgr.string("registerBtnAccName"));

        username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        username.setText(mgr.string("username"));
        username.setLabelFor(usernameFld);

        password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password.setText(mgr.string("password"));
        password.setLabelFor(passwordFld);

        usernameFld.setBackground(new java.awt.Color(204, 204, 204));
        usernameFld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameFld.setNextFocusableComponent(passwordFld);

        passwordFld.setBackground(new java.awt.Color(204, 204, 204));
        passwordFld.setNextFocusableComponent(loginBtn);

        loginBtn.setBackground(new java.awt.Color(204, 204, 204));
        loginBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginBtn.setText(mgr.string("loginBtn"));
        loginBtn.setToolTipText(mgr.string("loginBtnTT"));
        loginBtn.setNextFocusableComponent(registerBtn);
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username)
                    .addComponent(password))
                .addGap(18, 18, 18)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginBtn)
                    .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        BackGroundLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {password, username});

        BackGroundLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {passwordFld, usernameFld});

        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(username)
                    .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(password)
                    .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(loginBtn)
                .addGap(0, 114, Short.MAX_VALUE))
        );

        BackGroundLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {password, username});

        BackGroundLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {passwordFld, usernameFld});

        username.getAccessibleContext().setAccessibleName(mgr.string("usernameAccName"));
        username.getAccessibleContext().setAccessibleDescription(mgr.string("usernameAccDes"));
        password.getAccessibleContext().setAccessibleName(mgr.string("passwordAccName"));
        password.getAccessibleContext().setAccessibleDescription(mgr.string("passwordAccDes"));
        usernameFld.getAccessibleContext().setAccessibleName(mgr.string("usernameFldAccName"));
        usernameFld.getAccessibleContext().setAccessibleDescription(mgr.string("usernameFldAccDes"));
        passwordFld.getAccessibleContext().setAccessibleName(mgr.string("passwordFldAccName"));
        passwordFld.getAccessibleContext().setAccessibleDescription(mgr.string("passwordFldAccDes"));
        loginBtn.getAccessibleContext().setAccessibleName(mgr.string("loginBtnAccName"));

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
     * resetPasswordFld() sets passwordFld to empty String
     */
    public void resetPasswordFld() {
        passwordFld.setText("");
    }
    
    /**
     * registerBtnActionPerformed(ActionEvent) hides LoginView and displays
     *      CreateAccountView
     * @param evt 
     */
    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {                                            
            this.setVisible(false);
            CreateAccountView.instance().run();
    }                                           

    /**
     * exitBtnActionPerformed(ActionEvent) updates xml and exits program
     * @param evt 
     */
    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        IAccountSvc impl = AccountSvcXmlImpl.getInstance();
        impl.save();
        System.exit(0);
    }                                       

    /**
     * loginBtnActionPerformed(ActionEvent) verifies Login credentials and hides
     *      LoginView, loads Account to and displays DiscussionListView
     * @param evt 
     */
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        ResourceMgr mgr = ResourceMgr.instance();
        
        Login login = new Login();
        login.setUsername(usernameFld.getText());
        login.setPassword(new String(passwordFld.getPassword()));
        if (!login.validate()) {
            JOptionPane.showMessageDialog(this,mgr.string("supplyUsernamePassword"), 
                    mgr.string("error"), JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Use Account Svc to authenticate the username & password
        IAccountSvc impl = AccountSvcXmlImpl.getInstance();
        Account account = impl.authenticate(login);
        if (account == null) {
            JOptionPane.showMessageDialog(this, 
                    mgr.string("invalidUsernamePassword"), 
                    mgr.string("error"), JOptionPane.ERROR_MESSAGE);
        } else {
            this.setVisible(false);
            DiscussionListView.instance().setAccount(account);
        }
    }                                        

    /**
     * Sets look and feel and runs LoginView
     */
    public void run() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginView.instance().setVisible(true);
            }
        });
    }

    // Variables declaration                  
    private javax.swing.JPanel BackGround;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordFld;
    private javax.swing.JButton registerBtn;
    private javax.swing.JLabel title;
    private javax.swing.JPanel topBar;
    private javax.swing.JLabel username;
    private javax.swing.JTextField usernameFld;
    // End of variables declaration                   
}
