package com.modelo.service;

public class Operacao {
	
	private double qtd;
	private double pu;
	
	public Operacao(double qtd, double pu) {
		super();
		this.qtd = qtd;
		this.pu = pu;
	}

	public double getQtd() {
		return qtd;
	}

	public void setQtd(double qtd) {
		this.qtd = qtd;
	}

	public double getPu() {
		return pu;
	}

	public void setPu(double pu) {
		this.pu = pu;
	}

	public double getValorFinanceiro() {
		return (this.qtd * this.pu);
	}

	
	
	
}
