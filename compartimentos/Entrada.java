package compartimentos;

import models.moveis.*;
import interfaces.*;
import java.util.ArrayList;

public class Entrada implements Status, FuncionamentoPassagem {

    private ArrayList<Cliente> filaEntrada = new ArrayList<>();

    public Entrada() {
        existir();
    }

    //getters setters
    public ArrayList<Cliente> getFilaEntrada() {
        return filaEntrada;
    }

    public void setFilaEntrada(ArrayList<Cliente> filaEntrada) {
        this.filaEntrada = filaEntrada;
    }
    
    @Override
    public void existir() {
        System.out.println("Entrada criada");
    }
    
    @Override
    public int exibirStatus() {
        int quantidade = filaEntrada.size();
        System.out.println("Existem " + quantidade + " pessoas na fila esperando vaga no salão");
        return quantidade;  
    }

    @Override
    public void entrar(Cliente cliente) {
        filaEntrada.add(cliente);
    }

    @Override
    public Pessoa sair() {
        Cliente clienteTemp = filaEntrada.get(0);
        filaEntrada.remove(0);
        return (Pessoa)clienteTemp;
    }
    
}

