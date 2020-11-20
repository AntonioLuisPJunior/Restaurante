package models.estaticos;

import models.moveis.*;
import interfaces.*;
import java.util.HashMap;

public class Mesa implements Status, FuncionamentoMesa, VerificarMesas{

    private HashMap<Integer,Cliente> clientesSentados = new HashMap<Integer, Cliente>();

    public Mesa(){

    }

    public HashMap<Integer, Cliente> getClientesSentados() {
        return clientesSentados;
    }

    public void setClientesSentados(HashMap<Integer, Cliente> clientesSentados) {
        this.clientesSentados = clientesSentados;
    }

    @Override
    public void sentarMesa(Cliente cliente){
        clientesSentados.put(cliente.getId(),cliente);
    }

    @Override
    public void levantarMesa(Cliente cliente){
        clientesSentados.remove(cliente.getId());
    }
    
    @Override
    public void levantarMesa(int id){
        clientesSentados.remove(id);
    }

    @Override
    public boolean assentosVazios(){
        if(clientesSentados.size() == MAXIMOCLIENTESMESA){
            return false;
        } else{
            return true;
        }
    }

    @Override
    public int exibirStatus() {
        int quantidade = clientesSentados.size();
        System.out.println("Existem " + quantidade + " pessoas nessa mesa do restaurante");
        return quantidade;
    }

    @Override
    public void existir() {
        System.out.println("Eu sou uma mesa");

    }
    
}