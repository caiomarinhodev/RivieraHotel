package com.hotel.pages;

import com.hotel.classes.Contrato;
import com.hotel.classes.ServicoAluguelCarro;
import com.hotel.classes.Sistema;
import com.hotel.enums.TipoServicoAluguelCarro;
import com.hotel.interfaces.Tela;
import com.hotel.util.Log;
import javax.swing.JFrame;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;


public class TelaAddServicoDeAluguelDeCarros extends JFrame implements Tela{
    private Tela telaanterior;
    private Contrato contrato;
    
    public TelaAddServicoDeAluguelDeCarros(Tela tela, Contrato con) {
        this.contrato = con;
        this.telaanterior = tela;
        initComponents();
        setLocationRelativeTo(null);
        initializeStrategy();
    }
    
    private void initializeStrategy() {
        DateTimeZone BRAZIL = DateTimeZone.forID("America/Sao_Paulo");
        DateTime d1 = new DateTime(BRAZIL);
        boolean a = Sistema.verifyFimDeAno(d1);
        boolean b = Sistema.verifySaoJoaoOne(d1);
        boolean c = Sistema.verifySaoJoaoTwo(d1);
        
        if(a){
           Sistema.setSTRATEGY(1);
        }else if(b){
            Sistema.setSTRATEGY(2);
        }else if(c){
            Sistema.setSTRATEGY(3);
        }else{
            Sistema.setSTRATEGY(0);
        }
    }
    
    private void acaoConfirmar(){
        String tipo;
        int diarias;
        boolean isAdicional, carroAssegurado, tanqueCheio;
        
        isAdicional = campoTanque.isEnabled();
        
        tipo = (String) campoTipo.getSelectedItem();
        diarias = (Integer) campoDiarias.getValue();
        carroAssegurado = getCarSeguro();
        tanqueCheio = getTanqueCheio();
        if(tipo.replace(" ", "").equals("")){
            Log.view("Nao foi possivel adicionar o serviço, \n pois tipo não foi selecionado corretamente", "" ,
                    "", 1, null);
            fechar();
        }else{
            ServicoAluguelCarro ac = new ServicoAluguelCarro(diarias, tipo, isAdicional, carroAssegurado, tanqueCheio,
                    Double.valueOf(campoValorTotal.getText()));
            
            //Servico s = new ServicoAluguelCarro(diarias, tipo, isAdicional, carroAssegurado, tanqueCheio,
                    //Double.valueOf(campoValorTotal.getText()));
            //contrato.addServico(s);
            contrato.addServicoAluguelCarro(ac);
        }

    }
    
