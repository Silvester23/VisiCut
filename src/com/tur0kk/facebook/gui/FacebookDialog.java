/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FacebookDialog.java
 *
 * Created on 06.01.2015, 13:45:50
 */
package com.tur0kk.facebook.gui;

import com.t_oster.visicut.gui.MainView;
import com.tur0kk.facebook.FacebookManager;
import com.tur0kk.LoadingIcon;
import com.tur0kk.TakePhotoThread;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sven
 */
public class FacebookDialog extends javax.swing.JDialog
{
  private Thread livecamThread;
  Object cameraLock = new Object();
  Lock cameraUsageLock = new ReentrantLock();
  
  
  /** Creates new form FacebookDialog */
  public FacebookDialog(java.awt.Frame parent, boolean modal){
    super(parent, modal);
    super.setLocationRelativeTo(parent);
    
    initComponents();
    
    // just hide to keep state
    this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    
    // close camera on exit
    initWindowListener();
    
    // change cam 
    ItemListener selectChangeListener = new ItemListener() {

      public void itemStateChanged(ItemEvent e)
      {
        boolean selected = (e.getStateChange( ) == ItemEvent.SELECTED);
        if(selected == true){ // only if selected
          closeCamera();
          setupCamera();
        }
      
      }
    };
    rdbtnWebcam.addItemListener(selectChangeListener);
    rdbtnVisicam.addItemListener(selectChangeListener);
    
    // enable picture taking
    setupCamera();
    
    // user name
    initUsername();
    
    // profile picture
    initProfilePicture();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpCams = new javax.swing.ButtonGroup();
        btnLogout = new javax.swing.JButton();
        lUserName = new javax.swing.JLabel();
        lProfilePicture = new javax.swing.JLabel();
        pnlFoto = new javax.swing.JPanel();
        btnPhoto = new javax.swing.JButton();
        btnPhotoRedo = new javax.swing.JButton();
        lblPhoto = new javax.swing.JLabel();
        lblPublish = new javax.swing.JLabel();
        lblPublishSuccessStatus = new javax.swing.JLabel();
        btnPublish = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaPublish = new javax.swing.JTextArea();
        lblLoading = new javax.swing.JLabel();
        pnlSelectCamera = new javax.swing.JPanel();
        rdbtnWebcam = new javax.swing.JRadioButton();
        rdbtnVisicam = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N
        setResizable(false);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.t_oster.visicut.gui.VisicutApp.class).getContext().getResourceMap(FacebookDialog.class);
        btnLogout.setText(resourceMap.getString("btnLogout.text")); // NOI18N
        btnLogout.setAlignmentX(5.0F);
        btnLogout.setAlignmentY(5.0F);
        btnLogout.setName("btnLogout"); // NOI18N
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lUserName.setFont(resourceMap.getFont("lUserName.font")); // NOI18N
        lUserName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lUserName.setName("lUserName"); // NOI18N

        lProfilePicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lProfilePicture.setAlignmentX(5.0F);
        lProfilePicture.setAlignmentY(5.0F);
        lProfilePicture.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("lProfilePicture.border.lineColor"))); // NOI18N
        lProfilePicture.setName("lProfilePicture"); // NOI18N

        pnlFoto.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("pnlFoto.border.lineColor"))); // NOI18N
        pnlFoto.setName("pnlFoto"); // NOI18N

        btnPhoto.setText(resourceMap.getString("btnPhoto.text")); // NOI18N
        btnPhoto.setName("btnPhoto"); // NOI18N
        btnPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhotoActionPerformed(evt);
            }
        });

        btnPhotoRedo.setText(resourceMap.getString("btnPhotoRedo.text")); // NOI18N
        btnPhotoRedo.setName("btnPhotoRedo"); // NOI18N
        btnPhotoRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhotoRedoActionPerformed(evt);
            }
        });

        lblPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhoto.setText(resourceMap.getString("lblPhoto.text")); // NOI18N
        lblPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("lProfilePicture.border.lineColor"))); // NOI18N
        lblPhoto.setName("lblPhoto"); // NOI18N

        lblPublish.setText(resourceMap.getString("lblPublish.text")); // NOI18N
        lblPublish.setAlignmentY(0.0F);
        lblPublish.setName("lblPublish"); // NOI18N

        lblPublishSuccessStatus.setText(resourceMap.getString("lblPublishSuccessStatus.text")); // NOI18N
        lblPublishSuccessStatus.setName("lblPublishSuccessStatus"); // NOI18N

        btnPublish.setText(resourceMap.getString("btnPublish.text")); // NOI18N
        btnPublish.setToolTipText(resourceMap.getString("btnPublish.toolTipText")); // NOI18N
        btnPublish.setName("btnPublish"); // NOI18N
        btnPublish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublishActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        txtaPublish.setColumns(20);
        txtaPublish.setLineWrap(true);
        txtaPublish.setRows(5);
        txtaPublish.setAlignmentX(0.0F);
        txtaPublish.setAlignmentY(0.0F);
        txtaPublish.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("lProfilePicture.border.lineColor"))); // NOI18N
        txtaPublish.setName("txtaPublish"); // NOI18N
        jScrollPane1.setViewportView(txtaPublish);

        lblLoading.setIcon(LoadingIcon.get(LoadingIcon.CIRCLEBALL_SMALL));
        lblLoading.setText(resourceMap.getString("lblLoading.text")); // NOI18N
        lblLoading.setName("lblLoading"); // NOI18N

        javax.swing.GroupLayout pnlFotoLayout = new javax.swing.GroupLayout(pnlFoto);
        pnlFoto.setLayout(pnlFotoLayout);
        pnlFotoLayout.setHorizontalGroup(
            pnlFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFotoLayout.createSequentialGroup()
                        .addComponent(btnPhoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPhotoRedo)))
                .addGroup(pnlFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlFotoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblPublish)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPublishSuccessStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPublish))
                    .addGroup(pnlFotoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlFotoLayout.setVerticalGroup(
            pnlFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPhotoRedo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPublish, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPublishSuccessStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPublish)
                    .addComponent(lblLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlSelectCamera.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("pnlSelectCamera.border.title"))); // NOI18N
        pnlSelectCamera.setToolTipText(resourceMap.getString("pnlSelectCamera.toolTipText")); // NOI18N
        pnlSelectCamera.setName("pnlSelectCamera"); // NOI18N
        pnlSelectCamera.setLayout(new java.awt.GridLayout(2, 1));

        grpCams.add(rdbtnWebcam);
        rdbtnWebcam.setSelected(true);
        rdbtnWebcam.setText(resourceMap.getString("rdbtnWebcam.text")); // NOI18N
        rdbtnWebcam.setName("rdbtnWebcam"); // NOI18N
        pnlSelectCamera.add(rdbtnWebcam);

        grpCams.add(rdbtnVisicam);
        rdbtnVisicam.setText(resourceMap.getString("rdbtnVisicam.text")); // NOI18N
        rdbtnVisicam.setName("rdbtnVisicam"); // NOI18N
        pnlSelectCamera.add(rdbtnVisicam);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lProfilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlSelectCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSelectCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lProfilePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(pnlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
    FacebookManager.getInstance().logOut();
    dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)); // closing event closes the camera
}//GEN-LAST:event_btnLogoutActionPerformed

private void btnPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhotoActionPerformed
    closeCamera();
    
    // enable publishing
    btnPhoto.setEnabled(false);
    btnPhotoRedo.setEnabled(true);
    btnPublish.setEnabled(true);
}//GEN-LAST:event_btnPhotoActionPerformed

  private void btnPhotoRedoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPhotoRedoActionPerformed
  {//GEN-HEADEREND:event_btnPhotoRedoActionPerformed
    setupCamera();
  }//GEN-LAST:event_btnPhotoRedoActionPerformed

  private void btnPublishActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPublishActionPerformed
  {//GEN-HEADEREND:event_btnPublishActionPerformed
    
    
    // disable controls for publishing
    lblLoading.setVisible(true);
    btnPhotoRedo.setEnabled(false);
    btnPublish.setEnabled(false);
    
    // things to publish
    ImageIcon icon = (ImageIcon)lblPhoto.getIcon();
    final Image image = icon.getImage();    
    final String message = txtaPublish.getText();
    
    
    new Thread(new Runnable() {

      public void run()
      {
        FacebookManager facebook = FacebookManager.getInstance();
        boolean success = facebook.publishProject(message, image);
        String msg = "";
        if(success){
          msg = "Successful upload";
        }else{
          msg = "Error uploading photo";
        }
        
        final String message = msg;
        SwingUtilities.invokeLater(new Runnable() {
          public void run()
          {
            lblPublishSuccessStatus.setText(message);
            lblPublishSuccessStatus.setVisible(true);
            btnPhotoRedo.setEnabled(true);
            lblLoading.setVisible(false);
          }
        });
        
      }
    }).start();
    
    
  }//GEN-LAST:event_btnPublishActionPerformed

