package compartimentos;

import interfaces.*;
import models.moveis.*;
import java.util.ArrayList;

public class Saida implements Status, FuncionamentoPassagem {

    private ArrayList<Pessoa> filaSaida = new ArrayList<>();

    public Saida(){
        existir();
    }

    //getters setters
    public ArrayList<Pessoa> getFilaSaida() {
        return filaSaida;
    }

    public void setFilaSaida(ArrayList<Pessoa> filaSaida) {
        this.filaSaida = filaSaida;
    }

    @Override
    public void existir() {
        System.out.println("Saída criada");
    }

    @Override
    public void entrar(Cliente cliente) {
        filaSaida.add(cliente);
    }

    @Override
    public Pessoa sair() {
        Pessoa clienteTemp = filaSaida.get(0);
        filaSaida.remove(0);
        return clienteTemp;
    }

    @Override
    public int exibirStatus() {
        int quantidade = filaSaida.size();
        System.out.println("Existem " + quantidade + " pessoas saindo do restaurante");
        return quantidade;
    }

    
}
