/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adamm
 */
import static java.awt.Color.blue;
import static java.awt.Color.red;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
public class jeuprime extends javax.swing.JFrame {

    /**
     * Creates new form jeuprime
     */
    
    public jeuprime() {
        initComponents();
        selection();
    }
       
//Declaration des variablers dans lesquels les valeurs seront recupérés
      String bout1;
      String bout2;
      String bout3;
      String bout4;
      String bout5;
      String bout6;
      String bout7;
      String bout8;
      String bout9;
      //Declaration de la variable du fichier
        File File = new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\morpion\\src\\game.txt");
        int ch = 0;
        public String diff(){
            String cho;
            Random r = new Random();
            int k = r.nextInt(2);
            if (k == 1){
                cho = "X";
            } else {
                cho = "O";
            }
            return cho;
        }
        
        public void vider(){
        bt1.setText("");
        bt2.setText("");
        bt3.setText("");
        bt4.setText("");
        bt5.setText("");
        bt6.setText("");
        bt7.setText("");
        bt8.setText("");
        bt9.setText("");
        bt1.setEnabled(true);
        bt2.setEnabled(true);
        bt3.setEnabled(true);
        bt4.setEnabled(true);
        bt5.setEnabled(true);
        bt6.setEnabled(true);
        bt7.setEnabled(true);
        bt8.setEnabled(true);
        bt9.setEnabled(true);
        S = V;
    }
        
    public void color(JButton d){
        if (S == "X"){
            d.setForeground(blue);
        } else {
            d.setForeground(red);
        }
    }

    String S = diff();
    public String change(String S){

        String cho = S;
        if ("X".equals(cho)){
            cho = "O";
        } else {
            cho = "X";
        }
        return cho;
    }

    public boolean lien(JButton a, JButton b, JButton c){
        boolean N;
        N = a.getText().equals(b.getText()) && b.getText().equals(c.getText()) && !"".equals(c.getText());
        return N;
    }
    
    public boolean risque(JButton a, JButton b, JButton c){
        boolean N;
        N = a.getText().equals(b.getText()) && V.equals(b.getText()) && !change(V).equals(c.getText()) || a.getText().equals(c.getText()) && V.equals(c.getText()) && !change(V).equals(b.getText()) || b.getText().equals(c.getText()) && V.equals(b.getText()) && !change(V).equals(a.getText());
        return N;
    }
    
    public boolean chance(JButton a, JButton b, JButton c){
        boolean N;
        N = a.getText().equals(b.getText()) && change(V).equals(b.getText()) && !V.equals(c.getText()) || a.getText().equals(c.getText()) && change(V).equals(c.getText()) && !V.equals(b.getText()) || b.getText().equals(c.getText()) && change(V).equals(b.getText()) && !V.equals(a.getText());
        return N;
    }
    
    public JButton bloque(JButton a, JButton b, JButton c){
        JButton R = a;
        if (a.getText().equals(b.getText())) {
           R = c;
        } else if (a.getText().equals(c.getText())) {
           R = b;
        } else if (b.getText().equals(c.getText())) {
           R = a;
        }
        return R;
    }
    
    String V;
    public void selection(){
        V = S;
        choix.setText(V + " =");
        try{
            BufferedReader os = new BufferedReader(new FileReader("Texte.txt"));
            FileReader reader = new FileReader("Texte.txt");
            while(os.ready()){
                String ligne = os.readLine();
                pseud.setText(ligne);
            }
        }
        catch(Exception e){
            
        }
        game.setVisible(true);   
    }

