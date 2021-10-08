package br.com.sistema.sistemabancario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.sistema.sistemabancario.service.ContaService;

@RestController
@RequestMapping("/sistema-bancario")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@GetMapping(path = "/{id}")
	public double consultarSaldo(@PathVariable Long id) {
		return contaService.verificarSaldo(id);
	}

	@PostMapping
	public ResponseEntity<String> transferir(@RequestParam Long origem, @RequestParam Long destino,
			@RequestParam double valor,@RequestParam String tipo, @RequestParam int quantidadeParcela) {

		try {
			contaService.transferir(origem, destino, valor,tipo , quantidadeParcela);
			return new ResponseEntity<String>("Transferencia realizada com sucesso", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping
	public ResponseEntity<String> reverter(@RequestParam Long id) {

		try {
			contaService.reverterTransferencia(id);
			return new ResponseEntity<String>("Transferencia revertida com sucesso", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
