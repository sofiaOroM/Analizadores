package simbolo;

import java.util.Arrays;

public class Simbolo {
    private Type type;
    private String id;
    private boolean isConstant;
    private Object value;
    private int line;
    private int column;

    public Simbolo(Type type, String id, boolean isConstant, Object value, int line, int column) {
        this.type = type;
        this.id = id;
        this.isConstant = isConstant;
        this.line = line;
        this.column = column;

        if (value != null && value.getClass().isArray()) {
            this.value = Arrays.copyOf((Object[]) value, ((Object[]) value).length);
        } else {
            this.value = value;
        }
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isConstant() {
        return isConstant;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "Simbolo{" +
                "type=" + type.getType() +
                ", id='" + id + '\'' +
                ", isConstant=" + isConstant +
                ", value=" + value +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
