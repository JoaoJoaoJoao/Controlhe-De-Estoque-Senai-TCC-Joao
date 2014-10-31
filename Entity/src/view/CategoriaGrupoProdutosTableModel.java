/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.CategoriaGrupoProdutos;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author joao_victor1
 */
public class CategoriaGrupoProdutosTableModel extends AbstractTableModel {

    private List<CategoriaGrupoProdutos> categorias;

    @Override
    public int getRowCount() {
        return categorias.size();
    }
//http://www.java2s.com/Code/Java/Swing-JFC/TablewithacustomTableModel.htm
    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return categorias.get(rowIndex).getNome();
    }

    public List<CategoriaGrupoProdutos> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaGrupoProdutos> categorias) {
        this.categorias = categorias;
    }

}
