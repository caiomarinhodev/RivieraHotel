/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.classes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Helvis Lima
 */
public class Contrato {

    private int ID;
    private Hospede hospede;
    private ArrayList<ServicoBasico> listaServicoBasico;
    private ArrayList<ServicoBabySitter> listaServicoBabySitter;
    private ArrayList<ServicoAluguelCarro> listaServicoAluguelCarro;
    private ArrayList<Servico> listaDeServicos;
    private Cartao cartaoDeCredito;
    private double valorTotal;
    private boolean status;
    private java.util.Date checkin;
    private java.util.Date checkout;
    
    /**
     * Este é o construtor da classe Contrato.
     * @param hospede Um Objetodo tipo Hospede.
     * @param vt Este é o valor total dos serviços inclusosneste contrato,
     * e eles devem ser calculados por fora. Geralmente na view é possivel recuperar esta informação.
     */
    public Contrato(Hospede hospede, double vt) {
        this.hospede = hospede;
        this.listaServicoBasico = new ArrayList<>();
        this.listaServicoBabySitter = new ArrayList<>();
        this.listaServicoAluguelCarro = new ArrayList<>();
        this.listaDeServicos = new ArrayList<>();
        this.cartaoDeCredito = null;
        this.valorTotal = vt;
        this.status = true;
        this.checkin = new Date();
        this.ID = hashCode();
    }
    /**
     * Este metodo pega a lista de Servicos, todos do tipo Servico (tipo mais geral),
     * ou seja, pela classe Pai (downcast).
     * @return um ArrayList de Servicos.
     */
    public ArrayList<Servico> getListaDeServicos() {
        return listaDeServicos;
    }
    
    /**
     * Este metodo nao é usado. Ele seta a lista de Servicos em geral.
     * @param listaDeServicos Um ArrayList de Servicos.
     */
    public void setListaDeServicos(ArrayList<Servico> listaDeServicos) {
        this.listaDeServicos = listaDeServicos;
    }
    
    /**
     * Este método é quem adiciona na lista de Servicos Gerais um Servico oferecido
     * pelo hotel.
     * @param s Um Objeto do tipo Servico.
     */
    public void addServico(Servico s){
        this.listaDeServicos.add(s);
    }
    
    /**
     * Este método pesquisa na lista de Servicos em geral, o serviço com ID que se quer
     * pesquisar.
     * @param id O ID do objeto Servico a ser pesquisado.
     * @return Um Objeto com ID passado como parâmetro, caso exista.
     */
    public Servico pesquisaServico(int id){
        for (int i = 0; i < listaDeServicos.size(); i++) {
            if(listaDeServicos.get(i).getID()==id){
                return listaDeServicos.get(i);
            }
        }return null;
    }
    
    /**
     * Este método remove um Serviço da lista geral de Servicos.
     * @param id O ID do objeto Servico a ser removido.
     * @return um boolean true se foi removido, or false caso não seja removido.
     */
    public boolean removerServico(int id){
        Servico s = pesquisaServico(id);
        if(s!=null){
            for (int i = 0; i < listaDeServicos.size(); i++) {
                if(listaDeServicos.get(i).getID()==s.getID()){
                    this.listaDeServicos.remove(i);
                }
            }
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Este método nao é comumente usado. Ele setaria o valor total do contrato.
     * @param vt Um double represantando o valor total.
     */
    public void setValorTotal(double vt) {
        this.valorTotal = vt;
    }
    
    /**
     * Este método adiciona um cartão de crédito ao Contrato.
     * Este cartão nao necessáriamente precisaria ser do Hospede. Pode ser de
     * algum dependente dele.
     * @param cartao Um Objeto do tipo Cartão.
     * @return um boolean true se foi adicionado,or false caso nao seja.
     */
    public boolean addCartaoDeCredito(Cartao cartao) {
        if (cartao != null) {
            this.cartaoDeCredito = cartao;
            return true;
        } else {
            this.cartaoDeCredito = null;
            return false;
        }

    }
    
    /**
     * Este método retorna o momento de Checkin do Hospede.
     * @return Um Date representando o instante em que ele fez checkin no Hotel.
     */
    public Date getCheckin() {
        return checkin;
    }
    
    /**
     * Este método seta o momento de Checkin do Hospede caso seja necessário.
     * @param checkin Um Date representando o Checkin.
     */
    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }
    
    /**
     * Este método retorna o momento de Checkout do Hospede.
     * @return Um Date representando o instante em que ele fez checkout no Hotel.
     */
    public Date getCheckout() {
        return checkout;
    }
    
    /**
     * Este método seta o momento de Checkout do Hospede caso seja necessário.
     * @param checkout Um Date representando o Checkou.
     */
    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }
    
