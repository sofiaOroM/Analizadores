package expresiones;

import abstracto.Instruction;

public class Division extends Instruction {
    private final Instruction izquierda;
    private final Instruction derecha;

    public Division(Instruction izquierda, Instruction derecha) {
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    @Override
    public Object ejecutar() {
        return (int) izquierda.ejecutar() / (int) derecha.ejecutar();
    }
}