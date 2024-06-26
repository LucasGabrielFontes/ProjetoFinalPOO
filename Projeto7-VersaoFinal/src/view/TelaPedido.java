/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import classes.PainelComImagem;
import classes.Pedido;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static view.TelaInicial.pedidos;

public class TelaPedido extends javax.swing.JFrame {

    private TelaCadastraPedido2 telaCadastraPedido2;
    
    public TelaPedido(TelaCadastraPedido2 telaCadastraPedido2, ArrayList<Pedido> pedidos) {
        
        initComponents();
        setResizable(false); // Desabilita o redimensionamento da janela
        this.telaCadastraPedido2 = telaCadastraPedido2;
        
        exibirPedidos();
        
        
    }
    
    private void criarOuAtualizarArquivoPedidos() {
        try {
            FileWriter fw = new FileWriter(view.TelaCadastraPedido2.filePath, false); // O false indica que iremos sobrescrever o arquivo
            BufferedWriter bw = new BufferedWriter(fw);

            // Escrevendo os dados dos pedidos no arquivo
            for (Pedido pedido : pedidos) {
                bw.write("Número do pedido: " + pedido.getNumPedido() + ", Telefone do Cliente: " + pedido.getTelefone() + ", Código da Pizza: " + pedido.getCodigoPizza() + ", Estado do Pedido: " + pedido.getEstado());
                bw.newLine(); // Adiciona uma nova linha para o próximo pedido
            }

            bw.close(); // Fecha o BufferedWriter
            fw.close(); // Fecha o FileWriter

            //Log para confirmar se arquivo pedidos.txt foi atualizado/criado
            //System.out.println("Arquivo pedidos.txt atualizado com sucesso em: " + view.TelaCadastraPedido2.filePath); 


        } catch (Exception e) {
            System.err.println("Erro ao atualizar o arquivo pedidos.txt: " + e.getMessage());
        }
    }
    
        
    private void exibirPedidos() {
        DefaultTableModel model = (DefaultTableModel) jTablePedidos.getModel();
        model.setRowCount(0); // Limpa a tabela antes de preenchê-la novamente
        if (!pedidos.isEmpty()) { // Verifica se a lista de pedidos não está vazia
            for (Pedido p : pedidos) {
                model.addRow(new Object[]{p.getNumPedido(), p.getTelefone(), p.getCodigoPizza(), p.getEstado()});
            }
        }
    }
     
    public TelaPedido() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        PainelComImagem painelComImagem = new PainelComImagem("src/images/logoRedimensionada25.png");
        this.setContentPane(painelComImagem);

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePedidos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 40)); 
        jLabel1.setText("CRUD PEDIDOS");

        jTablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUMPEDIDO", "TELEFONE", "CÓDIGO PIZZA", "ESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTablePedidos);
        if (jTablePedidos.getColumnModel().getColumnCount() > 0) {
            jTablePedidos.getColumnModel().getColumn(0).setResizable(false);
            jTablePedidos.getColumnModel().getColumn(1).setResizable(false);
            jTablePedidos.getColumnModel().getColumn(2).setResizable(false);
            jTablePedidos.getColumnModel().getColumn(3).setResizable(false);
        }

        jTabbedPane1.addTab("PEDIDOS", jScrollPane1);

        jButton1.setFont(new java.awt.Font("Verdana", 0, 20)); 
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Verdana", 0, 12)); 
        btnExcluir.setForeground(new java.awt.Color(255, 51, 51));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(325, 325, 325))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(btnExcluir)
                        .addGap(185, 185, 185))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jButton1)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Torna a TelaPizza invisível
        setVisible(false);
        // Torna a TelaCadastraCliente visível
        telaCadastraPedido2.setVisible(true);
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTablePedidos.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir este pedido?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) jTablePedidos.getModel();
                

                pedidos.remove(selectedRow);
                criarOuAtualizarArquivoPedidos();
                if (!pedidos.isEmpty()) {
                    exibirPedidos();
                } else {
                    model.setRowCount(0);
                }

                jTablePedidos.revalidate();
                jTablePedidos.repaint();
                JOptionPane.showMessageDialog(null, "Pedido excluído com sucesso.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Nenhuma pedido selecionado.");
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPedido().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablePedidos;
    
}

