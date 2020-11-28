package compartimentos;

import interfaces.*;
import models.moveis.*;

public class Restaurante implements Status, Movimento, VerificarCadeira, ConstantesEntrada {

    private Entrada entrada;
    private Saida saida;
    private Salao salao;

    public Restaurante() {
        existir();        
        entrada = new Entrada();
        salao = new Salao();
        saida = new Saida();
    }

    // getters setters
    public Salao getSalao() {
        return salao;
    }

    public void setSalao(Salao salao) {
        this.salao = salao;
    }

    public Saida getSaida() {
        return saida;
    }

    public void setSaida(Saida saida) {
        this.saida = saida;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }
    // fim getters setters

    // metodos para classe

    // fim metodos para classe

    // metodos das interfaces
    @Override
    public void existir() {
        System.out.println("RESTAURANTE ABERTO");
    }

    @Override
    public int exibirStatus() {
        int quantidade = 0;
        for (int i = 0; i<10 ; i++){
            System.out.println("");
        }
        System.out.println("__________________________________________________________");
        System.out.println("\t\tSTATUS DO RESTAURANTE");
        quantidade += entrada.exibirStatus();
        quantidade += salao.exibirStatus();
        System.out.println("TOTAL DE PESSOAS NO RESTAURANTE: " + quantidade);
        System.out.println("TOTAL DE ATENDIMENTOS:           " + Salao.atendimentos.size());
        saida.exibirStatus();
        return quantidade;
    }

    @Override
    public void entrar(Cliente cliente) {
        entrada.entrar(cliente);
    }

    @Override
    public Pessoa sair() {
        return saida.sair();
    }

    @Override
    public Pessoa movimentar() {
        if (salao.assentosVazios()) {
            Object clienteTemporario = entrada.movimentar();
            if (clienteTemporario != null){
                salao.entrar((Cliente) clienteTemporario);
            }
        }
        Object clienteTemporario2 = salao.movimentar();
        if (clienteTemporario2 != null){
            saida.entrar((Cliente) clienteTemporario2);
        }
        Object clienteTemporario3 = saida.movimentar();
        if (clienteTemporario3 != null){
            System.out.println("UMA PESSOA SAIU DO RESTAURANTE");
            return (Cliente) clienteTemporario3;
        }
        return null;
    }

    @Override
    public boolean assentosVazios() {
        return salao.assentosVazios();
    }
    // fim metodos das interfaces

}