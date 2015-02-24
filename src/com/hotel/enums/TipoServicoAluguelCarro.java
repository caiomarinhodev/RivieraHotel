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
public enum TipoServicoAluguelCarro {
    AUTOMOVEL_LUXO(100.00*Sistema.getSTRATEGY(), "AUTOMOVEL DE LUXO"), AUTOMOVEL_EXECUTIVO(60.00*Sistema.getSTRATEGY(), "AUTOMOVEL EXECUTIVO"), 
    TANQUE_CHEIO(150.00*Sistema.getSTRATEGY(), "TANQUE CHEIO"), SEGURO(100.00*Sistema.getSTRATEGY(), "SEGURO");
 
	private double valorDiaria;
        private String nome;
	private TipoServicoAluguelCarro(double price, String nom) {
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
