package compartimentos;

import models.moveis.*;
import interfaces.*;
import java.util.ArrayList;

public class Entrada implements Status, Movimento, ConstantesEntrada {

    private ArrayList<Cliente> filaEntrada = new ArrayList<>();

    public Entrada() {
        existir();
    }

    // getters setters
    public ArrayList<Cliente> getFilaEntrada() {
        return filaEntrada;
    }

    public void setFilaEntrada(ArrayList<Cliente> filaEntrada) {
        this.filaEntrada = filaEntrada;
    }
    // fim getters setters

    // metodos para classe

    // fim metodos para classe

    // metodos para interfaces
    @Override
    public void existir() {
        System.out.println("Entrada aberta");
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
        if (!filaEntrada.isEmpty()){
            Pessoa temporario = filaEntrada.get(0);
            filaEntrada.remove(0);
            return temporario;
        }
        return null;
    }

    @Override
    public Pessoa movimentar() {
        return sair();
    }
    // fim metodos para interfaces

}
