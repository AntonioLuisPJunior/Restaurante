package models.moveis;

public class Garcom extends Pessoa{

    private boolean servindo;

    public Garcom(int id){
        super(id);
    }

    //getters setters
    public boolean getServindo() {
        return servindo;
    }
    public void setServindo(boolean servindo) {
        this.servindo = servindo;
    }

    @Override
    public void existir() {
        System.out.println("Garçom criado");
    }

    @Override
    public int exibirStatus() {
        System.out.println("Estou " + (servindo?"Servido":"Aguardando um Cliente"));
        return super.exibirStatus();
    }

}