    public void ordi(){
        int[] T = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int h = 0;
        JButton B;
        
        //Niveau difficile (DEBUT)
        if (chance(bt1,bt2,bt3)) {
            B = bloque(bt1,bt2,bt3);
        } else if (chance(bt1,bt4,bt7)) {
            B = bloque(bt1,bt4,bt7);
        } else if (chance(bt6,bt9,bt3)) {
            B = bloque(bt6,bt9,bt3);
        } else if (chance(bt7,bt8,bt9)) {
            B = bloque(bt7,bt8,bt9);
        } else if (chance(bt4,bt5,bt6)) {
            B = bloque(bt4,bt5,bt6);
        } else if (chance(bt5,bt2,bt8)) {
            B = bloque(bt5,bt2,bt8);
        } else if (chance(bt1,bt5,bt9)) {
            B = bloque(bt1,bt5,bt9);
        } else if (chance(bt3,bt5,bt7)) {
            B = bloque(bt3,bt5,bt7);
        }
        else 
        // Niveau moyen (DEBUT)
        if (risque(bt1,bt2,bt3)) {
            B = bloque(bt1,bt2,bt3);
        } else if (risque(bt1,bt4,bt7)) {
            B = bloque(bt1,bt4,bt7);
        } else if (risque(bt6,bt9,bt3)) {
            B = bloque(bt6,bt9,bt3);
        } else if (risque(bt7,bt8,bt9)) {
            B = bloque(bt7,bt8,bt9);
        } else if (risque(bt4,bt5,bt6)) {
            B = bloque(bt4,bt5,bt6);
        } else if (risque(bt5,bt2,bt8)) {
            B = bloque(bt5,bt2,bt8);
        } else if (risque(bt1,bt5,bt9)) {
            B = bloque(bt1,bt5,bt9);
        } else if (risque(bt3,bt5,bt7)) {
            B = bloque(bt3,bt5,bt7);
        }  
        else {
            // Niveau facile
            do {
                Random k = new Random();
                h = k.nextInt(T.length);
                switch(h){
                    case 0 : B = bt1;
                    break;
                    case 1 : B = bt2;
                    break;
                    case 2 : B = bt3;
                    break;
                    case 3 : B = bt4;
                    break;
                    case 4 : B = bt5;
                    break;
                    case 5 : B = bt6;
                    break;
                    case 6 : B = bt7;
                    break;
                    case 7 : B = bt8;
                    break;
                    case 8 : B = bt9;
                    break;
                    default : B = bt5;
                }
                if (!B.getText().equals("")){
                    T[h] = 0;
                }
            } while (T[h] == 0);
        }
        // Niveau moyen (FIN)
        // Niveau difficile (FIN)
        B.setEnabled(false);
        B.setText(S);
        S = change(S);
        color(B);
        if(lien(bt1,bt2,bt3) || lien(bt1,bt4,bt7) || lien(bt6,bt9,bt3) || lien(bt7,bt8,bt9) || lien(bt4,bt5,bt6) || lien(bt5,bt2,bt8) || lien(bt1,bt5,bt9) || lien(bt3,bt5,bt7)){
            if (change(V).equals(B.getText())){
                JOptionPane.showMessageDialog(null,"Oh mince! " +pseud.getText()+" Vous avez perdu");
                statut.setText("LOSER");
            }
            vider();
        } else if (!"".equals(bt1.getText()) && !"".equals(bt2.getText()) && !"".equals(bt3.getText()) && !"".equals(bt4.getText()) && !"".equals(bt5.getText()) && !"".equals(bt6.getText()) && !"".equals(bt7.getText()) && !"".equals(bt8.getText()) && !"".equals(bt9.getText())){
            JOptionPane.showMessageDialog(null,"Oups! Il n'y a aucun gagnant");
            statut.setText("");
            vider();
        }
    }
    
    public void decision(JButton B){
        if (gaming(B)){
            ordi();
        }
    }
        
