package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import conexao.Conexao;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class frm_Sobre extends JFrame {
    
    public frm_Sobre() {
        setTitle("Formulário Sobre");
        setSize(500, 300);
        setLayout(null);

        ImageIcon icone = new ImageIcon("img/pizza1.png");
        setIconImage(icone.getImage());
        
        JLabel labelImagem = new JLabel();
        ImageIcon imagem = new ImageIcon("img/fundo.png");
        labelImagem.setIcon(imagem);
        labelImagem.setBounds(0,0 ,500,500);
        
        
        getContentPane().setBackground(new Color(245,145,0));
        
        JLabel labeltitulo = new JLabel("Banco de dados de uma pizzaria");
        labeltitulo.setFont(new Font("Times New Roman",Font.BOLD,20)); 
        
        JLabel label1 = new JLabel("Geovanne Rodrigues de Paula ");
        JLabel label2 = new JLabel("Ayrton Silveira Diniz");
        JLabel label3 = new JLabel("Érik Iitirou Forcella");

        
        labeltitulo.setBounds(110, 1, 500, 130);
        label1.setBounds(50, 30, 200, 130);
        label2.setBounds(50, 70, 200, 130);
        label3.setBounds(50, 110, 200, 130);

        add(label1);
        add(label2);
        add(label3);
        add(labeltitulo);
        add(labelImagem);
        setVisible(true);
        setLocationRelativeTo(null);
    }}


