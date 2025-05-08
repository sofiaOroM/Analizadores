package logic;

public class Symbol {
    private String id;
    private String type;
    private boolean variableType;
    private String entorno;
    private String value;
    private int line;
    private int column;

    public Symbol(String id, boolean variableType, String type, String entorno, String value, int line, int column) {
        this.id = id;
        this.variableType = variableType;
        this.type = type;
        this.entorno = entorno;
        this.value = value;
        this.line = line;
        this.column = column;
    }

    public String getId() {
        return id;
    }

    public String getVariableType() {
        if (variableType) {
            return "Constante";
        }
        
        return "Variable";
    }
    
    public String getType() {
        return type;
    }

    public String getEntorno() {
        return entorno;
    }

    public String getValue() {
        return value;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
    
}
