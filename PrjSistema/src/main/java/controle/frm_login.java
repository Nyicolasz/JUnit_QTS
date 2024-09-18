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

public class frm_login extends JFrame {
    
    Conexao con_pizzaria;
    
    JLabel jlusuario, jlsenha, jltitulo, jlcod, labelImagem;
    JTextField jtfusuario, jtfcod;
    JPasswordField jpfsenha;
    JButton jblogar;
    
    public frm_login() {
        ImageIcon icone = new ImageIcon("img/pizza1.png");
        setIconImage(icone.getImage());
        
        con_pizzaria = new Conexao();
        con_pizzaria.conecta();
        
        setTitle(" *** Login de Acesso *** ");
        Container tela = getContentPane();
        setLayout(null);
        
        labelImagem = new JLabel();
        ImageIcon imagem = new ImageIcon("img/fundo.png");
        labelImagem.setIcon(imagem);
        labelImagem.setBounds(0, 0,  1000, 550);
         
 
        
        jltitulo = new JLabel("Acesso ao Sistema");
        jlcod = new JLabel("Código: ");
        jlusuario = new JLabel("Usuário: ");
        jlsenha = new JLabel("Senha: ");
        jtfcod = new JTextField("");
        jtfusuario = new JTextField("");
        jpfsenha = new JPasswordField("");
        jblogar = new JButton("Logar");
        
        jltitulo.setBounds(80, 25, 500, 100);
        jlcod.setBounds(40, 140, 100, 100);            jtfcod.setBounds(100, 180, 200, 20);
        jlusuario.setBounds(40, 170, 100, 100);        jtfusuario.setBounds(100,210,200,20);
        jlsenha.setBounds(40, 200, 100, 100);        jpfsenha.setBounds(100,240,200,20);
        jblogar.setBounds(115,450,100,30);
        
        jltitulo.setFont(new Font("Times New Roman",Font.BOLD,24)); 
        tela.setBackground(new Color(245,145,0));
        jblogar.setBackground(new Color(255,214,73));
       
         // Define um atalho (acelerador) para o botão "Logar" (Alt + L)
        jblogar.setMnemonic(KeyEvent.VK_L);

        
        jblogar.setMnemonic(KeyEvent.VK_L);
        
        tela.add(jlcod);
        tela.add(jtfcod);
        tela.add(jltitulo);
        tela.add(jlusuario);
        tela.add(jlsenha);
        tela.add(jtfusuario);
        tela.add(jpfsenha);
        tela.add(jblogar);
        tela.add(labelImagem);
        //depois dos tela.add
        jblogar.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                try{
                    String pesquisa = "select * from funcionario where cod_funcionario like '" + jtfcod.getText() + "' && usuario_funcionario like '" + jtfusuario.getText() + "' && senha_funcionario = " + jpfsenha.getText()+ "";
                    con_pizzaria.executaSQL(pesquisa);

                    if(con_pizzaria.resultset.first())
                    {//acesso ao form de cadastro
                        TelaMenu mostra = new TelaMenu();
                        mostra.setVisible(true);
                        dispose();
                    }
                    
                    else
                    {
                        JOptionPane.showMessageDialog(null, "\n Usuário não cadastrado!","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                        con_pizzaria.desconecta();
                        System.exit(0);
                    }
                }catch(SQLException errosql){
                    JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados! :\n" + errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        setSize(350, 550);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public static void main(String args[]) {
        frm_login app = new frm_login();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
