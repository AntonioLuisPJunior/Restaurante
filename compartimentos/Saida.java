package compartimentos;

import interfaces.*;
import models.moveis.*;
import java.util.ArrayList;

public class Saida implements Status, Movimento {

    private static ArrayList<Pessoa> filaSaida = new ArrayList<>();

    private int sairam = 0;

    public Saida() {
        existir();
    }

    // getters setters
    public static ArrayList<Pessoa> getFilaSaida() {
        return filaSaida;
    }

    public static void setFilaSaida(ArrayList<Pessoa> filaSaida) {
        Saida.filaSaida = filaSaida;
    }

    // metodos para classe

    // fim metodos para classe

    // metodos das interfaces
    @Override
    public void existir() {
        System.out.println("Saída aberta");
    }

    @Override
    public int exibirStatus() {
        int quantidade = filaSaida.size();
        System.out.println("Já saíram " + sairam + " pessoas do restaurante");
        return quantidade;
    }

    @Override
    public void entrar(Cliente cliente) {
        System.out.println(";@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ eNTROU GENTE NA FILA DE SAIDA");
        filaSaida.add(cliente);
    }

    @Override
    public Pessoa sair() {
        if (!filaSaida.isEmpty()){
            Pessoa temporario = filaSaida.get(0);
            filaSaida.remove(0);
            sairam ++;
            return temporario;
        } else {
            return null;
        }
    }

    @Override
    public Pessoa movimentar() {
        return sair();
    }
    // fim metodos das interfaces
}
