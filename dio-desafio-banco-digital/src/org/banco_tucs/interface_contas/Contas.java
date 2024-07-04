package org.banco_tucs.interface_contas;

import org.banco_tucs.client.Cliente;

public abstract class Contas implements InterfaceConta{

    protected static final int AGENCIA = 1;
    protected static int sequencialConta = 1;

    protected String agencia;
    protected String numeroConta;
    protected int digitoVerificador;
	protected double saldo;
    protected Cliente cliente;
    protected String banco;
    

    
    
    public Cliente getCliente() {
        return cliente;
    }
    public String getBanco() {
        return banco;
    }
    public String getAgencia() {
        return agencia;
    }
    public String getNumeroConta() {
        return numeroConta;
    }
    public int getDigitoVerificador() {
        return digitoVerificador;
    }
    public double getSaldo() {
        return saldo;
    }

    protected int gerarDigitoVerificador (String numeroConta){
        int contDigVer = 0;
        String contDigVerStr = null;
        for (int i=(numeroConta.length()-1);i>=0;i--){
            int charContaInt = 0;
            String charContaStr = null;

            if ((numeroConta.length()-i) % 2 != 0) {
                charContaInt = (Integer.parseInt(Character.toString(numeroConta.charAt(i))))*2;
                charContaStr = Integer.toString(charContaInt);
                if (charContaStr.length() > 1){
                    charContaInt = (Integer.parseInt(Character.toString(charContaStr.charAt(1))) + Integer.parseInt(Character.toString(charContaStr.charAt(0))));
                }
                contDigVer += charContaInt;

            }else {
                charContaInt = (Integer.parseInt(Character.toString(numeroConta.charAt(i))))*1;
                charContaStr = Integer.toString(charContaInt);
                if (charContaStr.length() > 1){
                    charContaInt = (Integer.parseInt(Character.toString(charContaStr.charAt(1))) + Integer.parseInt(Character.toString(charContaStr.charAt(0))));
                }
                contDigVer += charContaInt;

            }
        }
        contDigVerStr = Integer.toString(contDigVer);
        if (contDigVerStr.length() > 1){
            contDigVer = (Integer.parseInt(Character.toString(contDigVerStr.charAt(1))) + Integer.parseInt(Character.toString(contDigVerStr.charAt(0))));
        }
        return contDigVer;
    }

    public void sacar(double valor){
        if (saldo > valor){
            saldo -= valor;
        }else{
            System.out.println("Saldo Insuficiente.\n" + "Saldo Total: " + saldo);
        }
    }

	public void depositar(double valor){
        saldo += valor;
    }

	public void transferir(double valor, InterfaceConta contaDestino){
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public void imprimirExtrato(){
        System.out.printf("%s","\n=========== Extrato ==========\n");
        System.out.printf("%-15s","Banco " + getBanco());
        System.out.printf("%15s",getCliente() + "\n");
        System.out.printf("%s","Agência: - " + getAgencia() + "\n");
        System.out.printf("%s","Conta: --- " + getNumeroConta()+"-"+getDigitoVerificador() + "\n");
        System.out.printf("%s","\n");
        System.out.printf("R$ %,.2f",getSaldo());
        System.out.print("\n");
        System.out.print("\n");
    }
    @Override
    public String toString() {
        return 
            "\n"+banco + ";" + agencia + ";" + numeroConta+"-"+digitoVerificador + ";" +  saldo + ";" + cliente + "\n";
    }

    

	//protected Cliente cliente;

    // definir numero da conta: identificador de tipo de conta (poupança ou corrente - a definir 2 digitos) + numero sequencial 6 digitos +  digito verificador
    // para o digito verificador multiplicar alternando de tras para frente cada digito por 2 e 1 (em caso de numero maior q 9 somar os digitos) ao final somar cada digito obtido e por fim pegar o ultimo digito obtido e subtrair de 10
    //exemplo

    //conta: 01123844
   // calculo DV = (4*2)+(4*1)+(8*2)+(3*1)+(2*2)+(1*1)+(1*2)+(0*1) =>
   // -------------( 8 )+( 4 )+( 16)+( 3 )+( 4 )+( 1 )+( 2 )+( 0 ) =>
   // -------------( 8 )+( 4 )+(1+6)+( 3 )+( 4 )+( 1 )+( 2 )+( 0 ) =>
   // -------------( 8 )+( 4 )+( 7 )+( 3 )+( 4 )+( 1 )+( 2 )+( 0 ) =>
   // -------------( 29 ) =>
   // -------------( 10 - 9) =>
   // --------DV = (1)
   //contaComDigito: conta + "-" + DV = 01123844-1
}
