/*
 * (C) 2018 Derick Peterson, All rights reserved
 * Unauthorized duplication or distriubution without
 * the author's permission is strictly forbidden.
 * 
 * CS479 - Ethical Leadership in Computer Science
 */
package community.presentation;

import community.EncryptionMgr;
import community.ResourceMgr;
import community.services.*;
import community.domain.*;
import javax.swing.JOptionPane;

public class CreateAccountView extends javax.swing.JFrame {

    private static final CreateAccountView SINGLETON;
    
    static {
        SINGLETON = new CreateAccountView();
    }
    
    /**
     * instance() returns instance of CreateAccountView
     * @return CreateAccountView instance
     */
    public static CreateAccountView instance() {
        return SINGLETON;
    }
    
    /**
     * Creates new form NewJFrame
     */
    public CreateAccountView() {
        initComponents();
    }

    /**
     * initComponents() initializes GUI interface
     */
    @SuppressWarnings("unchecked")                         
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        topBar = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        usernameFld = new javax.swing.JTextField();
        passwordFld = new javax.swing.JPasswordField();
        registerUser = new javax.swing.JButton();
        verifyPassword = new javax.swing.JLabel();
        confirmPasswordFld = new javax.swing.JPasswordField();
        firstNameFld = new javax.swing.JTextField();
        firstName = new javax.swing.JLabel();
        lastNameFld = new javax.swing.JTextField();
        lastName = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        
        ResourceMgr mgr = ResourceMgr.instance();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 360));

        BackGround.setBackground(new java.awt.Color(102, 102, 102));

        topBar.setBackground(new java.awt.Color(204, 204, 204));

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setText(mgr.string("registerTitle"));

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        title.getAccessibleContext().setAccessibleName(mgr.string("registerTitleAccName"));
        title.getAccessibleContext().setAccessibleDescription(mgr.string("registerTitleAccDes"));

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
        passwordFld.setNextFocusableComponent(confirmPasswordFld);

        registerUser.setBackground(new java.awt.Color(204, 204, 204));
        registerUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registerUser.setText(mgr.string("registerBtn"));
        registerUser.setToolTipText(mgr.string("registerBtnTT"));
        registerUser.setNextFocusableComponent(cancel);
        registerUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerUserActionPerformed(evt);
            }
        });

        verifyPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        verifyPassword.setText(mgr.string("verifyPassword"));
        verifyPassword.setLabelFor(confirmPasswordFld);

        confirmPasswordFld.setBackground(new java.awt.Color(204, 204, 204));
        confirmPasswordFld.setNextFocusableComponent(registerUser);

        firstNameFld.setBackground(new java.awt.Color(204, 204, 204));
        firstNameFld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstNameFld.setNextFocusableComponent(lastNameFld);

        firstName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstName.setText(mgr.string("firstName"));
        firstName.setLabelFor(firstNameFld);

        lastNameFld.setBackground(new java.awt.Color(204, 204, 204));
        lastNameFld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastNameFld.setNextFocusableComponent(usernameFld);

        lastName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastName.setText(mgr.string("lastName"));
        lastName.setLabelFor(lastNameFld);

        cancel.setBackground(new java.awt.Color(204, 204, 204));
        cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancel.setText(mgr.string("cancelBtn"));
        cancel.setToolTipText(mgr.string("cancelBtnTT"));
        cancel.setNextFocusableComponent(firstNameFld);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGroundLayout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addComponent(password)
                        .addGap(18, 18, 18)
                        .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackGroundLayout.createSequentialGroup()
                        .addComponent(username)
                        .addGap(18, 18, 18)
                        .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BackGroundLayout.createSequentialGroup()
                            .addComponent(lastName)
                            .addGap(18, 18, 18)
                            .addComponent(lastNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BackGroundLayout.createSequentialGroup()
                                .addComponent(firstName)
                                .addGap(18, 18, 18)
                                .addComponent(firstNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BackGroundLayout.createSequentialGroup()
                                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cancel)
                                    .addComponent(verifyPassword))
                                .addGap(18, 18, 18)
                                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(confirmPasswordFld, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGroundLayout.createSequentialGroup()
                                        .addComponent(registerUser)
                                        .addGap(31, 31, 31)))))))
                .addGap(121, 121, 121))
        );

        BackGroundLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {confirmPasswordFld, firstNameFld, lastNameFld, passwordFld, usernameFld});

        BackGroundLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {firstName, lastName, password, username, verifyPassword});

        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(firstName)
                    .addComponent(firstNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lastName)
                    .addComponent(lastNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(username)
                    .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(password)
                    .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(verifyPassword)
                    .addComponent(confirmPasswordFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerUser)
                    .addComponent(cancel))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        BackGroundLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {confirmPasswordFld, firstNameFld, lastNameFld, passwordFld, usernameFld});

        BackGroundLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {firstName, lastName, password, username, verifyPassword});

        username.getAccessibleContext().setAccessibleName(mgr.string("usernameAccName"));
        password.getAccessibleContext().setAccessibleName(mgr.string("passwordAccName"));
        usernameFld.getAccessibleContext().setAccessibleName(mgr.string("usernameFldAccName"));
        usernameFld.getAccessibleContext().setAccessibleDescription(mgr.string("usernameFldAccDes"));
        passwordFld.getAccessibleContext().setAccessibleName(mgr.string("passwordFldAccName"));
        passwordFld.getAccessibleContext().setAccessibleDescription(mgr.string("passwordFldAccDes"));
        registerUser.getAccessibleContext().setAccessibleName(mgr.string("registerBtn"));
        verifyPassword.getAccessibleContext().setAccessibleName(mgr.string("verifyPasswordAccName"));
        confirmPasswordFld.getAccessibleContext().setAccessibleName(mgr.string("confirmPasswordFldAccName"));
        confirmPasswordFld.getAccessibleContext().setAccessibleDescription(mgr.string("confirmPasswordFldAccDes"));
        firstNameFld.getAccessibleContext().setAccessibleName(mgr.string("firstNameFldAccName"));
        firstNameFld.getAccessibleContext().setAccessibleDescription(mgr.string("firstNameFldAccDes"));
        firstName.getAccessibleContext().setAccessibleName(mgr.string("firstNameAccName"));
        lastNameFld.getAccessibleContext().setAccessibleName(mgr.string("lastNameFldAccName"));
        lastNameFld.getAccessibleContext().setAccessibleDescription(mgr.string("lastNameFldAccDes"));
        lastName.getAccessibleContext().setAccessibleName(mgr.string("lastNameAccName"));
        cancel.getAccessibleContext().setAccessibleName(mgr.string("cancelBtnAccName"));

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
     * registerUserActionPerformed(ActionEvent) Creates user account from input
     *      field data hides CreateAccountView and displays LoginView
     * @param evt 
     */
    private void registerUserActionPerformed(java.awt.event.ActionEvent evt) {                                             
        ResourceMgr mgr = ResourceMgr.instance();
        EncryptionMgr mgre = new EncryptionMgr();
        
        Login login = new Login();
        login.setUsername(usernameFld.getText());
        login.setPassword(new String(passwordFld.getPassword()));
        if (!login.validate()) {
            JOptionPane.showMessageDialog(this, 
                mgr.string("supplyUsernamePassord"), mgr.string("error"),
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String confirmPassword = new String(confirmPasswordFld.getPassword());
        if (!mgre.verify(login.getPassword(), confirmPassword)) {
            JOptionPane.showMessageDialog(this, mgr.string("mismatchPasswords"),
                    mgr.string("error"), JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Account account = new Account();
        account.setFirstName(firstNameFld.getText());
        account.setLastName(lastNameFld.getText());
        account.setLogin(login);
        boolean isValid = account.validate();
        if (!isValid) {
            JOptionPane.showMessageDialog(this, mgr.string("supplyFirstLastName"),
                    mgr.string("error"), JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            AccountSvcXmlImpl impl = AccountSvcXmlImpl.getInstance();
            account = impl.create(account);
            JOptionPane.showMessageDialog(this, mgr.string("accountCreated"), mgr.string("accountCreatedTitle"), JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            
            LoginView.instance().run();
        }
    }                                            

    /**
     * cancelActionPerformed(ActionEvent) hides CreateAccountView and displays
     *      LoginView
     * @param evt 
     */
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {                                       
            this.setVisible(false);
            LoginView.instance().run();
    }                                      

    /**
     * Sets Look and Feel and runs launches CreateAccountView
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
            java.util.logging.Logger.getLogger(CreateAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAccountView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel BackGround;
    private javax.swing.JButton cancel;
    private javax.swing.JPasswordField confirmPasswordFld;
    private javax.swing.JLabel firstName;
    private javax.swing.JTextField firstNameFld;
    private javax.swing.JLabel lastName;
    private javax.swing.JTextField lastNameFld;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordFld;
    private javax.swing.JButton registerUser;
    private javax.swing.JLabel title;
    private javax.swing.JPanel topBar;
    private javax.swing.JLabel username;
    private javax.swing.JTextField usernameFld;
    private javax.swing.JLabel verifyPassword;
    // End of variables declaration                   
}
