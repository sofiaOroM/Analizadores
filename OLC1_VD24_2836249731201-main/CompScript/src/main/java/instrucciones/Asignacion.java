package instrucciones;

import abstracto.Instruction;

import java.util.HashMap;

public class Asignacion extends Instruction {
    private final String id;
    private final Instruction valor;
    private static final HashMap<String, Integer> tabla = new HashMap<>();

    public Asignacion(String id, Instruction valor) {
        this.id = id;
        this.valor = valor;
    }

    @Override
    public Object ejecutar() {
        int val = (int) valor.ejecutar();
        tabla.put(id, val);
        System.out.println("Asignación: " + id + " = " + val);
        return null;
    }

    public static Integer obtenerValor(String id) {
        return tabla.getOrDefault(id, 0);
    }
}
