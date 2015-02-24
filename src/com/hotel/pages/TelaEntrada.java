package com.hotel.pages;

import com.hotel.classes.ChartLinear;
import com.hotel.classes.Contrato;
import com.hotel.classes.Sistema;
import com.hotel.interfaces.Tela;
import com.hotel.util.Log;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class TelaEntrada extends JFrame implements Tela{
 
    private SimpleTableModel model;
    
    
    public TelaEntrada() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setLocationRelativeTo(null);
        setTable();
    }
    
    
    private void setTable(){
        model = new SimpleTableModel(Sistema.getListaDeContratosFilterStatus(true));
        tabelaContratos.setModel(model);
    }

    @Override
    public void atualizar() {
        setTable();
        centralizeRows();
    }

    @Override
    public void fechar() {
        this.dispose();
        System.exit(0);
    }
    
    private void removeServico(){
        int id = (Integer) tabelaContratos.getModel().getValueAt(tabelaContratos.getSelectedRow(),0);
        
        boolean var = Sistema.removeContrato(id);
        if(var){
            atualizar();
            Log.view("Sucess!", "", "", 1, null);
        }else{
            Log.view("NÃO FOI POSSÍVEL DELETAR ITEM", "", "", 1, null);
        }
    }
    
    public void centralizeRows(){
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tabelaContratos.setDefaultRenderer(String.class, centerRenderer);
        tabelaContratos.setDefaultRenderer(Integer.class, centerRenderer);
        tabelaContratos.setDefaultRenderer(Double.class, centerRenderer);
    }
    
    
    
    
private class SimpleTableModel extends AbstractTableModel {
    public String[] m_colNames = { "ID", "NOME", "CPF", "VALOR TOTAL", "CHECKIN", "CHECKOUT", "STATUS" };

    public Class[] m_colTypes = { Integer.class, String.class, String.class, Double.class,
        String.class, String.class, String.class };

    ArrayList<Contrato> m_macDataVector;

    public SimpleTableModel(ArrayList<Contrato> macDataVector) {
      super();
      m_macDataVector = macDataVector;
      
       
    }
    public int getColumnCount() {
      return m_colNames.length;
    }
    public int getRowCount() {
      return m_macDataVector.size();
    }
    
    public String getColumnName(int col) {
      return m_colNames[col];
    }

    public Class getColumnClass(int col) {
      return m_colTypes[col];
    }
    public Object getValueAt(int row, int col) {
      Contrato macData = (Contrato) (m_macDataVector.get(row));

      switch (col) {
      case 0:
        return macData.getID();
      
      case 1:
        return macData.getHospede().getNome();
      
      case 2:
        return macData.getCartaoDeCredito().getCpfTitular();
      
      case 3:
        return macData.getValorTotal();
      
      case 4:
        return macData.getCheckin().toLocaleString();
      
      case 5:
        return macData.getCheckout().toLocaleString();
      
      case 6:
          if(macData.getStatus()){
              return "ABERTO";
          }else{
              return "FECHADO";
          }
        
      }

      return new String();
    }
  }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btnRecarregar = new javax.swing.JButton();
        btnCheckIn = new javax.swing.JButton();
        btnOpinioes = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaContratos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        campoPesquisar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HOTEL RIVIERA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1422745462_user-id-32.png"))); // NOI18N
        jButton1.setText("VISUALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1422745332_678069-sign-error-32.png"))); // NOI18N
        jButton2.setText("REMOVER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(70, 70, 70)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton2))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        jToolBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnRecarregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1423274247_reload.png"))); // NOI18N
        btnRecarregar.setText("RECARREGAR");
        btnRecarregar.setFocusable(false);
        btnRecarregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRecarregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRecarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecarregarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRecarregar);

        btnCheckIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1422745306_678092-sign-add-48.png"))); // NOI18N
        btnCheckIn.setText("CHECK-IN");
        btnCheckIn.setFocusable(false);
        btnCheckIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCheckIn.setMargin(new java.awt.Insets(2, 15, 2, 15));
        btnCheckIn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckInActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCheckIn);

        btnOpinioes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1422746126_678084-folder-48.png"))); // NOI18N
        btnOpinioes.setText("OPINIÕES");
        btnOpinioes.setFocusable(false);
        btnOpinioes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpinioes.setMargin(new java.awt.Insets(2, 15, 2, 15));
        btnOpinioes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnOpinioes);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1422746268_file-powerpoint-48.png"))); // NOI18N
        jButton3.setText("RELATORIOS");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1423274390_exit.png"))); // NOI18N
        btnSair.setText("SAIR");
        btnSair.setFocusable(false);
        btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSair.setMargin(new java.awt.Insets(2, 15, 2, 15));
        btnSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSair);

        tabelaContratos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabelaContratos.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tabelaContratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "CPF", "ENDERECO", "DATA NASCIMENTO", "ID PESSOA", "ID CONTRATO"
            }
        ));
        tabelaContratos.setRowHeight(20);
        tabelaContratos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaContratos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1422745491_search-24.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void btnRecarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecarregarActionPerformed
        atualizar();
    }//GEN-LAST:event_btnRecarregarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        fechar();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckInActionPerformed
        new TelaAddContrato(this).setVisible(true);
    }//GEN-LAST:event_btnCheckInActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         if(tabelaContratos.isRowSelected(tabelaContratos.getSelectedRow())){
            removeServico();
        }else{
            Log.view("SELECIONE UM CONTRATO", "", "", 1, null);
         }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(tabelaContratos.isRowSelected(tabelaContratos.getSelectedRow())){
            int id = (Integer) tabelaContratos.getModel().getValueAt(tabelaContratos.getSelectedRow(), 0);
            Contrato c = Sistema.pesquisaContrato(id);
            new TelaVisualizaContrato(this, c).setVisible(true);
        }else{
            Log.view("SELECIONE UM CONTRATO", "", "", 1, null);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new TelaChooseReport().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckIn;
    private javax.swing.JButton btnOpinioes;
    private javax.swing.JButton btnRecarregar;
    private javax.swing.JButton btnSair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoPesquisar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tabelaContratos;
    // End of variables declaration//GEN-END:variables

  
}
