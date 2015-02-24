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
public class ServicoBabySitter extends Servico {

    private int totalHoras, ID;
    private double valorTotal;
    private String de, ate;

    public ServicoBabySitter(String de, String ate, int totalHoras, double vt) {
        this.totalHoras = totalHoras;
        this.valorTotal = vt;
        this.de = de;
        this.ate = ate;
        this.ID = Sistema.getcount();
        setNome("Serviço de Babysitter");
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getAte() {
        return ate;
    }

    public void setAte(String ate) {
        this.ate = ate;
    }

    

    @Override
    public double getValorTotal() {
        return this.valorTotal;
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 47 * hash + Sistema.getRandom();
        //hash = 47 * hash + (int) (Double.doubleToLongBits(this.valorTotal) ^ (Double.doubleToLongBits(this.valorTotal) >>> 32));
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
        final ServicoBabySitter other = (ServicoBabySitter) obj;
        return true;
    }

}