    /**
     * Este método adiciona de forma bruta um Cartao de Crédito a este contrato.
     * Todas as informações a serem passadas no parâmetro são Strings.
     * @param nomeCartao O nome do Cartao.
     * @param numCartao Um número inscrito no Cartao.
     * @param codSegCartao Os tres digitos de sgurança do cartao.
     * @param dataDeValidade A data de validade do cartao.
     * @param cpfTitular o cpf do titular do cartão.
     * @return um boolean true se foi adicionado, or false caso nao seja.
     */
    public boolean addCartaoDeCreditoString(String nomeCartao, String numCartao, String codSegCartao, String dataDeValidade, String cpfTitular) {
        if (numCartao.length() != 19 || cpfTitular.length() != 14) {
            Cartao c = new Cartao(nomeCartao, numCartao, codSegCartao, dataDeValidade, cpfTitular);
            this.cartaoDeCredito = c;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Este método add Um servico básico a lista de Servicos Basicos.
     * @param servico Um Objeto do tipo Servico Basico.
     * @return um boolean true se for adicionado, or false caso nao seja.
     */
    public boolean addServicoBasico(ServicoBasico servico) {
        if (servico != null) {
            this.listaServicoBasico.add(servico);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Este método add Um servico básico a lista de Servicos Basicos.
     * @param tipo
     * @param diarias
     * @param adicional
     * @param numeroDeCamas
     * @param vt
     * @return um boolean true se for adicionado, or false caso nao seja.
     */
    public boolean addServicoBasico(String tipo, int diarias, boolean adicional,
            int numeroDeCamas, double vt) {
        if (!tipo.isEmpty() && diarias != 0) {
            ServicoBasico sb = new ServicoBasico(tipo, diarias, adicional, numeroDeCamas, vt);
            this.listaServicoBasico.add(sb);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Este método Pesquisa por um Servico Básico na lista de Servicos Basicos.
     * @param ID um int.
     * @return o Objeto do tipo Servico Basico. caso exista, se não retorna null.
     */
    public ServicoBasico pesquisaServicoBasico(int ID) {
        for (int i = 0; i < listaServicoBasico.size(); i++) {
            if (listaServicoBasico.get(i).getID() == ID) {
                return listaServicoBasico.get(i);
            }
        }
        return null;
    }
    
    public int searchServicoBasico(int ID){
        for (int i = 0; i < listaServicoBasico.size(); i++) {
            if (listaServicoBasico.get(i).getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeServicoBasico(int ID) {
        ServicoBasico sb = pesquisaServicoBasico(ID);
        if (sb != null) {
            this.listaServicoBasico.remove(sb);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean removeServicoBasicoPosition(int position) {
        if (position != -1) {
            this.listaServicoBasico.remove(position);
            return true;
        } else {
            return false;
        }
    }

    public boolean addServicoBaby(ServicoBabySitter servico) {
        if (servico != null) {
            this.listaServicoBabySitter.add(servico);
            return true;
        } else {
            return false;
        }
    }

    public boolean addServicoBaby(String start, String end, int totalHoras, double vt) {
        if (!start.isEmpty() && !end.isEmpty() && totalHoras != 0) {
            ServicoBabySitter sbs = new ServicoBabySitter(start, end, totalHoras, vt);
            this.listaServicoBabySitter.add(sbs);
            return true;
        } else {
            return false;
        }
    }

    public ServicoBabySitter pesquisaServicoBabySitter(int ID) {
        for (int i = 0; i < listaServicoBabySitter.size(); i++) {
            if (listaServicoBabySitter.get(i).getID() == ID) {
                return listaServicoBabySitter.get(i);
            }
        }
        return null;
    }
    
    public int searchServicoBabySitter(int ID){
        for (int i = 0; i < listaServicoBabySitter.size(); i++) {
            if (listaServicoBabySitter.get(i).getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeServicoBaby(int ID) {
        ServicoBabySitter sbs = pesquisaServicoBabySitter(ID);
        if (sbs != null) {
            this.listaServicoBabySitter.remove(sbs);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean removeServicoBabyPosition(int position) {
        if (position != -1) {
            this.listaServicoBabySitter.remove(position);
            return true;
        } else {
            return false;
        }
    }

    public boolean addServicoAluguelCarro(ServicoAluguelCarro servico) {
        if (servico != null) {
            this.listaServicoAluguelCarro.add(servico);
            return true;
        } else {
            return false;
        }
    }

    public boolean addServicoAluguelCarro(int diarias, String tipo, boolean adicional,
            boolean tanque, boolean seguro, double vt) {

        if (!tipo.isEmpty() && diarias != 0) {
            ServicoAluguelCarro sac = new ServicoAluguelCarro(diarias, tipo,
                    adicional, tanque, seguro, vt);
            this.listaServicoAluguelCarro.add(sac);
            return true;

        } else {
            return false;
        }
    }

    public ServicoAluguelCarro pesquisaServicoAluguelCarro(int ID) {
        for (int i = 0; i < listaServicoAluguelCarro.size(); i++) {
            if (listaServicoAluguelCarro.get(i).getID() == ID) {
                return listaServicoAluguelCarro.get(i);
            }
        }
        return null;
    }
    
    public int searchServicoAluguelCarro(int ID){
        for (int i = 0; i < listaServicoAluguelCarro.size(); i++) {
            if (listaServicoAluguelCarro.get(i).getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeServicoAluguelCarro(int ID) {
        ServicoAluguelCarro sac = pesquisaServicoAluguelCarro(ID);
        if (sac != null) {
            this.listaServicoAluguelCarro.remove(sac);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean removeServicoAluguelCarroPosition(int position) {
        if (position != -1) {
            this.listaServicoAluguelCarro.remove(position);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Servico> getListaDeTodosServicos() {

        ArrayList<Servico> a = new ArrayList<>();

        ArrayList<ServicoBabySitter> lb = getListaServicoBabySitter();
        ArrayList<ServicoAluguelCarro> lac = getListaServicoAluguelCarro();
        ArrayList<ServicoBasico> sb = getListaServicoBasico();

        for (int i = 0; i < lb.size(); i++) {
            a.add(lb.get(i));
        }

        for (int i = 0; i < lac.size(); i++) {
            a.add(lac.get(i));
        }

        for (int i = 0; i < sb.size(); i++) {
            a.add(sb.get(i));
        }
        return a;
    }

    public boolean removeServicoGeralPorId(int ID) {
        ServicoAluguelCarro ac = pesquisaServicoAluguelCarro(ID);
        ServicoBabySitter bs = pesquisaServicoBabySitter(ID);
        ServicoBasico sb = pesquisaServicoBasico(ID);

        if (ac != null) {
            int p = searchServicoAluguelCarro(ID);
            this.listaServicoAluguelCarro.remove(p);
            return true;
        } else if (bs != null) {
            int h = searchServicoBabySitter(ID);
            this.listaServicoBabySitter.remove(h);
            return true;
        } else if (sb != null) {
            int k = searchServicoBasico(ID);
            this.listaServicoBasico.remove(k);
            return true;
        } else {
            return false;
        }

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public ArrayList<ServicoBasico> getListaServicoBasico() {
        return listaServicoBasico;
    }

    public ArrayList<ServicoBabySitter> getListaServicoBabySitter() {
        return listaServicoBabySitter;
    }

    public ArrayList<ServicoAluguelCarro> getListaServicoAluguelCarro() {
        return listaServicoAluguelCarro;
    }

    public Cartao getCartaoDeCredito() {
        return cartaoDeCredito;
    }

    public void setCartaoDeCredito(Cartao cartaoDeCredito) {
        this.cartaoDeCredito = cartaoDeCredito;
    }

    public double getValorTotal() {
        return calculaValorTotal();
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private double calculaValorTotal() {
        double servicoBasico = 0.00;
        double servicoBaby = 0.00;
        double servicoAluguelCarro = 0.00;

        for (int i = 0; i < listaServicoBasico.size(); i++) {
            servicoBasico = servicoBasico + listaServicoBasico.get(i).
                    getValorTotal();
        }

        for (int i = 0; i < listaServicoBabySitter.size(); i++) {
            servicoBaby = servicoBaby + listaServicoBabySitter.get(i).
                    getValorTotal();
        }

        for (int i = 0; i < listaServicoAluguelCarro.size(); i++) {
            servicoAluguelCarro = servicoAluguelCarro + listaServicoAluguelCarro.
                    get(i).getValorTotal();
        }

        double total = servicoBasico + servicoBaby + servicoAluguelCarro;

        return total;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = hash * Sistema.getRandom();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contrato other = (Contrato) obj;
        return true;
    }

}
