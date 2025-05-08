package instrucciones;

import abstracto.Instruction;

public class Print extends Instruction {
    private final Instruction valor;

    public Print(Instruction valor) {
        this.valor = valor;
    }

    @Override
    public Object ejecutar() {
        System.out.println(valor.ejecutar());
        return null;
    }
}