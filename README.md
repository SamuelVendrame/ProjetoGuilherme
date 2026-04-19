2. controle de biblioteca escolar
tabelas:

livro: titulo, autor, quantidade disponivel.
aluno: nome, matricula/contato.
emprestimo: livro, aluno, data de retirada, data de devolucao, status (aberto/devolvido).

Regras de negocio:

proibido cadastrar livros com titulo vazio.
proibido cadastrar livros com quantidade negativa.
nao permitir emprestimo se nao houver quantidade disponivel.
controle de devolucao para liberar o exemplar novamente.
consulta de quais livros estao emprestados no momento.
