/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.classes;

import java.util.Objects;

/**
 *
 * @author Helvis Lima
 */
public class Cartao {

    private int ID;
    private String nomeCartao;
    private String numCartao;
    private String codSegCartao;
    private String dataDeValidade;
    private String cpfTitular;

    public Cartao(String nomeCartao, String numCartao, String codSegCartao, String dataDeValidade, String cpfTitular) {
        this.nomeCartao = nomeCartao;
        this.numCartao = numCartao;
        this.codSegCartao = codSegCartao;
        this.dataDeValidade = dataDeValidade;
        this.cpfTitular = cpfTitular;
        this.ID = hashCode();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public String getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }

    public String getCodSegCartao() {
        return codSegCartao;
    }

    public void setCodSegCartao(String codSegCartao) {
        this.codSegCartao = codSegCartao;
    }

    public String getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(String dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nomeCartao);
        hash = 97 * hash + Objects.hashCode(this.codSegCartao);
        hash = 97 * hash + Objects.hashCode(this.cpfTitular);
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
        final Cartao other = (Cartao) obj;
        return true;
    }

}
