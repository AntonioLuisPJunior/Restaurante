package models.estaticos;

import models.moveis.*;
import interfaces.*;
import utils.*;
import java.util.ArrayList;

public class Caixa implements Status, Movimento, ConstantesPagamento {

    private ArrayList<Cliente> clientesAPagar = new ArrayList<>();
    private Cliente clientePagando = null;

    public Caixa() {

    }

    // getters setters
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
    // fim getters setters

    // metodos da classe
    public void pagar() {
        clientePagando.setPagou(true);
    }
    // fim metodos da classe

    // metodos para interfaces
    @Override
    public void existir() {
        System.out.println("Eu sou um caixa");
    }

    @Override
    public int exibirStatus() {
        int quantidade = clientesAPagar.size();
        if (clientePagando != null)
            quantidade++;
        System.out.println("Existem " + quantidade + " pessoas nesse caixa do restaurante");
        return quantidade;
    }

    @Override
    public void entrar(Cliente cliente) {
        clientesAPagar.add(cliente);
    }

    @Override
    public Pessoa sair() {
        Pessoa temporario = this.clientePagando;
        this.clientePagando = null;
        return temporario;
    }

    @Override
    public Pessoa movimentar() {
        if (clientePagando == null) {
            if (!clientesAPagar.isEmpty()){
                this.clientePagando = clientesAPagar.get(0);
                clientesAPagar.remove(0);
            }
            return null;
        } else {
            // Aleatorio.randomico.nextInt(TEMPOMAXPAGAMENTO);
            pagar();
            return sair();
        }
    }
    // fim metodos para interfaces
}