package fastread;

import javax.swing.UIManager;

/**
 *
 * @author Max Carter
 */
public class MainFrame extends javax.swing.JFrame {

    private Thread thread;
    
    private volatile boolean reading = false;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }
    
    /**
     * Displays the words onto the display.
     * 
     * @param words Array of words to read from.
     */
    private synchronized void readText(String[] words) {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (reading) {
                    for (int i = 0; i < words.length; i++) {
                        if (reading) display.setText(words[i]);
                        
                        try {
                            Thread.sleep(100 + words[i].length() * 25);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    reading = false;
                    updateButtonText();
                }
            }
        });
        thread.start();
    }
    
    /**
     * Trims and splits the text into a translatable list.
     * 
     * @param text Sentence to be split.
     * @return List of split sentence containing individual words.
     */
    private String[] getWords(String text) {
        return text.trim().split("[ .,!]");
    }
    
    /**
     * Updates the text of the button to display correct message.
     */
    private void updateButtonText() {
        toggle.setText((reading ? "Stop" : "Start") + " FastReader");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        field = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        display = new javax.swing.JLabel();
        clearText = new javax.swing.JButton();
        toggle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fast Reader");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        field.setBackground(new java.awt.Color(71, 71, 71));
        field.setColumns(20);
        field.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        field.setForeground(new java.awt.Color(255, 255, 255));
        field.setRows(5);
        field.setBorder(null);
        jScrollPane1.setViewportView(field);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        display.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        display.setForeground(new java.awt.Color(255, 255, 255));
        display.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        display.setText("Display");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(display, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(display, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        clearText.setBackground(new java.awt.Color(102, 102, 102));
        clearText.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        clearText.setForeground(new java.awt.Color(204, 204, 204));
        clearText.setText("Clear Text");
        clearText.setFocusable(false);
        clearText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTextActionPerformed(evt);
            }
        });

        toggle.setBackground(new java.awt.Color(102, 102, 102));
        toggle.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        toggle.setForeground(new java.awt.Color(204, 204, 204));
        toggle.setText("Start Fast Reader");
        toggle.setFocusable(false);
        toggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clearText, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toggle, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clearText)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(toggle)
                        .addContainerGap())))
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void clearTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTextActionPerformed
        field.setText("");
    }//GEN-LAST:event_clearTextActionPerformed

    private void toggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleActionPerformed
        reading = !reading;
        updateButtonText();
        if (reading)  readText(getWords(field.getText()));
    }//GEN-LAST:event_toggleActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearText;
    private javax.swing.JLabel display;
    private javax.swing.JTextArea field;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton toggle;
    // End of variables declaration//GEN-END:variables
}