    public boolean gaming(JButton g){
        boolean c = true;
        if(lien(bt1,bt2,bt3) || lien(bt1,bt4,bt7) || lien(bt6,bt9,bt3) || lien(bt7,bt8,bt9) || lien(bt4,bt5,bt6) || lien(bt5,bt2,bt8) || lien(bt1,bt5,bt9) || lien(bt3,bt5,bt7)){
            if (V.equals(g.getText())){
                JOptionPane.showMessageDialog(null,"Waouh! " +pseud.getText()+" Vous avez gagnez");
                statut.setText("WINNER");
            }
            vider();
            c = false;
        } else if (!"".equals(bt1.getText()) && !"".equals(bt2.getText()) && !"".equals(bt3.getText()) && !"".equals(bt4.getText()) && !"".equals(bt5.getText()) && !"".equals(bt6.getText()) && !"".equals(bt7.getText()) && !"".equals(bt8.getText()) && !"".equals(bt9.getText())){
            JOptionPane.showMessageDialog(null,"Oups! Il n'y a aucun gagnant");
            statut.setText("");
            vider();
            c = false;
        }
        return c;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pseud = new javax.swing.JTextField();
        Retour = new javax.swing.JButton();
        Rejouer = new javax.swing.JButton();
        statut = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        game = new javax.swing.JPanel();
        bt1 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt7 = new javax.swing.JButton();
        bt9 = new javax.swing.JButton();
        bt8 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        choix = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pseud.setEditable(false);
        pseud.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pseud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pseudActionPerformed(evt);
            }
        });

        Retour.setText("Retour");
        Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetourActionPerformed(evt);
            }
        });

        Rejouer.setText("Rejouer");
        Rejouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RejouerActionPerformed(evt);
            }
        });

        statut.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Statut");

        game.setBackground(new java.awt.Color(0, 153, 153));
        game.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                gameAncestorRemoved(evt);
            }
        });

        bt1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        bt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt1MouseClicked(evt);
            }
        });
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });

        bt3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        bt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt3MouseClicked(evt);
            }
        });
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });

        bt4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        bt4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt4MouseClicked(evt);
            }
        });
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });

        bt7.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        bt7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt7MouseClicked(evt);
            }
        });
        bt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt7ActionPerformed(evt);
            }
        });

        bt9.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        bt9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt9MouseClicked(evt);
            }
        });
        bt9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt9ActionPerformed(evt);
            }
        });

        bt8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        bt8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt8MouseClicked(evt);
            }
        });
        bt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt8ActionPerformed(evt);
            }
        });

        bt2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        bt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt2MouseClicked(evt);
            }
        });
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });

        bt5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        bt5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt5MouseClicked(evt);
            }
        });
        bt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt5ActionPerformed(evt);
            }
        });

        bt6.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        bt6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt6MouseClicked(evt);
            }
        });
        bt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gameLayout = new javax.swing.GroupLayout(game);
        game.setLayout(gameLayout);
        gameLayout.setHorizontalGroup(
            gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(bt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(gameLayout.createSequentialGroup()
                        .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bt5, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(bt6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(gameLayout.createSequentialGroup()
                        .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        gameLayout.setVerticalGroup(
            gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt7, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(bt4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(gameLayout.createSequentialGroup()
                        .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gameLayout.createSequentialGroup()
                        .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bt5, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(bt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gameLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(bt6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(gameLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(bt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(26, 26, 26))
        );

        choix.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pseud, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(choix, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statut, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Retour, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Rejouer, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))))
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(game, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 191, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pseud, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statut, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choix, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(game, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rejouer, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Retour, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetourActionPerformed
        // TODO add your handling code here:
        choix Retour = new choix();
        Retour.show();
        dispose();
    }//GEN-LAST:event_RetourActionPerformed

    private void pseudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pseudActionPerformed
        // TODO add your handling code here:
     //pseud.setText("Hello Dear");
        
    }//GEN-LAST:event_pseudActionPerformed

    private void bt9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt9ActionPerformed
        // TODO add your handling code here:
        bt9.setEnabled(false);
        bt9.setText(S);
        S = change(S);
        color(bt9);
        decision(bt9);
    }//GEN-LAST:event_bt9ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // TODO add your handling code here:
        bt1.setEnabled(false);
        bt1.setText(S);
        S = change(S);
        color(bt1);
        decision(bt1);
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        bt2.setEnabled(false);
        bt2.setText(S);
        S = change(S);
        color(bt2);
        decision(bt2);
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed
        // TODO add your handling code here:
        bt3.setEnabled(false);
        bt3.setText(S);
        S = change(S);
        color(bt3);
        decision(bt3);
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
        // TODO add your handling code here:
        bt4.setEnabled(false);
        bt4.setText(S);
        S = change(S);
        color(bt4);
        decision(bt4);
    }//GEN-LAST:event_bt4ActionPerformed

    private void bt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt5ActionPerformed
        // TODO add your handling code here:
        bt5.setEnabled(false);
        bt5.setText(S);
        S = change(S);
        color(bt5);
        decision(bt5);
    }//GEN-LAST:event_bt5ActionPerformed

    private void bt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt6ActionPerformed
        // TODO add your handling code here:
        bt6.setEnabled(false);
        bt6.setText(S);
        S = change(S);
        color(bt6);
        decision(bt6);
    }//GEN-LAST:event_bt6ActionPerformed

    private void bt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt7ActionPerformed
        bt7.setEnabled(false);
        bt7.setText(S);
        S = change(S);
        color(bt7);
        decision(bt7);
    }//GEN-LAST:event_bt7ActionPerformed

    private void bt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt8ActionPerformed
        bt8.setEnabled(false);
        bt8.setText(S);
        S = change(S);
        color(bt8);
        decision(bt8);
    }//GEN-LAST:event_bt8ActionPerformed

    private void bt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt1MouseClicked
        // TODO add your handling code here
    }//GEN-LAST:event_bt1MouseClicked

    private void bt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt2MouseClicked

    private void bt3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt3MouseClicked

    private void bt4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt4MouseClicked

    private void bt5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt5MouseClicked

    private void bt6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt6MouseClicked

    private void bt7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt7MouseClicked

    private void bt8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt8MouseClicked

    private void bt9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt9MouseClicked

    private void gameAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_gameAncestorRemoved
        // TODO add your handling code here
    }//GEN-LAST:event_gameAncestorRemoved

    private void RejouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RejouerActionPerformed
        // TODO add your handling code here:
        vider();
        V = change(V);
        S = V;
        choix.setText(V + " =");
    }//GEN-LAST:event_RejouerActionPerformed

    
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
            java.util.logging.Logger.getLogger(jeuprime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jeuprime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jeuprime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jeuprime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jeuprime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Rejouer;
    private javax.swing.JButton Retour;
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt6;
    private javax.swing.JButton bt7;
    private javax.swing.JButton bt8;
    private javax.swing.JButton bt9;
    private javax.swing.JLabel choix;
    private javax.swing.JPanel game;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField pseud;
    private javax.swing.JTextField statut;
    // End of variables declaration//GEN-END:variables
}
