package com.hotel.pages;

import com.hotel.classes.Contrato;
import com.hotel.classes.Hospede;
import com.hotel.classes.Sistema;
import com.hotel.classes.Servico;
import com.hotel.interfaces.Tela;
import com.hotel.util.Log;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

public class TelaAddContrato extends JFrame implements Tela{
    private Contrato contrato;
    private SimpleTableModel model;
    private TelaEntrada telaAnterior;
    
    public TelaAddContrato(TelaEntrada tela) {
        contrato = null;
        this.telaAnterior = tela;
        initComponents();
        setLocationRelativeTo(null);
        setTable(new ArrayList<Servico>());
    }
    
    private void setTable(ArrayList<Servico> a){
        model = new SimpleTableModel(a);
        tabela.setModel(model);
    }
    
    private void acaoCadastrarContrato(){
        
        if(contrato.getCartaoDeCredito()!=null && !contrato.getListaServicoBasico().isEmpty()){
            boolean stats = true;
            contrato.setStatus(stats);
            contrato.setValorTotal(Double.parseDouble(campoTelaValorTotalContrato.getText()));
            Sistema.addContrato(contrato);
            Log.view("CADASTRO REALIZADO COM SUCESSO", "", "", 1, null);
        }else{
            Log.view("NAO FOI POSSÍVEL FINALIZAR CADASTRO \n"
                    + "INSIRA CARTAO E UM SERVICO DE QUARTO!", "", "", 1, null);
        }
    }
    
    private Hospede criaHospede(){
        String nome, cpf, end;
        java.util.Date dataNascimento;
        
        nome = campoNomeHospede1.getText();
        cpf = campoCpf1.getText();
        end = campoEndereco1.getText();
        dataNascimento = campoDataNascimento1.getDate();
        if(nome.replace("","").equals("")){
            return null;
        }else{
            Hospede h = new Hospede(nome, cpf, end, dataNascimento);
            return h;
        }
    }
    
    private void acaoPosCadastro(){
        Hospede h = criaHospede();
        if(h!=null){
            contrato = new Contrato(h, 0.00);
            btnAddBabySitter.setEnabled(true);
            btnAddCarro.setEnabled(true);
            btnAddCartao.setEnabled(true);
            btnAddServicoQuarto.setEnabled(true);
            btnRemoverServico.setEnabled(true);
            
            
            campoCpf1.setEnabled(false);
            campoDataNascimento1.setEnabled(false);
            campoEndereco1.setEnabled(false);
            campoNomeHospede1.setEnabled(false);
            btnCadastrarHospede.setEnabled(false);
            
            
            
            btnFinalizar.setEnabled(true);
        }else{
            Log.view("Nao Foi possível criar Hóspede!", "", "", 1, null);
        }
    }
    
public class SimpleTableModel extends AbstractTableModel {
    ArrayList<Servico> data = new ArrayList<>();
    String colNames[] = { "ID", "TIPO", "VALOR TOTAL" };
    Class<?> colClasses[] = { Integer.class, String.class, Double.class };

    public SimpleTableModel(ArrayList<Servico> arr) {
       this.data = arr;
    }

    public int getRowCount() {
        return data.size();
    }

    public int getColumnCount() {
        return colNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return data.get(rowIndex).getID();
        }
        if (columnIndex == 1) {
            return data.get(rowIndex).getNome();
        }
        if (columnIndex == 2) {
            return data.get(rowIndex).getValorTotal();
        }
        return null;
    }

    public String getColumnName(int columnIndex) {
        return colNames[columnIndex];
    }

