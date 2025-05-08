package logic;

public class Token {
    private int type;
    private String lexeme;
    private int line;
    private int column;

    public Token(int type, String lexeme,int line, int column) {
        this.type = type;
        this.lexeme = lexeme;
        this.line = line;
        this.column = column;
    }

    public String getLexeme() {
        return lexeme;
    }

    public int getType() {
        return type;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }
    public void setLine(int line) {
        this.line = line;
    }
    public void setColumn(int column) {
        this.column = column;
    }
}
