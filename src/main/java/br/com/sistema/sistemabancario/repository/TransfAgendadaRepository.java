package br.com.sistema.sistemabancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sistema.sistemabancario.entity.TransferenciaAgendada;

public interface TransfAgendadaRepository extends JpaRepository<TransferenciaAgendada, Long> {

}
