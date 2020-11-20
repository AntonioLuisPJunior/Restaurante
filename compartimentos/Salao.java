package compartimentos;

import models.estaticos.*;
import models.moveis.*;
import interfaces.*;
import java.util.ArrayList;

public class Salao implements Status, Movimento, VerificarCadeira {

    private ArrayList<Garcom> garcons = new ArrayList<>();
    private ArrayList<Mesa> mesas = new ArrayList<>();
    private ArrayList<Caixa> caixas = new ArrayList<>();

    public Salao() {
        existir();
        iniciar();
    }

    public Salao(boolean aberto) {
        existir();
        iniciar();
    }

    // getters setters
    public ArrayList<Garcom> getGarcons() {
        return garcons;
    }

    public void setGarcons(ArrayList<Garcom> garcons) {
        this.garcons = garcons;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    public ArrayList<Caixa> getCaixas() {
        return caixas;
    }

    public void setCaixas(ArrayList<Caixa> caixas) {
        this.caixas = caixas;
    }
    // fim getters setters

    // metodos para as classes
    public void iniciar() {
        garcons.add(new Garcom(1));
        garcons.add(new Garcom(2));
        caixas.add(new Caixa());
        caixas.add(new Caixa());
        mesas.add(new Mesa());
        mesas.add(new Mesa());
        mesas.add(new Mesa());
        mesas.add(new Mesa());
    }

    public int quantidadeGarcons() {
        return garcons.size();
    }
    // fim metodos para as classes

    // metodos para interfaces
    @Override
    public void existir() {
        System.out.println("Salão aberto");
    }

    @Override
    public int exibirStatus() {
        int quantidade = 0;
        int i = 1;
        for (Garcom garcom : garcons) {
            System.out.println("Garcom " + i);
            quantidade += garcom.exibirStatus();
            i++;
        }
        i = 1;
        for (Mesa mesa : mesas) {
            System.out.println("Mesa " + i);
            quantidade += mesa.exibirStatus();
            i++;
        }
        i = 1;
        for (Caixa caixa : caixas) {
            System.out.println("Caixa " + i);
            quantidade += caixa.exibirStatus();
            i++;
        }
        return quantidade;
    }

    @Override
    public void entrar(Cliente cliente) {
        for (Mesa mesa : mesas) {
            if (mesa.assentosVazios()) {
                mesa.entrar(cliente);
                break;
            }
        }
    }

    @Override
    public Pessoa sair() {
        for (Caixa caixa : caixas) {
            if (caixa.sair() != null)
                return caixa.sair();
        }
        return null;
    }

    @Override
    public Pessoa movimentar() {
        for (Mesa mesa : mesas) {
            if (mesa.sair() != null) {
                Cliente clienteTemporario;
                clienteTemporario = (Cliente) mesa.sair();
                if (caixas.get(0).getClientesAPagar().size() == caixas.get(1).getClientesAPagar().size()) {
                    caixas.get(0).entrar(clienteTemporario);
                } else if (caixas.get(0).getClientesAPagar().size() > caixas.get(1).getClientesAPagar().size()) {
                    caixas.get(1).entrar(clienteTemporario);
                } else if (caixas.get(0).getClientesAPagar().size() < caixas.get(1).getClientesAPagar().size()) {
                    caixas.get(0).entrar(clienteTemporario);
                }
            }
        }
        for (Caixa caixa : caixas) {
            if (caixa.sair() != null) {
                return caixa.sair();
            }
        }
        return null;
    }

    @Override
    public boolean assentosVazios() {
        for (Mesa mesa : mesas) {
            if (mesa.assentosVazios() == true)
                return true;
        }
        return false;
    }
    // fim metodos para interfaces
}
