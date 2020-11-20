package compartimentos;

import interfaces.*;
import models.moveis.*;

public class Restaurante implements Status, FuncionamentoPassagem, VerificarMesas {

    private Entrada entrada;
    private Saida saida;
    private Salao salao;

    public Restaurante() {
        existir();
        entrada = new Entrada();
        saida = new Saida();
        salao = new Salao();
    }

    public Restaurante(Entrada entrada, Saida saida, Salao salao) {
        existir();
        this.entrada = new Entrada();
        this.saida = new Saida();
        this.salao = new Salao();
    }

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

    @Override
    public void existir() {
        System.out.println("Restaurante criado");
    }

    @Override
    public int exibirStatus() {
        int quantidade = 0;
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        System.out.println("No momento o restaurante esta:");
        quantidade += entrada.exibirStatus();
        quantidade += salao.exibirStatus();
        quantidade += saida.exibirStatus();
        System.out.println("Com um total de "+ quantidade +" pessoas");
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
    public boolean assentosVazios() {
        return salao.assentosVazios();
    }
}