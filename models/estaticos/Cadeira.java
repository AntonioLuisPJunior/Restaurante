package models.estaticos;

import models.moveis.*;
import interfaces.*;
import java.util.TimerTask;
import java.util.Timer;

public class Cadeira implements Status, Movimento, VerificarCadeira, ConstantesComida {

    private Cliente sentado = null;
    public Timer timer;

    // getters setters
    public Cliente getSentado() {
        return sentado;
    }

    public void setSentado(Cliente sentado) {
        this.sentado = sentado;
    }
    // fim getters setters

    // metodos da classe
    public void comendo() {
        sentado.setComendo(true);
    }

    public void comeu() {
        sentado.setComendo(false);
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
        if (sentado != null) {
            if (sentado.getComeu())
                return sair();
            if (!sentado.isComendo()) {
                sentado.comendo();
                int tempoTotal = TEMPOMAXATENDIMENTO + TEMPOMAXCOZINHANDO + TEMPOMAXATRAZENDOCOMIDA + TEMPOMAXCOMENDO;
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        sentado.comeu();
                        System.out.println("UM CLIENTE TERMINOU DE COMER");
                    }
                }, tempoTotal);
                timer = null;
                return null;
            }
            return null;
        }
        return null;
    }
    // fim metodos para interfaces

}
