/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafiodiobanco;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathe
 */
public abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    
    protected int agencia;
    protected int numeroConta;
    protected double saldo;
    
    private Cliente cliente;
    
    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
        this.saldo = 0;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    public void sacar(double valorSaque) throws Exception{
        if(saldo >= valorSaque)
        {
            saldo -= valorSaque;
        }
        else
        {
            throw new Exception("O valor do saque excede seu saldo.");
        }
    }
    
    public void depositar(double valorDeposito) throws Exception{
        if(valorDeposito > 0)
        {
            saldo += valorDeposito;
        }
        else
        {
            throw new Exception("Não é possível depositar um valor nulo ou negativo.");
        }
        
    }
    
    public void transferir(double valorTransferencia, Conta contaDestino) throws Exception {
        if(saldo >= valorTransferencia)
        {
            sacar(valorTransferencia);
            contaDestino.depositar(valorTransferencia);
        }
        else
        {
            throw new Exception("O valor a ser transferido excede seu saldo.");
        }
    }
    
    public static List<Conta> procurarContas(Cliente titularDaConta, Banco banco){
        List<Conta> contas = banco.getContas();
        List<Conta> contasDoCliente = new ArrayList<>();
        
        for(Conta conta: contas)
        {
            if(conta.getCliente() == titularDaConta){
                contasDoCliente.add(conta);
            }
        }
        return contasDoCliente;
    }
    
    @Override
    public String toString(){
        return "Agencia: " + agencia + "\nNumero da Conta: " + numeroConta +"\nTitular: " + cliente.getNome() +"\nSaldo: " + saldo;
    }
    
}
