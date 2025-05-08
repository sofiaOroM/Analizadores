package expresiones;

import abstracto.Instruction;

public class Suma extends Instruction {
    private final Instruction izquierda;
    private final Instruction derecha;

    public Suma(Instruction izquierda, Instruction derecha) {
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    @Override
    public Object ejecutar() {
        int izq = (int) izquierda.ejecutar();
        int der = (int) derecha.ejecutar();
        return izq + der;
    }
}