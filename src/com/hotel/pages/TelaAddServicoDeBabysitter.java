package com.hotel.pages;

import com.hotel.classes.Contrato;
import com.hotel.classes.ServicoBabySitter;
import com.hotel.enums.TipoServicoBabySitter;
import com.hotel.interfaces.Tela;
import com.hotel.util.Log;
import javax.swing.JFrame;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;

public class TelaAddServicoDeBabysitter extends JFrame implements Tela {

    private Tela telaAnterior;
    private Contrato contrato;

    public TelaAddServicoDeBabysitter(Contrato c, Tela tela) {
        this.contrato = c;
        initComponents();
        setLocationRelativeTo(null);
        this.telaAnterior = tela;
        
    }
    
    private void method() {
        int de, ate, totalHoras;
        
        de = campoHourDe.getSelectedIndex();
        ate = campoHourAte.getSelectedIndex();
        
        DateTime datetime = new DateTime();
        
        DateTime dtnow = new DateTime(datetime.getYear(), datetime.getMonthOfYear(), datetime.getDayOfMonth(), de, 0);
        
        DateTime dtpos = dtnow.plusHours(getsum(de, ate));
        
        Duration duration = new Duration(dtnow, dtpos);
        int horasTotal = duration.toStandardHours().getHours();
        
        if (de > 0 && ate > 0 && de != ate) {
            setTotalHoras(horasTotal);
        } else {
            setTotalHoras(24);
        }
        
        int thd = 0;
        int thn = 0;
        
        if (isDobrada(dtnow) && isDobrada(dtpos)) {
            
            if (dtnow.getHourOfDay() > 18) {
                thd = (24 - dtnow.getHourOfDay()) + dtpos.getHourOfDay();
            } else if (dtnow.getHourOfDay() < 7 && dtpos.getHourOfDay() > 18) {
                thd = (7 - dtnow.getHourOfDay()) + (24 - dtpos.getHourOfDay());
                thn = horasTotal - thd;
            } else {
                thd = dtpos.getHourOfDay() - dtnow.getHourOfDay();
            }
        } else if (isDobrada(dtnow) && dtpos.getHourOfDay() < 18) {
            
            thd = (24 - dtnow.getHourOfDay()) + 7;
        } else if (isDobrada(dtnow) && isDobrada(dtpos)) {
            thd = horasTotal;
        }
        
        if (!isDobrada(dtnow) && !isDobrada(dtpos)) {
            Duration du = new Duration(dtnow, dtpos);
            thn = du.toStandardHours().getHours();
        } else if (!isDobrada(dtnow) && isDobrada(dtpos)) {
            if (dtnow.getHourOfDay() < 18 && dtpos.getHourOfDay() >= 18) {
                thn = 18 - dtnow.getHourOfDay();
                thd = dtpos.getHourOfDay() - 18;
            } else {
                thn = 18 - dtnow.getHourOfDay();
                thd = 7 - dtpos.getHourOfDay();
            }
        }
        
        setValorTotal(thn, thd);
    }
    
    private boolean isDobrada(DateTime d) {
        
        if (d.getHourOfDay() >= 18 || d.getHourOfDay() <= 7) {
            return true;
        } else {
            return false;
        }
    }
    
    private void setTotalHoras(int i) {
        campoTotalHoras.setText(String.valueOf(i));
    }
    
    private void setValorTotal(int horasNormal, int horasDob) {
        campoValorTotal.setText(String.valueOf(calculaValor(horasNormal, horasDob)));
    }
    
    private int getsum(int s, int e) {
        int sum = 0;
        
        if (s > e) {
            sum = (24 - s) + e;
        } else {
            sum = e - s;
        }
        return sum;
    }
    
    private void acao() {
        
        String de = (String) campoHourDe.getSelectedItem();
        String ate = (String) campoHourAte.getSelectedItem();
        int tot = Integer.parseInt(campoTotalHoras.getText());
        double vt = Double.parseDouble(campoValorTotal.getText());
        
        if (de.replace(" ", "").equals("")) {
            Log.view("Nao foi possivel adicionar o serviço, \n pois tipo não foi selecionado corretamente", "",
                    "", 1, null);
            fechar();
        } else {
            ServicoBabySitter bs = new ServicoBabySitter(de, ate, tot, vt);
            
            //Servico s = new ServicoBabySitter(de, ate, tot, vt);
            //contrato.addServico(bs);
            contrato.addServicoBaby(bs);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        campoValorTotal = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoTotalHoras = new javax.swing.JFormattedTextField();
        campoHourDe = new javax.swing.JComboBox();
        campoHourAte = new javax.swing.JComboBox();

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
        jLabel1.setText("BABYSITTER");

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("TOTAL:");

        campoValorTotal.setEditable(false);
        campoValorTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        campoValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        campoValorTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoValorTotal.setText("0,00");
        campoValorTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "PERÍODO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Aharoni", 1, 12))); // NOI18N

        jLabel2.setText("DE:");

        jLabel3.setText("ATÉ:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("TOTAL DE HORAS:");

        campoTotalHoras.setEditable(false);
        campoTotalHoras.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        campoHourDe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "23:59" }));

        campoHourAte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "23:59" }));
        campoHourAte.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                campoHourAteItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTotalHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoHourDe, 0, 73, Short.MAX_VALUE)
                            .addComponent(campoHourAte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoHourDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoHourAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoTotalHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {campoValorTotal, jLabel6});

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        acao();
        this.telaAnterior.atualizar();
        fechar();
    }//GEN-LAST:event_btnOkActionPerformed

    private void campoHourAteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_campoHourAteItemStateChanged
        method();
    }//GEN-LAST:event_campoHourAteItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox campoHourAte;
    private javax.swing.JComboBox campoHourDe;
    private javax.swing.JFormattedTextField campoTotalHoras;
    private javax.swing.JFormattedTextField campoValorTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void atualizar() {
        method();
    }
    
    @Override
    public void fechar() {
        this.dispose();
    }
    
    private double calculaValor(int horasNormal, int horasDobrada) {
        double v1 = horasNormal * TipoServicoBabySitter.NORMAL.getValorDiaria();
        double v2 = horasDobrada * TipoServicoBabySitter.DOBRADA.getValorDiaria();
        return v1 + v2;
    }
    
}
