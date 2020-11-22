package comeco;

import compartimentos.*;
import interfaces.*;
import models.moveis.*;

public class Controlador implements Runnable, Status, ConstantesEntrada {

    private boolean aberto;
    private Restaurante restaurante;
    private Thread thread;

    private int id = 0;

    public Controlador() {
        existir();
    }

    public void entraCliente() {
        Cliente cliente = new Cliente(this.id);
        restaurante.entrar(cliente);
        this.id++;
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
        System.out.println("\t\tBEM VINDO AO RESTAURANTE");
        this.id = restaurante.getSalao().quantidadeGarcons() + 1;
    }

    public void tick() {
        entraCliente();
        restaurante.movimentar();
    }

    public void render() {
        exibirStatus();
    }

    @Override
    public void run() {
        iniciar();
        while (aberto) {
            tick();
            try {
                Thread.sleep(1000);
                render();

            } catch (Exception e) {
                e.printStackTrace();
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
