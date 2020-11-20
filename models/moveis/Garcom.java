package models.moveis;

public class Garcom extends Pessoa{

    private boolean servindo;

    public Garcom(int id){
        super(id);
    }
    public boolean getServindo() {
        return servindo;
    }
    public void setServindo(boolean servindo) {
        this.servindo = servindo;
    }
    
    // metodos da interface
    @Override
    public void existir() {
        System.out.println("Garçom aberto");
    }

    @Override
    public int exibirStatus() {
        System.out.println("Estou " + (servindo?"Servido":"Aguardando um Cliente"));
        return super.exibirStatus();
    }
    //fim metodos da interface

}
