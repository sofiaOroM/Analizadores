/*
 * Funcionalidad para mostrar las líneas en el editor de texto
 * Fuente: https://www.youtube.com/watch?v=JJBAzyXb7-g&ab_channel=MATEMATICA_SENCILLA
 */
package GUI;

import abstracto.Instruction;
import analyzers.Lexer;
import analyzers.Parser;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java_cup.runtime.Symbol;
import analyzers.sym; // Ensure the sym class is imported

import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.undo.UndoManager;

import excepciones.Errors;
import instrucciones.*;
import logic.FilesManager;
import logic.lineNumber;
import simbolo.Tree;
import simbolo.symbolsTabel;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.*;

public class Home extends javax.swing.JFrame {

    JFileChooser choosed = new JFileChooser();
    File file;
    FilesManager manager = new FilesManager();

    lineNumber lineNumb;
    private UndoManager undoManager = new UndoManager();
    private Highlighter.HighlightPainter yellowHighlighter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
    private List<Object> highlights = new ArrayList<>();

    public Home() {
        initComponents();
        this.setLocationRelativeTo(null);
        lineNumb = new lineNumber(codeTextPane);
        codeScrollPane.setRowHeaderView(lineNumb);

        codeTextPane.getDocument().addUndoableEditListener(e -> undoManager.addEdit(e.getEdit()));
        choosed.setAcceptAllFileFilterUsed(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        compileBttn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        codeScrollPane = new javax.swing.JScrollPane();
        codeTextPane = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        terminalTextPane = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newFileBttn = new javax.swing.JMenuItem();
        openFileBttn = new javax.swing.JMenuItem();
        saveFileBttn = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        tokensTableBttn = new javax.swing.JMenuItem();
        errorsTableBttn = new javax.swing.JMenuItem();
        symbolsTableBttn = new javax.swing.JMenuItem();
        astBttn = new javax.swing.JMenuItem();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador Lexico y Sintáctico");

        compileBttn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        compileBttn.setText("Ejecutar");
        compileBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compileBttnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel1.setText("Entrada");

        codeScrollPane.setViewportView(codeTextPane);

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel2.setText("Consola");

        terminalTextPane.setEditable(false);
        jScrollPane2.setViewportView(terminalTextPane);

        jMenu1.setText("Archivo");

        newFileBttn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newFileBttn.setText("Nuevo Archivo");
        newFileBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileBttnActionPerformed(evt);
            }
        });
        jMenu1.add(newFileBttn);

        openFileBttn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openFileBttn.setText("Abrir Archivo");
        openFileBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileBttnActionPerformed(evt);
            }
        });
        jMenu1.add(openFileBttn);

        saveFileBttn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveFileBttn.setText("Guardar Archivo");
        saveFileBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileBttnActionPerformed(evt);
            }
        });
        jMenu1.add(saveFileBttn);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reportes");

        tokensTableBttn.setText("Tabla de Tokens");
        tokensTableBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tokensTableBttnActionPerformed(evt);
            }
        });
        jMenu2.add(tokensTableBttn);

        errorsTableBttn.setText("Tabla de Errores");
        errorsTableBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                errorsTableBttnActionPerformed(evt);
            }
        });
        jMenu2.add(errorsTableBttn);

        symbolsTableBttn.setText("Tabla de Simbolos");
        symbolsTableBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symbolsTableBttnActionPerformed(evt);
            }
        });
        jMenu2.add(symbolsTableBttn);

        astBttn.setText("AST");
        jMenu2.add(astBttn);

        astBttn.setVisible(false);
        symbolsTableBttn.setVisible(false);

        jMenuBar1.add(jMenu2);

        javax.swing.JMenu jMenu3 = new javax.swing.JMenu();
        jMenu3.setText("Editar");
    
        // Item Copiar
        javax.swing.JMenuItem copiarItem = new javax.swing.JMenuItem();
        copiarItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        copiarItem.setText("Copiar");
        copiarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiarTexto();
            }
        });
        jMenu3.add(copiarItem);
    
        // Item Pegar
        javax.swing.JMenuItem pegarItem = new javax.swing.JMenuItem();
        pegarItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        pegarItem.setText("Pegar");
        pegarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegarTexto();
            }
        });
        jMenu3.add(pegarItem);
    
        // Separador
        jMenu3.add(new javax.swing.JPopupMenu.Separator());
    
        // Item Deshacer
        javax.swing.JMenuItem deshacerItem = new javax.swing.JMenuItem();
        deshacerItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        deshacerItem.setText("Deshacer");
        deshacerItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deshacerAccion();
            }
        });
        jMenu3.add(deshacerItem);
    
        // Item Rehacer
        javax.swing.JMenuItem rehacerItem = new javax.swing.JMenuItem();
        rehacerItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        rehacerItem.setText("Rehacer");
        rehacerItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rehacerAccion();
            }
        });
        jMenu3.add(rehacerItem);
    
        // Separador
        jMenu3.add(new javax.swing.JPopupMenu.Separator());
    
        // Item Buscar
        javax.swing.JMenuItem buscarItem = new javax.swing.JMenuItem();
        buscarItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        buscarItem.setText("Buscar");
        buscarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarTexto();
            }
        });
        jMenu3.add(buscarItem);
    
        // Agregar el menú Editar a la barra de menú
        jMenuBar1.add(jMenu3);
        ayudaMenu = new javax.swing.JMenu();
        ayudaMenu.setText("Ayuda");
        
        acercaDeItem = new javax.swing.JMenuItem();
        acercaDeItem.setText("Acerca de");
        acercaDeItem.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            mostrarAcercaDe(evt);
        }
        });
        
        ayudaMenu.add(acercaDeItem);
        jMenuBar1.add(ayudaMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(compileBttn)
                                .addGap(50, 50, 50))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(codeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(compileBttn)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2)
                                        .addComponent(codeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))
                                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newFileBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileBttnActionPerformed
        terminalTextPane.setText(null);
        codeTextPane.setText(null);
    }//GEN-LAST:event_newFileBttnActionPerformed

    private void saveFileBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileBttnActionPerformed
        if (choosed.showDialog(null, "Guardar archivo") == JFileChooser.APPROVE_OPTION) {
            file = choosed.getSelectedFile();
            if (file.getName().endsWith(".cs")) {
                String content = codeTextPane.getText();
                String response = manager.saveFile(file, content);
                if (response != null) {
                    JOptionPane.showMessageDialog(null, response);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveFileBttnActionPerformed

    private void openFileBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileBttnActionPerformed

        choosed.setFileFilter(null); // Permite todos los tipos de archivos
        
        int returnVal = choosed.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = choosed.getSelectedFile();
            try {
                if (!file.exists()) {
                    JOptionPane.showMessageDialog(this, "El archivo no existe", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                String content = manager.openFile(file);
                if (content != null) {
                    codeTextPane.setText(content);
                    terminalTextPane.setText("Archivo cargado: " + file.getName());
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, 
                    "Error al abrir: " + e.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_openFileBttnActionPerformed

    // Copiar texto seleccionado
    private void copiarTexto() {
        String seleccion = codeTextPane.getSelectedText();
        if (seleccion != null && !seleccion.isEmpty()) {
            StringSelection stringSelection = new StringSelection(seleccion);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        } else {
            JOptionPane.showMessageDialog(this, "No hay texto seleccionado para copiar", 
                "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    // Pegar texto desde el portapapeles
    private void pegarTexto() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);
        
        if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                String texto = (String)contents.getTransferData(DataFlavor.stringFlavor);
                codeTextPane.replaceSelection(texto);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al pegar texto", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay texto en el portapapeles", 
                "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    // Deshacer última acción
    private void deshacerAccion() {
        if (undoManager.canUndo()) {
            undoManager.undo();
        } else {
            JOptionPane.showMessageDialog(this, "No hay acciones para deshacer", 
                "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    // Rehacer acción
    private void rehacerAccion() {
        if (undoManager.canRedo()) {
            undoManager.redo();
        } else {
            JOptionPane.showMessageDialog(this, "No hay acciones para rehacer", 
                "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Método para buscar texto
    private void buscarTexto() {
        String textoBuscar = JOptionPane.showInputDialog(this, "Texto a buscar:");
        if (textoBuscar != null && !textoBuscar.isEmpty()) {
            buscarYResaltar(textoBuscar);
        }
    }
    
    // Buscar y resaltar texto
    private void buscarYResaltar(String textoBuscar) {
        // Limpiar resaltados anteriores
        limpiarResaltados();
        
        if (textoBuscar == null || textoBuscar.isEmpty()) {
            return;
        }
        
        String contenido = codeTextPane.getText();
        Highlighter highlighter = codeTextPane.getHighlighter();
        int pos = 0;
        int contador = 0;
        
        try {
            while ((pos = contenido.indexOf(textoBuscar, pos)) >= 0) {
                int endPos = pos + textoBuscar.length();
                highlights.add(highlighter.addHighlight(pos, endPos, yellowHighlighter));
                pos = endPos;
                contador++;
            }
            
            if (contador > 0) {
                terminalTextPane.setText("Se encontraron " + contador + " coincidencias");
            } else {
                terminalTextPane.setText("No se encontraron coincidencias");
            }
        } catch (BadLocationException e) {
            terminalTextPane.setText("Error en la búsqueda: " + e.getMessage());
        }
    }
    
    // Limpiar resaltados
    private void limpiarResaltados() {
        Highlighter highlighter = codeTextPane.getHighlighter();
        for (Object highlight : highlights) {
            highlighter.removeHighlight(highlight);
        }
        highlights.clear();
    }

    private void tokensTableBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tokensTableBttnActionPerformed
        TokensTable tokensFrame = new TokensTable();
        tokensFrame.setVisible(true);
    }//GEN-LAST:event_tokensTableBttnActionPerformed

    private void errorsTableBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_errorsTableBttnActionPerformed
        ErrorsTable errorsFrame = new ErrorsTable();
        errorsFrame.setVisible(true);
    }//GEN-LAST:event_errorsTableBttnActionPerformed

    private void symbolsTableBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_symbolsTableBttnActionPerformed
        SymbolsTable symbolsFrame = new SymbolsTable();
        symbolsFrame.setVisible(true);
    }//GEN-LAST:event_symbolsTableBttnActionPerformed
    
    
    private void compileBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compileBttnActionPerformed
        // Limpiar datos previos
        TokensTable.tokensList.clear();
        ErrorsTable.errorsList.clear();
        SymbolsTable.symbolsList.clear();
        terminalTextPane.setText("");
        String code = codeTextPane.getText();
        if (code.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningún código escrito.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            // Análisis Léxico
            Lexer lexer = new Lexer(new BufferedReader(new StringReader(code)));
            Symbol token;
            while ((token = lexer.next_token()).sym != sym.EOF) {
                System.out.println("Token: " + getType() + " Valor: " + token.value);
            }
        
            if (!ErrorsTable.errorsList.isEmpty()) {
                terminalTextPane.setText("Errores léxicos encontrados. Corrige antes de continuar.\n\n");
                for (Errors err : ErrorsTable.errorsList) {
                    terminalTextPane.setText(terminalTextPane.getText() + err.toString() + "\n");
                }
                return;
            }
        
            // Reiniciar lexer para análisis sintáctico
            lexer = new Lexer(new BufferedReader(new StringReader(code)));
            Parser parser = new Parser();
            Parser.construirInstrucciones(); // si construyes desde método estático
            Parser.interpretar();

            if (!ErrorsTable.errorsList.isEmpty()) {
                terminalTextPane.setText("Errores sintácticos encontrados. No se generará archivo.\n\n");
                for (Errors err : ErrorsTable.errorsList) {
                    terminalTextPane.setText(terminalTextPane.getText() + err.toString() + "\n");
                }
                return;
            }
        
            // Solicita ubicación para guardar archivo de salida
            if (choosed.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File output = choosed.getSelectedFile();
                Parser.crearArchivo(output.getAbsolutePath());
                for (Instruction instr : Parser.instrucciones) {
                    Parser.escribir(instr.toString());
                }
                Parser.cerrarArchivo();
                terminalTextPane.setText("Análisis completado correctamente. Archivo guardado.\n");
            }
        
        } catch (Exception e) {
            terminalTextPane.setText("Se produjo un error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_compileBttnActionPerformed        
    
    private void mostrarAcercaDe(java.awt.event.ActionEvent evt) {
        javax.swing.JOptionPane.showMessageDialog(this,
        "Analizador Léxico y Sintáctico\n" +
        "Desarrollado por: Dayana Sofía Orozco Mendóza\n" +
        "Versión: 1.0\n" +
        "2025 Universidad San Carlos de Guatemala\n",
        "Acerca de",
        javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatIntelliJLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem astBttn;
    private javax.swing.JScrollPane codeScrollPane;
    private javax.swing.JTextPane codeTextPane;
    private javax.swing.JButton compileBttn;
    private javax.swing.JMenuItem errorsTableBttn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem newFileBttn;
    private javax.swing.JMenuItem openFileBttn;
    private javax.swing.JMenuItem saveFileBttn;
    private javax.swing.JMenuItem symbolsTableBttn;
    private javax.swing.JTextPane terminalTextPane;
    private javax.swing.JMenuItem tokensTableBttn;
    private javax.swing.JMenu ayudaMenu;
    private javax.swing.JMenuItem acercaDeItem;
    // End of variables declaration//GEN-END:variables
}
