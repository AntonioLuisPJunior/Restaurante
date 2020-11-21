package models.estaticos;

import interfaces.*;
import models.moveis.*;
import java.util.ArrayList;

public class Mesa implements Status, Movimento, VerificarCadeira {

    private ArrayList<Cadeira> cadeiras = new ArrayList<>();

    public Mesa() {
        cadeiras.add(new Cadeira());
        cadeiras.add(new Cadeira());
        cadeiras.add(new Cadeira());
        cadeiras.add(new Cadeira());
    }

    // getters setters
    public ArrayList<Cadeira> getCadeiras() {
        return cadeiras;
    }

    public void setCadeiras(ArrayList<Cadeira> cadeiras) {
        this.cadeiras = cadeiras;
    }
    // fim getters setters

    // metodos para interfaces
    @Override
    public void existir() {
        System.out.println("Eu sou uma mesa");
    }

    @Override
    public int exibirStatus() {
        int quantidade = cadeiras.size();
        System.out.println("Existem " + quantidade + " pessoas nessa mesa do restaurante");
        return quantidade;
    }

    @Override
    public void entrar(Cliente cliente) {
        for (Cadeira cadeira : cadeiras) {
            if (cadeira.assentosVazios()) {
                cadeira.entrar(cliente);
                break;
            }
        }
    }

    @Override
    public Pessoa sair() {
        for (Cadeira cadeira : cadeiras) {
            if (cadeira.getSentado().getComeu()) {
                return cadeira.sair();
            }
        }
        return null;
    }

    @Override
    public Pessoa movimentar() {
        for (Cadeira cadeira : cadeiras) {
            if (cadeira.getSentado().getComeu()) {
                return cadeira.sair();
            }
        }
        return sair();
    }

    @Override
    public boolean assentosVazios() {
        for (Cadeira cadeira : cadeiras) {
            if (cadeira.assentosVazios() == true)
                return true;
        }
        return false;
    }
    // fim metodos para interfaces

}
