package models.moveis;

import interfaces.*;
import utils.Aleatorio;

public abstract class Pessoa implements Status {

    protected int id;
    protected String nome = Aleatorio.nomeAleatorio();

    public Pessoa(){
    }
    public Pessoa(int id){
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // metodos da interface
    @Override
    public void existir() {
        System.out.println("Garçom aberto");
    }

    @Override
    public int exibirStatus() {
        return 1;
    }
    //fim metodos da interface

}
