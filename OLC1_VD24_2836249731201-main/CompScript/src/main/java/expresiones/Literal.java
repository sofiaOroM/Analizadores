package expresiones;

import abstracto.Instruction;

public class Literal extends Instruction {
    private final int valor;

    public Literal(int valor) {
        this.valor = valor;
    }

    @Override
    public Object ejecutar() {
        return valor;
    }
}