    private boolean getCarSeguro(){
        String s = (String) campoSeguro.getSelectedItem();
        if(s.equals("SIM")){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean getTanqueCheio(){
        String s = (String) campoTanque.getSelectedItem();
        if(s.equals("SIM")){
            return true;
        }else{
            return false;
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campoSeguro = new javax.swing.JComboBox();
        campoTanque = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        butSim = new javax.swing.JRadioButton();
        butNao = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        campoValorTotal = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        campoTipo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        campoDiarias = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ALUGUEL DE CARROS");

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

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1422745371_678134-sign-check-24.png"))); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("CARRO ASSEGURADO:");

        jLabel7.setText("TANQUE CHEIO:");

        campoSeguro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NÃO", "SIM" }));
        campoSeguro.setEnabled(false);
        campoSeguro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                campoSeguroMouseReleased(evt);
            }
        });
        campoSeguro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                campoSeguroItemStateChanged(evt);
            }
        });

        campoTanque.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NÃO", "SIM" }));
        campoTanque.setEnabled(false);
        campoTanque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                campoTanqueMouseReleased(evt);
            }
        });
        campoTanque.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                campoTanqueItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoSeguro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoTanque, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoTanque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("ADICIONAL:");

        buttonGroup1.add(butSim);
        butSim.setText("SIM");
        butSim.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                butSimItemStateChanged(evt);
            }
        });

        buttonGroup1.add(butNao);
        butNao.setText("NÃO");
        butNao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                butNaoItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("TOTAL:");

        campoValorTotal.setEditable(false);
        campoValorTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        campoValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        campoValorTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoValorTotal.setText("0,00");
        campoValorTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("DIÁRIAS:");

        campoTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "AUTOMOVEL DE LUXO", "AUTOMOVEL EXECUTIVO" }));
        campoTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                campoTipoItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("TIPO:");

        campoDiarias.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        campoDiarias.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                campoDiariasStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(campoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(14, 14, 14))
                    .addComponent(campoDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(butSim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butNao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(butSim)
                    .addComponent(butNao))
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {campoValorTotal, jLabel6});

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void butSimItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_butSimItemStateChanged
        campoTanque.setEnabled(true);
        campoSeguro.setEnabled(true);
    }//GEN-LAST:event_butSimItemStateChanged

    private void butNaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_butNaoItemStateChanged
        campoTanque.setEnabled(false);
        campoSeguro.setEnabled(false);
    }//GEN-LAST:event_butNaoItemStateChanged

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        acaoConfirmar();
        telaanterior.atualizar();
        fechar();
    }//GEN-LAST:event_btnOkActionPerformed

    private void campoTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_campoTipoItemStateChanged
        atualizar();
    }//GEN-LAST:event_campoTipoItemStateChanged

    private void campoDiariasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_campoDiariasStateChanged
        atualizar();
    }//GEN-LAST:event_campoDiariasStateChanged

    private void campoSeguroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_campoSeguroItemStateChanged
        atualizar();
    }//GEN-LAST:event_campoSeguroItemStateChanged

    private void campoSeguroMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoSeguroMouseReleased
        atualizar();
    }//GEN-LAST:event_campoSeguroMouseReleased

    private void campoTanqueMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoTanqueMouseReleased
        atualizar();
    }//GEN-LAST:event_campoTanqueMouseReleased

    private void campoTanqueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_campoTanqueItemStateChanged
        atualizar();
    }//GEN-LAST:event_campoTanqueItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JRadioButton butNao;
    private javax.swing.JRadioButton butSim;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JSpinner campoDiarias;
    private javax.swing.JComboBox campoSeguro;
    private javax.swing.JComboBox campoTanque;
    private javax.swing.JComboBox campoTipo;
    private javax.swing.JFormattedTextField campoValorTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void atualizar() {
        //usar estrategia seu burro.
        double valor = Double.valueOf(String.format(java.util.Locale.US, "%.2f", getValorTotal()));
        campoValorTotal.setText(String.valueOf(valor));
    }
    
    // Este method verifica pelo campo Tipo, qual é o tipo do serviço selecionado. e retorna o tipo Enum.
    private TipoServicoAluguelCarro getServicoAluguelCarro(){
        String atual = (String) campoTipo.getSelectedItem();
        for (TipoServicoAluguelCarro t : TipoServicoAluguelCarro.values()) {
            if(t.getNome().equals(atual)){
                return t;
            }
        }
        return null;
    }
    
    //Está sem Estrategia, inserir isso looogo!!!
    private double getValorTotal(){
         int diarias = (Integer) campoDiarias.getValue();
        if(getServicoAluguelCarro() != null){
            double valorDiaria = getServicoAluguelCarro().getValorDiaria() * diarias;
            if(getCarSeguro()){
                valorDiaria = valorDiaria + getServicoAluguelCarro().SEGURO.getValorDiaria();
            }
            if(getTanqueCheio()){
                valorDiaria = valorDiaria + getServicoAluguelCarro().TANQUE_CHEIO.getValorDiaria();
            }
            return valorDiaria;
        }else{
            Log.view("NAO FOI POSSÍVEL ADICIONAR SERVIÇO", "", "", 1, null);
            fechar();
        }
        
        return 0.00;
    }
        
    
    
    @Override
    public void fechar() {
        this.dispose();
    }

  
}
