package excepciones;

public class Errors {
    private String type;
    private String description;
    private int line;
    private int column;

    public Errors(int line, int column, String description, String type) {
        this.type = type;
        this.description = description;
        this.line = line;
        this.column = column;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "--->Error: " + type + ". Descripción: " + description + " en la línea " + line + " y columna " + column;
    }

}
