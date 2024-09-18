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

public class frm_compra extends JFrame {

    Conexao con_pizzaria;

    JLabel rcod_compra, rcod_pizza, rcod_cliente, rcod_funcionario, rdata_compra, rpesquisa,labelImagem;
    JTextField tcod_compra, tcod_pizza, tcod_cliente, tcod_funcionario, tpesquisa;
    JFormattedTextField fdata;
    MaskFormatter mdata;
    
    JButton primeiro, ultimo, proximo, anterior;
    JButton btnregistro, btngravar, btnalterar, btnexcluir;
    JButton btnsair, btnpesquisar;

    JTable cliente; // datagrid
    JScrollPane scp_tabela; // container para o datagrid

    public frm_compra() {
        con_pizzaria = new Conexao(); // inicializacao do objeto
        con_pizzaria.conecta(); // chama metodo que conecta

        setTitle("Formulário de compra");
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

        rcod_compra = new JLabel("Código da compra:");
        rcod_pizza = new JLabel("Código da pizza:");
        rcod_cliente = new JLabel("Código do cliente:");
        rcod_funcionario = new JLabel("Código do funcionário:");
        rdata_compra = new JLabel("Data da compra:");
        rpesquisa = new JLabel("Dia da Compra: ");

        tcod_compra = new JTextField();
        tcod_pizza = new JTextField();
        tcod_cliente = new JTextField();
        tcod_funcionario = new JTextField();
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
        
        btngravar.setBounds(670,50,116,25); btnsair.setBounds(630,500,116,25);
        btnregistro.setBounds(670,90,116,25); rpesquisa.setBounds(10,750,200,25);
        btnalterar.setBounds(670,130,116,25); btnpesquisar.setBounds(350,750,116,25);
        btnexcluir.setBounds(670,170,116,25); 

        rcod_compra.setBounds(110, 50, 200, 30); tcod_compra.setBounds(250, 55, 200, 20);
        rcod_cliente.setBounds(110, 80, 200, 30); tcod_cliente.setBounds(250, 85, 200, 20);
        rcod_funcionario.setBounds(110, 110, 200, 30); tcod_funcionario.setBounds(250, 115, 200, 20);
        rdata_compra.setBounds(110, 133, 200, 30); tpesquisa.setBounds(125,752,200,20);
        rcod_pizza.setBounds(110, 158, 200, 30); tcod_pizza.setBounds(250, 170, 200, 20);
        
        primeiro.setBounds(500, 50, 116, 25);
        ultimo.setBounds(500, 90, 116, 25);
        proximo.setBounds(500, 130, 116, 25);
        anterior.setBounds(500, 170, 116, 25);
        
        primeiro.setBackground(new Color(255,214,73));
        ultimo.setBackground(new Color(255,214,73));
        proximo.setBackground(new Color(255,214,73));
        anterior.setBackground(new Color(255,214,73));
        
        tcod_compra.setBackground(new Color(255,214,73));
        tcod_cliente.setBackground(new Color(255,214,73));
        tcod_funcionario.setBackground(new Color(255,214,73));
        tcod_pizza.setBackground(new Color(255,214,73));
        
        rpesquisa.setBackground(new Color(255,214,73));
        ultimo.setBackground(new Color(255,214,73));
        proximo.setBackground(new Color(255,214,73));
        anterior.setBackground(new Color(255,214,73));
        
        btngravar.setBackground(new Color(255,214,73));
        btnsair.setBackground(new Color(255,214,73));
        btnexcluir.setBackground(new Color(255,214,73));
        btnpesquisar.setBackground(new Color(255,214,73));
        btnalterar.setBackground(new Color(255,214,73));
        btnregistro.setBackground(new Color(255,214,73));
        
        try {
            mdata = new MaskFormatter("##/##/####");
            mdata.setPlaceholderCharacter('_');
            fdata = new JFormattedTextField(mdata);
        } catch (ParseException excp) {
            excp.printStackTrace();
        }
        
        fdata.setBackground(new Color(255,214,73));
        
        fdata.setBounds(250, 145, 200,20);
        
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
            { null, null, null, null, null },
            { null, null, null, null, null }, 
            { null, null, null, null, null }, 
            { null, null, null, null, null }
        },
            new String[] 
            { "Código da compra", "Código do cliente", "Código do funcionário", "Data da compra", "Código da pizza" }
        ) 
        {
            boolean[] canEdit = new boolean[] { false, false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) 
            {
                return canEdit[columnIndex];
            }
        });
        
   

