package interfaces;

import models.moveis.*;

public interface FuncionamentoMesa {
    void sentarMesa(Cliente cliente);
    void levantarMesa(Cliente cliente);
    void levantarMesa(int id);
}
