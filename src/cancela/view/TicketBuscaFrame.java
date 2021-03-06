/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cancela.view;

import cancela.dados.CancelaDAOException;
import cancela.negocio.CancelaFachada;
import cancela.negocio.CodigoSimples;
import cancela.negocio.Ticket;
import cancela.negocio.TicketEvent;
import cancela.negocio.TicketListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 12104861
 */
public class TicketBuscaFrame extends javax.swing.JFrame implements MouseListener,TicketListener  {

    /**
     * Creates new form TicketBuscaFrame
     */
    public CancelaFachada fac;
    public TicketBuscaFrame(CancelaFachada fachada) {
        this.fac = fachada;
        this.fac.addCadastroListener(this);
        initComponents();
        setJlist();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        informaCodigoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codigoField = new javax.swing.JTextField();
        optionsPanel = new javax.swing.JPanel();
        porCodigoOption = new javax.swing.JRadioButton();
        todosOptions = new javax.swing.JRadioButton();
        naoPagoOption = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        bucarButton = new javax.swing.JButton();
        extraviadosButton = new javax.swing.JRadioButton();
        pagosButton = new javax.swing.JRadioButton();
        resultadoPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Codigo :");

        codigoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout informaCodigoPanelLayout = new javax.swing.GroupLayout(informaCodigoPanel);
        informaCodigoPanel.setLayout(informaCodigoPanelLayout);
        informaCodigoPanelLayout.setHorizontalGroup(
            informaCodigoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informaCodigoPanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(codigoField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        informaCodigoPanelLayout.setVerticalGroup(
            informaCodigoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informaCodigoPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(informaCodigoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonGroup1.add(porCodigoOption);
        porCodigoOption.setSelected(true);
        porCodigoOption.setText("Por codigo");
        porCodigoOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porCodigoOptionActionPerformed(evt);
            }
        });

        buttonGroup1.add(todosOptions);
        todosOptions.setText("Todos");
        todosOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todosOptionsActionPerformed(evt);
            }
        });

        buttonGroup1.add(naoPagoOption);
        naoPagoOption.setText("Não Pagos");

        jLabel2.setText("Criterio de busca:");

        bucarButton.setText("Busca");
        bucarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bucarButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(extraviadosButton);
        extraviadosButton.setText("Extraviados");
        extraviadosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extraviadosButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(pagosButton);
        pagosButton.setText("Pagos");

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addComponent(porCodigoOption)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(todosOptions)
                        .addGap(18, 18, 18)
                        .addComponent(naoPagoOption)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(extraviadosButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pagosButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(bucarButton)
                        .addGap(34, 34, 34))))
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionsPanelLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(porCodigoOption)
                    .addComponent(todosOptions)
                    .addComponent(naoPagoOption)
                    .addComponent(bucarButton)
                    .addComponent(extraviadosButton)
                    .addComponent(pagosButton))
                .addContainerGap())
        );

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout resultadoPanelLayout = new javax.swing.GroupLayout(resultadoPanel);
        resultadoPanel.setLayout(resultadoPanelLayout);
        resultadoPanelLayout.setHorizontalGroup(
            resultadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultadoPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        resultadoPanelLayout.setVerticalGroup(
            resultadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultadoPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultadoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(informaCodigoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(informaCodigoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultadoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoFieldActionPerformed

    private void bucarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bucarButtonActionPerformed
        // TODO add your handling code here:        
        validaOpcao();
    }//GEN-LAST:event_bucarButtonActionPerformed

    private void todosOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todosOptionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_todosOptionsActionPerformed

    private void porCodigoOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porCodigoOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_porCodigoOptionActionPerformed

    private void extraviadosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extraviadosButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_extraviadosButtonActionPerformed
    public void validaOpcao() {
        try {            
            if (todosOptions.isSelected()) { 
                jList1.setListData(fac.getTodos().toArray());
            } else if (naoPagoOption.isSelected()) {
                jList1.setListData(fac.getTodosNaoPagos().toArray());
            }else if (extraviadosButton.isSelected()) {
                jList1.setListData(fac.getTodosExtraviados().toArray());
            }else if (pagosButton.isSelected()) {
                jList1.setListData(fac.getTodosPagos().toArray());
                System.out.println(fac.getTodosPagos().toArray());
            } else if (porCodigoOption.isSelected()) {
                Ticket[] data = new Ticket[1];
                data[0] = fac.getTicketPorCodigo(new CodigoSimples(codigoField.getText()));
                jList1.setListData(data);
            }
        } catch (CancelaDAOException ex) {
            Logger.getLogger(TicketBuscaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bucarButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField codigoField;
    private javax.swing.JRadioButton extraviadosButton;
    private javax.swing.JPanel informaCodigoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JRadioButton naoPagoOption;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JRadioButton pagosButton;
    private javax.swing.JRadioButton porCodigoOption;
    private javax.swing.JPanel resultadoPanel;
    private javax.swing.JRadioButton todosOptions;
    // End of variables declaration//GEN-END:variables

    private void setJlist() {
    jList1.setModel(new javax.swing.AbstractListModel() {
        Object[] strings = {};
        @Override
        public int getSize() { return strings.length; }
        @Override
        public Object getElementAt(int i) { return strings[i];}
        });
    
    jList1.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(jList1.isSelectionEmpty()) {
            return;
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
                    try {
                         new TicketPagamentoFramev2(fac,(Ticket)jList1.getSelectedValue()).setVisible(true);
                    } catch (CancelaDAOException ex) {
                        Logger.getLogger(TicketPagamentoFramev2.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        });
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void elementoAlterado(TicketEvent evt) {
        validaOpcao();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
