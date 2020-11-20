package interfaces;

import models.moveis.*;

public interface Movimento {
    void entrar(Cliente cliente);
    Pessoa sair();
    Pessoa movimentar();
}
