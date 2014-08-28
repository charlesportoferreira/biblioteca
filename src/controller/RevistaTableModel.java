package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Revista;

public class RevistaTableModel extends AbstractTableModel {


    /* Lista de Revista que representam as linhas. */
    private List<Revista> linhas;

    /* Array de Strings com o nome das colunas. */
    private String[] colunas = new String[]{
        "Titulo", "Ano", "Volume", "Numero", "Exemplares", "Disponiveis"};

    /* Cria um RevustaTableModel vazio. */
    public RevistaTableModel() {
        linhas = new ArrayList<>();
    }

    /* Cria um RevistaTableModel carregado com 
     * a lista de Revista especificada. */
    public RevistaTableModel(List<Revista> listaDeRevista) {
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
        // Retorna o tamanho da lista de Revista.  
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
        Revista revista = linhas.get(rowIndex);

        // Retorna o campo referente a coluna especificada.  
        // Aqui é feito um switch para verificar qual é a coluna  
        // e retornar o campo adequado. As colunas sãoas mesmas  
        // que foram especificadas no array "colunas".  
        switch (columnIndex) {
            case 0:
                return revista.getTitulo();
            case 1:
                return revista.getAno();
            case 2:
                return revista.getVolume();
            case 3:
                return revista.getNumero();
            case 4:
                return revista.getExemplares().size();
            case 5:
                return revista.getQtdeExemplaresDisponiveis();
            default:
                // Isto não deveria acontecer...  
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
//modifica na linha e coluna especificada  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Revista revista = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        switch (columnIndex) { // Seta o valor do campo respectivo  
            case 0:
                revista.setTitulo(aValue.toString());
            case 1:
                revista.setAno((int) aValue);
            case 2:
                revista.setVolume((int) aValue);
            case 3:
                revista.setNumero((int) aValue);

            default:
            // Isto não deveria acontecer...               
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    //modifica na linha especificada  
    public void setValueAt(Revista aValue, int rowIndex) {
        Revista revista = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        revista.setTitulo(aValue.getTitulo());
        revista.setAno(aValue.getAno());
        revista.setVolume(aValue.getVolume());
        revista.setNumero(aValue.getNumero());

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

    public Revista getRevista(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    /* Adiciona um registro. */
    public void addRevista(Revista m) {
        // Adiciona o registro.  
        linhas.add(m);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /* Remove a linha especificada. */
    public void removeRevista(int indiceLinha) {
        linhas.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    /* Adiciona uma lista de Revista ao final dos registros. */
    public void addListaDeRvista(List<Revista> revista) {
        // Pega o tamanho antigo da tabela.  
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.  
        linhas.addAll(revista);

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
