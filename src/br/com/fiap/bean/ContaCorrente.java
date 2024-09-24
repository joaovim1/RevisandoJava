package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.bean.exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta {

	private TipoConta tipoConta;
	
	
	
	
	//metodos
	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		if(tipoConta == TipoConta.COMUM && valor > saldo) {
			throw new SaldoInsuficienteException(saldo);
		}
		
		if(tipoConta == TipoConta.ESPECIAL && valor > saldo) {
			throw new SaldoInsuficienteException(saldo);
		}
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		
	}
	
	
	//construtores
	public ContaCorrente () {}

	
	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipoConta) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipoConta = tipoConta;
	}
	
	
	//get set
	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	
	
}
