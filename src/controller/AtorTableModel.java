package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Ator;

public class AtorTableModel extends AbstractTableModel{
    
     /* Lista de Atores que representam as linhas. */
    private List<Ator> linhas;

    /* Array de Strings com o nome das colunas. */
    private String[] colunas = new String[]{
        "Titulo", "Ano", "Editora", "Edicao", "ISBN", "Publicacao", "Exemplares", "Disponiveis"};

    /* Cria um AtorTableModel vazio. */
    public AtorTableModel() {
        linhas = new ArrayList<>();
    }

    /* Cria um AtorTableModel carregado com 
     * a lista de Ator especificada. */
    public AtorTableModel(List<Ator> listaDeAtors) {
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
        // Retorna o tamanho da lista de Ator.  
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
        Ator ator = linhas.get(rowIndex);

        // Retorna o campo referente a coluna especificada.  
        // Aqui é feito um switch para verificar qual é a coluna  
        // e retornar o campo adequado. As colunas sãoas mesmas  
        // que foram especificadas no array "colunas".  
        switch (columnIndex) {
            case 0:
                return ator.getNome();
            
            default:
                // Isto não deveria acontecer...  
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
//modifica na linha e coluna especificada  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Ator ator = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        switch (columnIndex) { // Seta o valor do campo respectivo  
            case 0:
                ator.setNome(aValue.toString());
           
            default:
            // Isto não deveria acontecer...               
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    //modifica na linha especificada  
    public void setValueAt(Ator aValue, int rowIndex) {
        Ator ator = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        ator.setNome(aValue.getNome());
          

        fireTableCellUpdated(rowIndex, 0);
       

    }

  
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Ator getAtor(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    /* Adiciona um registro. */
    public void addAtor(Ator m) {
        // Adiciona o registro.  
        linhas.add(m);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /* Remove a linha especificada. */
    public void removeAtor(int indiceLinha) {
        linhas.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    /* Adiciona uma lista de Livro ao final dos registros. */
    public void addListaDeAtor(List<Ator> ator) {
        // Pega o tamanho antigo da tabela.  
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.  
        linhas.addAll(ator);

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
