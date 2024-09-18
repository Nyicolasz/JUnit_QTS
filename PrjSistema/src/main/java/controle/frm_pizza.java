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

public class frm_pizza extends JFrame {

    Conexao con_cliente;

    JLabel rcod, rnome, rpreco, rpesquisa,labelImagem;
    JTextField tcod, tnome, tpreco, tpesquisa;
    
    JButton primeiro, ultimo, proximo, anterior;
    JButton btnregistro, btngravar, btnalterar, btnexcluir;
    JButton btnsair, btnpesquisar;

    JTable cliente; // datagrid
    JScrollPane scp_tabela; // container para o datagrid

    public frm_pizza() {
        con_cliente = new Conexao(); // inicializacao do objeto
        con_cliente.conecta(); // chama metodo que conecta

        setTitle("Formulário de pizza");
        setResizable(false);
        setLayout(null);
        Container tela = getContentPane();
        
        labelImagem = new JLabel();
        ImageIcon imagem = new ImageIcon("img/fundo2.png");
        labelImagem.setIcon(imagem);
        labelImagem.setBounds(0,0 ,1000,1000);
        
        getContentPane().setBackground(new Color(245,145,0));
        
        ImageIcon icone = new ImageIcon("img/pizza1.png");
        setIconImage(icone.getImage());

        rcod = new JLabel("Código:");
        rnome = new JLabel("nome:");
        rpreco = new JLabel("preço:");
        rpesquisa = new JLabel("Pesquisar Pizza:");

        tcod = new JTextField();
        tnome = new JTextField();
        tpreco = new JTextField();
        tpesquisa = new JTextField();
        
        primeiro = new JButton("Primeiro");
        ultimo = new JButton("Último");
        proximo = new JButton("Próximo");
        anterior = new JButton("Anterior");
        
        btnpesquisar = new JButton("Pesquisar");
        btnsair = new JButton("Sair");
        
        btnregistro = new JButton("Novo Registro");
        btnexcluir = new JButton("Excluir");
        btnalterar = new JButton("Alterar");
        btngravar = new JButton("Gravar");
        
        btngravar.setBounds(600,50,116,25); btnsair.setBounds(630,500,116,25);
        btnregistro.setBounds(600,90,116,25); rpesquisa.setBounds(10,750,200,25);
        btnalterar.setBounds(600,130,116,25); btnpesquisar.setBounds(350,750,116,25);
        btnexcluir.setBounds(600,170,116,25); tpesquisa.setBounds(125,752,200,20);

        rcod.setBounds(115, 50, 100, 30); tcod.setBounds(175, 55, 200, 20);
        rnome.setBounds(115, 80, 100, 30); tnome.setBounds(175, 85, 200, 20);
        rpreco.setBounds(115, 110, 100, 30);tpreco.setBounds(175, 115, 200, 20);
        
        primeiro.setBounds(430, 50, 116, 25);
        ultimo.setBounds(430, 90, 116, 25);
        proximo.setBounds(430, 130, 116, 25);
        anterior.setBounds(430, 170, 116, 25);
        
        primeiro.setBackground(new Color(255,214,73));
        ultimo.setBackground(new Color(255,214,73));
        proximo.setBackground(new Color(255,214,73));
        anterior.setBackground(new Color(255,214,73));
        
        tcod.setBackground(new Color(255,214,73));
        tpreco.setBackground(new Color(255,214,73));
        tnome.setBackground(new Color(255,214,73));
        
        ultimo.setBackground(new Color(255,214,73));
        proximo.setBackground(new Color(255,214,73));
        anterior.setBackground(new Color(255,214,73));
        
        btngravar.setBackground(new Color(255,214,73));
        btnsair.setBackground(new Color(255,214,73));
        btnexcluir.setBackground(new Color(255,214,73));
        btnalterar.setBackground(new Color(255,214,73));
        btnregistro.setBackground(new Color(255,214,73));
        tpesquisa.setBackground(new Color(255,214,73));
        btnpesquisar.setBackground(new Color(255,214,73));


        // configuração da JTable
        
        cliente = new javax.swing.JTable();
        scp_tabela = new javax.swing.JScrollPane();

        cliente.setBounds(35, 230, 500, 500);
        scp_tabela.setBounds(35, 230, 800, 500);
        
        cliente.setBackground(new Color(255,214,73));
        scp_tabela.setBackground(new Color(255,214,73));

        tela.add(cliente);
        tela.add(scp_tabela);

        cliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cliente.setFont(new java.awt.Font("Arial", 1, 12));

        cliente.setModel(new javax.swing.table.DefaultTableModel(new Object[][] 
        {
            { null, null, null },
            { null, null, null }, 
            { null, null, null }, 
            { null, null, null } 
        },
            new String[] 
            { "Código", "Nome", "Preço" }
        ) 
        {
            boolean[] canEdit = new boolean[] { false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) 
            {
                return canEdit[columnIndex];
            }
        });
        
        

primeiro.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

               try {

                   if(!con_cliente.resultset.isFirst()) {

                        con_cliente.resultset.first();

                        mostrar_Dados();

                   } else {

                       JOptionPane.showMessageDialog(null, "Já é o primeiro registro!", "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);

                   }


               } catch(SQLException erro) {

                   JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registrao: "+ erro, "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);

               }

            }

        });


        anterior.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

               try {

                   if(!con_cliente.resultset.isFirst()) {

                         con_cliente.resultset.previous();

                         mostrar_Dados();

                   } else {

                       JOptionPane.showMessageDialog(null, "Já é o primeiro registro!", "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);

                   }


               } catch(SQLException erro) {

                   JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registrao: "+ erro, "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);

               }

            }

        });


        proximo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

               try {

                    if(!con_cliente.resultset.isLast()) {

                        con_cliente.resultset.next();

                        mostrar_Dados();

                   } else {

                       JOptionPane.showMessageDialog(null, "Já é o ultimo registro!", "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);

                   }

               } catch(SQLException erro) {

                   JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registrao: "+ erro, "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);

               } 

            }

        });


        ultimo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

               try {

                   if(!con_cliente.resultset.isLast()) {

                        con_cliente.resultset.last();

                        mostrar_Dados();

                   } else {

                       JOptionPane.showMessageDialog(null, "Já é o ultimo registro!", "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);

                   }

               } catch(SQLException erro) {

                   JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registrao: "+ erro, "Mesangem do Programa", JOptionPane.INFORMATION_MESSAGE);

               }

            }

        });

        btnregistro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                tcod.setText(""); //limpa a caixa de texto em questão
                tnome.setText("");
                tpreco.setText("");
                tcod.requestFocus();
            }
        });
        
        btngravar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String nome = tnome.getText();
                String preco = tpreco.getText();
                
            try {
                String insert_sql="insert into pizza (nome_pizza, preco_pizza) value ('"+nome+"','"+preco+"')";
                con_cliente.statement.executeUpdate(insert_sql);
                JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!","mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
                
                con_cliente.executaSQL("select * from pizza order by cod_pizza");
                preencherTabela();
            } catch(SQLException errosql) {
                JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n "+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            }
            }
        });
        
        btnalterar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String nome = tnome.getText();
                String preco = tpreco.getText();
                String sql;
                String msg="";
                
                try {
                    if(tcod.getText().equals("")){
                        sql="insert into pizza (nome_pizza, preco_pizza) values ('"+nome+"','"+preco+"')";
                        msg="Gravação de um novo registro";
                    } else {
                        sql = "update pizza set nome_pizza='" + nome + "', preco_pizza='" + preco + "' where cod_pizza=" + tcod.getText();
                        msg="Alteração de registro";
                    }
                    con_cliente.statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso.","Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);

                    con_cliente.executaSQL("select * from pizza order by cod_pizza");
                    preencherTabela(); 
                }
                
                catch(SQLException errosql) {
                    JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n "+errosql,"Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }); 
        
        btnexcluir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String sql ="";
                
                try {
                    int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro: ","  Confirmar exclusão",JOptionPane.YES_NO_OPTION,3);
                    if (resposta ==0){
                        sql = "delete from pizza where cod_pizza = " +tcod.getText();
                        int excluir = con_cliente.statement.executeUpdate(sql);
                        if(excluir==1){
                            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso.","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                            con_cliente.executaSQL("select * from pizza order by cod_pizza");
                            con_cliente.resultset.first();
                            preencherTabela();
                            posicionarRegistro();
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário.","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException excecao) {
                    JOptionPane.showMessageDialog(null, "Erro na exclusão: "+excecao,"Mensagem do programa ",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }); 
        
        btnsair.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {    
                dispose();
            }
        });
        
        btnpesquisar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {    
                try {
                    String pesquisa = "select * from pizza where nome_pizza like '"+tpesquisa.getText() +"%'";
                    con_cliente.executaSQL(pesquisa);
                    
                    if(con_cliente.resultset.first()){
                        preencherTabela();
                    }else {
                        JOptionPane.showMessageDialog(null, "\n Não existe dados com este parâmetro.","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                    }
                } 
                catch(SQLException errosql) {
                    JOptionPane.showMessageDialog(null,"\n Os dados digitados não foram localizados: \n"+errosql, "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        

        scp_tabela.setViewportView(cliente);
        cliente.setAutoCreateRowSorter(true);// ativa a classificação ordenada
        // fim da config jtable
        tela.add(rcod);
        tela.add(rnome);
        tela.add(rpreco);

        tela.add(tcod);
        tela.add(tnome);
        tela.add(tpreco);
        
        tela.add(primeiro);
        tela.add(ultimo);
        tela.add(proximo);
        tela.add(anterior);
        
        tela.add(btngravar);
        tela.add(btnexcluir);
        tela.add(btnregistro);
        tela.add(btnalterar);
        
        tela.add(tpesquisa);
        tela.add(rpesquisa);
        tela.add(btnpesquisar);
        tela.add(btnsair);
        
        tela.add(labelImagem);
        
        setSize(900, 825);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        con_cliente.executaSQL("select * from pizza order by cod_pizza");
        preencherTabela();
        posicionarRegistro();
    }
    
    public void preencherTabela(){
        cliente.getColumnModel().getColumn(0).setPreferredWidth(50);
        cliente.getColumnModel().getColumn(1).setPreferredWidth(50);
        cliente.getColumnModel().getColumn(2).setPreferredWidth(50);
        
        DefaultTableModel modelo = (DefaultTableModel) cliente.getModel();
        modelo.setNumRows(0);
        
        try {
            con_cliente.resultset.beforeFirst();
            while(con_cliente.resultset.next()) {
                modelo.addRow(new Object[] {
                    con_cliente.resultset.getString("cod_pizza"),
                    con_cliente.resultset.getString("nome_pizza"),
                    con_cliente.resultset.getString("preco_pizza"),
                });
            }
        }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!!: \n "+erro, "Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                    }
    }
    
    public void posicionarRegistro() {
        try {
            con_cliente.resultset.first(); //posiciona no 1º registro da tabela
            mostrar_Dados(); //chama o metodo que ira buscar o dado da tabela
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar no primeiro registro: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void mostrar_Dados() {
        try {
            tcod.setText(con_cliente.resultset.getString("cod_pizza")); // associar a caixa de texto ao campo cod
            tnome.setText(con_cliente.resultset.getString("nome_pizza")); // associar a caixa de texto ao campo nome
            tpreco.setText(con_cliente.resultset.getString("preco_pizza"));
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não localizou dados: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
