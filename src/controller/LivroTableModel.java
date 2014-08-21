/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Livro;

/**
 *
 * @author charleshenriqueportoferreira
 */
public class LivroTableModel extends AbstractTableModel {

    /* Lista de Livros que representam as linhas. */
    private List<Livro> linhas;

    /* Array de Strings com o nome das colunas. */
    private String[] colunas = new String[]{
        "Titulo", "Ano", "Editora", "Edicao", "ISBN", "Publicacao", "Exemplares", "Disponiveis"};

    /* Cria um LivroTableModel vazio. */
    public LivroTableModel() {
        linhas = new ArrayList<>();
    }

    /* Cria um LivroTableModel carregado com 
     * a lista de Livro especificada. */
    public LivroTableModel(List<Livro> listaDeLIvros) {
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
        // Retorna o tamanho da lista de Livro.  
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
        Livro livro = linhas.get(rowIndex);

        // Retorna o campo referente a coluna especificada.  
        // Aqui é feito um switch para verificar qual é a coluna  
        // e retornar o campo adequado. As colunas sãoas mesmas  
        // que foram especificadas no array "colunas".  
        switch (columnIndex) {
            case 0:
                return livro.getTitulo();
            case 1:
                return livro.getAno();
            case 2:
                return livro.getEditora();
            case 3:
                return livro.getEdicao();
            case 4:
                return livro.getISBN();
            case 5:
                return livro.getLocalPublicacao();
            case 6:
                return livro.getExemplares().size();
            case 7:
                return livro.getQtdeExemplaresDisponiveis();
            default:
                // Isto não deveria acontecer...  
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
//modifica na linha e coluna especificada  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Livro livro = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        switch (columnIndex) { // Seta o valor do campo respectivo  
            case 0:
                livro.setTitulo(aValue.toString());
            case 1:
                livro.setAno((int) aValue);
            case 2:
                livro.setEditora(aValue.toString());
            case 3:
                livro.setEdicao((int) aValue);
            case 4:
                livro.setISBN(aValue.toString());
            case 5:
                livro.setLocalPublicacao(aValue.toString());
            case 6:
            // livro.setExemplares(aValue.);
            default:
            // Isto não deveria acontecer...               
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    //modifica na linha especificada  
    public void setValueAt(Livro aValue, int rowIndex) {
        Livro livro = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        livro.setTitulo(aValue.getTitulo());
        livro.setAno(aValue.getAno());
        livro.setEditora(aValue.getEditora());
        livro.setEdicao(aValue.getEdicao());
        livro.setISBN(aValue.getISBN());
        livro.setLocalPublicacao(aValue.getLocalPublicacao());
        livro.setExemplares(aValue.getExemplares());
        // item.setTel(aValue.getTel());  

        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
        fireTableCellUpdated(rowIndex, 5);
        fireTableCellUpdated(rowIndex, 6);

    }

    ;  
  
  
    ;  
  
  
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Livro getLivro(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    /* Adiciona um registro. */
    public void addLivro(Livro m) {
        // Adiciona o registro.  
        linhas.add(m);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /* Remove a linha especificada. */
    public void removeLivro(int indiceLinha) {
        linhas.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    /* Adiciona uma lista de Livro ao final dos registros. */
    public void addListaDeLivro(List<Livro> livro) {
        // Pega o tamanho antigo da tabela.  
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.  
        linhas.addAll(livro);

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
