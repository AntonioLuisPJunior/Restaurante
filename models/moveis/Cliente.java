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

}
