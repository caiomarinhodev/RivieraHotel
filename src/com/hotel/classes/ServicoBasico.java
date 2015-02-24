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
public class ServicoBasico extends Servico {

    private String tipo;
    private int diarias;
    private boolean adicional;
    private int numeroDeCamas;
    private double valorTotal;

    public ServicoBasico(String tipo, int diarias, boolean adicional, int numeroDeCamas, double vt) {
        this.tipo = tipo;
        this.diarias = diarias;
        this.adicional = adicional;
        this.numeroDeCamas = numeroDeCamas;
        this.valorTotal = vt;
        setNome(tipo);

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDiarias() {
        return diarias;
    }

    public void setDiarias(int diarias) {
        this.diarias = diarias;
    }

    public boolean isAdicional() {
        return adicional;
    }

    public void setAdicional(boolean adicional) {
        this.adicional = adicional;
    }

    public int getNumeroDeCamas() {
        return numeroDeCamas;
    }

    public void setNumeroDeCamas(int numeroDeCamas) {
        this.numeroDeCamas = numeroDeCamas;
    }

   
    @Override
    public double getValorTotal() {
        return this.valorTotal;
    }

    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 11 * hash + Sistema.getRandom();
        hash = 11 * hash + this.diarias;
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
        final ServicoBasico other = (ServicoBasico) obj;
        return true;
    }

}
