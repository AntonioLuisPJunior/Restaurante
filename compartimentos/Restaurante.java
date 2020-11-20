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
        quantidade += saida.exibirStatus();
        System.out.println("Com um total de " + quantidade + " pessoas");
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
            Cliente clienteTemporario = (Cliente) entrada.sair();
            salao.entrar(clienteTemporario);
        }
        if (salao.sair() != null) {
            Cliente clienteTemporario2 = (Cliente) salao.sair();
            saida.entrar(clienteTemporario2);
        }
        if (salao.sair() != null) {
            return saida.sair();
        }
        return null;
    }

    @Override
    public boolean assentosVazios() {
        return salao.assentosVazios();
    }
    // fim metodos das interfaces

}