primeiro.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

               try {

                   if(!con_pizzaria.resultset.isFirst()) {

                        con_pizzaria.resultset.first();

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

                   if(!con_pizzaria.resultset.isFirst()) {

                         con_pizzaria.resultset.previous();

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

                    if(!con_pizzaria.resultset.isLast()) {

                        con_pizzaria.resultset.next();

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

                   if(!con_pizzaria.resultset.isLast()) {

                        con_pizzaria.resultset.last();

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
                tcod_compra.setText(""); //limpa a caixa de texto em questão
                tcod_cliente.setText("");
                tcod_funcionario.setText("");
                fdata.setText("");
                tcod_pizza.setText("");
            }
        });
        
        btngravar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String cod_compra = tcod_compra.getText();
                String cod_cliente = tcod_cliente.getText();
                String cod_funcionario = tcod_funcionario.getText();
                String data_compra = fdata.getText();
                String cod_pizza = tcod_pizza.getText();
                
            try {
                String insert_sql="insert into compra (cod_compra, cod_cliente, cod_funcionario, data_compra, cod_pizza) values ('"+cod_compra+"','"+cod_cliente+"','"+cod_funcionario+"','"+data_compra+"','"+cod_pizza+"')";
                con_pizzaria.statement.executeUpdate(insert_sql);
                JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!","mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
                
                con_pizzaria.executaSQL("select * from compra order by cod_compra");
                preencherTabela();
            } catch(SQLException errosql) {
                JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n "+errosql,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            }
            }
        });
        
        btnalterar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String cod_compra = tcod_compra.getText();
                String cod_cliente = tcod_cliente.getText();
                String cod_funcionario = tcod_funcionario.getText();
                String data_compra = fdata.getText();
                String cod_pizza = tcod_pizza.getText();
                String sql;
                String msg="";
                
                try {
                    if(tcod_compra.getText().equals("")){
                        sql="insert into compra (cod_compra, cod_cliente, cod_funcionario, data_compra, cod_pizza) values ('"+cod_compra+"','"+cod_cliente+"','"+cod_funcionario+"','"+data_compra+"','"+cod_pizza+"')";
                        msg="Gravação de um novo registro";
                    } else {
                        sql = "update compra set cod_compra='" + cod_compra + "', cod_cliente = '" + cod_cliente + "', cod_funcionario ='" +  cod_funcionario + "', data_compra ='" + data_compra + "', cod_pizza ='" + cod_pizza + "'  where cod_compra=" + tcod_compra.getText();
                        msg="Alteração de registro";
                    }
                    con_pizzaria.statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso.","Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);

                    con_pizzaria.executaSQL("select * from compra order by cod_compra");
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
                        sql = "delete from compra where cod_compra = " +tcod_compra.getText();
                        int excluir = con_pizzaria.statement.executeUpdate(sql);
                        if(excluir==1){
                            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso.","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                            con_pizzaria.executaSQL("select * from compra order by cod_compra");
                            con_pizzaria.resultset.first();
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
                    String pesquisa = "select * from compra where data_compra like '"+tpesquisa.getText() +"%'";
                    con_pizzaria.executaSQL(pesquisa);
                    
                    if(con_pizzaria.resultset.first()){
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
        tela.add(rcod_compra);
        tela.add(rcod_pizza);
        tela.add(rcod_cliente);
        tela.add(rcod_funcionario);
        tela.add(rdata_compra);

        tela.add(tcod_compra);
        tela.add(tcod_pizza);
        tela.add(tcod_cliente);
        tela.add(tcod_funcionario);
        tela.add(fdata);
        
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
        
        con_pizzaria.executaSQL("select * from compra order by cod_compra");
        preencherTabela();
        posicionarRegistro();
    }
    
    public void preencherTabela() {
        cliente.getColumnModel().getColumn(0).setPreferredWidth(50);
        cliente.getColumnModel().getColumn(1).setPreferredWidth(50);
        cliente.getColumnModel().getColumn(2).setPreferredWidth(50);
        cliente.getColumnModel().getColumn(3).setPreferredWidth(50);
        cliente.getColumnModel().getColumn(4).setPreferredWidth(50);
        
        DefaultTableModel modelo = (DefaultTableModel) cliente.getModel();
        modelo.setNumRows(0);
        
        try {
            con_pizzaria.resultset.beforeFirst();
            while(con_pizzaria.resultset.next()) {
                modelo.addRow(new Object[] {
                    con_pizzaria.resultset.getString("cod_compra"),
                    con_pizzaria.resultset.getString("cod_cliente"),
                    con_pizzaria.resultset.getString("cod_funcionario"),
                    con_pizzaria.resultset.getString("data_compra"),
                    con_pizzaria.resultset.getString("cod_pizza")
                });
            }
        }catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!!: \n "+erro, "Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void posicionarRegistro() {
        try {
            con_pizzaria.resultset.first(); //posiciona no 1º registro da tabela
            mostrar_Dados(); //chama o metodo que ira buscar o dado da tabela
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar no primeiro registro: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void mostrar_Dados() {
        try {
            tcod_compra.setText(con_pizzaria.resultset.getString("cod_compra"));
            tcod_cliente.setText(con_pizzaria.resultset.getString("cod_cliente"));
            tcod_funcionario.setText(con_pizzaria.resultset.getString("cod_funcionario"));
            fdata.setText(con_pizzaria.resultset.getString("data_compra"));
            tcod_pizza.setText(con_pizzaria.resultset.getString("cod_pizza"));
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não localizou dados: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}