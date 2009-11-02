package ubadbtools.recoveryLogAnalyzer.gui.forms;

import java.awt.Frame;
import java.util.Set;

import ubadbtools.recoveryLogAnalyzer.logRecords.RecoveryLogRecord;

public class StartCheckpointLogRecordDialog extends javax.swing.JDialog {

	private RecoveryLogRecord logRecord = null;    

    public StartCheckpointLogRecordDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    
    public static RecoveryLogRecord showDialog(Frame parent, Set<String> transactions)
    {
    	StartCheckpointLogRecordDialog dialog = new StartCheckpointLogRecordDialog(parent, true);
        dialog.setVisible(true);
        
        return dialog.logRecord;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btCancelar = new javax.swing.JButton();
        btAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Start Checkpoint");

        btCancelar.setText("Cancelar");
        btCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCancelarMouseClicked(evt);
            }
        });

        btAceptar.setText("Aceptar");
        btAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAceptarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(btAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btAceptar))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarMouseClicked
       this.setVisible(false);
    }//GEN-LAST:event_btCancelarMouseClicked

    private void btAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAceptarMouseClicked
//        logRecord = new CommitLogRecord((String)cbTransactions.getSelectedItem());
        this.setVisible(false);
    }//GEN-LAST:event_btAceptarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
