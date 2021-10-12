
**Sistema Bancario**
 
 O projeto consiste em desenvolver uma aplicação semelhante a um sistema bancário. O projeto deve permitir as seguintes operações:

	- Consulta de saldo;
	- Transferência entre contas;
	- Reverter uma transferência;
	- Programar uma transferência futura parcelada 
		(Ex: Usuário informa que quer transferir 300,00 em 3x. Isso deve gerar 3 registros em outra entidade com cada transferência a ser realizada. 
		Não é necessário implementar nada referente a efetivação dessas transferências futuras. Queremos ver somente a listagem de transferências futuras.)
    
    
    
  Segue abaixo Script SQL para criação dos clientes no banco de dados PostgreSQL

    INSERT INTO tb_conta (titular, numero, agencia, saldo)
    VALUES ('Elton Jones Manetti', '01', '10', 1750.00);

    INSERT INTO tb_conta (titular, numero, agencia, saldo)
    VALUES ('Anderson Andres Cuccittini ', '02', '220', 3450.50);

    INSERT INTO tb_conta (titular, numero, agencia, saldo)
    VALUES ('Lionel Messi Ronaldo', '03', '74', 4540.00);

    
Requisições foram feitas atraves do POSTMAN

Exemplos de requisições

**CONSULTA**
http://localhost:8080/sistema-bancario/1

**TRANSFERENCIA**
http://localhost:8080/sistema-bancario?origem=1&destino=4&valor=300.00&tipo=parcelada&quantidadeParcela=2

OBS: É necessario passar o valor da parcela, mesmo que não seja uma transferencia parcelada, exemplo:
http://localhost:8080/sistema-bancario?origem=1&destino=4&valor=300.00&tipo=parcelada&quantidadeParcela=0

Para **reverter** uma transferencia basta passar como parametro o valor do id da transferencia que a mesma sera revertida.
http://localhost:8080/sistema-bancario/?id=5

SELECT responsavel por visualizar os logs das transferencias:

	SELECT * FROM tb_log;
	
SELECT responsavel por visualizar os logs das transferencias agendadas:

	SELECT * FROM transferencia_agendada;
	
