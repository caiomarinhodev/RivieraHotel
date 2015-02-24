/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.enums;

import com.hotel.classes.Sistema;

/**
 *
 * @author Helvis Lima
 */
public enum TipoServicoBabySitter {
    NORMAL(25.00*Sistema.getSTRATEGY(), ""), DOBRADA(50.00*Sistema.getSTRATEGY(),  "");
 
	private double valorDiaria;
        private String nome;
 
	private TipoServicoBabySitter(double price, String nom) {
		valorDiaria = price;
                nome = nom;
	}
        
        public String getNome(){
            return nome;
        }
 
	public double getValorDiaria() {
		return valorDiaria;
	}
    
}
