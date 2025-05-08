
// parser.java generado manualmente como si fuera por Java CUP
package analyzers;

import java_cup.runtime.Symbol;
import java.util.ArrayList;
import java.util.List;
import abstracto.Instruction;
import instrucciones.*;
import expresiones.*;
import java.io.FileWriter;
import java.io.IOException;


public class Parser {
    public static List<Instruction> instrucciones = new ArrayList<>();
    public static FileWriter writer;

    public static void crearArchivo(String path) {
        try {
            writer = new FileWriter(path);
        } catch (IOException e) {
            System.out.println("Error creando archivo: " + e.getMessage());
        }
    }

    public static void escribir(String linea) {
        try {
            writer.write(linea + "\n");
        } catch (IOException e) {
            System.out.println("Error escribiendo: " + e.getMessage());
        }
    }

    public static void cerrarArchivo() {
        try {
            if (writer != null) writer.close();
        } catch (IOException e) {
            System.out.println("Error cerrando archivo: " + e.getMessage());
        }
    }

    public static void interpretar() {
        for (Instruction instr : instrucciones) {
            instr.ejecutar();
        }
    }

    // Simulación de construcción de árbol por parte del parser.cup
    public static void construirInstrucciones() {
        // Aquí se podrían insertar instrucciones manualmente para prueba
        instrucciones.add(new Print(new Literal(42)));
    }
}
