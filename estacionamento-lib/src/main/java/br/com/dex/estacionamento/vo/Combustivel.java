package br.com.dex.estacionamento.vo;

import java.io.Serializable;

public enum Combustivel implements Serializable {
	GASOLINA,
	DIESEL,
	ALCOOL,
	FLEX,
	GNV;

	public static Combustivel fromInt(int value){
		return Combustivel.values()[value];
	}
}
