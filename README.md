# GerenciamentoAPI - Backend do Projeto de Gerenciamento de Finanças Pessoais

O GerenciamentoAPI é o backend do projeto de Gerenciamento de Finanças Pessoais, desenvolvido com Java e Spring Boot.

## Tecnologias Utilizadas

- Java com Spring Boot: Plataforma Java para desenvolvimento da aplicação backend.
- Spring Data JPA com Hibernate: Tecnologias para acesso ao banco de dados relacional e mapeamento objeto-relacional.
- Banco de Dados MySQL.
  A fazer: subir o banco para a nuvem.
- Maven: Gerenciador de dependências e construção do projeto.

## Funcionalidades Implementadas

- Gerenciamento de Categorias: Permite criar, atualizar, visualizar e excluir categorias para classificar as receitas e despesas.
- Gerenciamento de Receitas: Permite criar, atualizar, visualizar e excluir receitas, incluindo informações sobre data, descrição, valor e categoria associada.
- Gerenciamento de Despesas: Permite criar, atualizar, visualizar e excluir despesas, incluindo informações sobre data, descrição, valor e categoria associada.

## Como Executar o Backend

1. Certifique-se de ter o Java JDK 17 ou versão posterior instalado em sua máquina.
2. Configure as informações de conexão do banco de dados MySQL no arquivo `application.properties`.
3. Execute o seguinte comando na raiz do projeto para construir e executar a aplicação:
   ./mvnw spring-boot:run
   O backend estará acessível em http://localhost:8080.

## Contribuindo

Se você deseja contribuir para o desenvolvimento do GerenciamentoAPI, sinta-se à vontade para abrir um pull request ou reportar problemas no repositório do projeto.