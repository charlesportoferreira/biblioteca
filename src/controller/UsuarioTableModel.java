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
import model.Usuario;

/**
 *
 * @author charleshenriqueportoferreira
 */
public class UsuarioTableModel extends AbstractTableModel {

    /* Lista de Usuario que representam as linhas. */
    private List<Usuario> linhas;

    /* Array de Strings com o nome das colunas. */
    private String[] colunas = new String[]{
        "Nome", "Endereco", "email", "RG", "CPF", "DataNascimento"};

    /* Cria um UsuarioTableModel vazio. */
    public UsuarioTableModel() {
        linhas = new ArrayList<>();
    }

    /* Cria um UsuarioTableModel carregado com 
     * a lista de Usuario especificada. */
    public UsuarioTableModel(List<Usuario> listaDeUsuario) {
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
        // Retorna o tamanho da lista de Usuario.  
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
        Usuario usuario = linhas.get(rowIndex);
//"Nome", "Endereco", "email", "RG", "CPF", "DataNascimento"};
        // Retorna o campo referente a coluna especificada.  
        // Aqui é feito um switch para verificar qual é a coluna  
        // e retornar o campo adequado. As colunas sãoas mesmas  
        // que foram especificadas no array "colunas".  
        switch (columnIndex) {
            case 0:
                return usuario.getNome();
            case 1:
                return usuario.getEndereco();
            case 2:
                return usuario.getEmail();
            case 3:
                return usuario.getRG();
            case 4:
                return usuario.getCPF();
            case 5:
                return usuario.getDataNascimento();
            default:
                // Isto não deveria acontecer...  
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
//modifica na linha e coluna especificada  
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Usuario usuario = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        switch (columnIndex) { // Seta o valor do campo respectivo  
            case 0:
                usuario.setNome(aValue.toString());
            case 1:
                usuario.setEndereco(aValue.toString());
            case 2:
                usuario.setEmail(aValue.toString());
            case 3:
                usuario.setRG((int) aValue);
            case 4:
                usuario.setCPF((int) aValue);
            case 5:
                usuario.setDataNascimento((Date) aValue);
            default:
            // Isto não deveria acontecer...               
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    //modifica na linha especificada  
    public void setValueAt(Usuario aValue, int rowIndex) {
        Usuario usuario = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  

        usuario.setNome(aValue.getNome());
        usuario.setEndereco(aValue.getEndereco());
        usuario.setEmail(aValue.getEmail());
        usuario.setRG(aValue.getRG());
        usuario.setCPF(aValue.getCPF());
        usuario.setDataNascimento(aValue.getDataNascimento());

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

    public Usuario getUsuario(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    /* Adiciona um registro. */
    public void addUsuario(Usuario m) {
        // Adiciona o registro.  
        linhas.add(m);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /* Remove a linha especificada. */
    public void removeUsuario(int indiceLinha) {
        linhas.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    /* Adiciona uma lista de usuario ao final dos registros. */
    public void addListaDeUsuario(List<Usuario> usuario) {
        // Pega o tamanho antigo da tabela.  
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.  
        linhas.addAll(usuario);

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
