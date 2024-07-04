# dio-dasafio-banco-digital

Desafio de projeto proposto pela **DIO** (Digital Innovation One) no **Bootcamp Santander 2024** *Trilha Java* 

## Objetivo do Desafio

Abstrair uma solução Orientada a Objetos em Java, interpretando o seguinte cenário:

> “Um banco oferece aos seus clientes dois tipos de contas (corrente e poupança), as quais possuem as funcionalidades de depósito, saque e transferência (entre contas da própria instituição).”

## Sobre o Desenvolvimento

1. Interface;
   - Criação da interface InterfaceConta para definir contrato dos principais metodos, `Sacar`, `Depositar`, `Transferir`, `Extrato`;
     
2. Herança.
   - Criação das classes `Corrente` e `Poupanca` herdando de `Contas` para otimizar a escrita;
   - A classa `Contas` também conta com o método `gerarDigitoVerificador` onde utilizei de contas matematicas para criar uma regra de negocio funcional para criação do `digitoVerificador`.
  
3. Tipos e Numeros de Contas.
   - Utilizei de variaveis `statics` e `final` para definir um numeo de conta de forma automatica de sequencial onde podemos diferenciar entre os tipos de conta pelos 2 primeiros digitos de seu numero, 01 para contas Correntes e 02 para Paupança.
