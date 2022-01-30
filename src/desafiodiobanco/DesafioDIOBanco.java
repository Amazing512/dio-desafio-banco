
package desafiodiobanco;

import java.util.ArrayList;

public class DesafioDIOBanco {

    public static void main(String[] args) {
        Cliente usuario = new Cliente("Rodrigo");
        Conta contaCorrente = new ContaCorrente(usuario);
        
        Cliente poupador = new Cliente("Igor");
        Conta contaPoupancaIgor = new ContaPoupanca(poupador);
        Conta contaCorrenteIgor = new ContaCorrente(poupador);
        Conta contaSecundariaPoupancaIgor = new ContaPoupanca(poupador);
        
        /*Teste mensagem de erro*/
        try {
            contaPoupancaIgor.depositar(-5); // erro
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        
        
        try {
            contaPoupancaIgor.depositar(5000);
            contaPoupancaIgor.transferir(2500, contaCorrente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        ArrayList<Conta> contas = new ArrayList<>();
        contas.add(contaCorrente);
        contas.add(contaCorrenteIgor);
        contas.add(contaPoupancaIgor);
        contas.add(contaSecundariaPoupancaIgor);
        Banco banco = new Banco("Banco do Brasil");
        banco.setContas(contas);
        
        ArrayList<Conta> contasDoPoupador = (ArrayList) Conta.procurarContas(poupador, banco);
        
        System.out.println("--------Contas de Igor----------");
        for(Conta conta: contasDoPoupador){
            System.out.println(conta.toString());
            System.out.println();
        }
        System.out.println("----------------------------------");
        
        System.out.println(contaCorrente.toString());
        System.out.println();
        System.out.println(contaPoupancaIgor.toString());
    }
    
}
