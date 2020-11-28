package situacoes;

import models.moveis.*;

public class Atender {

    private Cliente cliente;
    private Garcom garcom;

    private boolean finalizado = false;

    public Atender(Cliente cliente, Garcom garcom) {
        this.cliente = cliente;
        this.garcom = garcom;
    }

    // metodos da classe
    public void finalizarAtendimento() {
        cliente.atendido();
        garcom.atendeu();
        finalizado = true;
    }
    // fim metodos da classe

    // getters setters
    public Cliente getCliente() {
        return cliente;
    }

    public Garcom getGarcom() {
        return garcom;
    }

    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    // fim getters setters

}
