package view;

import controller.CategoriaGrupoProdutosController;
import entity.CategoriaGrupoProdutos;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TelaAlterarGrupo extends javax.swing.JFrame {
    private String  nomeAnterior;
    
    
    
    
    private CategoriaGrupoProdutosController CprodutoController = new CategoriaGrupoProdutosController();
    private CategoriaGrupoProdutos cProdutos;

    public TelaAlterarGrupo(CategoriaGrupoProdutos cProdutos) {
        initComponents();
        setLocationRelativeTo(null);
  if (cProdutos == null) {
            cProdutos = new CategoriaGrupoProdutos();
        } else {
            cProdutos = cProdutos;
            txtNome.setText(cProdutos.getNome());
          
        }
        CprodutoController = new CategoriaGrupoProdutosController();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText(" Nome ");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jButton1.setText("Alterar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton1)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        

//update tbgrupo set nome = novo where nome = nomeAnterior


// Pegando os valores preenchidos nos campos e guardando nas variavéis
        cProdutos.setNome(txtNome.getText());
        
        // If's Verificando se os campos obrigatórios estão preenchidos
        String obrigatorio = "";
        boolean erro = false;
        if (cProdutos.getNome().equals("")) {
            obrigatorio += " Nome Grupo produto \n";
            erro = true;
        }

        // Se existir erro ele mostra na Tela o erro e mostra os campos que estão faltando preencher.
        if (erro) {
            JOptionPane.showMessageDialog(rootPane, "Favor preencher os Campos Obrigatórios, \n " + obrigatorio);
        } else {
            // If verificando se o IdUsuário é nulo se for ele vai inserir os dados do Material Apoio no BD
            if (cProdutos.getIdCategoriaGrupoProdutos() == null) {
                JOptionPane.showMessageDialog(null, CprodutoController.insert(cProdutos));
                this.dispose();
                // If verificando se o IdUsuário é nulo se for ele vai inserir os dados do Material Apoio no BD
            } else {
                JOptionPane.showMessageDialog(null, CprodutoController.update(cProdutos));
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                TelaAlterarGrupo telinha = new TelaAlterarGrupo(null);
                telinha.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}