package org.banco_tucs.interface_contas;

import org.banco_tucs.banco.Banco;
import org.banco_tucs.client.Cliente;

public class Poupanca extends Contas {
    private static final int TIPOCONTANUM = 02;

    public Poupanca(Cliente cliente) {
        super.cliente = cliente;
        super.banco = Banco.NOME_BANCO;
        super.agencia = String.format("%04d", Contas.AGENCIA);
        super.numeroConta = String.format("%02d", TIPOCONTANUM) + String.format("%06d", Contas.sequencialConta++);
        super.digitoVerificador = gerarDigitoVerificador (numeroConta);
        super.saldo=0;
    }  
}
