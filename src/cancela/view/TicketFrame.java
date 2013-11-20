/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on Nov 18, 2013, 1:08:03 AM
 */
package cancela.view;

import cancela.dados.CancelaDAO;
import cancela.dados.CancelaDAOException;
import cancela.dados.CancelaDAOJavaDb;
import cancela.dados.CancelaDAOJavaDbGerencial;
import cancela.model.CancelaFachada;
import cancela.model.CodigoSimples;
import cancela.model.Ticket;
import cancela.services.Calculo;
import cancela.services.CalculoSimples;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author italo
 */
public class TicketFrame extends javax.swing.JFrame {
    private CancelaFachada fac;
    private Calculo cs;
    private Ticket ticket;
    /** Creates new form MainFrame */
    public TicketFrame(CancelaFachada fachada, Ticket tick) throws CancelaDAOException {
        cs = new CalculoSimples();
        fac = fachada;
        ticket = tick;
        initComponents();
        initValues();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        liberaTicket = new java.awt.Button();
        codigoLabel = new javax.swing.JLabel();
        dataLabel = new javax.swing.JLabel();
        codigoTicket = new java.awt.TextField();
        dataTicket = new java.awt.TextField();
        statusLabel = new javax.swing.JLabel();
        statusTicket = new java.awt.TextField();
        dividaLabel = new javax.swing.JLabel();
        precoTicket = new java.awt.TextField();
        liberaTicketSem = new java.awt.Button();
        extraviadoTicket = new java.awt.Button();
        textoPadrao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        liberaTicket.setLabel("Libera Ticket");
        liberaTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liberaTicketActionPerformed(evt);
            }
        });

        codigoLabel.setText("Codigo Ticket");

        dataLabel.setText("Data de entrada");

        codigoTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        codigoTicket.setEditable(false);
        codigoTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoTicketActionPerformed(evt);
            }
        });

        dataTicket.setEditable(false);
        dataTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataTicketActionPerformed(evt);
            }
        });

        statusLabel.setText("Status");

        statusTicket.setEditable(false);

        dividaLabel.setText("Total a pagar");

        precoTicket.setEditable(false);

        liberaTicketSem.setLabel("Libera Ticket sem pagar");
        liberaTicketSem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liberaTicketSemActionPerformed(evt);
            }
        });

        extraviadoTicket.setLabel("Extraviado");
        extraviadoTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extraviadoTicketActionPerformed(evt);
            }
        });

        textoPadrao.setText("Janela que libera os tickets de estacionamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(codigoLabel)
                                    .addComponent(dataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(dividaLabel)
                                .addComponent(statusLabel))
                            .addGap(34, 34, 34)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(statusTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                                .addComponent(dataTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                                .addComponent(codigoTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                                .addComponent(precoTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(liberaTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)
                            .addComponent(liberaTicketSem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                            .addComponent(extraviadoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textoPadrao)
                        .addGap(77, 77, 77))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(textoPadrao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(codigoTicket, 0, 0, Short.MAX_VALUE)
                    .addComponent(codigoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataLabel)
                    .addComponent(dataTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(statusTicket, 0, 0, Short.MAX_VALUE)
                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(precoTicket, 0, 0, Short.MAX_VALUE)
                    .addComponent(dividaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(liberaTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(liberaTicketSem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(extraviadoTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void liberaTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liberaTicketActionPerformed
   try {
       if (!fac.validaTicket(ticket.getCodigo().getCodigo())) {
           fac.liberaTicket(ticket.getCodigo().getCodigo(),cs.calculaPreco(ticket));
           this.ticket = fac.getTicketPorCodigo(ticket.getCodigo());
       }   
    codigoTicket.setText(ticket.getCodigo().getCodigo());
    Timestamp ts = new Timestamp(ticket.getDate().getTimeInMillis());
    dataTicket.setText(ts.toString());
    statusTicket.setText(String.valueOf(ticket.getStatus()));
    precoTicket.setText(String.valueOf(cs.calculaPreco(ticket)));
   } catch (CancelaDAOException ex) {
    Logger.getLogger(TicketFrame.class.getName()).log(Level.SEVERE, null, ex);
   }
}//GEN-LAST:event_liberaTicketActionPerformed

private void codigoTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoTicketActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_codigoTicketActionPerformed

private void dataTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataTicketActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_dataTicketActionPerformed

private void liberaTicketSemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liberaTicketSemActionPerformed
// TODO add your handling code here:
       try {
       if (!fac.validaTicket(ticket.getCodigo().getCodigo())) {
           fac.liberaTicket(ticket.getCodigo().getCodigo(),0.0);
           this.ticket = fac.getTicketPorCodigo(ticket.getCodigo());
       }   
    codigoTicket.setText(ticket.getCodigo().getCodigo());
    Timestamp ts = new Timestamp(ticket.getDate().getTimeInMillis());
    dataTicket.setText(ts.toString());
    statusTicket.setText(String.valueOf(ticket.getStatus()));
    precoTicket.setText(String.valueOf(cs.calculaPreco(ticket)));
   } catch (CancelaDAOException ex) {
    Logger.getLogger(TicketFrame.class.getName()).log(Level.SEVERE, null, ex);
   }
}//GEN-LAST:event_liberaTicketSemActionPerformed

private void extraviadoTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extraviadoTicketActionPerformed
// TODO add your handling code here:
       try {
       if (!fac.validaTicket(ticket.getCodigo().getCodigo())) {
           fac.liberaTicket(ticket.getCodigo().getCodigo(),CalculoSimples.precoExtraviado);
           this.ticket = fac.getTicketPorCodigo(ticket.getCodigo());
       }   
    codigoTicket.setText(ticket.getCodigo().getCodigo());
    Timestamp ts = new Timestamp(ticket.getDate().getTimeInMillis());
    dataTicket.setText(ts.toString());
    statusTicket.setText(String.valueOf(ticket.getStatus()));
    precoTicket.setText(String.valueOf(cs.calculaPreco(ticket)));
   } catch (CancelaDAOException ex) {
    Logger.getLogger(TicketFrame.class.getName()).log(Level.SEVERE, null, ex);
   }
}//GEN-LAST:event_extraviadoTicketActionPerformed

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
        } catch (ClassNotFoundException ex)TicketFrame      java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)TicketFrame      java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)TicketFrame      java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)TicketFrame      java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        try {
            final CancelaFachada t = new CancelaFachada();
            final Ticket teste = new Ticket(new CodigoSimples(),new GregorianCalendar(2013, 11, 13, 0, 0 ),1);
            t.adicionaTicket();
        java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
                    try {
                       // new TicketFrame(teste,b).setVisible(true);
                         new TicketFrame(new CancelaFachada(),t.getTodos().get(0)).setVisible(true);
                          //new TicketFrame(teste,b2).setVisible(true);
                    } catch (CancelaDAOException ex) {
                        Logger.getLogger(TicketFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        });
        } catch (Exception e) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codigoLabel;
    private java.awt.TextField codigoTicket;
    private javax.swing.JLabel dataLabel;
    private java.awt.TextField dataTicket;
    private javax.swing.JLabel dividaLabel;
    private java.awt.Button extraviadoTicket;
    private java.awt.Button liberaTicket;
    private java.awt.Button liberaTicketSem;
    private java.awt.TextField precoTicket;
    private javax.swing.JLabel statusLabel;
    private java.awt.TextField statusTicket;
    private javax.swing.JLabel textoPadrao;
    // End of variables declaration//GEN-END:variables

    private void initValues() throws CancelaDAOException {
        codigoTicket.setText(ticket.getCodigo().getCodigo());
        Timestamp ts = new Timestamp(ticket.getDate().getTimeInMillis());
        dataTicket.setText(ts.toString());
        statusTicket.setText(String.valueOf(ticket.getStatus())); 
        precoTicket.setText(String.valueOf(cs.calculaPreco(ticket)));
    }
}