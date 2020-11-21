package compartimentos;

import interfaces.*;
import models.moveis.*;

public class Restaurante implements Status, Movimento, VerificarCadeira, ConstantesEntrada {

    private Entrada entrada;
    private Saida saida;
    private Salao salao;

    private int teste;
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
        System.out.println("Restaurante aberto");
    }

    @Override
    public int exibirStatus() {
        int quantidade = 0;
        for (int i = 0; i<10 ; i++){
            System.out.println("");
        }
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        System.out.println("No momento o restaurante esta:");
        quantidade += entrada.exibirStatus();
        quantidade += salao.exibirStatus();
        int teste = saida.exibirStatus();
        this.teste += teste;
        quantidade += teste;
        System.out.println("Com um total de " + quantidade + " pessoas");
        System.out.println("Ja sairam desde restaurante " + this.teste + " pessoas");
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
            saida.entrar((Cliente)  clienteTemporario2);
        }
        return saida.movimentar();
    }

    @Override
    public boolean assentosVazios() {
        return salao.assentosVazios();
    }
    // fim metodos das interfaces

}