package models.estaticos;

import models.moveis.*;
import interfaces.*;
import java.util.ArrayList;

public class Caixa implements Status{ 

    private ArrayList<Cliente> clientesAPagar = new ArrayList<>();
    private Cliente clientePagando = null;

    public Caixa(){
        
    }

    //getters setters
    public Cliente getClientePagando() {
        return clientePagando;
    }
    public void setClientePagando(Cliente clientePagando) {
        this.clientePagando = clientePagando;
    }
    public ArrayList<Cliente> getClientesAPagar() {
        return clientesAPagar;
    }
    public void setClientesAPagar(ArrayList<Cliente> clientesAPagar) {
        this.clientesAPagar = clientesAPagar;
    }

    @Override
    public int exibirStatus() {
        int quantidade = clientesAPagar.size();
        if(clientePagando != null)
            quantidade++;
        System.out.println("Existem " + quantidade + " pessoas nesse caixa do restaurante");
        return quantidade;
    }

    @Override
    public void existir() {
        System.out.println("Eu sou um caixa");
    }
    
}
