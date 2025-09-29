/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Form;

import entidades.Cliente;
import entidades.ContasReceber;
import entidades.ItensVenda;
import entidades.MovimentoEstoque;
import entidades.Produto;
import entidades.Venda;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.HibernateUtil;

/**
 *
 * @author mathe
 */
public class Form_Venda extends javax.swing.JPanel {

    
    List<Venda> lista;
    List<Cliente> listaClientes;
    List<Produto> listaProdutos;

    Venda venda = new Venda();
    ItensVenda itensVenda = new ItensVenda();

    public void validaTela(String operacao) {
        if (operacao.equals("inicio")) {
            cDataVenda.setEnabled(false);
            cCliente.setEnabled(false);
            cProduto.setEnabled(false);
            cQuantidade.setEnabled(false);
            cPreco.setEnabled(false);
            btAdd.setEnabled(false);
            btNovo.setEnabled(true);
            btEditar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
        } else if (operacao.equals("novo")) {
            cDataVenda.setEnabled(true);
            cCliente.setEnabled(true);
            cProduto.setEnabled(true);
            cQuantidade.setEnabled(true);
            cPreco.setEnabled(true);
            btAdd.setEnabled(true);
            btNovo.setEnabled(false);
            btEditar.setEnabled(false);
            btExcluir.setEnabled(false);
            btSalvar.setEnabled(true);
            btCancelar.setEnabled(true);
        } else if (operacao.equals("selecionado")) {
            cDataVenda.setEnabled(false);
            cCliente.setEnabled(false);
            cProduto.setEnabled(false);
            cQuantidade.setEnabled(false);
            cPreco.setEnabled(false);
            btAdd.setEnabled(false);
            btNovo.setEnabled(true);
            btEditar.setEnabled(true);
            btExcluir.setEnabled(true);
            btSalvar.setEnabled(false);
            btCancelar.setEnabled(false);
        }
    }

    public void montaComboClientes() {
        cCliente.removeAllItems();
        listaClientes = HibernateUtil.getSession().createQuery("from Cliente").list();
        for (Cliente e : listaClientes) {
            cCliente.addItem(e.getNome());
        }
    }

    public void montaComboProdutos() {
        cProduto.removeAllItems();
        listaProdutos = HibernateUtil.getSession().createQuery("from Produto").list();
        for (Produto p : listaProdutos) {
            cProduto.addItem(p.getNome());
        }
    }
    
    public Form_Venda() {
        initComponents();
        montaTabela();
        montaTabelaItens();
        validaTela("inicio");
        montaComboClientes();
        montaComboProdutos();
    }

    
    public void montaTabela() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Cliente");
        modelo.addColumn("Total");

        lista = HibernateUtil.getSession().createQuery("from Venda").list();
        for (Venda c : lista) {
            modelo.addRow(new Object[]{c.getId(), c.getDataVenda(), c.getCliente().getNome(), c.getValorTotal()});
        }

