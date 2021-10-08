package br.com.sistema.sistemabancario.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOG")
public class LogTransferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long destino;
	private Long origem;
	private LocalDateTime dataTransferencia;
	private String tipo;
	private boolean status;
	private double valor;

	public LogTransferencia(Long destino, Long origem, LocalDateTime dataTransferencia, boolean status,
			double valor) {
		this.destino = destino;
		this.origem = origem;
		this.dataTransferencia = dataTransferencia;
		this.status = status;
		this.valor = valor;
	}

	public LogTransferencia() {
		
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDestino() {
		return destino;
	}

	public void setDestino(Long destino) {
		this.destino = destino;
	}

	public Long getOrigem() {
		return origem;
	}

	public void setOrigem(Long origem) {
		this.origem = origem;
	}

	public LocalDateTime getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDateTime dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
