package editortextos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.undo.UndoManager;

public class EditorTextos extends javax.swing.JFrame {
    private UndoManager undoManager, redoManager;
    
    public EditorTextos() {
        initComponents();

        //FUENTE
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) comboBoxFuente.getModel();

        // Agregar las fuentes disponibles al modelo
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fontName : fontNames) {
            model.addElement(fontName);
        }
        
        //UNDO Y REDO OPCIONES
        undoManager = new UndoManager();
        TextPane.getDocument().addUndoableEditListener(undoManager);
        
        redoManager = new UndoManager();
        TextPane.getDocument().addUndoableEditListener(redoManager);
        
        //COLORES USADOS
        COLORES.setLayout(new GridLayout(3, 8));

        for (int indice = 0; indice < 24; indice++) {
            JButton colorButton = new JButton();
            colorButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            colorButton.setBackground(Color.WHITE); // Establecer color inicial
            COLORES.add(colorButton);

            colorButton.addActionListener(new ColorButtonListener(colorButton));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        COLORES = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextPane = new javax.swing.JTextPane();
        comboBoxFuente = new javax.swing.JComboBox<>();
        comboBoxTamaño = new javax.swing.JComboBox<>();
        REDO = new javax.swing.JLabel();
        UNDO = new javax.swing.JLabel();
        NUEVO = new javax.swing.JLabel();
        ITALIC = new javax.swing.JLabel();
        UNDERLINE = new javax.swing.JLabel();
        IZQ = new javax.swing.JLabel();
        CENTRO = new javax.swing.JLabel();
        DER = new javax.swing.JLabel();
        BOLD = new javax.swing.JLabel();
        PEGAR = new javax.swing.JLabel();
        CORTAR = new javax.swing.JLabel();
        GUARDAR = new javax.swing.JLabel();
        ABRIR = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("¡EDITOR DE TEXTO!");
        setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 153, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        COLORES.setBackground(new java.awt.Color(255, 69, 162));

        javax.swing.GroupLayout COLORESLayout = new javax.swing.GroupLayout(COLORES);
        COLORES.setLayout(COLORESLayout);
        COLORESLayout.setHorizontalGroup(
            COLORESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        COLORESLayout.setVerticalGroup(
            COLORESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jPanel1.add(COLORES, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 260, 90));

        jScrollPane1.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N

        TextPane.setBackground(new java.awt.Color(255, 255, 255));
        TextPane.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        TextPane.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(TextPane);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 860, 410));

        comboBoxFuente.setBackground(new java.awt.Color(255, 255, 255));
        comboBoxFuente.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        comboBoxFuente.setForeground(new java.awt.Color(0, 0, 0));
        comboBoxFuente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        comboBoxFuente.setToolTipText("ELEGIR TIPO DE FUENTE");
        comboBoxFuente.setBorder(null);
        comboBoxFuente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxFuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxFuenteActionPerformed(evt);
            }
        });
        jPanel1.add(comboBoxFuente, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 25, 250, 30));

        comboBoxTamaño.setBackground(new java.awt.Color(255, 255, 255));
        comboBoxTamaño.setFont(new java.awt.Font("Avenir Next Condensed", 1, 18)); // NOI18N
        comboBoxTamaño.setForeground(new java.awt.Color(0, 0, 0));
        comboBoxTamaño.setModel(new javax.swing.DefaultComboBoxModel<>(new Integer[] { 8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72 }));
        comboBoxTamaño.setToolTipText("Tamaño de Texto");
        comboBoxTamaño.setBorder(null);
        comboBoxTamaño.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxTamaño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTamañoActionPerformed(evt);
            }
        });
        jPanel1.add(comboBoxTamaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 74, 100, 30));

        REDO.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        REDO.setToolTipText("REDO");
        REDO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        REDO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                REDOMouseClicked(evt);
            }
        });
        jPanel1.add(REDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 60, 20));

        UNDO.setFont(new java.awt.Font("Microsoft Tai Le", 1, 12)); // NOI18N
        UNDO.setToolTipText("UNDO");
        UNDO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UNDO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UNDOMouseClicked(evt);
            }
        });
        jPanel1.add(UNDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 50, 20));

        NUEVO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NUEVO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NUEVOMouseClicked(evt);
            }
        });
        jPanel1.add(NUEVO, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 140, 20));

        ITALIC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ITALIC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ITALICMouseClicked(evt);
            }
        });
        jPanel1.add(ITALIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 20, 20));

        UNDERLINE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UNDERLINE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UNDERLINEMouseClicked(evt);
            }
        });
        jPanel1.add(UNDERLINE, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 20, 20));

        IZQ.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IZQ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IZQMouseClicked(evt);
            }
        });
        jPanel1.add(IZQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 30, 30));

        CENTRO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CENTRO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CENTROMouseClicked(evt);
            }
        });
        jPanel1.add(CENTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 30, 30));

        DER.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DERMouseClicked(evt);
            }
        });
        jPanel1.add(DER, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 30, 30));

        BOLD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BOLD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BOLDMouseClicked(evt);
            }
        });
        jPanel1.add(BOLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 20, 20));

        PEGAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PEGAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PEGARMouseClicked(evt);
            }
        });
        jPanel1.add(PEGAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 50, 80));

        CORTAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CORTAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CORTARMouseClicked(evt);
            }
        });
        jPanel1.add(CORTAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 60, 80));

        GUARDAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GUARDAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GUARDARMouseClicked(evt);
            }
        });
        jPanel1.add(GUARDAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 20));

        ABRIR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ABRIR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ABRIRMouseClicked(evt);
            }
        });
        jPanel1.add(ABRIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editortextos/ABRIR ARCHIVO (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private class ColorButtonListener implements ActionListener {

        private JButton button;

        public ColorButtonListener(JButton button) {
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color currentColor = button.getBackground();
            if (currentColor.equals(Color.WHITE)) {
                Color selectedColor = JColorChooser.showDialog(EditorTextos.this, "SELECCIONE UN COLOR", button.getBackground());

                if (selectedColor != null) {
                    button.setBackground(selectedColor);
                    aplicarColorATexto(selectedColor);
                }
            } else {
                aplicarColorATexto(currentColor);
            }
        }

        private void aplicarColorATexto(Color color) {
            StyledDocument doc = TextPane.getStyledDocument();
            int start = TextPane.getSelectionStart();
            int end = TextPane.getSelectionEnd();

            AttributeSet attrs = doc.getCharacterElement(start).getAttributes();
            SimpleAttributeSet newAttrs = new SimpleAttributeSet();
            StyleConstants.setForeground(newAttrs, color);

            doc.setCharacterAttributes(start, end - start, newAttrs, false);
        }
    }

    private void loadFont() {
        GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = gEnv.getAvailableFontFamilyNames();
        ComboBoxModel model = new DefaultComboBoxModel(fontNames);
        comboBoxFuente.setModel(model);
    }

    private void comboBoxFuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxFuenteActionPerformed
        String selectedFont = (String) comboBoxFuente.getSelectedItem();
        if (selectedFont != null) {
            StyledDocument doc = TextPane.getStyledDocument();
            int start = TextPane.getSelectionStart();
            int end = TextPane.getSelectionEnd();

            Style style = TextPane.addStyle("MyFontStyle", null);
            StyleConstants.setFontFamily(style, selectedFont);

            doc.setCharacterAttributes(start, end - start, style, false);
        }
    }//GEN-LAST:event_comboBoxFuenteActionPerformed

    private void comboBoxTamañoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTamañoActionPerformed
        Integer selectedSize = (Integer) comboBoxTamaño.getSelectedItem();
        if (selectedSize != null) {
            StyledDocument doc = TextPane.getStyledDocument();
            int start = TextPane.getSelectionStart();
            int end = TextPane.getSelectionEnd();

            // Crea un nuevo estilo con el tamaño seleccionado
            Style style = TextPane.addStyle("MyFontSizeStyle", null);
            StyleConstants.setFontSize(style, selectedSize);

            // Aplica el estilo solo al texto seleccionado
            doc.setCharacterAttributes(start, end - start, style, false);
        }
    }//GEN-LAST:event_comboBoxTamañoActionPerformed

    private void ABRIRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABRIRMouseClicked
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
       fileChooser.setPreferredSize(new Dimension(800, 600));

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                StyledDocument doc = TextPane.getStyledDocument();
                doc.remove(0, doc.getLength());
                String line;
                while ((line = br.readLine()) != null) {
                    doc.insertString(doc.getLength(), line + "\n", null);
                }
            } catch (IOException | BadLocationException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_ABRIRMouseClicked

    private void GUARDARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GUARDARMouseClicked
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setPreferredSize(new Dimension(800, 600));
            
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(TextPane.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_GUARDARMouseClicked

    private void CORTARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CORTARMouseClicked
        // TODO add your handling code here:
        String textoSeleccionado = TextPane.getSelectedText();
        
        //Copiar el texto seleccionado
        StringSelection stringSelection = new StringSelection(textoSeleccionado);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }//GEN-LAST:event_CORTARMouseClicked

    private void PEGARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PEGARMouseClicked
        // TODO add your handling code here:
        TextPane.paste();
    }//GEN-LAST:event_PEGARMouseClicked

    private void BOLDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BOLDMouseClicked
        // TODO add your handling code here:
        StyledDocument doc = TextPane.getStyledDocument();
        int start = TextPane.getSelectionStart();
        int end = TextPane.getSelectionEnd();

        // Obtiene los atributos actuales del texto seleccionado
        AttributeSet attrs = doc.getCharacterElement(start).getAttributes();
        boolean isBold = StyleConstants.isBold(attrs);

        // Crea un nuevo estilo con la negrita alternada
        SimpleAttributeSet newAttrs = new SimpleAttributeSet();
        StyleConstants.setBold(newAttrs, !isBold);

        // Aplica el nuevo estilo al texto seleccionado
        doc.setCharacterAttributes(start, end - start, newAttrs, false);
    }//GEN-LAST:event_BOLDMouseClicked

    private void NUEVOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NUEVOMouseClicked
        // TODO add your handling code here:
        if (!TextPane.getText().isEmpty()) {
            int option = JOptionPane.showConfirmDialog(null, "¿SEGURO DE CREAR NUEVO DOCUMENTO? SE PERDERAN CAMBIOS SI NO ESTAN GUARDADO.", "NUEVO DOCUMENTO", JOptionPane.YES_NO_OPTION);
            if (option != JOptionPane.YES_OPTION) {
                return; 
            }
        }
        TextPane.setText("");
    }//GEN-LAST:event_NUEVOMouseClicked

    private void DERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DERMouseClicked
        // TODO add your handling code here:
        StyledDocument doc = TextPane.getStyledDocument();
        int start = TextPane.getSelectionStart();
        int end = TextPane.getSelectionEnd();

        // Crea un nuevo estilo con la alineación justificada a la derecha
        SimpleAttributeSet newAttrs = new SimpleAttributeSet();
        StyleConstants.setAlignment(newAttrs, StyleConstants.ALIGN_RIGHT);

        // Aplica el nuevo estilo al texto seleccionado
        doc.setParagraphAttributes(start, end - start, newAttrs, false);
    }//GEN-LAST:event_DERMouseClicked

    private void CENTROMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CENTROMouseClicked
        // TODO add your handling code here:
        StyledDocument doc = TextPane.getStyledDocument();
        int start = TextPane.getSelectionStart();
        int end = TextPane.getSelectionEnd();

        // Crea un nuevo estilo con la alineación justificada a la derecha
        SimpleAttributeSet newAttrs = new SimpleAttributeSet();
        StyleConstants.setAlignment(newAttrs, StyleConstants.ALIGN_CENTER);

        // Aplica el nuevo estilo al texto seleccionado
        doc.setParagraphAttributes(start, end - start, newAttrs, false);
    }//GEN-LAST:event_CENTROMouseClicked

    private void ITALICMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ITALICMouseClicked
        // TODO add your handling code here:
        StyledDocument doc = TextPane.getStyledDocument();
        int start = TextPane.getSelectionStart();
        int end = TextPane.getSelectionEnd();

        // Obtiene los atributos actuales del texto seleccionado
        AttributeSet attrs = doc.getCharacterElement(start).getAttributes();
        boolean isItalic = StyleConstants.isItalic(attrs);

        // Crea un nuevo estilo con la negrita alternada
        SimpleAttributeSet newAttrs = new SimpleAttributeSet();
        StyleConstants.setItalic(newAttrs, !isItalic);

        // Aplica el nuevo estilo al texto seleccionado
        doc.setCharacterAttributes(start, end - start, newAttrs, false);
    }//GEN-LAST:event_ITALICMouseClicked

    private void UNDERLINEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UNDERLINEMouseClicked
        // TODO add your handling code here:
        StyledDocument doc = TextPane.getStyledDocument();
        int start = TextPane.getSelectionStart();
        int end = TextPane.getSelectionEnd();

        // Obtiene los atributos actuales del texto seleccionado
        AttributeSet attrs = doc.getCharacterElement(start).getAttributes();
        boolean isUnderline = StyleConstants.isUnderline(attrs);

        // Crea un nuevo estilo con la negrita alternada
        SimpleAttributeSet newAttrs = new SimpleAttributeSet();
        StyleConstants.setUnderline(newAttrs, !isUnderline);

        // Aplica el nuevo estilo al texto seleccionado
        doc.setCharacterAttributes(start, end - start, newAttrs, false);
    }//GEN-LAST:event_UNDERLINEMouseClicked

    private void IZQMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IZQMouseClicked
        // TODO add your handling code here:
        StyledDocument doc = TextPane.getStyledDocument();
        int start = TextPane.getSelectionStart();
        int end = TextPane.getSelectionEnd();

        // Crea un nuevo estilo con la alineación justificada a la derecha
        SimpleAttributeSet newAttrs = new SimpleAttributeSet();
        StyleConstants.setAlignment(newAttrs, StyleConstants.ALIGN_LEFT);

        // Aplica el nuevo estilo al texto seleccionado
        doc.setParagraphAttributes(start, end - start, newAttrs, false);
    }//GEN-LAST:event_IZQMouseClicked

    private void UNDOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UNDOMouseClicked
        // TODO add your handling code here:
        if (undoManager.canUndo()) {
            undoManager.undo();
        }
    }//GEN-LAST:event_UNDOMouseClicked

    private void REDOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REDOMouseClicked
        // TODO add your handling code here:
        if (undoManager.canRedo()) {
            undoManager.redo();
        }
    }//GEN-LAST:event_REDOMouseClicked

    /*
    SI DESEA RESETAR COLORES
    int option = JOptionPane.showConfirmDialog(EditorTextos.this, "¿Estás seguro de que deseas eliminar los colores?", "Resetear Colores", JOptionPane.YES_NO_OPTION);
      
        if (option == JOptionPane.YES_OPTION) {
            Component[] components = ColoresPanel.getComponents();
            for (Component component : components) {
                if (component instanceof JButton) {
                    JButton colorButton = (JButton) component;
                    colorButton.setBackground(Color.WHITE);
                }
            }
        }
    */
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditorTextos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorTextos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorTextos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorTextos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditorTextos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ABRIR;
    private javax.swing.JLabel BOLD;
    private javax.swing.JLabel CENTRO;
    private javax.swing.JPanel COLORES;
    private javax.swing.JLabel CORTAR;
    private javax.swing.JLabel DER;
    private javax.swing.JLabel GUARDAR;
    private javax.swing.JLabel ITALIC;
    private javax.swing.JLabel IZQ;
    private javax.swing.JLabel NUEVO;
    private javax.swing.JLabel PEGAR;
    private javax.swing.JLabel REDO;
    private javax.swing.JTextPane TextPane;
    private javax.swing.JLabel UNDERLINE;
    private javax.swing.JLabel UNDO;
    private javax.swing.JComboBox<String> comboBoxFuente;
    private javax.swing.JComboBox<Integer> comboBoxTamaño;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