        tabela.setModel(modelo);
    }
    
     public void montaTabelaParcelas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Parcela");
        modelo.addColumn("Vencimento");
        modelo.addColumn("Valor");      
        
        
        
        for (ContasReceber c : venda.getContasRecebers()) {
            modelo.addRow(new Object[]{c.getParcela(), c.getDataVencimento(), c.getValor()});
        }

        TabelaParcelas.setModel(modelo);
    }

    public void montaTabelaItens() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Produto");
        modelo.addColumn("Preço");
        modelo.addColumn("Quantidade");
        modelo.addColumn("Subtotal");

        for (ItensVenda it : venda.getItensVendas()) {
            modelo.addRow(new Object[]{
                it.getProduto().getNome(),
                "R$ " + it.getPreco().toString().replace(".", ","),
                it.getQuantidade(),
                "R$ " + it.getSubTotal().toString().replace(".", ",")
            });
        }

        tabelaItens.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cCliente = new javax.swing.JComboBox<>();
        cDataVenda = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaItens = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cProduto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cPreco = new util.JMoneyField();
        jLabel7 = new javax.swing.JLabel();
        cQuantidade = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cFormaPag = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cParcelas = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaParcelas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cTotalVenda = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btExcluir = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();

        jLabel2.setText("Código:");

        cId.setEditable(false);
        cId.setEnabled(false);

        jLabel3.setText("Data Venda:");

        jLabel4.setText("Cliente:");

        cCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cId, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1014, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Venda", jPanel1);

        tabelaItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelaItens);

        jLabel5.setText("Produto:");

        cProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cProdutoItemStateChanged(evt);
            }
        });
        cProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cProdutoActionPerformed(evt);
            }
        });

        jLabel6.setText("Preço:");

        cPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cPrecoActionPerformed(evt);
            }
        });

        jLabel7.setText("Quantidade:");

        cQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cQuantidadeActionPerformed(evt);
            }
        });

        btAdd.setText("ADD");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAdd)
                        .addGap(0, 697, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(cPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(cQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Itens da Venda", jPanel2);

        cFormaPag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Cartão de Crédito", "Cartão de Débito", "PIX", "Cheque" }));
        cFormaPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cFormaPagActionPerformed(evt);
            }
        });

        jLabel9.setText("Forma de Pagamento:");

        jLabel10.setText("Qtd Parcelas:");

        cParcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cParcelasActionPerformed(evt);
            }
        });

        jButton1.setText("Gerar Parcelas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TabelaParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(TabelaParcelas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cFormaPag, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(779, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cFormaPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Financeiro", jPanel3);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel1.setText("Venda");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 51));
        jLabel8.setText("Total da venda:");

        cTotalVenda.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        cTotalVenda.setForeground(new java.awt.Color(0, 102, 51));
        cTotalVenda.setText("R$ 0,00");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(cTotalVenda)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cTotalVenda))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNovo)
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public Boolean validaCampos() {
        String mensagem = "";

        if (cCliente.getSelectedItem() == (null)) {
            mensagem = mensagem + "O cliente é obrigatório!";
        }
        if (!mensagem.equals("")) {
            JOptionPane.showMessageDialog(null, mensagem);
            return false;
        } else {
            return true;
        }
    }
    
    private void cProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cProdutoItemStateChanged
        if (cProduto.getSelectedItem() != null) {
            System.out.println(String.format("%.2f", listaProdutos.get(cProduto.getSelectedIndex()).getPreco()).replace(".", ","));
            cPreco.setText(String.format("%.2f", listaProdutos.get(cProduto.getSelectedIndex()).getPreco()).replace(".", ","));
        }
    }//GEN-LAST:event_cProdutoItemStateChanged

    private void cProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cProdutoActionPerformed

    private void cPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cPrecoActionPerformed

    private void cQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cQuantidadeActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed

        itensVenda.setProduto(listaProdutos.get(cProduto.getSelectedIndex()));
        itensVenda.setPreco(Double.parseDouble(cPreco.getText().replace(".", "").replace(",", ".")));
        itensVenda.setQuantidade(Double.parseDouble(cQuantidade.getText().replace(".", "").replace(",", ".")));
        itensVenda.setVenda(venda);
        Double estoque = itensVenda.getProduto().getEstoque();

        for (ItensVenda it : venda.getItensVendas()) {
            if (it.getProduto().getId().equals(itensVenda.getProduto().getId())) {
                estoque = estoque - it.getQuantidade();
            }
        }

        if (estoque < itensVenda.getQuantidade()) {
            JOptionPane.showMessageDialog(null, "Estoque insuficiente! Restam apenas " + estoque + " unidades!");
        } else {
            venda.getItensVendas().add(itensVenda);
            itensVenda = new ItensVenda();
            montaTabelaItens();
            cProduto.setSelectedItem(null);
            cPreco.setText("");
            cQuantidade.setText("");

            cTotalVenda.setText("R$ " + venda.getValorTotal().toString());
        }
    }//GEN-LAST:event_btAddActionPerformed

    private void cFormaPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cFormaPagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cFormaPagActionPerformed

    private void cParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cParcelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cParcelasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int np = Integer.parseInt(cParcelas.getText());
        Date dtVenc = cDataVenda.getDate();
        for (int i = 1; i <= np; i++) {
            ContasReceber cr = new ContasReceber();
            cr.setCliente(listaClientes.get(cCliente.getSelectedIndex()));
            cr.setDataLacamento(new Date());
            cr.setDataVencimento(dtVenc);
            cr.setFormaPagamento(cFormaPag.getSelectedItem().toString());
            cr.setValor(venda.getValorTotal() / np);
            cr.setVenda(venda);
            cr.setParcela(i);
            cr.setObservacao("Conta gerada a partir da venda.");

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dtVenc);
            calendar.add(Calendar.DAY_OF_MONTH, 30); // soma 30 dias
            dtVenc = calendar.getTime();

            venda.getContasRecebers().add(cr);
        }
        montaTabelaParcelas();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public void limparCampos() {
        cId.setText("");
        cDataVenda.setDate(null);
        cCliente.setSelectedItem(null);
    }
    
    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (validaCampos()) {

            venda.setDataVenda(cDataVenda.getDate());
            venda.setCliente(listaClientes.get(cCliente.getSelectedIndex()));

            for (ItensVenda it : venda.getItensVendas()) {
                Produto p = it.getProduto();

                MovimentoEstoque m = new MovimentoEstoque();
                m.setProduto(p);
                m.setEstoqueAnterior(p.getEstoque());
                m.setQuantidade(it.getQuantidade());
                m.setTipoMovimento("S");
                HibernateUtil.beginTransaction();
                HibernateUtil.getSession().persist(m);
                HibernateUtil.commitTransaction();
                HibernateUtil.closeSession();

                p.setEstoque(p.getEstoque() - it.getQuantidade());
                HibernateUtil.beginTransaction();
                HibernateUtil.getSession().update(p);
                HibernateUtil.commitTransaction();
                HibernateUtil.closeSession();

            }

            HibernateUtil.beginTransaction();
            HibernateUtil.getSession().persist(venda);
            HibernateUtil.commitTransaction();
            HibernateUtil.closeSession();

            venda = new Venda();
            montaTabela();
            montaTabelaItens();
            limparCampos();
            validaTela("inicio");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked

        venda = lista.get(tabela.getSelectedRow());
        cId.setText(venda.getId().toString());
        cDataVenda.setDate(venda.getDataVenda());
        cCliente.setSelectedItem(venda.getCliente().getNome());
        montaTabelaItens();
        validaTela("selecionado");
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().delete(venda);
        HibernateUtil.commitTransaction();
        HibernateUtil.closeSession();

        montaTabela();
        montaTabelaItens();
        limparCampos();

        validaTela("inicio");
        // TODO add your handling code here:
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        venda = new Venda();
        itensVenda = new ItensVenda();
        limparCampos();
        validaTela("novo");
        // TODO add your handling code here:
    }//GEN-LAST:event_btNovoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        limparCampos();
        validaTela("inicio");
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed

        validaTela("novo");
        // TODO add your handling code here:
    }//GEN-LAST:event_btEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaParcelas;
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cCliente;
    private com.toedter.calendar.JDateChooser cDataVenda;
    private javax.swing.JComboBox<String> cFormaPag;
    private javax.swing.JTextField cId;
    private javax.swing.JTextField cParcelas;
    private util.JMoneyField cPreco;
    private javax.swing.JComboBox<String> cProduto;
    private javax.swing.JTextField cQuantidade;
    private javax.swing.JLabel cTotalVenda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabelaItens;
    // End of variables declaration//GEN-END:variables
}
