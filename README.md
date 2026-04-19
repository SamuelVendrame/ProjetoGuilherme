1. controle de aluguel de quadra esportiva
tabelas:

cliente: nome, telefone.
horario: hora, preco, status (disponivel/ocupado).
aluguel: cliente, horario, data, valor cobrado.

regras de negocio:

proibido cadastrar cliente com nome vazio.
proibido cadastrar horario com valor negativo.
nao permitir reserva de um horario que ja esteja ocupado.
calculo automatico do valor total para multiplos horarios do mesmo cliente no dia.
consulta de todos os alugueis por data.
