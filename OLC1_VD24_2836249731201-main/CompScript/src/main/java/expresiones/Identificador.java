package expresiones;

import abstracto.Instruction;

public class Identificador extends Instruction {
    private final String nombre;

    public Identificador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Object ejecutar() {
        // Aquí puedes recuperar el valor de una tabla de símbolos si tienes una
        return "Valor de " + nombre; // Placeholder
    }
}