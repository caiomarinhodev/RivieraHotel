package com.hotel.pages;

import com.hotel.classes.Contrato;
import com.hotel.classes.ServicoBasico;
import com.hotel.classes.Sistema;
import com.hotel.enums.TipoServicoQuarto;
import com.hotel.interfaces.Tela;
import com.hotel.util.Log;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFrame;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Period;

public class TelaAddServicoDeQuarto extends JFrame implements Tela {

    private Contrato contrato;
    private Tela telaAnterior;

    public TelaAddServicoDeQuarto(Tela tela, Contrato c) {
        this.telaAnterior = tela;
        this.contrato = c;
        initComponents();
        setLocationRelativeTo(null);
        initializeStrategy();
        System.out.print(Sistema.getSTRATEGY());
    }

    private void initializeStrategy() {
        DateTimeZone BRAZIL = DateTimeZone.forID("America/Sao_Paulo");
        DateTime d1 = new DateTime(BRAZIL);
        
        boolean a = Sistema.verifyFimDeAno(d1);
        boolean b = Sistema.verifySaoJoaoOne(d1);
        boolean c = Sistema.verifySaoJoaoTwo(d1);
        
        if(a){
            System.out.println("Entrou A");
           Sistema.setSTRATEGY(1);
        }else if(b){
            System.out.println("Entrou B");
            Sistema.setSTRATEGY(2);
        }else if(c){
            System.out.println("Entrou C");
            Sistema.setSTRATEGY(3);
        }else{
            Sistema.setSTRATEGY(0);
        }
    }
    
    

    private void acaoConfirmar() {
        String tipo;
        int diarias, numcamas;
        boolean isAdicional;

        isAdicional = campoNumCamas.isEnabled();

        tipo = (String) campoTipo.getSelectedItem();
        diarias = (Integer) campoDiarias.getValue();
        numcamas = (Integer) campoNumCamas.getValue();
        if (tipo.replace(" ", "").equals("")) {
            Log.view("Nao foi possivel adicionar o serviço, \n pois tipo não foi selecionado corretamente", "",
                    "", 1, null);
        } else {
            if (getServicoQuarto() != null) {
                TipoServicoQuarto sq = getServicoQuarto();
                if (Sistema.isDisponivelTipoServicoQuarto(sq, getCountCurrentNumQuartos(getServicoQuarto()))) {
                    ServicoBasico sb = new ServicoBasico(tipo, diarias, isAdicional, numcamas,
                            Double.parseDouble(campoTotal.getText()));
                    DateTime dt = new DateTime();

                    contrato.setCheckout(dt.plusDays(diarias).toCalendar(Locale.UK).getTime());

                    //Servico s = new ServicoBasico(tipo, diarias, isAdicional, numcamas,
                    //Double.parseDouble(campoTotal.getText()));
                    //contrato.addServico(s);
                    contrato.addServicoBasico(sb);
                } else {
                    Log.view("NAO HÁ MAIS QUARTOS DISPONÍVEIS!", "", "", 1, null);
                }
            } else {
                Log.view("SERVICO DE QUARTO IS NULL", "", "", 1, null);
            }
        }

    }

    private int getCountCurrentNumQuartos(TipoServicoQuarto tp) {
        ArrayList<ServicoBasico> arr = contrato.getListaServicoBasico();
        int c = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getTipo().equals(tp.getNome())) {
                c++;
            }
        }
        return c;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        campoTipo = new javax.swing.JComboBox();
        campoDiarias = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoNumCamas = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        butSim = new javax.swing.JRadioButton();
        butNao = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        campoTotal = new javax.swing.JFormattedTextField();

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SERVIÇO DE QUARTO");

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("TIPO:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("DIÁRIAS:");

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1422745371_678134-sign-check-24.png"))); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        campoTipo.setMaximumRowCount(9);
        campoTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "PRESIDENCIAL", "LUXO SIMPLES", "LUXO DUPLO", "LUXO TRIPLO", "EXECUTIVO SIMPLES", "EXECUTIVO DUPLO", "EXECUTIVO TRIPLO" }));
        campoTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                campoTipoItemStateChanged(evt);
            }
        });

        campoDiarias.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        campoDiarias.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                campoDiariasStateChanged(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("NÚMERO DE CAMAS:");

        campoNumCamas.setModel(new javax.swing.SpinnerNumberModel(0, 0, 3, 1));
        campoNumCamas.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNumCamas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNumCamas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        campoTotal.setEditable(false);
        campoTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        campoTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        campoTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoTotal.setText("0,00");
        campoTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(butSim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butNao)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4)))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campoDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDiarias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(butSim))
                    .addComponent(butNao))
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(campoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {campoTotal, jLabel6});

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void butSimItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_butSimItemStateChanged
        campoNumCamas.setEnabled(true);
    }//GEN-LAST:event_butSimItemStateChanged

    private void butNaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_butNaoItemStateChanged
        campoNumCamas.setEnabled(false);
    }//GEN-LAST:event_butNaoItemStateChanged

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        acaoConfirmar();
        telaAnterior.atualizar();
        fechar();
    }//GEN-LAST:event_btnOkActionPerformed

    private void campoTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_campoTipoItemStateChanged
        atualizar();
    }//GEN-LAST:event_campoTipoItemStateChanged

    private void campoDiariasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_campoDiariasStateChanged
        atualizar();
    }//GEN-LAST:event_campoDiariasStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JRadioButton butNao;
    private javax.swing.JRadioButton butSim;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JSpinner campoDiarias;
    private javax.swing.JSpinner campoNumCamas;
    private javax.swing.JComboBox campoTipo;
    private javax.swing.JFormattedTextField campoTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void atualizar() {
        //usar estrategia seu burro.
        double valor = Double.valueOf(String.format(java.util.Locale.US, "%.2f", getValorTotal()));
        campoTotal.setText(String.valueOf(valor));
    }

    // Este method verifica pelo campo Tipo, qual é o tipo do serviço selecionado. e retorna o tipo Enum.
    private TipoServicoQuarto getServicoQuarto() {
        String atual = (String) campoTipo.getSelectedItem();
        for (TipoServicoQuarto t : TipoServicoQuarto.values()) {
            if (t.getNome().equals(atual)) {
                return t;
            }
        }
        return null;
    }

    //Está sem Estrategia, inserir isso looogo!!!
    private double getValorTotal() {
        int diarias = (Integer) campoDiarias.getValue();
        if (getServicoQuarto() != null) {
            double valorDiaria = (getServicoQuarto().getValorDiaria() * diarias) * Sistema.getSTRATEGY();
            if (butSim.isSelected()) {
                //valorDiaria = valorDiaria + 
            }
            return valorDiaria;
        } else {
            Log.view("Nao foi possivel adicionar Serviço!", "", "", 1, null);
            fechar();
        }

        return 0.00;
    }

    @Override
    public void fechar() {
        this.dispose();
    }

}
