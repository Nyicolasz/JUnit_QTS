package controle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import conexao.Conexao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.sql.*;
import java.text.*;
import javax.swing.text.MaskFormatter;
import javax.swing.table.DefaultTableModel; 
import javax.swing.border.Border;

public class TelaMenu extends JFrame {
    
    Conexao con_pizzaria;
    
    public TelaMenu() {
        Container tela = getContentPane();
        tela.setLayout(null);tela.setBackground(new Color(245, 145, 0));
        ImageIcon icone = new ImageIcon("img/pizza1.png");
        setIconImage(icone.getImage());
        
        con_pizzaria = new Conexao();
        con_pizzaria.conecta();
        
        JLabel labelImagem = new JLabel();
        ImageIcon imagem = new ImageIcon("img/pizza1.png");
        labelImagem.setIcon(imagem);
        labelImagem.setBounds(260, 50, imagem.getIconWidth(), imagem.getIconHeight());
        add(labelImagem);
        
        // Configurações básicas da janela
        setTitle("Menu da Pizzaria");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu menuFormulario = new JMenu("Formulários");
        menuBar.add(menuFormulario);
        
        JMenu menuSobre = new JMenu("Sobre");
        menuBar.add(menuSobre);
        
        
        JMenu menuSair = new JMenu("Sair");
        
        menuBar.add(menuSair);
        menuBar.add(menuSobre);
        
        JMenuItem menuItemSobre = new JMenuItem("Sobre");
        menuSobre.add(menuItemSobre);
        
        JMenuItem menuItemSair = new JMenuItem("Sair");
        menuSair.add(menuItemSair);
        
        JMenuItem menuItemCardapio = new JMenuItem("Gerenciar Pizzas");
        menuFormulario.add(menuItemCardapio);

        // Submenu "Gerenciar Compra"
        JMenuItem menuItemGerenciarCompra = new JMenuItem("Gerenciar Compra");
        menuFormulario.add(menuItemGerenciarCompra);

        // Submenu "Gerenciar Clientes"
        JMenuItem menuItemGerenciarClientes = new JMenuItem("Gerenciar Clientes");
        menuFormulario.add(menuItemGerenciarClientes);
        
        menuItemSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });  
        
        menuItemSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frm_Sobre mostra = new frm_Sobre();
                mostra.setVisible(true);
            }
        });  
        // Painel principal
        tela.setLayout(null); // Desativar layout para usar setBounds

        // Botões do menu
        JButton botaoGerenciarPizzas = new JButton("Gerenciar Pizzas");
        JButton botaoGerenciarCompra = new JButton("Gerenciar Compras");
        JButton botaoGerenciarClientes = new JButton("Gerenciar Clientes");
        JButton botaoSobre = new JButton("Sobre");

        // Define as posições e tamanhos dos botões usando setBounds
        botaoGerenciarPizzas.setBounds(100, 120, 200, 30);
        botaoGerenciarCompra.setBounds(100, 215, 200, 30);
        botaoGerenciarClientes.setBounds(100, 310, 200, 30);

        botaoGerenciarPizzas.setBackground(new Color(255,214,73));
        botaoGerenciarCompra.setBackground(new Color(255,214,73));
        botaoGerenciarClientes.setBackground(new Color(255,214,73));
        
        // Adicione os botões ao painel
        
        // Define atalhos para os botões
        botaoGerenciarPizzas.setMnemonic(KeyEvent.VK_P); 
        botaoGerenciarPizzas.setMnemonic(KeyEvent.VK_P);
        // Alt + P
        
        botaoGerenciarCompra.setMnemonic(KeyEvent.VK_C); 
        botaoGerenciarCompra.setMnemonic(KeyEvent.VK_C);
        // Alt + C
        
        botaoGerenciarClientes.setMnemonic(KeyEvent.VK_L); 
        botaoGerenciarClientes.setMnemonic(KeyEvent.VK_L);    
        // Alt + L

        // Adicione um ouvinte de evento para cada botão
        botaoGerenciarPizzas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frm_pizza mostra = new frm_pizza();
                mostra.setVisible(true);
            }
        });
        menuItemCardapio.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
                frm_pizza mostra = new frm_pizza();
                mostra.setVisible(true);
            }
        });
        //
        botaoGerenciarCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frm_compra mostra = new frm_compra();
                mostra.setVisible(true);
            }
        });
        menuItemGerenciarCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frm_compra mostra = new frm_compra();
                mostra.setVisible(true);
            }
        });
        //
        botaoGerenciarClientes.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frm_cliente mostra = new frm_cliente();
                mostra.setVisible(true);
            }   
        });
        menuItemGerenciarClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frm_cliente mostra = new frm_cliente();
                mostra.setVisible(true);
            }
        }); 
        
        // Adicione o painel à janela
        tela.add(botaoGerenciarPizzas);
        tela.add(botaoGerenciarCompra);
        tela.add(botaoGerenciarClientes);
        tela.add(botaoSobre);

        // Centralize a janela
        setSize(800, 500);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
