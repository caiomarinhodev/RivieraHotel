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
public enum TipoServicoQuarto {
    PRESIDENCIAL(1200.00*Sistema.getSTRATEGY(), 5, "PRESIDENCIAL"), LUXO_SIMPLES(520.00*Sistema.getSTRATEGY(), 5, "LUXO SIMPLES"), 
    LUXO_DUPLO(570.00*Sistema.getSTRATEGY(), 15, "LUXO DUPLO"), LUXO_TRIPLO(620.00*Sistema.getSTRATEGY(), 20, "LUXO TRIPLO"), 
    EXECUTIVO_SIMPLES(360.00*Sistema.getSTRATEGY(), 5, "EXECUTIVO SIMPLES"), EXECUTIVO_DUPLO(385.00*Sistema.getSTRATEGY(), 15, "EXECUTIVO DUPLO"), 
    EXECUTIVO_TRIPLO(440.00*Sistema.getSTRATEGY(), 20, "EXECUTIVO TRIPLO");
 
	private double valorDiaria;
        private int totalQuartos;
        private String nome;
 
	private TipoServicoQuarto(double p, int tq, String nom) {
		valorDiaria = p;
                totalQuartos = tq;
                nome = nom;
	}
        
        public String getNome(){
            return nome;
        }
 
	public double getValorDiaria() {
		return valorDiaria;
	}
        
        public int getTotalQuartos(){
            return totalQuartos;
        }
    
}
