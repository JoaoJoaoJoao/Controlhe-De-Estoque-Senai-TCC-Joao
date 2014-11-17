package view;

import controller.CategoriaGrupoProdutosController;
import entity.CategoriaProduto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaDeGrupos extends javax.swing.JFrame {

    private CategoriaGrupoProdutosController controler = new CategoriaGrupoProdutosController();
    private List<CategoriaProduto> listaCProdutos;

    public TelaDeGrupos() {
        initComponents();
        setLocationRelativeTo(null);
        listarCProduto(listaCProdutos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Alterar Grupos"));

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nome"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void listarCategoriaProdutos(List<CategoriaProduto> listaCProduto) {

        DefaultTableModel modelo = (DefaultTableModel) this.jTable1.getModel();
        modelo.setRowCount(listaCProduto.size());

        for (int i = 0; i < listaCProduto.size(); i++) {

            modelo.setValueAt(listaCProduto.get(i).getNome(), i, 0);

        }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();

        int selecionado = jTable1.getSelectedRow();
        
        String nome = jTable1.getValueAt(selecionado, 0).toString();

   CategoriaProduto cProdutos = controler.getByName(nome);

        if (cProdutos == null) {
            JOptionPane.showMessageDialog(null, "Selecione um item da tabela");
        } else {

            TelaAlterarGrupo telaAlterar = new TelaAlterarGrupo(cProdutos);
            telaAlterar.setVisible(true);
        }

        listaCProdutos = controler.getAll();
        listarGrupoProdutos(listaCProdutos);
    }//GEN-LAST:event_jButton2ActionPerformed
    private void listarGrupoProdutos(List<CategoriaProduto> listaGrupoP) {

        DefaultTableModel jTableT = (DefaultTableModel) this.jTable1.getModel();
        jTableT.setRowCount(listaGrupoP.size());

        for (int i = 0; i < listaGrupoP.size(); i++) {

            jTableT.setValueAt(listaGrupoP.get(i).getIdCategoriaGrupoProdutos(), i, 0);
            jTableT.setValueAt(listaGrupoP.get(i).getNome(), i, 1);

        }

    }

    private void listarCProduto(List<CategoriaProduto> lista) {
        listaCProdutos = controler.getAll();
        DefaultTableModel modelo = (DefaultTableModel) this.jTable1.getModel();
        modelo.setRowCount(listaCProdutos.size());

        for (int i = 0; i < listaCProdutos.size(); i++) {

            modelo.setValueAt(listaCProdutos.get(i).getNome(), i, 0);

        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir?");
        if (resposta == 0) {

            CategoriaProduto cProdutos = new CategoriaProduto();
            //Criar o metodo getByName
            cProdutos = controler.getByName(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            JOptionPane.showMessageDialog(rootPane, controler.delete(cProdutos));
             listarCategoriaProdutos(listaCProdutos = controler.getAll());

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeGrupos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
