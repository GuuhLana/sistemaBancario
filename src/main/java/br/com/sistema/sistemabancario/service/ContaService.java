package br.com.sistema.sistemabancario.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.sistemabancario.entity.Conta;
import br.com.sistema.sistemabancario.entity.LogTransferencia;
import br.com.sistema.sistemabancario.entity.TransferenciaAgendada;
import br.com.sistema.sistemabancario.repository.ContaRepository;
import br.com.sistema.sistemabancario.repository.LogRepository;
import br.com.sistema.sistemabancario.repository.TransfAgendadaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private LogRepository logRepository;

	@Autowired
	private TransfAgendadaRepository transfAgendadaRepository;

	public double verificarSaldo(Long id) {
		Optional<Conta> conta = contaRepository.findById(id);
		return conta.get().getSaldo();
	}

	public void transferir(Long origem, Long destino, double valor, String tipo, int quantidadeParcela) {
		Optional<Conta> contaOrigem = contaRepository.findById(origem);
		Optional<Conta> contaDestino = contaRepository.findById(destino);
		
		if (tipo.equals("parcelada")) {
			TransferenciaAgendada agendada = new TransferenciaAgendada(valor, quantidadeParcela);
			transfAgendadaRepository.save(agendada);
		}

		else if (contaOrigem.get().getSaldo() >= valor) {
			contaOrigem.get().transferir(valor);
			contaDestino.get().receberTransferencia(valor);

			contaRepository.save(contaOrigem.get());
			contaRepository.save(contaDestino.get());

			LogTransferencia log = new LogTransferencia(contaDestino.get().getId(), contaOrigem.get().getId(),
					LocalDateTime.now(), true, valor);

			logRepository.save(log);
		} else {
			throw new RuntimeException("Não foi possivel realizar a transferencia, verifique os valores inseridos");
		}

	}

	public void reverterTransferencia(Long id) {
		Optional<LogTransferencia> log = logRepository.findById(id);
		Optional<Conta> contaOrigem = contaRepository.findById(log.get().getOrigem());
		Optional<Conta> contaDestino = contaRepository.findById(log.get().getDestino());

		contaDestino.get().transferir(log.get().getValor());
		contaOrigem.get().receberTransferencia(log.get().getValor());

		log.get().setStatus(false);

		logRepository.save(log.get());

	}

}
