package models.moveis;

public class Cliente extends Pessoa{

    private boolean comeu = false;
    private boolean pagou = false;

    public Cliente(int id){
        super(id);
    }
    
    //getters setters
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

    @Override
    public void existir() {
        System.out.println("Garçom criado");
    }

    @Override
    public int exibirStatus() {
        if       (pagou == false && comeu == false){
            System.out.println("Estou aguardando o Garçom");
        } else if(pagou == false && comeu == true){
            System.out.println("Eu comi");
        } else if(pagou == true  && comeu == false){
            System.out.println("Eu fui besta");
        } else if(pagou == true  && comeu == true) {
            System.out.println("Eu estou saindo");
        }
        return super.exibirStatus();
    }

}
