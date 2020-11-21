package models.moveis;

public class Cliente extends Pessoa {

    private boolean comeu = false;
    private boolean pagou = false;
    private boolean comendo = false;
    private boolean pagando = false;

    public Cliente() {
    }

    public Cliente(int id) {
        super(id);
    }

    // getters setters
    public boolean getComeu() {
        return comeu;
    }

    public void setComeu(boolean comeu) {
        this.comeu = comeu;
    }

    public boolean getPagou() {
        return pagou;
    }

    public void setPagou(boolean pagou) {
        this.pagou = pagou;
    }

    public boolean isPagando() {
        return pagando;
    }

    public void setPagando(boolean pagando) {
        this.pagando = pagando;
    }

    public boolean isComendo() {
        return comendo;
    }

    public void setComendo(boolean comendo) {
        this.comendo = comendo;
    }
    // fim getters setters

    // metodos interfaces
    @Override
    public void existir() {
        System.out.println("Garçom aberto");
    }

    @Override
    public int exibirStatus() {
        if (pagou == false && comeu == false) {
            System.out.println("Estou aguardando o Garçom");
        } else if (pagou == false && comeu == true) {
            System.out.println("Eu comi");
        } else if (pagou == true && comeu == false) {
            System.out.println("Eu fui besta");
        } else if (pagou == true && comeu == true) {
            System.out.println("Eu estou saindo");
        }
        return super.exibirStatus();
    }
    // metodos interfaces

}
