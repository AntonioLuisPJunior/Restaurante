package comeco;

import compartimentos.*;
import models.moveis.*;

public class Launcher {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();  
        for(int i = 3; i <5; i++){
            Cliente cliente = new Cliente(i);
            restaurante.entrar(cliente);
            restaurante.exibirStatus();
        }     
    }
}
