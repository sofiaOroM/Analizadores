package expresiones;

import abstracto.Instruction;

public class Multiplicacion extends Instruction {
    private final Instruction izquierda;
    private final Instruction derecha;

    public Multiplicacion(Instruction izquierda, Instruction derecha) {
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    @Override
    public Object ejecutar() {
        return (int) izquierda.ejecutar() * (int) derecha.ejecutar();
    }
}