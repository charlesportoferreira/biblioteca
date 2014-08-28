package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Filme;

public class FilmeTableModel extends AbstractTableModel {

    /* Lista de Filme que representam as linhas. */
    private List<Filme> linhas;

    /* Array de Strings com o nome das colunas. */
    private String[] colunas = new String[]{
        "Titulo", "Ano", "Categoria", "Produtora", "Exemplares", "Disponiveis"};

    /* Cria um FilmeTableModel vazio. */
    public FilmeTableModel() {
        linhas = new ArrayList<>();
    }

    /* Cria um FilmeTableModel carregado com 
     * a lista de Filme especificada. */
    public FilmeTableModel(List<Filme> listaDeFilmes) {
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
        // Retorna o tamanho da lista de Filme.  
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
        Filme filme = linhas.get(rowIndex);

        // Retorna o campo referente a coluna especificada.  
        // Aqui é feito um switch para verificar qual é a coluna  
        // e retornar o campo adequado. As colunas sãoas mesmas  
        // que foram especificadas no array "colunas".  
        switch (columnIndex) {
            case 0:
                return filme.getTitulo();
            case 1:
                return filme.getAno();
            case 2:
                return filme.getCategoria();
            case 3:
                return filme.getProdutora();
            case 4:
                return filme.getExemplares().size();
            case 5:
                return filme.getQtdeExemplaresDisponiveis();
            default:
                // Isto não deveria acontecer...  
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
//modifica na linha e coluna especificada  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Filme filme = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        switch (columnIndex) { // Seta o valor do campo respectivo  
            case 0:
                filme.setTitulo(aValue.toString());
            case 1:
                filme.setAno((int) aValue);
            case 2:
                filme.setCategoria(aValue.toString());
            case 3:
                filme.setProdutora(aValue.toString());

            default:
            // Isto não deveria acontecer...               
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    //modifica na linha especificada  
    public void setValueAt(Filme aValue, int rowIndex) {
        Filme filme = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        filme.setTitulo(aValue.getTitulo());
        filme.setAno(aValue.getAno());
        filme.setCategoria(aValue.getCategoria());
        filme.setProdutora(aValue.getProdutora());

        // item.setTel(aValue.getTel());  
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);

    }

    ;  
  
  
    ;  
  
  
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Filme getFilme(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    /* Adiciona um registro. */
    public void addFilme(Filme m) {
        // Adiciona o registro.  
        linhas.add(m);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /* Remove a linha especificada. */
    public void removeFilme(int indiceLinha) {
        linhas.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    /* Adiciona uma lista de Filme ao final dos registros. */
    public void addListaDeFilme(List<Filme> filme) {
        // Pega o tamanho antigo da tabela.  
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.  
        linhas.addAll(filme);

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
