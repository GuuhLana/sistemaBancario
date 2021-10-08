package br.com.sistema.sistemabancario.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransferenciaAgendada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double valorTotal;
	private int quantidadeParcela;
	private double valorParcela;
	
	public TransferenciaAgendada(double valorTotal, int quantidadeParcela) {
		super();
		this.valorTotal = valorTotal;
		this.quantidadeParcela = quantidadeParcela;
		this.valorParcela = valorTotal/quantidadeParcela;
	}
	
	public TransferenciaAgendada() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public int getQuantidadeParcela() {
		return quantidadeParcela;
	}
	public void setQuantidadeParcela(int quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}
	public double getValorParcela() {
		return valorParcela;
	}
	public void setValorParcela(double valorParcela) {
		this.valorParcela = valorParcela;
	}
	
	
}
