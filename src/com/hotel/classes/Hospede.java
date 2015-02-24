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
public class Hospede {
    private int ID;
    private String nome;
    private String cpf;
    private String endereco;
    private java.util.Date dataDeNascimento;

    public Hospede(String nome, String cpf, String endereco, java.util.Date dataDeNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataDeNascimento = dataDeNascimento;
        this.ID = hashCode();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public java.util.Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(java.util.Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.cpf);
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
        final Hospede other = (Hospede) obj;
        return true;
    }
    
    
    
    
}
