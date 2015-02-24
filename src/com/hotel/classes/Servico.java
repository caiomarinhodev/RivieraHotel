/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.classes;

/**
 *
 * @author Helvis Lima
 */
public abstract class Servico {

    private double valorTotal;
    private String nome;
    private int ID;

    public Servico() {
        this.ID = Sistema.getcount();
        this.valorTotal = 0.00;
        this.nome = "";
    }
    
    
    public int getID(){
        return this.ID;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Sistema.getRandom();
        //hash = 11 * hash + (int) (Double.doubleToLongBits(this.valorTotal) ^ (Double.doubleToLongBits(this.valorTotal) >>> 32));
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
        final Servico other = (Servico) obj;
        return true;
    }

}
