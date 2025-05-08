package instrucciones;

import abstracto.Instruction;

public class If extends Instruction {
    private final boolean condicion;
    private final Instruction printInstruccion;

    public If(boolean condicion, Instruction printInstruccion) {
        this.condicion = condicion;
        this.printInstruccion = printInstruccion;
    }

    @Override
    public Object ejecutar() {
        if (condicion && printInstruccion != null) {
            printInstruccion.ejecutar();
        }
        return null;
    }
}