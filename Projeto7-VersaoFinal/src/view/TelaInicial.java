package view;

import javax.swing.JOptionPane;
import classes.Cliente;
import classes.PainelComImagem;
import classes.Pedido;
import classes.Pizza;
import java.util.ArrayList;

public class TelaInicial extends javax.swing.JFrame {
    
    String senha = "admin";
    
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    public static ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    
    public static void adicionaCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public static void adicionaPizza(Pizza pizza) {
        pizzas.add(pizza);
    }
    
    public static void adicionaPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    
    public TelaInicial() {
        initComponents();
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setResizable(false); // Desabilita o redimensionamento da janela
        
        // Associa o botão "btnLogar" ao evento de pressionar "Enter"
        getRootPane().setDefaultButton(btnLogar);
        
    }
    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        PainelComImagem painelComImagem = new PainelComImagem("src/images/logoRedimensionada25.png");
        this.setContentPane(painelComImagem);
    
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        btnLogar = new javax.swing.JButton();
    
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 40)); 
        jLabel1.setText("Tá chovendo pizza!");
    
        lblSenha.setFont(new java.awt.Font("Tahoma", 0, 18));
    
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); 
        jLabel3.setText("Digite a senha para acessar o sistema: ");
    
        btnLogar.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        btnLogar.setText("Logar");
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });
        
        jPanel1.setOpaque(false);
    
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogar)))
                .addContainerGap(173, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(211, 211, 211))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel1)))
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogar))
                .addContainerGap(280, Short.MAX_VALUE))
        );
    
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(painelComImagem);
        painelComImagem.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    
        pack();
        setLocationRelativeTo(null);
    }

    public void exibir () {
        this.setVisible(true);
    }
    
    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {

        if (!String.valueOf(lblSenha.getPassword()).equals(senha)) {
            JOptionPane.showMessageDialog(null, "Senha inválida! Tente novamente.");
        } else {
            this.setVisible(false);
            TelaFuncionario telaFuncionario = new TelaFuncionario();
            telaFuncionario.setVisible(true);
        }
        
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField lblSenha;

}
