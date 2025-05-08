package simbolo;

import GUI.SymbolsTable;
import logic.Symbol;

import java.lang.reflect.Array;
import java.util.HashMap;

public class symbolsTabel {

    private HashMap<String, Simbolo> actualTable;
    private String name;
    private symbolsTabel father;

    public symbolsTabel() {
        this.actualTable = new HashMap<>();
        this.name = "";
    }

    public symbolsTabel(symbolsTabel father, String name) {
        this.father = father;
        this.actualTable = new HashMap<>();
        this.name = name;
    }

    public HashMap<String, Simbolo> getActualTable() {
        return actualTable;
    }

    public String getName() {
        return name;
    }

    public symbolsTabel getFather() {
        return father;
    }

    public void setActualTable(HashMap<String, Simbolo> actualTable) {
        this.actualTable = actualTable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean setVariable(Simbolo symbol) {
        Simbolo search = this.actualTable.get(symbol.getId().toLowerCase());
        if (search == null) {
            this.actualTable.put(symbol.getId().toLowerCase(), symbol);
            return true;
        } else {
            return false;
        }
    }

    public Simbolo getVariable(String id) {
        for (symbolsTabel i = this; i != null; i = i.getFather()) {
            Simbolo search = i.getActualTable().get(id.toLowerCase());
            if (search != null) {
                return search;
            }
        }
        return null;
    }

    public boolean editValue(String id, Object value) {
        for (symbolsTabel i = this; i != null; i = i.getFather()) {
            Simbolo search = i.getActualTable().get(id.toLowerCase());
            if (search != null) {
                search.setValue(value);
                return true;
            }
        }
        return false;
    }

    public void printTable() {
        for (Simbolo i : this.actualTable.values()) {
            SymbolsTable.symbolsList.add(new Symbol(i.getId(), i.isConstant(), i.getType().getType().toString(), "Global", i.getValue().toString(), i.getLine(), i.getColumn()));
        }
    }

    @Override
    public String toString() {
        return "symbolsTable{" +
                "actualTable=" + actualTable +
                ", name='" + name + '\'' +
                ", father=" + father +
                '}';
    }
}
