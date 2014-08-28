package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Categoria;

public class CategoriaTableModel extends AbstractTableModel {

    /* Lista de Categorias que representam as linhas. */
    private List<Categoria> linhas;

    /* Array de Strings com o nome das colunas. */
    private String[] colunas = new String[]{
        "Tipo", "Dias Emprestimo", "Privilegiado"};

    /* Cria um CategoriaTableModel vazio. */
    public CategoriaTableModel() {
        linhas = new ArrayList<>();
    }

    /* Cria um CategoriaTableModel carregado com 
     * a lista de Categoria especificada. */
    public CategoriaTableModel(List<Categoria> listaDeCategorias) {
        linhas = new ArrayList<>();
    }

    /* Retorna a quantidade de colunas. */
    @Override
    public int getColumnCount() {
        // EstÃ¡ retornando o tamanho do array "colunas".  
        return colunas.length;
    }

    /* Retorna a quantidade de linhas. */
    @Override
    public int getRowCount() {
        // Retorna o tamanho da lista de Categoria.  
        return linhas.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        // Retorna o conteÃºdo do Array que possui o nome das colunas  
        return colunas[columnIndex];
    }

    ;  
  
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    ;  
  
  
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Categoria categoria = linhas.get(rowIndex);

        // Retorna o campo referente a coluna especificada.  
        // Aqui é feito um switch para verificar qual é a coluna  
        // e retornar o campo adequado. As colunas sãoas mesmas  
        // que foram especificadas no array "colunas".  
        switch (columnIndex) {
            case 0:
                return categoria.getTipo();
            case 1:
                return categoria.getDiasEmprestimo();
            case 2:
                return categoria.isPrivilegiado();

            default:
                // Isto não deveria acontecer...  
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
//modifica na linha e coluna especificada  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Categoria categoria = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        switch (columnIndex) { // Seta o valor do campo respectivo  
            case 0:
                categoria.setTipo(aValue.toString());
            case 1:
                categoria.setDiasEmprestimo((int) aValue);
            case 2:
                categoria.setPrivilegiado((boolean) aValue);

            default:
            // Isto não deveria acontecer...               
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    //modifica na linha especificada  
    public void setValueAt(Categoria aValue, int rowIndex) {
        Categoria categoria = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        categoria.setTipo(aValue.getTipo());
        categoria.setDiasEmprestimo(aValue.getDiasEmprestimo());
        categoria.setPrivilegiado(aValue.isPrivilegiado());

        // item.setTel(aValue.getTel());  
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);

    }

    ;  
  
  
    ;  
  
  
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Categoria getCategoria(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    /* Adiciona um registro. */
    public void addcategoria(Categoria m) {
        // Adiciona o registro.  
        linhas.add(m);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /* Remove a linha especificada. */
    public void removeCategoria(int indiceLinha) {
        linhas.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    /* Adiciona uma lista de Categoria ao final dos registros. */
    public void addListaDeCategoria(List<Categoria> categoria) {
        // Pega o tamanho antigo da tabela.  
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.  
        linhas.addAll(categoria);

        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    /* Remove todos os registros. */
    public void limpar() {
        linhas.clear();

        fireTableDataChanged();
    }

    /* Verifica se este table model esta vazio. */
    public boolean isEmpty() {
        return linhas.isEmpty();
    }

}
