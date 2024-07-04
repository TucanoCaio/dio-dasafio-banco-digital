package org.banco_tucs.banco;
import java.util.HashMap;
import java.util.Map;

//import org.banco_tucs.client.Cliente;
import org.banco_tucs.interface_contas.Contas;
//import org.banco_tucs.interface_contas.Corrente;
//import org.banco_tucs.interface_contas.Poupanca;

public class Banco {
    
    public final static String NOME_BANCO = "Tucs";
    private static int index = 1;
    private Map<Integer,Contas> bancoDados;

    public Banco() {
        this.bancoDados = new HashMap<>();
    }
    
    public void cadastrarContaCliente (Contas cc, Contas cp){  
        bancoDados.put(Banco.index++, cc);
        bancoDados.put(Banco.index++, cp);
    }

    public void printar (){
        System.out.println(bancoDados);
    }

    /*public static void main(String[] args) {
        Banco bancoDados = new Banco();

        Cliente caioTucano = new Cliente("caio ribeiro tucano");

        Contas caioTucanoCc = new Corrente(caioTucano);
        Contas caioTucanoCp = new Poupanca(caioTucano);
        bancoDados.cadastrarContaCliente(caioTucanoCc,caioTucanoCp);

        Cliente luFerreira = new Cliente("lucivania ferreira chaves");

        Contas luFerreiraCc = new Corrente(luFerreira);
        Contas luFerreiraCp = new Poupanca(luFerreira);
        bancoDados.cadastrarContaCliente(luFerreiraCc,luFerreiraCp);

        caioTucanoCc.depositar(20);
        caioTucanoCp.depositar(100);
        luFerreiraCc.depositar(30);
        luFerreiraCp.depositar(1400);

        caioTucanoCc.sacar(10);

        caioTucanoCc.depositar(20);

        caioTucanoCc.transferir(20, luFerreiraCc);

        caioTucanoCc.imprimirExtrato();

        bancoDados.printar();
    }*/
}
