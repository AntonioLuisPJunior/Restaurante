package models.moveis;

public class Garcom extends Pessoa {

    private boolean atendendo;
    private boolean atendeu;

    public Garcom(int id) {
        super(id);
    }

    // getters setters
    public boolean isAtendeu() {
        return atendeu;
    }

    public void setAtendeu(boolean atendeu) {
        this.atendeu = atendeu;
    }

    public boolean getAtendendo() {
        return atendendo;
    }

    public void setAtendendo(boolean atendendo) {
        this.atendendo = atendendo;
    }
    // fim getters setters

    // metodos da interface
    @Override
    public void existir() {
        System.out.println("Garçom aberto");
    }

    @Override
    public int exibirStatus() {
        System.out.println("\tESTOU " + (atendendo ? "ATENDENDO " : "AGUARDANDO ") + "UM CLIENTE");
        return super.exibirStatus();
    }
    // fim metodos da interface

}
