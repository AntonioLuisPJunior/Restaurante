package utils;

import java.util.Random;

public class Aleatorio {

    public static Random randomico = new Random();

    public static int maiorZero(int i) {
        int x = randomico.nextInt(i);
        if (x <= 0) {
            return 1;
        }
        return x;
    }

    public static String nomeAleatorio(){
        String[] alfabeto = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String nome = "";
        int nrAleatorio;
        Random ramdom = new Random();
        for(int i = 0; i < 20; i++){
            nrAleatorio = 0 + ramdom.nextInt(25);
            if(i == 10){
                nome += " ";
            }
            nome += alfabeto[nrAleatorio];
        }
        return nome;
    }

}
