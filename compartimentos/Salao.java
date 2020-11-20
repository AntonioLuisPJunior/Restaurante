package compartimentos;

import models.estaticos.*;
import models.moveis.*;
import interfaces.*;
import java.util.ArrayList;

public class Salao implements Status, VerificarMesas{

    private ArrayList<Garcom> garcons = new ArrayList<>();
    private ArrayList<Mesa> mesas = new ArrayList<>();
    private ArrayList<Caixa> caixas = new ArrayList<>();

    public Salao() {
        existir();
        garcons.add(new Garcom(1));
        garcons.add(new Garcom(2));
        caixas.add(new Caixa());
        caixas.add(new Caixa());
        mesas.add(new Mesa());
        mesas.add(new Mesa());
        mesas.add(new Mesa());
        mesas.add(new Mesa());
    }
    
    public int quantidadeGarcons(){
        return garcons.size();
    }

    public ArrayList<Garcom> getGarcons() {
        return garcons;
    }
    public void setGarcons(ArrayList<Garcom> garcons) {
        this.garcons = garcons;
    }
    public ArrayList<Caixa> getCaixas() {
        return caixas;
    }
    public void setCaixas(ArrayList<Caixa> caixas) {
        this.caixas = caixas;
    }
    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }
    
    @Override
    public void existir() {
        System.out.println("Salão criado");
    }

    @Override
    public int exibirStatus() {
        int quantidade = 0;
        int i = 1;
        for(Garcom garcom: garcons){
            System.out.println("Garcom " + i);
            quantidade += garcom.exibirStatus();
            i++;
        }
        i = 1;
        for(Mesa mesa: mesas){
            System.out.println("Mesa " + i);
            quantidade += mesa.exibirStatus();
            i++;
        }
        i = 1;
        for(Caixa caixa: caixas){
            System.out.println("Caixa " + i);
            quantidade += caixa.exibirStatus();
            i++;
        }
        return quantidade;
    }

    @Override
    public boolean assentosVazios(){
        for(Mesa mesa: mesas){
            if (mesa.assentosVazios() == true){
                return true;
            }
        }
        return  false;
    }
}