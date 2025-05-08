package analyzers;

import java.util.List;
import excepciones.Errors;
import logic.Token;

public class SyntaxController {
    public static boolean analizarSintaxis(List<Token> tokens, List<Errors> errores) {
        if (errores != null && !errores.isEmpty()) {
            System.out.println("Errores léxicos detectados. Análisis sintáctico cancelado.");
            for (Errors error : errores) {
                System.out.println(error.toString());
            }
            return false;
        }
    
        // Simulación de análisis sintáctico si no hay errores léxicos
        try {
            System.out.println("Análisis léxico exitoso. Iniciando análisis sintáctico...");
            Parser.crearArchivo("salida.txt");
            Parser.construirInstrucciones();  // Lógica simulada
            Parser.interpretar();              // Solo si deseas ejecutar las instrucciones
            Parser.cerrarArchivo();
            System.out.println("Análisis sintáctico completado. Archivo generado.");
            return true;
        } catch (Exception ex) {
            System.out.println("Error durante análisis sintáctico: " + ex.getMessage());
            return false;
        }
    }
}    