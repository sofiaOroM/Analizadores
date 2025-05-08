package abstracto;

//import simbolo.Tree;
//import simbolo.Type;
//import simbolo.symbolsTabel;

public abstract class Instruction {
    /* public Type type;
    public int line;
    public int column;

    public Instruction(Type type, int line, int column) {
        this.type = type;
        this.line = line;
        this.column = column;
    }*/
    public abstract Object ejecutar();

    
    //public abstract Object interpret(Tree tree, symbolsTabel table);
    
}
