/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Emprestimo;

/**
 *
 * @author charleshenriqueportoferreira
 */
public class EmprestimoTableModel extends AbstractTableModel {

    /* Lista de Emprestimo que representam as linhas. */
    private List<Emprestimo> linhas;

    /* Array de Strings com o nome das colunas. */
    private String[] colunas = new String[]{
        "Exemplar", "Usuario", "Renovacoes", "Data Emprestimo", "Data Devolucao","Data Limite", "Multa"};

    /* Cria um EmprestimoTableModel vazio. */
    public EmprestimoTableModel() {
        linhas = new ArrayList<>();
    }

    /* Cria um EmprestimoTableModel carregado com 
     * a lista de Emprestimo especificada. */
    public EmprestimoTableModel(List<Emprestimo> listaDeEmprestimo) {
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
        // Retorna o tamanho da lista de Emprestimo.  
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
        Emprestimo emprestimo = linhas.get(rowIndex);
//  "Exemplar", "Usuario", "Renovacoes", "Data Emprestimo", "Data Devolucao", "Multa"};
        // Retorna o campo referente a coluna especificada.  
        // Aqui é feito um switch para verificar qual é a coluna  
        // e retornar o campo adequado. As colunas sãoas mesmas  
        // que foram especificadas no array "colunas".  
        switch (columnIndex) {
            case 0:
                return emprestimo.getExemplar().getItem().getTitulo();
            case 1:
                return emprestimo.getUsuario().getNome();
            case 2:
                return emprestimo.getQtdRenovacoes();
            case 3:
                return emprestimo.getDataEmprestimo();
            case 4:
                return emprestimo.getDataDevolucao();
            case 5:
                return emprestimo.getDataLimite();
            case 6:
                return emprestimo.getMulta();
            default:
                // Isto não deveria acontecer...  
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
//modifica na linha e coluna especificada  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Emprestimo emprestimo = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        switch (columnIndex) { // Seta o valor do campo respectivo  
            case 0:
                emprestimo.getExemplar().getItem().setTitulo(aValue.toString());
            case 1:
                emprestimo.getUsuario().setNome(aValue.toString());
            case 2:
                emprestimo.setQtdRenovacoes((int) aValue);
            case 3:
                emprestimo.setDataEmprestimo((Date) aValue);
            case 4:
                emprestimo.setDataDevolucao((Date) aValue);
            case 5:
                emprestimo.setDataLimite(((Date) aValue));
            case 6:
                emprestimo.setMulta((int) aValue);
            default:
            // Isto não deveria acontecer...               
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    //modifica na linha especificada  
    public void setValueAt(Emprestimo aValue, int rowIndex) {
        Emprestimo emprestimo = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        emprestimo.getExemplar().getItem().setTitulo(aValue.getExemplar().getItem().getTitulo());
        emprestimo.getUsuario().setNome(aValue.getUsuario().getNome());
        emprestimo.setQtdRenovacoes((int) aValue.getQtdRenovacoes());
        emprestimo.setDataEmprestimo((Date) aValue.getDataEmprestimo());
        emprestimo.setDataDevolucao((Date) aValue.getDataDevolucao());
        emprestimo.setDataLimite((Date) aValue.getDataLimite());
        emprestimo.setMulta((int) aValue.getMulta());

        // item.setTel(aValue.getTel());  
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Emprestimo getEmprestimo(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    /* Adiciona um registro. */
    public void addEmprestimo(Emprestimo m) {
        // Adiciona o registro.  
        linhas.add(m);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /* Remove a linha especificada. */
    public void removeEmprestimo(int indiceLinha) {
        linhas.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    /* Adiciona uma lista de emprestimo ao final dos registros. */
    public void addListaDeEmprestimo(List<Emprestimo> emprestimo) {
        // Pega o tamanho antigo da tabela.  
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.  
        linhas.addAll(emprestimo);

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
