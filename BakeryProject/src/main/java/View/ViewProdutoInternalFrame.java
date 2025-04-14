package View;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */


import DAO.ProdutoDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.Produto;

/**
 *
 * @author joaoh
 */

 /**
 * Interface gráfica para visualização e gerenciamento de produtos no sistema.
 * Este frame interno permite aos usuários visualizar todos os produtos cadastrados,
 * atualizar a lista, ver detalhes de produtos específicos e excluir registros.
 */
public class ViewProdutoInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewProdutoInternalFrame
     */
    public ViewProdutoInternalFrame() {
        initComponents();
        popularJtable();
        abrirOpcoes();

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Todos os Produtos");
        setToolTipText("Todos os Produtos");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Quantidade", "Valor", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("TODOS OS PRODUTOS");

        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Clique com o botão direito em algum item da tabela para abrir as opções");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        popularJtable();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
    * Popula a tabela com todos os produtos cadastrados no banco de dados.
    * Este método é chamado na inicialização do frame e quando o botão Atualizar é clicado.
    */
    public void popularJtable() {
    try {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.buscarTodos();
        
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        
        modelo.setRowCount(0);
        
        for (Produto produto : produtos) {
            modelo.addRow(new Object[]{
                produto.getId(),
                produto.getNome(),
                produto.getQuantidade(),
                produto.getValor(),
                produto.getCategoria()
            });
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Erro ao carregar produtos: " + e.getMessage(), 
            "Erro", 
            JOptionPane.ERROR_MESSAGE);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
    /**
    * Configura o listener de mouse para a tabela de produtos,
    * permitindo a exibição de um menu de contexto ao clicar com o botão direito.
    */
    public void abrirOpcoes() {
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { 
                    int row = jTable1.getSelectedRow();
                    if (row != -1) { 
                       mostrarPopupMenu(e);
                    }
                }
            }
        });
    }
    
    
    /**
    * Exibe um menu de contexto com opções para o produto selecionado.
    * As opções incluem ver detalhes e deletar o produto.
    * 
    * @param e O evento de mouse que acionou o menu
    */
    public void mostrarPopupMenu(MouseEvent e) {
        int row = jTable1.rowAtPoint(e.getPoint());
        if (row >= 0) {
            jTable1.setRowSelectionInterval(row, row); 
            
            JPopupMenu popupMenu = new JPopupMenu();
            
            JMenuItem verDetalhes = new JMenuItem("Ver Detalhes");
            verDetalhes.addActionListener(ev -> abrirDetalhesProduto(row));
            popupMenu.add(verDetalhes);
            
            
            JMenuItem deletarItem = new JMenuItem("Deletar");
            deletarItem.addActionListener(ev -> confirmarDelecao(row));
            popupMenu.add(deletarItem);
            
            popupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
    
    /**
    * Exibe uma caixa de diálogo para confirmar a exclusão do produto selecionado.
    * 
    * @param rowIndex O índice da linha selecionada na tabela
    */
    public void confirmarDelecao(int rowIndex) {
        Long id = (Long) jTable1.getValueAt(rowIndex, 0);
        String nome = (String) jTable1.getValueAt(rowIndex, 1);

        int confirm = JOptionPane.showConfirmDialog(this,
            "Tem certeza que deseja deletar o produto:\n" + nome + " (ID: " + id + ")",
            "Confirmar Deleção",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            deletarProduto(id, rowIndex);
        }
    }
    
    
    /**
     * Exclui um produto do banco de dados e remove a linha correspondente da tabela.
     * 
     * @param id O ID do produto a ser excluído
     * @param rowIndex O índice da linha na tabela a ser removida
     */
    public void deletarProduto(Long id, int rowIndex) {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            ((DefaultTableModel)jTable1.getModel()).removeRow(rowIndex);
            dao.excluir(id);
            JOptionPane.showMessageDialog(this, 
                "Produto deletado com sucesso!", 
                "Sucesso", 
                JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao deletar: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
    * Exibe os detalhes completos do produto selecionado em uma caixa de diálogo.
    * 
    * @param rowIndex O índice da linha selecionada na tabela
    */
    public void abrirDetalhesProduto(int rowIndex) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Long id = (Long) model.getValueAt(rowIndex, 0);
        try {
            ProdutoDAO dao = new ProdutoDAO();
            Produto produto = dao.buscarPorId(id);

            JOptionPane.showMessageDialog(this,
                "Detalhes do Produto:\n\n" +
                "ID: " + produto.getId() + "\n" +
                "Nome: " + produto.getNome() + "\n" +
                "Valor: R$ " + String.format("%.2f", produto.getValor()) + "\n" +
                "Quantidade: " + produto.getQuantidade() + "\n" +
                "Categoria: " + produto.getCategoria(),
                "Detalhes do Produto",
                JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao carregar detalhes: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
