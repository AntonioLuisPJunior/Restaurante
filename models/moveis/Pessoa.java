package models.moveis;

import interfaces.*;

public class Pessoa implements Status {

    protected int id;

    public Pessoa(int id){
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void existir() {
    }

    @Override
    public int exibirStatus() {
        return 1;
    }
}
