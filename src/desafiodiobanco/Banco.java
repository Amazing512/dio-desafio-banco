
package desafiodiobanco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Conta> getContas(){
        return contas;
    }
    
    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
    
    public void addConta(Conta conta) {
        contas.add(conta);
    }
    
    public void removeConta(Conta conta) throws Exception {
        if(contas.contains(conta)) {
            contas.remove(conta);
        }
        else
        {
            throw new Exception("Essa conta não existe.");
        }
    }
}
