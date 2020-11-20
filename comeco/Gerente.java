package comeco;

import compartimentos.*;
import interfaces.*;
import utils.*;
import models.moveis.*;

public class Gerente implements Runnable, Status, ConstantesEntrada {

    private boolean aberto;
    private Restaurante restaurante;
    private Thread thread;

    private int id = 0;

    public Gerente() {
        existir();
    }

    public void entraCliente() {
        try {
            Thread.sleep(Aleatorio.randomico.nextInt(TEMPOMAXENTRADA));
            Cliente cliente = new Cliente(id);
            restaurante.entrar(cliente);
            this.id++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // metodos da thread
    public synchronized void start() {
        if (aberto)
            return;
        aberto = true;
        thread = new Thread(this);
        thread.start();
    }

    public void iniciar() {
        restaurante = new Restaurante();
        System.out.println("Bem vindo ao Restaurante");
        this.id = restaurante.getSalao().quantidadeGarcons() + 1;
    }

    public void tick(int id) {
        entraCliente();
        restaurante.movimentar();
        restaurante.sair();
    }

    public void render() {
        exibirStatus();
    }

    @Override
    public void run() {
        iniciar();
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        while (aberto) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;
            int id = 1;
            tick(id);
            if (delta >= 1) {
                render();
                delta--;
            }
        }
        stop();
    }

    public synchronized void stop() {
        if (!aberto)
            return;
        aberto = false;
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // fim metodos da thread

    // metodos da interface
    @Override
    public void existir() {
        System.out.println("Eu sou o gerente e já vou abrir o Restaurante");
    }

    @Override
    public int exibirStatus() {
        return restaurante.exibirStatus();
    }
    // fim metodos da interface
}
