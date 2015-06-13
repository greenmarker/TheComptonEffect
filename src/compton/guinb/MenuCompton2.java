package compton.guinb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import compton.AppConstants;
import compton.Physics;
import compton.animation.SinusoidComponent;

import java.awt.*;

/**
 *
 * @author Kamil
 */
public class MenuCompton2 extends javax.swing.JFrame {

    /**
     * Creates new form MenuCompton2
     */
    public MenuCompton2() {
        initComponents();
        panelAnimation.setLayout(new BorderLayout());
        panelAnimation.add(new SinusoidComponent(), BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        source = new javax.swing.ButtonGroup();
        panelParameters = new javax.swing.JPanel();
        labelEnergyBefore = new javax.swing.JLabel();
        labelAngle = new javax.swing.JLabel();
        labelEnergyAfter = new javax.swing.JLabel();
        labelSource = new javax.swing.JLabel();
        txtEnergyBefore = new javax.swing.JTextField();
        txtAngle = new javax.swing.JTextField();
        txtEnergyAfter = new javax.swing.JTextField();
        radioCaesium = new javax.swing.JRadioButton();
        radioIodine = new javax.swing.JRadioButton();
        sliderEnergyBefore = new javax.swing.JSlider();
        sliderAngle = new javax.swing.JSlider();
        unitkeV = new javax.swing.JLabel();
        unitDegree = new javax.swing.JLabel();
        panelAnimation = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(242, 242, 242));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("compton"); // NOI18N
        labelEnergyBefore.setText(bundle.getString("parameter_energy_before_dissipation")); // NOI18N

        labelAngle.setText(bundle.getString("parameter_angle")); // NOI18N

        labelEnergyAfter.setText(bundle.getString("parameter_energy_after_dissipation")); // NOI18N

        labelSource.setText(bundle.getString("sample_sources")); // NOI18N

        txtEnergyBefore.setText(AppConstants.DEFAULT_ENERGY_BEFORE + "");
        txtEnergyBefore.setToolTipText(bundle.getString("parameter_energy")); // NOI18N
        txtEnergyBefore.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEnergyBeforeKeyReleased(evt);
            }
        });

        txtAngle.setText(AppConstants.DEFAULT_ANGLE + "");
        txtAngle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAngleKeyReleased(evt);
            }
        });

        txtEnergyAfter.setEditable(false);

        source.add(radioCaesium);
        radioCaesium.setSelected(true);
        radioCaesium.setText(bundle.getString("caesium")); // NOI18N

        source.add(radioIodine);
        radioIodine.setText(bundle.getString("iodine")); // NOI18N

        sliderEnergyBefore.setMajorTickSpacing(1000);
        sliderEnergyBefore.setMaximum(1000);
        sliderEnergyBefore.setPaintLabels(true);
        sliderEnergyBefore.setValue(AppConstants.DEFAULT_ENERGY_BEFORE);
        sliderEnergyBefore.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderEnergyBeforeStateChanged(evt);
            }
        });

        sliderAngle.setMajorTickSpacing(180);
        sliderAngle.setMaximum(180);
        sliderAngle.setPaintLabels(true);
        sliderAngle.setValue(AppConstants.DEFAULT_ANGLE);
        sliderAngle.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderAngleStateChanged(evt);
            }
        });

        unitkeV.setText(bundle.getString("unit_kev")); // NOI18N

        unitDegree.setText(bundle.getString("unit_degree")); // NOI18N

        javax.swing.GroupLayout panelParametersLayout = new javax.swing.GroupLayout(panelParameters);
        panelParameters.setLayout(panelParametersLayout);
        panelParametersLayout.setHorizontalGroup(
            panelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParametersLayout.createSequentialGroup()
                .addGroup(panelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelEnergyAfter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelAngle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelEnergyBefore, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
                    .addComponent(labelSource))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelParametersLayout.createSequentialGroup()
                        .addGroup(panelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioIodine)
                            .addComponent(radioCaesium))
                        .addGap(0, 654, Short.MAX_VALUE))
                    .addGroup(panelParametersLayout.createSequentialGroup()
                        .addGroup(panelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEnergyBefore)
                            .addComponent(txtAngle)
                            .addComponent(txtEnergyAfter, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(unitkeV)
                            .addComponent(unitDegree))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sliderEnergyBefore, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                            .addComponent(sliderAngle, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)))))
        );
        panelParametersLayout.setVerticalGroup(
            panelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParametersLayout.createSequentialGroup()
                .addGroup(panelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderEnergyBefore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEnergyBefore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelEnergyBefore)
                        .addComponent(unitkeV)))
                .addGap(3, 3, 3)
                .addGroup(panelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAngle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelAngle)
                        .addComponent(unitDegree))
                    .addComponent(sliderAngle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(panelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEnergyAfter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEnergyAfter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSource)
                    .addComponent(radioCaesium))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioIodine)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelAnimation.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelAnimationLayout = new javax.swing.GroupLayout(panelAnimation);
        panelAnimation.setLayout(panelAnimationLayout);
        panelAnimationLayout.setHorizontalGroup(
            panelAnimationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelAnimationLayout.setVerticalGroup(
            panelAnimationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelAnimation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelParameters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAnimation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelParameters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sliderEnergyBeforeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderEnergyBeforeStateChanged
        this.txtEnergyBefore.setText(sliderEnergyBefore.getValue() + "");
        updateEnergyAfter();
    }//GEN-LAST:event_sliderEnergyBeforeStateChanged

    private void sliderAngleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderAngleStateChanged
        this.txtAngle.setText(sliderAngle.getValue() + "");
        updateEnergyAfter();
    }//GEN-LAST:event_sliderAngleStateChanged

    private void txtEnergyBeforeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnergyBeforeKeyReleased
        this.sliderEnergyBefore.setValue(Integer.parseInt(this.txtAngle.getText()));
        updateEnergyAfter();
    }//GEN-LAST:event_txtEnergyBeforeKeyReleased

    private void txtAngleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAngleKeyReleased
        this.sliderAngle.setValue(Integer.parseInt(this.txtAngle.getText()));
        updateEnergyAfter();
    }//GEN-LAST:event_txtAngleKeyReleased

    private void updateEnergyAfter(){
        double energyBefore = Double.parseDouble(this.txtEnergyBefore.getText());
        double electronMass = getSourceEnergy(); // TODO check what really should be here
        double angle = Double.parseDouble(this.txtAngle.getText());
        double energyAfter = Physics.getEnergyAfter(energyBefore, electronMass, angle);
        this.txtEnergyAfter.setText(energyAfter + "");
    }

    private int getSourceEnergy(){
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("compton");
        if (radioCaesium.isSelected()){
            return 662;
        } else if (radioIodine.isSelected()){
            return 364;
        }
        throw new RuntimeException("None of listed atoms was selected: "); // this would be a programmers error
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MenuCompton2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCompton2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCompton2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCompton2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuCompton2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelAngle;
    private javax.swing.JLabel labelEnergyAfter;
    private javax.swing.JLabel labelEnergyBefore;
    private javax.swing.JLabel labelSource;
    private javax.swing.JPanel panelAnimation;
    private javax.swing.JPanel panelParameters;
    private javax.swing.JRadioButton radioCaesium;
    private javax.swing.JRadioButton radioIodine;
    private javax.swing.JSlider sliderAngle;
    private javax.swing.JSlider sliderEnergyBefore;
    private javax.swing.ButtonGroup source;
    private javax.swing.JTextField txtAngle;
    private javax.swing.JTextField txtEnergyAfter;
    private javax.swing.JTextField txtEnergyBefore;
    private javax.swing.JLabel unitDegree;
    private javax.swing.JLabel unitkeV;
    // End of variables declaration//GEN-END:variables
}
