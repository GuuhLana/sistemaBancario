package br.com.sistema.sistemabancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sistema.sistemabancario.entity.LogTransferencia;

public interface LogRepository extends JpaRepository<LogTransferencia, Long>{

}