    public Class<?> getColumnClass(int columnIndex) {
        return colClasses[columnIndex];
    }

    
    public Servico getService(int id){
        
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getID()==id){
                return data.get(i);
            }
        }
        return null;
        
    }
    
    public boolean removeServ(int id){
        Servico s = getService(id);
        data.remove(s);
        if(contrato.removeServicoGeralPorId(id)){
            return true;
        }
        return false;
    }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoTelaValorTotalContrato = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        btnAddServicoQuarto = new javax.swing.JButton();
        btnAddBabySitter = new javax.swing.JButton();
        btnAddCarro = new javax.swing.JButton();
        btnAddCartao = new javax.swing.JButton();
        btnRemoverServico = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        campoNomeHospede1 = new javax.swing.JTextField();
        campoEndereco1 = new javax.swing.JTextField();
        campoDataNascimento1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        campoCpf1 = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnCadastrarHospede = new javax.swing.JButton();

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
        jLabel1.setText("CADASTRO DE NOVO CONTRATO");

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

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1423004069_gtk-go-back-ltr.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1422745371_678134-sign-check-24.png"))); // NOI18N
        btnFinalizar.setText("FINALIZAR");
        btnFinalizar.setEnabled(false);
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFinalizar))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnCancelar)
                .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, btnFinalizar});

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TOTAL:");

        campoTelaValorTotalContrato.setEditable(false);
        campoTelaValorTotalContrato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        campoTelaValorTotalContrato.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoTelaValorTotalContrato.setText("0.00");
        campoTelaValorTotalContrato.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoTelaValorTotalContrato, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(campoTelaValorTotalContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAddServicoQuarto.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        btnAddServicoQuarto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1423003474_bed-20.png"))); // NOI18N
        btnAddServicoQuarto.setText("QUARTO");
        btnAddServicoQuarto.setEnabled(false);
        btnAddServicoQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServicoQuartoActionPerformed(evt);
            }
        });

        btnAddBabySitter.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        btnAddBabySitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1423003408_aiga_nursery-20.png"))); // NOI18N
        btnAddBabySitter.setText("BABYSITTER");
        btnAddBabySitter.setEnabled(false);
        btnAddBabySitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBabySitterActionPerformed(evt);
            }
        });

        btnAddCarro.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        btnAddCarro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1423003434_13-20.png"))); // NOI18N
        btnAddCarro.setText("CARRO");
        btnAddCarro.setEnabled(false);
        btnAddCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCarroActionPerformed(evt);
            }
        });

        btnAddCartao.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        btnAddCartao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1423003454_icon-card-20.png"))); // NOI18N
        btnAddCartao.setText("CARTÃO");
        btnAddCartao.setEnabled(false);
        btnAddCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCartaoActionPerformed(evt);
            }
        });

        btnRemoverServico.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        btnRemoverServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1422745328_678069-sign-error-20.png"))); // NOI18N
        btnRemoverServico.setText("REMOVER");
        btnRemoverServico.setEnabled(false);
        btnRemoverServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverServicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(btnAddServicoQuarto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddBabySitter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddCarro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddCartao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRemoverServico))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddBabySitter, btnAddCarro, btnAddCartao, btnAddServicoQuarto, btnRemoverServico});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnAddServicoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAddBabySitter)
                .addComponent(btnAddCarro)
                .addComponent(btnAddCartao)
                .addComponent(btnRemoverServico))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddBabySitter, btnAddCarro, btnAddCartao, btnAddServicoQuarto, btnRemoverServico});

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SERVIÇOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tabela.setAutoCreateRowSorter(true);
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabela);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("ENDEREÇO:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("NOME:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("DATA DE NASCIMENTO:");

        try {
            campoCpf1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("CPF:");

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1422745304_678092-sign-add-32.png"))); // NOI18N
        jLabel11.setText("CADASTRAR HÓSPEDE");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCadastrarHospede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/1422745304_678092-sign-add-32.png"))); // NOI18N
        btnCadastrarHospede.setText("CADASTRAR");
        btnCadastrarHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarHospedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoEndereco1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNomeHospede1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(campoCpf1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDataNascimento1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btnCadastrarHospede)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNomeHospede1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoCpf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoEndereco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDataNascimento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnCadastrarHospede)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        fechar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAddServicoQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServicoQuartoActionPerformed
        new TelaAddServicoDeQuarto(this, contrato).setVisible(true);
    }//GEN-LAST:event_btnAddServicoQuartoActionPerformed

    private void btnCadastrarHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarHospedeActionPerformed
        acaoPosCadastro();
    }//GEN-LAST:event_btnCadastrarHospedeActionPerformed

    private void btnAddCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCarroActionPerformed
       new TelaAddServicoDeAluguelDeCarros(this, contrato).setVisible(true);
    }//GEN-LAST:event_btnAddCarroActionPerformed

    private void btnAddCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCartaoActionPerformed
        new TelaCadastroCartaoCredito(this, contrato).setVisible(true);
    }//GEN-LAST:event_btnAddCartaoActionPerformed

    private void btnRemoverServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverServicoActionPerformed
        if(tabela.isRowSelected(tabela.getSelectedRow())){
            removeServico();
        }
    }//GEN-LAST:event_btnRemoverServicoActionPerformed

    private void btnAddBabySitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBabySitterActionPerformed
        new TelaAddServicoDeBabysitter(contrato, this).setVisible(true);
    }//GEN-LAST:event_btnAddBabySitterActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        acaoCadastrarContrato();
        this.telaAnterior.atualizar();
        fechar();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBabySitter;
    private javax.swing.JButton btnAddCarro;
    private javax.swing.JButton btnAddCartao;
    private javax.swing.JButton btnAddServicoQuarto;
    private javax.swing.JButton btnCadastrarHospede;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnRemoverServico;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField campoCpf1;
    private com.toedter.calendar.JDateChooser campoDataNascimento1;
    private javax.swing.JTextField campoEndereco1;
    private javax.swing.JTextField campoNomeHospede1;
    private javax.swing.JFormattedTextField campoTelaValorTotalContrato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

    @Override
    public void atualizar() {
        //setTable(new ArrayList<Servico>());
        setTable(contrato.getListaDeTodosServicos());
        setValorTotal(contrato.getListaDeTodosServicos());
    }

    @Override
    public void fechar() {
       this.dispose();
    }
    
    private void setValorTotal(ArrayList<Servico> a){
        double valor = 0.00;
        for (int i = 0; i < a.size(); i++) {
            valor = valor + a.get(i).getValorTotal();
        }
        campoTelaValorTotalContrato.setText(String.valueOf(valor));
    }
    
    private void removeServico(){
        int id = (Integer) tabela.getValueAt(tabela.getSelectedRow(), 0);
        System.out.println("IDremove Service:" + id);
        boolean var = contrato.removeServicoGeralPorId(id);
        if(var){
            atualizar();
            Log.view("Removido com Sucesso!", "", "", 1, null);
        }else{
            Log.view("NAO FOI POSSÍVEL DELETAR ITEM!", "", "", 1, null);
        }
    }



  
}
