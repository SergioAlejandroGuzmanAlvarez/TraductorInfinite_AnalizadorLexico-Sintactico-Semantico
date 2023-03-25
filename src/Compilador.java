//*
import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

   
    public Compilador() {
        initComponents();
        init();
    }

    private void init() {
        title = "LEARN++";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".Learn");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(jtpCode);
        timerKeyReleased = new Timer((int) (1000 * 0.01), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        rootPanel.setBackground(new java.awt.Color(102, 102, 102));

        jtpCode.setBackground(new java.awt.Color(51, 51, 51));
        jtpCode.setForeground(new java.awt.Color(255, 255, 255));
        jtpCode.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jtpCode);

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setBackground(new java.awt.Color(51, 51, 51));
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setForeground(new java.awt.Color(255, 255, 255));
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        tblTokens.setBackground(new java.awt.Color(51, 51, 51));
        tblTokens.setForeground(new java.awt.Color(255, 255, 255));
        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " ID", "Componente Léxico", "Entrada", "[R, C]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTokens.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblTokens);

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addContainerGap())
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );

        getContentPane().add(rootPanel);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/20x20.jpg"))); // NOI18N
        jMenu5.setMaximumSize(new java.awt.Dimension(40, 40));
        jMenuBar1.add(jMenu5);
        jMenu5.setFocusPainted(false);
        jMenu5.setFocusable(false);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.jpg"))); // NOI18N
        jMenu1.setText("Abrir");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/4.png"))); // NOI18N
        jMenu2.setText("Nuevo");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1.png"))); // NOI18N
        jMenu3.setText("Guardar");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/3.jpg"))); // NOI18N
        jMenu4.setText("Guardar Como");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu6.setText("                                    ");
        jMenu6.setEnabled(false);
        jMenu6.setFocusable(false);
        jMenuBar1.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/231.png"))); // NOI18N
        jMenu7.setText("Analizar");
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
    
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
          directorio.New();
        clearFields();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
          if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
         if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
         if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_jMenu7MouseClicked

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }

    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no Existe " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error Al Guardar " + ex.getMessage());
        }
    }

    private void syntacticAnalysis() {
        Grammar gramatica = new Grammar(tokens, errors);
          /* Eliminar errores */
          gramatica.delete(new String[]{"ERROR_1","ERROR_2","ERROR_3"},1);
          /* agrupar identificadores y parametros */
           
          
            /* agrupar valores */
          gramatica.group("VALORES_ENTEROS"," NUMERO ",true);
           gramatica.group("VALORES_LOGICOS"," VERDADERO | FALSO ",true);
            gramatica.group("VALORES_TEXTO"," CADENA ",true);
            gramatica.group("VALORES_DECIMAL"," NUMERO_DECIMAL",true);
            gramatica.group("OPERADORES_ARITMETRICOS",
                    "OPERADOR_MAS | OPERADOR_MENOS | OPERADOR_MULTIPLICAR | OPERADOR_DIVIDIR");
            gramatica.group("OPERADORES_LOGICOS","OPERADOR_AND | OPERADOR_OR",true);
         
          
        
          
           /* declarar variable ENTERA */
           gramatica.group("DECLARAR_ENTERO","TIPO_DE_DATO_ENTERO IDENTIFICADOR OPERADOR_ASIGNACION VALORES_ENTEROS FIN_DE_SENTENCIA",true,identProd);
           //No ;
           gramatica.group("DECLARAR_ENTERO","TIPO_DE_DATO_ENTERO IDENTIFICADOR OPERADOR_ASIGNACION VALORES_ENTEROS",true,
                   2,"Error sintáctico {}: falta ; en la declaracion de variable (Linea: # )");
           // no identificador
           gramatica.group("DECLARAR_ENTERO","TIPO_DE_DATO_ENTERO OPERADOR_ASIGNACION VALORES_ENTEROS FIN_DE_SENTENCIA",true,
                   3,"Error sintáctico {}: falta identificador en la declaracion (Linea: # )");
           //no valor
           gramatica.group("DECLARAR_ENTERO","TIPO_DE_DATO_ENTERO IDENTIFICADOR OPERADOR_ASIGNACION FIN_DE_SENTENCIA",true,
                   4,"Error sintáctico {}: falta VALOR en la declaracion (Linea: # )",identProd);
           //no op asignacion
           gramatica.group("DECLARAR_ENTERO","TIPO_DE_DATO_ENTERO IDENTIFICADOR VALORES_ENTEROS FIN_DE_SENTENCIA",true,
                   5,"Error sintáctico {}: falta operador de asignacion en la declaracion (Linea: # )");
           //NO TIPO DE DATO
           gramatica.group("DECLARAR_ENTERO","IDENTIFICADOR OPERADOR_ASIGNACION VALORES_ENTEROS FIN_DE_SENTENCIA",true,
                   6,"Error sintáctico {}: falta tipo de dato en la declaracion (Linea: # )");
           //TIPO DE DATO INCORRECTO
            gramatica.group("DECLARAR_ENTERO","TIPO_DE_DATO_ENTERO IDENTIFICADOR OPERADOR_ASIGNACION VALORES_LOGICOS FIN_DE_SENTENCIA",true,
                   7,"Error sintáctico {}: booleano no permitido , ingresa un entero (Linea: # )");
            //TIPO DE DATO INCORRECTO
            gramatica.group("DECLARAR_ENTERO","TIPO_DE_DATO_ENTERO IDENTIFICADOR OPERADOR_ASIGNACION VALORES_TEXTO FIN_DE_SENTENCIA",true,
                   8,"Error sintáctico {}: tipo cadena no permitido , ingresa un entero (Linea: # )");
            //TIPO DE DATO INCORRECTO
            gramatica.group("DECLARAR_ENTERO","TIPO_DE_DATO_ENTERO IDENTIFICADOR OPERADOR_ASIGNACION VALORES_DECIMAL FIN_DE_SENTENCIA",true,
                   9,"Error sintáctico {}: decimal no permitido , ingresa un entero (Linea: # )");
            
            ///DECLARAR DECIMAL
            
            gramatica.group("DECLARAR_DECIMAL","TIPO_DE_DATO_DECIMAL IDENTIFICADOR OPERADOR_ASIGNACION VALORES_DECIMAL FIN_DE_SENTENCIA",true);
           //No !
           gramatica.group("DECLARAR_DECIMAL","TIPO_DE_DATO_DECIMAL IDENTIFICADOR OPERADOR_ASIGNACION VALORES_DECIMAL",true,
                   10,"Error sintáctico {}: falta ! en la declaracion de variable (Linea: # )");
           // no identificador
           gramatica.group("DECLARAR_DECIMAL","TIPO_DE_DATO_DECIMAL OPERADOR_ASIGNACION VALORES_DECIMAL FIN_DE_SENTENCIA",true,
                   11,"Error sintáctico {}: falta identificador en la declaracion (Linea: # )");
           //no valor
           gramatica.group("DECLARAR_DECIMAL","TIPO_DE_DATO_DECIMAL IDENTIFICADOR OPERADOR_ASIGNACION FIN_DE_SENTENCIA",true,
                   12,"Error sintáctico {}: falta VALOR en la declaracion (Linea: # )");
           //no op asignacion
           gramatica.group("DECLARAR_DECIMAL","TIPO_DE_DATO_DECIMAL IDENTIFICADOR VALORES_DECIMAL FIN_DE_SENTENCIA",true,
                   13,"Error sintáctico {}: falta operador de asignacion en la declaracion (Linea: # )");
           //NO TIPO DE DATO
           gramatica.group("DECLARAR_DECIMAL","IDENTIFICADOR OPERADOR_ASIGNACION VALORES_DECIMAL FIN_DE_SENTENCIA",true,
                   14,"Error sintáctico {}: falta tipo de dato en la declaracion (Linea: # )");
           //TIPO DE DATO INCORRECTO
            gramatica.group("DECLARAR_DECIMAL","TIPO_DE_DATO_DECIMAL IDENTIFICADOR OPERADOR_ASIGNACION VALORES_LOGICOS FIN_DE_SENTENCIA",true,
                   15,"Error sintáctico {}: booleano no permitido , ingresa un decimal (Linea: # )");
            //TIPO DE DATO INCORRECTO
            gramatica.group("DECLARAR_DECIMAL","TIPO_DE_DATO_DECIMAL IDENTIFICADOR OPERADOR_ASIGNACION VALORES_TEXTO FIN_DE_SENTENCIA",true,
                   16,"Error sintáctico {}: tipo cadena no permitido , ingresa un decimal (Linea: # )");
            //TIPO DE DATO INCORRECTO
            gramatica.group("DECLARAR_DECIMAL","TIPO_DE_DATO_DECIMAL IDENTIFICADOR OPERADOR_ASIGNACION VALORES_ENTEROS FIN_DE_SENTENCIA",true,
                   17,"Error sintáctico {}: Entero no permitido , ingresa un decimal (Linea: # )");
            
            //Declarar cadena
             gramatica.group("DECLARAR_CADENA","TIPO_DE_DATO_CADENA IDENTIFICADOR OPERADOR_ASIGNACION VALORES_TEXTO FIN_DE_SENTENCIA",true);
           //No !
           gramatica.group("DECLARAR_CADENA","TIPO_DE_DATO_CADENA IDENTIFICADOR OPERADOR_ASIGNACION VALORES_TEXTO",true,
                   18,"Error sintáctico {}: falta ! en la declaracion de variable (Linea: # )");
           // no identificador
           gramatica.group("DECLARAR_CADENA","TIPO_DE_DATO_CADENA OPERADOR_ASIGNACION VALORES_TEXTO FIN_DE_SENTENCIA",true,
                   19,"Error sintáctico {}: falta identificador en la declaracion (Linea: # )");
           //no valor
           gramatica.group("DECLARAR_CADENA","TIPO_DE_DATO_CADENA IDENTIFICADOR OPERADOR_ASIGNACION FIN_DE_SENTENCIA",true,
                   20,"Error sintáctico {}: falta VALOR en la declaracion (Linea: # )");
           //no op asignacion
           gramatica.group("DECLARAR_CADENA","TIPO_DE_DATO_CADENA IDENTIFICADOR VALORES_TEXTO FIN_DE_SENTENCIA",true,
                   21,"Error sintáctico {}: falta operador de asignacion en la declaracion (Linea: # )");
           //NO TIPO DE DATO
           gramatica.group("DECLARAR_CADENA","IDENTIFICADOR OPERADOR_ASIGNACION VALORES_TEXTO FIN_DE_SENTENCIA",true,
                   22,"Error sintáctico {}: falta tipo de dato en la declaracion (Linea: # )");
           //TIPO DE DATO INCORRECTO
            gramatica.group("DECLARAR_CADENA","TIPO_DE_DATO_CADENA IDENTIFICADOR OPERADOR_ASIGNACION VALORES_LOGICOS FIN_DE_SENTENCIA",true,
                   23,"Error sintáctico {}: booleano no permitido , ingresa una cadena (Linea: # )");
            //TIPO DE DATO INCORRECTO
            gramatica.group("DECLARAR_CADENA","TIPO_DE_DATO_CADENA IDENTIFICADOR OPERADOR_ASIGNACION VALORES_DECIMAL FIN_DE_SENTENCIA",true,
                   24,"Error sintáctico {}: tipo decimal no permitido , ingresa una cadena (Linea: # )");
            //TIPO DE DATO INCORRECTO
            gramatica.group("DECLARAR_CADENA","TIPO_DE_DATO_CADENA IDENTIFICADOR OPERADOR_ASIGNACION VALORES_ENTEROS FIN_DE_SENTENCIA",true,
                   25,"Error sintáctico {}: Entero no permitido , ingresa una cadena (Linea: # )");
            
            
           //declarar booleano
 gramatica.group("DECLARAR_BOOLEANO","TIPO_DE_DATO_BOOLEANO IDENTIFICADOR OPERADOR_ASIGNACION VALORES_LOGICOS FIN_DE_SENTENCIA",true);
           //No !
           gramatica.group("DECLARAR_BOOLEANO","TIPO_DE_DATO_BOOLEANO IDENTIFICADOR OPERADOR_ASIGNACION VALORES_LOGICOS",true,
                   26,"Error sintáctico {}: falta ! en la declaracion de variable (Linea: # )");
           // no identificador
           gramatica.group("DECLARAR_BOOLEANO","TIPO_DE_DATO_BOOLEANO OPERADOR_ASIGNACION VALORES_LOGICOS FIN_DE_SENTENCIA",true,
                   27,"Error sintáctico {}: falta identificador en la declaracion (Linea: # )");
           //no valor
           gramatica.group("DECLARAR_BOOLEANO","TIPO_DE_DATO_BOOLEANO IDENTIFICADOR OPERADOR_ASIGNACION FIN_DE_SENTENCIA",true,
                   28,"Error sintáctico {}: falta VALOR en la declaracion (Linea: # )");
           //no op asignacion
           gramatica.group("DECLARAR_BOOLEANO","TIPO_DE_DATO_BOOLEANO IDENTIFICADOR VALORES_LOGICOS FIN_DE_SENTENCIA",true,
                   29,"Error sintáctico {}: falta operador de asignacion en la declaracion (Linea: # )");
           //NO TIPO DE DATO
           gramatica.group("DECLARAR_BOOLEANO","IDENTIFICADOR OPERADOR_ASIGNACION VALORES_LOGICOS FIN_DE_SENTENCIA",true,
                   30,"Error sintáctico {}: falta tipo de dato en la declaracion (Linea: # )");
           //TIPO DE DATO INCORRECTO
            gramatica.group("DECLARAR_BOOLEANO","TIPO_DE_DATO_BOOLEANO IDENTIFICADOR OPERADOR_ASIGNACION VALORES_TEXTO FIN_DE_SENTENCIA",true,
                   31,"Error sintáctico {}: CADENA no permitido , ingresa un BOOLEANO (Linea: # )");
            //TIPO DE DATO INCORRECTO
            gramatica.group("DECLARAR_BOOLEANO","TIPO_DE_DATO_BOOLEANO IDENTIFICADOR OPERADOR_ASIGNACION VALORES_DECIMAL FIN_DE_SENTENCIA",true,
                   32,"Error sintáctico {}: tipo decimal no permitido , ingresa un BOOLEANO (Linea: # )");
            //TIPO DE DATO INCORRECTO
            gramatica.group("DECLARAR_BOOLEANO","TIPO_DE_DATO_BOOLEANO IDENTIFICADOR OPERADOR_ASIGNACION VALORES_ENTEROS FIN_DE_SENTENCIA",true,
                   33,"Error sintáctico {}: Entero no permitido , ingresa un BOOLEANO (Linea: # )");
            
           gramatica.delete("TIPO_DE_DATO_ENTERO",34,"Error sintáctico {}: Elimina el TIPO_DE_DATO aislado (Linea: # )");
           gramatica.delete("TIPO_DE_DATO_DECIMAL",35,"Error sintáctico {}: Elimina el TIPO_DE_DATO aislado (Linea: # )");
           gramatica.delete("TIPO_DE_DATO_BOOLEANO",36,"Error sintáctico {}: Elimina el TIPO_DE_DATO aislado (Linea: # )");
           gramatica.delete("TIPO_DE_DATO_CADENA",37,"Error sintáctico {}: Elimina el TIPO_DE_DATO aislado (Linea: # )"); 
            
//ARITMETRICA
gramatica.group("VALORES", " IDENTIFICADOR | VALORES_ENTEROS");

 gramatica.group("OPERACION_ARITMETRICA",
         " VALORES OPERADORES_ARITMETRICOS VALORES FIN_DE_SENTENCIA",true); 
 
          
         
           gramatica.group("OPERACION_ARITMETRICA", 
                   " VALORES OPERADORES_ARITMETRICOS FIN_DE_SENTENCIA",true,
                   38,"Error sintáctico {}: falta un valor en la operacion de la (Linea: # )");
            gramatica.group("OPERACION_ARITMETRICA", 
                   " IDENTIFICADOR OPERADORES_ARITMETRICOS FIN_DE_SENTENCIA",true,
                   39,"Error sintáctico {}: falta un valor en la operacion de la (Linea: # )");
            
            gramatica.group("OPERACION_ARITMETRICA", 
                   " VALORES OPERADORES_ARITMETRICOS VALORES_LOGICOS FIN_DE_SENTENCIA",true,
                   40,"Error sintáctico {}: no se permiten booleanos en operacion arimetricas (Linea: # )");
            gramatica.group("OPERACION_ARITMETRICA", 
                   " VALORES OPERADORES_ARITMETRICOS VALORES_TEXTO FIN_DE_SENTENCIA",true,
                   41,"Error sintáctico {}: no se permiten Cadenas en operacion arimetricas (Linea: # )");
              //FALTA !
             gramatica.group("OPERACION_ARITMETRICA", 
                   " VALORES OPERADORES_ARITMETRICOS VALORES",true,
                   42,"Error sintáctico {}: falta ! en la (Linea: # )");
             
          //LOGICAAAAAA
          
           gramatica.group("OPERACION_LOGICA",
         " VALORES OPERADORES_LOGICOS VALORES_LOGICOS FIN_DE_SENTENCIA",true); 
           
 gramatica.group("OPERACION_LOGICA",
         " VALORES OPERADORES_LOGICOS FIN_DE_SENTENCIA",true,
         43,"Error sintáctico {}: falta un valor en la operacion de la (Linea: # )");
       gramatica.group("OPERACION_LOGICA",
         " VALORES OPERADORES_LOGICOS VALORES_LOGICOS",true,
         44,"Error sintáctico {}: falta ! en la (Linea: # )");   
       
       gramatica.group("OPERACION_LOGICA",
         " VALORES OPERADORES_LOGICOS VALORES_ENTEROS FIN_DE_SENTENCIA",true,
         45,"Error sintáctico {}: No se permiten enteros en operaciones logicas (Linea: # )");
       
            gramatica.group("OPERACION_LOGICA",
         " VALORES OPERADORES_LOGICOS VALORES_DECIMAL FIN_DE_SENTENCIA",true,
         46,"Error sintáctico {}: No se permiten decimales en operaciones logicas (Linea: # )");
            
             gramatica.group("OPERACION_LOGICA",
         " VALORES OPERADORES_LOGICOS VALORES_TEXTO FIN_DE_SENTENCIA",true,
         47,"Error sintáctico {}: No se permiten cadenas en operaciones logicas (Linea: # )");
           
           
           
           
            gramatica.group("PARAMETROS", "VALORES (COMA VALORES)+");
           
           
           
           //FUNCIONES
           gramatica.group("FUNCIONES", "FUNCION ABRE_PARENTESIS (VALORES | PARAMETROS | VALORES_TEXTO)? CIERRA_PARENTESIS",true);
           //parentesis abrir
           gramatica.group("FUNCIONES", "FUNCION (VALORES | PARAMETROS | VALORES_TEXTO)? CIERRA_PARENTESIS",true,
                   48,"Error sintáctico {}: falta abrir parentesis  (Linea: # )");
           //parentesis cerrar 
           gramatica.group("FUNCIONES", " FUNCION ABRE_PARENTESIS(VALORES | PARAMETROS | VALORES_TEXTO)? ",true,
                   49,"Error sintáctico {}: falta cerrar parentesis  (Linea: # )");
           
           
           //ESTRUCTURAS DE CONTROL
           gramatica.group("ESTRUCTURA_CONTROL","(INICIO_CONDICIONAL | CICLO_FOR | SEGUIR_CONDICIONAL)");
           
 gramatica.group("ESTRUCTURA_CONTROL_COMP","ESTRUCTURA_CONTROL ABRE_PARENTESIS (VALORES | PARAMETROS )? CIERRA_PARENTESIS ",true);
          
     gramatica.group("ESTRUCTURA_CONTROL_COMP","ESTRUCTURA_CONTROL ABRE_PARENTESIS (VALORES | PARAMETROS )  ",true,
     50,"Error sintáctico {}: falta cerrar parentesis  (Linea: # )"); 
      gramatica.group("ESTRUCTURA_CONTROL_COMP","ESTRUCTURA_CONTROL (VALORES | PARAMETROS ) CIERRA_PARENTESIS",true,
     51,"Error sintáctico {}: falta abrir parentesis  (Linea: # )"); 
     gramatica.group("ESTRUCTURA_CONTROL_COMP","ESTRUCTURA_CONTROL",true,
     52,"Error sintáctico {}: faltan  parentesis ()  (Linea: # )"); 
     gramatica.group("ESTRUCTURA_CONTROL_COMP","ESTRUCTURA_CONTROL ABRE_PARENTESIS CIERRA_PARENTESIS",true,
     53,"Error sintáctico {}: faltan parametros o valores  (Linea: # )"); 
          
           
        /* Mostrar gramáticas */
        gramatica.show();
    }

    private void semanticAnalysis() {
        for(Production id: identProd){
            System.out.println(id.lexemeRank(0,-1)); 
            System.out.println(id.lexicalCompRank(0,-1));
            //lexemrank imprime el lexema y lexicalcomp el comp léxi
        }
    }

    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            } 
            
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no Existe " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error Al guardar " + ex.getMessage());
        } 
        
        
        Functions.colorTextPane(textsColor, jtpCode, new Color(255, 255, 255));
    }
    public String id(String n){
        if(n.equals("IDENTIFICADOR")){return "1";}
        if(n.equals("CADENA")){return "2";}
        if(n.equals("TIPO_DE_DATO_ENTERO")){return "3";}
        if(n.equals("NUMERO")){return "4";}
        if(n.equals("COLOR")){return "5";}
        if(n.equals("LLAVE_ABIERTA")){return "6";}
        if(n.equals("LLAVE_CERRADA")){return "7";}
        if(n.equals("OPERADOR_ASIGNACION")){return "8";}
        if(n.equals("OPERADOR_MAS")){return "9";}
        if(n.equals("OPERADOR_MENOS")){return "10";}
        if(n.equals("OPERADOR_MULTIPLICAR")){return "11";}
        if(n.equals("OPERADOR_DIVIDIR")){return "12";}
        if(n.equals("OPERADOR_AND")){return "13";}
        if(n.equals("OPERADOR_OR")){return "14";}
        if(n.equals("OPERADOR_DIFERENTEQUE")){return "15";}
        if(n.equals("OPERADOR_MAYORQUE")){return "16";}
        if(n.equals("OPERADOR_MENORQUE")){return "17";}
        if(n.equals("OPERADOR_INCREMENTO")){return "18";}
        if(n.equals("OPERADOR_DECREMENTO")){return "19";}
        if(n.equals("FIN_DE_SENTENCIA")){return "20";}
        if(n.equals("COMA")){return "1";}
        if(n.equals("ABRE_PARENTESIS")){return "21";}
        if(n.equals("CIERRA_PARENTESIS")){return "22";}
        if(n.equals("INICIO_CONDICIONAL")){return "23";}
        if(n.equals("SEGUIR_CONDICIONAL")){return "24";}
        if(n.equals("CICLO_WHILE")){return "25";}
        if(n.equals("CICLO_FOR")){return "26";}
        if(n.equals("CICLO_DOWHILE")){return "27";}
        if(n.equals("PALABRA_RESERVADA")){return "28";}
        if(n.equals("VERDADERO")){return "29";}
        if(n.equals("FALSO")){return "30";}
        if(n.equals("FUNCION")){return "31";}
        if(n.equals("ERROR_1")){return "32";}
        if(n.equals("ERROR_2")){return "33";}
        if(n.equals("ERROR_3")){return "34";}
        if(n.equals("TIPO_DE_DATO_CADENA")){return "35";}
        if(n.equals("TIPO_DE_DATO_BOOLEANO")){return "36";}
        if(n.equals("TIPO_DE_DATO_DECIMAL")){return "37";}
        if(n.equals("NUMERO_DECIMAL")){return "38";}
        return "";
    }
    private void fillTableTokens() {
             
        tokens.forEach(token -> {
           
            Object[] data = new Object[]{id(token.getLexicalComp()),token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }
private int numerrores(){
    
   String line = System.getProperty("line.separator");
   
String demo = jtaOutputConsole.getText();

       int replace = demo.length() - demo.replace("\n", "").length();
    
return replace-3;

}
    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) { 
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
               
            }
             int replace = strErrors.length() - strErrors.replace("\n", "").length();
             int a=replace-1;
            jtaOutputConsole.setText("Compilación lista\n" + strErrors + "\n La compilación terminó con " + a +" ERRORES...");
        } else {
            jtaOutputConsole.setText("Compilación sin errores\n");
        }
        jtaOutputConsole.setCaretPosition(0);
        
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
