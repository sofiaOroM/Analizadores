package instrucciones;

import abstracto.Instruction;
import java.util.HashMap;
import java.util.LinkedList;

public class Method extends Instruction {
public String id;
public LinkedList<HashMap<String, Object>> parameters;
public LinkedList<Instruction> instructions;

public Method(String id, LinkedList<HashMap<String, Object>> parameters, LinkedList<Instruction> instructions) {
    this.id = id;
    this.parameters = parameters;
    this.instructions = instructions;
}

    @Override
    public Object ejecutar() {
        for (Instruction instr : instructions) {
            Object result = instr.ejecutar();
            // Si quieres capturar retornos, puedes agregarlos aquí
            // Por ahora solo imprime cada ejecución
        }
        return null;
    }
}
