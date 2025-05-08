package analyzers;

import java_cup.runtime.*;
import logic.Token;
import GUI.TokensTable;
import excepciones.Errors;
import java.util.ArrayList;

%%

/* Configuración */
%public
%class Lexer
%cup
%unicode
%line
%column

%{
    private ArrayList<Errors> errorsList = new ArrayList<>();

    private Symbol symbol(int type) {
        Token token = new Token(type, yytext(), yyline+1, yycolumn+1);
        TokensTable.tokensList.add(token);
        return new Symbol(type, yyline, yycolumn, token);
    }

    private void addError(String message) {
        errorsList.add(new Errors(yyline+1, yycolumn+1, message, yytext()));
        ErrorsTable.errorsList = errorsList;
    }
%}

/* Macros */
LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]
Identifier = \$[a-zA-Z0-9_-]+
Integer = [+-]?[0-9]+
Literal = \"([^\"]|\\.)*\"
LineComment = #.*
BlockComment = \/\*([^*]|\*+[^*/])*\*+\/

%%

/* Reglas léxicas */
<YYINITIAL> {
    /* Palabras reservadas */
    "PRINT"     { return symbol(sym.PRINT); }
    "END"       { return symbol(sym.END); }
    "REPEAT"    { return symbol(sym.REPEAT); }
    "INIT"      { return symbol(sym.INIT); }
    "IF"        { return symbol(sym.IF); }
    "TRUE"      { return symbol(sym.TRUE); }
    "FALSE"     { return symbol(sym.FALSE); }
    "THEN"      { return symbol(sym.THEN); }

    /* Operadores */
    "+"         { return symbol(sym.MAS); }
    "-"         { return symbol(sym.MENOS); }
    "*"         { return symbol(sym.POR); }
    "/"         { return symbol(sym.DIV); }
    "^"         { return symbol(sym.POT); }
    "="         { return symbol(sym.ASIGNACION); }

    /* Identificadores */
    {Identifier}    { return symbol(sym.IDENTIFICADOR); }

    /* Números */
    {Integer}       { return symbol(sym.ENTERO); }

    /* Literales */
    {Literal}       { return symbol(sym.LITERAL); }

    /* Comentarios */
    {LineComment}   { /* Ignorar */ }
    {BlockComment}  { /* Ignorar */ }

    /* Espacios */
    {WhiteSpace}    { /* Ignorar */ }

    /* Errores */
    .               { addError("Caracter no válido: " + yytext()); }

    "("     { return symbol(sym.ParO); }
    ")"     { return symbol(sym.ParC); }
}

<<EOF>>             { return symbol(sym.EOF); }