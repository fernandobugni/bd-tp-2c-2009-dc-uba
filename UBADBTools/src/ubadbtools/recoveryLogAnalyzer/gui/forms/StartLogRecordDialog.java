package ubadbtools.recoveryLogAnalyzer.gui.forms;

import java.awt.Frame;
import java.util.Set;

import ubadbtools.recoveryLogAnalyzer.logRecords.RecoveryLogRecord;
import ubadbtools.recoveryLogAnalyzer.logRecords.StartLogRecord;
import ubadbtools.util.guiHelper.GUIHelper;

/**
 *
 * @author ces
 */
public class StartLogRecordDialog extends javax.swing.JDialog {

	//[start] Atributos
	private RecoveryLogRecord logRecord = null;
	//[end]
	
	//[start] Constructor
    public StartLogRecordDialog(java.awt.Frame parent, boolean modal, Set<String> transactions) {
        super(parent, modal);
        initComponents();
        
        //Lleno las transacciones
        for(String transaction : transactions)
        	cbTransactions.addItem(transaction);
    }
    //[end]

    //[start] showDialog
    public static RecoveryLogRecord showDialog(Frame parent, Set<String> transactions)
    {
    	StartLogRecordDialog dialog = new StartLogRecordDialog(parent, true, transactions);
        dialog.setVisible(true);
        
        return dialog.logRecord;
    }
    //[end]
    
    //[start] InitComponents (AUTO-GENERATED)
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btCancelar = new javax.swing.JButton();
        btAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbTransactions = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Start");

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

        jLabel1.setText("Transacci�n");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //[end]

    //[start] Eventos
    private void btCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarMouseClicked
       this.setVisible(false);
    }//GEN-LAST:event_btCancelarMouseClicked

    private void btAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAceptarMouseClicked
    	if(cbTransactions.getSelectedItem()==null)
        	GUIHelper.showWarningMessage(this, "Falta ingresar alg�n dato");
    	else
    	{
	    	logRecord = new StartLogRecord((String)cbTransactions.getSelectedItem());
	        this.setVisible(false);
    	}
    }//GEN-LAST:event_btAceptarMouseClicked
    //[end]

    //[start] Variables Form (AUTO-GENERATED)
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JComboBox cbTransactions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    //[end]

}
