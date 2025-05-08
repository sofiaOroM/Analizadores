package instrucciones;

import abstracto.Instruction;
import java.util.List;

public class Repeat extends Instruction {
    private final Instruction repeticiones;
    private final List<Instruction> instrucciones;

    public Repeat(Instruction repeticiones, List<Instruction> instrucciones) {
        this.repeticiones = repeticiones;
        this.instrucciones = instrucciones;
    }

    @Override
    public Object ejecutar() {
        int veces = (int) repeticiones.ejecutar();
        for (int i = 0; i < veces; i++) {
            for (Instruction instr : instrucciones) {
                instr.ejecutar();
            }
        }
        return null;
    }
}