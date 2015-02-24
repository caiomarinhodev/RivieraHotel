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
public class ServicoAluguelCarro extends Servico {

    private int diarias, ID;
    private String tipo;
    private boolean adicional, tanque, seguro;
    private double valorTotal;

    public ServicoAluguelCarro(int diarias, String tipo, boolean adicional, boolean tanque, boolean seguro, double vt) {
        this.diarias = diarias;
        this.tipo = tipo;
        this.adicional = adicional;
        this.tanque = tanque;
        this.seguro = seguro;
        this.valorTotal = vt;
        setNome(tipo);
        this.ID = Sistema.getcount();
    }

    public int getDiarias() {
        return diarias;
    }

    public void setDiarias(int diarias) {
        this.diarias = diarias;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isAdicional() {
        return adicional;
    }

    public void setAdicional(boolean adicional) {
        this.adicional = adicional;
    }

    public boolean isTanque() {
        return tanque;
    }

    public void setTanque(boolean tanque) {
        this.tanque = tanque;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    

    @Override
    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 17 * hash + Sistema.getRandom();
        //hash = 17 * hash + Objects.hashCode(this.tipo);
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
        final ServicoAluguelCarro other = (ServicoAluguelCarro) obj;
        return true;
    }

}