private void initWindowListener(){
  this.addWindowListener(new WindowListener() {

      public void windowOpened(WindowEvent e)
      {

      }

      public void windowClosing(WindowEvent e)
      {
         closeCamera();
      }

      public void windowClosed(WindowEvent e)
      {

      }

      public void windowIconified(WindowEvent e)
      {

      }

      public void windowDeiconified(WindowEvent e)
      {

      }

      public void windowActivated(WindowEvent e)
      {

      }

      public void windowDeactivated(WindowEvent e)
      {

      }
    });
}

private void initUsername(){
    
  // display username
  new Thread(new Runnable() {
    String username = null;
    public void run()
    {
      // display loading icon
      final ImageIcon loadingIcon = LoadingIcon.get(LoadingIcon.CIRCLEBALL_MEDIUM);
      // display loading icon in label
      SwingUtilities.invokeLater(new Runnable() {
        public void run()
        {
          lProfilePicture.setIcon(loadingIcon);
        }
      });
        
      // get profile picture
      FacebookManager facebook = FacebookManager.getInstance();
      
      username = facebook.getUserName();
      SwingUtilities.invokeLater(new Runnable() {
        public void run()
        {
          lUserName.setText("Hello " + username);
        }
      });
    }
  }).start();
}

private void initProfilePicture(){
    
  // set profile picture
  new Thread(new Runnable() {

    public void run()
    {
      // profile picture, resized to label
      try
      {
        FacebookManager facebook = FacebookManager.getInstance();
        
        String path = facebook.getUserImage();
        URL url = new URL(path);

        // load profile picture and scale to label
        ImageIcon imageIcon = new ImageIcon(url);
        Image rawImage = imageIcon.getImage();
        Image scaledImage = rawImage.getScaledInstance(
          lProfilePicture.getWidth(),
          lProfilePicture.getHeight(),
          Image.SCALE_SMOOTH);
        final ImageIcon profilePicture = new ImageIcon(scaledImage);
        SwingUtilities.invokeLater(new Runnable() {
          public void run()
          {
            lProfilePicture.setIcon(profilePicture);
          }
        });
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
    }
  }).start();
}
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPhoto;
    private javax.swing.JButton btnPhotoRedo;
    private javax.swing.JButton btnPublish;
    private javax.swing.ButtonGroup grpCams;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lProfilePicture;
    private javax.swing.JLabel lUserName;
    private javax.swing.JLabel lblLoading;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblPublish;
    private javax.swing.JLabel lblPublishSuccessStatus;
    private javax.swing.JPanel pnlFoto;
    private javax.swing.JPanel pnlSelectCamera;
    private javax.swing.JRadioButton rdbtnVisicam;
    private javax.swing.JRadioButton rdbtnWebcam;
    private javax.swing.JTextArea txtaPublish;
    // End of variables declaration//GEN-END:variables

    
/*
 * Camera functions
 */
    
private void setupCamera(){
  // disable publish functions
  lblPhoto.setIcon(null);
  lblLoading.setVisible(false);
  lblPublishSuccessStatus.setVisible(false);
  btnPhotoRedo.setEnabled(false);
  btnPublish.setEnabled(false);
  
  // check selected cam mode and if corresponding hardware is available
  boolean start = false;
  if(rdbtnWebcam.isSelected()){
    if(TakePhotoThread.isWebCamDetected()){
      start = true;
    }
  }
  else{// visicam
    if(TakePhotoThread.isVisiCamDetected()){
      start = true;
    }
  }

  if(start){
    // start picture taking thread to display live preview
    boolean webcamMode = rdbtnWebcam.isSelected(); // if false, then visicam
    livecamThread = new TakePhotoThread(lblPhoto, webcamMode);
    livecamThread.start();

    btnPhoto.setEnabled(true);
  }
  else{
    // disable taking photos
    btnPhoto.setEnabled(false);
    lblPhoto.setText("Please attach webcam");
  }
}

private void closeCamera(){
  if(livecamThread != null){
    livecamThread.interrupt(); // stop live stream thread
    livecamThread = null;
  }
}


}
