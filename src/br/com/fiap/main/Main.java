package br.com.fiap.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
import br.com.fiap.bean.exception.SaldoInsuficienteException;

public class Main {

	public static void main(String[] args) throws SaldoInsuficienteException {
		
		//instancia a conta corrente
		ContaCorrente cc = new ContaCorrente(1, 12, new GregorianCalendar(2010, Calendar.MARCH, 27), 100, TipoConta.ESPECIAL);
		
		//instancia a conta poupança
		ContaPoupanca cp = new ContaPoupanca(2, 200, Calendar.getInstance(), 200, 2);
		
		//chama o metodo depositar
		cc.depositar(3000);
		cp.depositar(2000);
		
		//exibe o saldo cc
		System.out.println("Saldo conta corrente: " + cc.getSaldo());
		
		//exibe o saldo cp
		System.out.println("Saldo conta poupança: " + cp.getSaldo());
		
		try {
			//chama o metodo retirar cc
			cc.retirar(5000);
			//exibe o novo saldo cc
			System.out.println("Saldo conta corrente: " + cc.getSaldo());
			
			//chama o metodo retirar cp
			cp.retirar(5000);
			//exibe o novo saldo cp
			System.out.println("Saldo conta poupança: " + cp.getSaldo());
		} catch (SaldoInsuficienteException e) {
			System.err.println(e.getMessage());
		}
		
		//cria uma lista de cc
		List<ContaCorrente> lista = new ArrayList<>();
		
		//adicionar cc na lista
		lista.add(cc);
		lista.add(new ContaCorrente(13, 125, new GregorianCalendar(2020, Calendar.FEBRUARY, 21), 100, TipoConta.COMUM));
		lista.add(new ContaCorrente(54, 122, new GregorianCalendar(2025, Calendar.JULY, 21), 5600, TipoConta.PREMIUM));
		lista.add(new ContaCorrente(4, 123, new GregorianCalendar(2021, Calendar.AUGUST, 22), 100, TipoConta.ESPECIAL));
		
		//exibir saldo das contas correntes
		System.out.println("Saldos: ");
		for (ContaCorrente item : lista) {
			System.out.println(item.getSaldo());
		}
		
		
	}

}
