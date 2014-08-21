/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Software;

/**
 *
 * @author charleshenriqueportoferreira
 */
public class SoftwareTableModel extends AbstractTableModel {

    /* Lista de Software que representam as linhas. */
    private List<Software> linhas;

    /* Array de Strings com o nome das colunas. */
    private String[] colunas = new String[]{
        "Titulo", "Ano", "Versao", "SO", "Fabricante", "Requisitos", "Compra", "Exemplares", "Disponiveis"};

    /* Cria um SoftwareTableModel vazio. */
    public SoftwareTableModel() {
        linhas = new ArrayList<>();
    }

    /* Cria um SoftwareTableModel carregado com 
     * a lista de Software especificada. */
    public SoftwareTableModel(List<Software> listaDeSoftware) {
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
        // Retorna o tamanho da lista de Software.  
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
        Software software = linhas.get(rowIndex);
//"Titulo", "Ano", "Versao", "SO", "Fabricante", "Requisitos", "Compra"};
        // Retorna o campo referente a coluna especificada.  
        // Aqui é feito um switch para verificar qual é a coluna  
        // e retornar o campo adequado. As colunas sãoas mesmas  
        // que foram especificadas no array "colunas".  
        switch (columnIndex) {
            case 0:
                return software.getTitulo();
            case 1:
                return software.getAno();
            case 2:
                return software.getVersao();
            case 3:
                return software.getSistemaOperacional();
            case 4:
                return software.getFabricante();
            case 5:
                return software.getRequisitosInstalacao();
            case 6:
                return software.getAnoCompra();
            case 7:
                return software.getExemplares().size();
            case 8:
                return software.getQtdeExemplaresDisponiveis();
            default:
                // Isto não deveria acontecer...  
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
//modifica na linha e coluna especificada  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Software software = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        switch (columnIndex) { // Seta o valor do campo respectivo  
            case 0:
                software.setTitulo(aValue.toString());
            case 1:
                software.setAno((int) aValue);
            case 2:
                software.setVersao((int) aValue);
            case 3:
                software.setSistemaOperacional(aValue.toString());
            case 4:
                software.setFabricante(aValue.toString());
            case 5:
                software.setRequisitosInstalacao(aValue.toString());
            case 6:
                software.setAnoCompra((int) aValue);

            default:
            // Isto não deveria acontecer...               
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    //modifica na linha especificada  
    public void setValueAt(Software aValue, int rowIndex) {
        Software software = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        software.setTitulo(aValue.getTitulo());
        software.setAno(aValue.getAno());
        software.setVersao(aValue.getVersao());
        software.setSistemaOperacional(aValue.getSistemaOperacional());
        software.setFabricante(aValue.getFabricante());
        software.setRequisitosInstalacao(aValue.getRequisitosInstalacao());
        software.setAnoCompra(aValue.getAnoCompra());

        // item.setTel(aValue.getTel());  
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Software getSoftware(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    /* Adiciona um registro. */
    public void addSoftware(Software m) {
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

    /* Adiciona uma lista de Software ao final dos registros. */
    public void addListaDeSoftware(List<Software> software) {
        // Pega o tamanho antigo da tabela.  
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.  
        linhas.addAll(software);

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
