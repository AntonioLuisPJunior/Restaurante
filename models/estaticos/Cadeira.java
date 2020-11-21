package models.estaticos;

import models.moveis.*;
import interfaces.*;
import utils.*;

public class Cadeira implements Status, Movimento, VerificarCadeira, ConstantesComida {

    private Cliente sentado = null;

    // getters setters
    public Cliente getSentado() {
        return sentado;
    }

    public void setSentado(Cliente sentado) {
        this.sentado = sentado;
    }
    // fim getters setters

    // metodos da classe
    public void alimentar() {
        sentado.setComeu(true);
    }
    // fim metodos da classe

    // metodos da interface
    @Override
    public void existir() {
        System.out.println("Eu sou uma cadeira");
    }

    @Override
    public int exibirStatus() {
        int quantidade = 0;
        if (sentado != null)
            quantidade = 1;
        return quantidade;
    }

    public boolean assentosVazios() {
        if (sentado == null)
            return true;
        return false;
    }

    @Override
    public void entrar(Cliente cliente) {
        this.sentado = cliente;
    }

    @Override
    public Pessoa sair() {
        Pessoa temporario = this.sentado;
        this.sentado = null;
        return temporario;
    }

    @Override
    public Pessoa movimentar() {
        // int tempoTotal = TEMPOMAXATENDIMENTO + TEMPOMAXCOZINHANDO +
        // TEMPOMAXATRAZENDOCOMIDA + TEMPOMAXCOMENDO;
        // Aleatorio.randomico.nextInt(tempoTotal);
        alimentar();
        return sair();
    }
    // fim metodos para interfaces

}
