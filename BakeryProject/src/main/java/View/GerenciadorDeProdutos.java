package View;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */


import DAO.ProdutoDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * Classe que representa uma interface gráfica para gerenciar Produtos.
 * Permite cadastrar, editar, visualizar e excluir funcionários através de uma interface.
 */
public class GerenciadorDeProdutos extends javax.swing.JInternalFrame {
    
    private Long produtoEditandoId;
    
    /**
     * Creates new form EditProduto
     */
    public GerenciadorDeProdutos() {
        initComponents();
        buscarTodosProdutos();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        quantidadeProduto = new javax.swing.JTextField();
        nomeProduto = new javax.swing.JTextField();
        valorProduto = new javax.swing.JTextField();
        categoriaProduto = new javax.swing.JTextField();
        cadastrarProduto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        editNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        editQuantidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        editValor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        editCategoria = new javax.swing.JTextField();
        editarProduto = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        queryProdInput = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        cancelarEdicao = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gerenciador De Produtos");
        setToolTipText("Gerenciador de Produtos");

        jTabbedPane1.setToolTipText("Gerenciador De Produtos");

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 22)); // NOI18N
        jLabel1.setText("CADASTRO DE PRODUTOS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Quantidade");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Valor");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Catégoria");

        quantidadeProduto.setActionCommand("<Not Set>");
        quantidadeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantidadeProdutoActionPerformed(evt);
            }
        });

        nomeProduto.setActionCommand("<Not Set>");
        nomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeProdutoActionPerformed(evt);
            }
        });

        valorProduto.setActionCommand("<Not Set>");
        valorProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorProdutoActionPerformed(evt);
            }
        });

        categoriaProduto.setActionCommand("<Not Set>");
        categoriaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaProdutoActionPerformed(evt);
            }
        });

        cadastrarProduto.setText("Cadastrar");
        cadastrarProduto.setToolTipText("");
        cadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(cadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorProduto)
                            .addComponent(quantidadeProduto)
                            .addComponent(nomeProduto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(categoriaProduto))))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(quantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(valorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(categoriaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addComponent(cadastrarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        jTabbedPane1.addTab("Criar Produtos", jPanel1);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Nome");

        editNome.setActionCommand("<Not Set>");
        editNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editNomeActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Quantidade");

        editQuantidade.setActionCommand("<Not Set>");
        editQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editQuantidadeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Valor");

        editValor.setActionCommand("<Not Set>");
        editValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editValorActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Catégoria");

        editCategoria.setActionCommand("<Not Set>");
        editCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCategoriaActionPerformed(evt);
            }
        });

        editarProduto.setText("Atualizar");
        editarProduto.setToolTipText("");
        editarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarProdutoActionPerformed(evt);
            }
        });

        jLabel10.setText("BUSQUE OS PRODUTOS");

        queryProdInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryProdInputActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Quantidade", "Valor", "Categória "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaProdutos);

        jLabel11.setText("Clique com o botão direito em algum item da tabela para abrir as opções");

        cancelarEdicao.setText("Cancelar");
        cancelarEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEdicaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(queryProdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(351, 351, 351)
                                        .addComponent(jLabel10)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(editValor))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(editNome, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(74, 74, 74)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cancelarEdicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(editarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(editCategoria)
                                    .addComponent(editQuantidade))))
                        .addGap(27, 27, 27))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(queryProdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(editNome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(editQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(editValor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(editCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelarEdicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Editar Produtos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quantidadeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantidadeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantidadeProdutoActionPerformed

    private void nomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeProdutoActionPerformed

    private void valorProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorProdutoActionPerformed

    private void categoriaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoriaProdutoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limparCamposEdicao();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos;
        try {
            produtos = produtoDAO.buscarPorNome(queryProdInput.getText());
            popularProdutos(produtos);
        } catch (Exception ex) {
            Logger.getLogger(VendaItensInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void queryProdInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryProdInputActionPerformed

    }//GEN-LAST:event_queryProdInputActionPerformed

    private void editCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editCategoriaActionPerformed

    private void editValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editValorActionPerformed

    private void editQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editQuantidadeActionPerformed

    private void editNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editNomeActionPerformed

    private void editarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarProdutoActionPerformed
        editarProduto();
    }//GEN-LAST:event_editarProdutoActionPerformed

    private void cadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarProdutoActionPerformed
        cadastrarProduto();
    }//GEN-LAST:event_cadastrarProdutoActionPerformed

    private void cancelarEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEdicaoActionPerformed
        limparCamposEdicao();
    }//GEN-LAST:event_cancelarEdicaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarProduto;
    private javax.swing.JButton cancelarEdicao;
    private javax.swing.JTextField categoriaProduto;
    private javax.swing.JTextField editCategoria;
    private javax.swing.JTextField editNome;
    private javax.swing.JTextField editQuantidade;
    private javax.swing.JTextField editValor;
    private javax.swing.JButton editarProduto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nomeProduto;
    private javax.swing.JTextField quantidadeProduto;
    private javax.swing.JTextField queryProdInput;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JTextField valorProduto;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Cadastra um novo Produto com os dados preenchidos nos campos do formulário.
     * Valida os dados antes de enviar para o banco de dados e exibe mensagens de sucesso/erro.
     */
    public void cadastrarProduto() {
        try {
            Produto produto = new Produto();
            produto.setNome(nomeProduto.getText());
            produto.setQuantidade(Integer.parseInt(quantidadeProduto.getText()));
            produto.setValor(Double.parseDouble(valorProduto.getText()));
            produto.setCategoria(categoriaProduto.getText());

            ProdutoDAO dao = new ProdutoDAO();
            Long id = dao.salvar(produto);

            JOptionPane.showMessageDialog(this, "Produto cadastrado com ID: " + id);
            limparCampos();
            
            try {
                buscarTodosProdutos();
            } catch (Exception e) {
               JOptionPane.showMessageDialog(this, "Erro ao buscar todos os produtos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade e valor devem ser números!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Limpa todos os campos do formulário de cadastro de produtos.
     */
    public void limparCampos() {
        nomeProduto.setText("");
        quantidadeProduto.setText("");
        valorProduto.setText("");
        categoriaProduto.setText("");
    }
    
    /**
     * Popula a tabela de Produtos com os produtos do banco de dados.
     */
    public void popularProdutos(List<Produto> produtos) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabelaProdutos.getModel();

            modelo.setRowCount(0);

            for (Produto produto: produtos) {
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
                "Erro ao carregar funcionários: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Função para buscar todos os produtos.
     */
    public void buscarTodosProdutos(){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos;
        try {
            produtos = produtoDAO.buscarTodos();
            popularProdutos(produtos);
        } catch (Exception ex) {
            Logger.getLogger(VendaItensInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Configura os listeners para abrir o menu de opções ao clicar com o botão direito na tabela.
     */
    public void abrirOpcoes() {
        tabelaProdutos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { 
                    int row = tabelaProdutos.getSelectedRow();
                    if (row != -1) { 
                       mostrarPopupMenu(e);
                    }
                }
            }
        });
    }
    
    /**
     * Exibe um menu popup com opções para o produto selecionado na tabela.
     * @param e O evento de mouse que disparou a abertura do popup
     */
    public void mostrarPopupMenu(MouseEvent e) {
        int row = tabelaProdutos.rowAtPoint(e.getPoint());
        if (row >= 0) {
            tabelaProdutos.setRowSelectionInterval(row, row); 
            
            JPopupMenu popupMenu = new JPopupMenu();
            
            JMenuItem verDetalhes = new JMenuItem("Ver Detalhes");
            verDetalhes.addActionListener(ev -> abrirDetalhesProduto(row));
            popupMenu.add(verDetalhes);
            
            
            JMenuItem deletarItem = new JMenuItem("Deletar");
            deletarItem.addActionListener(ev -> confirmarDelecao(row));
            popupMenu.add(deletarItem);
            
            JMenuItem editarProduto = new JMenuItem("Editar Produto");
            editarProduto.addActionListener(ev -> preencherCamposEdicao(row));
            popupMenu.add(editarProduto);
            
            popupMenu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
    
    /**
     * Solicita confirmação antes de deletar um produto.
     * @param rowIndex O índice da linha do produto na tabela
     */
    public void confirmarDelecao(int rowIndex) {
        Long id = (Long) tabelaProdutos.getValueAt(rowIndex, 0);
        String nome = (String) tabelaProdutos.getValueAt(rowIndex, 1);

        int confirm = JOptionPane.showConfirmDialog(this,
            "Tem certeza que deseja deletar o produto:\n" + nome + " (ID: " + id + ")",
            "Confirmar Deleção",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            deletarProduto(id, rowIndex);
        }
    }
    
    /**
     * Remove um produto do banco de dados.
     * @param id O ID do Produto a ser removido
     * @param rowIndex O índice da linha na tabela
     */
    public void deletarProduto(Long id, int rowIndex) {
        try {
            ProdutoDAO dao = new ProdutoDAO();
            ((DefaultTableModel)tabelaProdutos.getModel()).removeRow(rowIndex);
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
     * Exibe os detalhes completos de um produto em uma caixa de diálogo.
     * @param rowIndex O índice da linha do produto na tabela
     */
    public void abrirDetalhesProduto(int rowIndex) {
        DefaultTableModel model = (DefaultTableModel) tabelaProdutos.getModel();
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
    
    /**
     * Preenche os campos de edição com os dados do Produto.
     */
    public void preencherCamposEdicao(int rowIndex) {
        DefaultTableModel model = (DefaultTableModel) tabelaProdutos.getModel();
        produtoEditandoId = (Long) model.getValueAt(rowIndex, 0);
        editNome.setText((String) model.getValueAt(rowIndex, 1));
        editQuantidade.setText(model.getValueAt(rowIndex, 2).toString());
        editValor.setText(model.getValueAt(rowIndex, 3).toString());
        editCategoria.setText((String) model.getValueAt(rowIndex, 4));

        jTabbedPane1.setSelectedIndex(1);
    }
    
    /**
     * Atualiza os dados de um produto existente no banco de dados.
     */
    public void editarProduto(){
        if (produtoEditandoId == null) {
            JOptionPane.showMessageDialog(this, "Nenhum produto selecionado para edição", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Produto produto = new Produto();
            produto.setId(produtoEditandoId);
            produto.setNome(editNome.getText());
            produto.setQuantidade(Integer.parseInt(editQuantidade.getText()));
            produto.setValor(Double.parseDouble(editValor.getText()));
            produto.setCategoria(editCategoria.getText());

            ProdutoDAO dao = new ProdutoDAO();
            dao.atualizar(produto);

            JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
            limparCamposEdicao();
            buscarTodosProdutos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade e valor devem ser números!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Limpa os Campos de Edição.
     */
    public void limparCamposEdicao() {
        produtoEditandoId = null;
        editNome.setText("");
        editQuantidade.setText("");
        editValor.setText("");
        editCategoria.setText("");
    }
}
