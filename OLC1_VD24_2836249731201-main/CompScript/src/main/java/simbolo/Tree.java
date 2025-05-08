package simbolo;

import GUI.ErrorsTable;
import abstracto.Instruction;
import excepciones.Errors;
import instrucciones.Method;

import java.util.LinkedList;

public class Tree {
    private LinkedList<Instruction> instructions;
    private LinkedList<Errors> errors;
    private String console;
    private symbolsTabel globalTabel;
    private LinkedList<Instruction> functions;

    public Tree(LinkedList<Instruction> instructions) {
        this.instructions = instructions;
        console = "";
        this.errors = new LinkedList<>();
        this.functions = new LinkedList<>();
    }

    public LinkedList<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(LinkedList<Instruction> instructions) {
        this.instructions = instructions;
    }

    public void print(String val) {
        this.console += val + "\n";
    }

    public String getConsole() {
        return console;
    }

    public void addError(Errors error) {
        this.errors.add(error);
    }

    public void printErrors() {
        ErrorsTable.errorsList.addAll(errors);
    }

    public symbolsTabel getGlobalTabel() {
        return globalTabel;
    }

    public void setGlobalTabel(symbolsTabel globalTabel) {
        this.globalTabel = globalTabel;
    }

    public LinkedList<Instruction> getFunctions() {
        return functions;
    }

    public void setFunctions(LinkedList<Instruction> functions) {
        this.functions = functions;
    }

    public void addFunctions(Instruction functions) {
        this.functions.add(functions);
    }

    public Instruction getFunction(String id) {
        for (var i : this.functions) {
            if (i instanceof Method) {
                if (((Method) i).id.equalsIgnoreCase(id)) {
                    return i;
                }
            }
        }
        return null;
    }
}
