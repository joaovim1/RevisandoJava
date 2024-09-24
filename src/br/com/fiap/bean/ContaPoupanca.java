package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.bean.exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta implements ContaInvestimento {
	
	//atributo
	private float taxa;
	
	//constante
	public static final float RENDIMENTO = 0.01f;
	
	
	
	//metodos
	@Override
	public final double calculaRetornoInvestimento() {
		return saldo * RENDIMENTO;
	}

	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		
		if (valor + taxa > saldo) {
			throw new SaldoInsuficienteException(saldo - taxa);
		}		
		saldo -= valor + taxa;
		
	}
	
	@Override
	public void depositar(double valor) {
		saldo += valor;
		
	}
	
	
	//construtor
	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

	

	

	//get set
	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

}
