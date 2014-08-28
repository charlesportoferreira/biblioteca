package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Reserva;

public class ReservaTableModel extends AbstractTableModel {

    /* Lista de Reservas que representam as linhas. */
    private List<Reserva> linhas;

    /* Array de Strings com o nome das colunas. */
    private String[] colunas = new String[]{
        "Titulo", "Usuario", "Data da Reserva"};

    /* Cria um ReservaTableModel vazio. */
    public ReservaTableModel() {
        linhas = new ArrayList<>();
    }

    /* Cria um ReservaTableModel carregado com 
     * a lista de Reserva especificada. */
    public ReservaTableModel(List<Reserva> listaDeReserva) {
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
        // Retorna o tamanho da lista de Reserva.  
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

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reserva reserva = linhas.get(rowIndex);

        // Retorna o campo referente a coluna especificada.  
        // Aqui é feito um switch para verificar qual é a coluna  
        // e retornar o campo adequado. As colunas sãoas mesmas  
        // que foram especificadas no array "colunas".  
        switch (columnIndex) {
            case 0:
                return reserva.getItem().getTitulo();
            case 1:
                return reserva.getUsuario().getNome();
            case 2:
                return reserva.getDataReserva();

            default:
                // Isto não deveria acontecer...  
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
//modifica na linha e coluna especificada  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Reserva reserva = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        switch (columnIndex) { // Seta o valor do campo respectivo  
            case 0:
                reserva.getItem().setTitulo(aValue.toString());
            case 1:
                reserva.getUsuario().setNome(aValue.toString());
            case 2:
                reserva.setDataReserva((Date) aValue);

            // reserva.setExemplares(aValue.);
            default:
            // Isto não deveria acontecer...               
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    //modifica na linha especificada  
    public void setValueAt(Reserva aValue, int rowIndex) {
        Reserva reserva = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        reserva.getItem().setTitulo(aValue.getItem().getTitulo());
        reserva.getUsuario().setNome(aValue.getUsuario().getNome());
        reserva.setDataReserva(aValue.getDataReserva());

        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Reserva getReserva(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    /* Adiciona um registro. */
    public void addReserva(Reserva m) {
        // Adiciona o registro.  
        linhas.add(m);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /* Remove a linha especificada. */
    public void removeReserva(int indiceLinha) {
        linhas.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    /* Adiciona uma lista de Reserva ao final dos registros. */
    public void addListaDeReserva(List<Reserva> reserva) {
        // Pega o tamanho antigo da tabela.  
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.  
        linhas.addAll(reserva);

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
