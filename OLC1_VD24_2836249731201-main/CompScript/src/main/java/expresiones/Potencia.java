package expresiones;

import abstracto.Instruction;

public class Potencia extends Instruction {
    private final Instruction base;
    private final Instruction exponente;

    public Potencia(Instruction base, Instruction exponente) {
        this.base = base;
        this.exponente = exponente;
    }

    @Override
    public Object ejecutar() {
        return (int) Math.pow((int) base.ejecutar(), (int) exponente.ejecutar());
    }
}