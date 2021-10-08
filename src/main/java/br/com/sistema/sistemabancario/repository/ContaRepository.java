package br.com.sistema.sistemabancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sistema.sistemabancario.entity.Conta;



public interface ContaRepository extends JpaRepository<Conta, Long> {

}
