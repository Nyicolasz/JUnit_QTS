/*
Esta classe será responsável pela conexão com o MySql e terá 3 métodos:
método 1: abertura da conexão
método 2: fechamento da conexão
método 3: execução de comandos SQL
*/
package conexao;

import javax.swing.JOptionPane;
import java.sql.*;

public class Conexao {
    final private String driver = "com.mysql.cj.jdbc.Driver"; //definição do driver mysql para acesso aos dados
    final private String url = "jdbc:mysql://localhost/pizzaria_MySQL"; // acesso ao bd "pizzaria_MySQL" no servidor (myAdmin)
    final private String usuario = "root"; //usuario do mysql
    final private String senha = ""; // senha do mysql
    private Connection conexao; // variavel que armazenará o resultado da execução de um comando SQL
    public Statement statement; // variavel para execucao dos comandos sql dentro do ambiente java
    public ResultSet resultset; // variavel que armazenara o resultado da execucao de um comando SQL
    
    public boolean conecta() {
        boolean result = true;
            try {
            Class.forName(driver);
                conexao = DriverManager.getConnection(url,usuario,senha);   
            } catch (ClassNotFoundException Driver) {
                JOptionPane.showMessageDialog(null, "Driver não localizado"+Driver,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                result = false;
            } catch (SQLException Fonte) {
                JOptionPane.showMessageDialog(null, "Fonte de dados não localizada!"+Fonte,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                result = false;
            }
            return result;
    }
    
    public void desconecta() {
        try {
            conexao.close();
            JOptionPane.showMessageDialog(null, "Conexão com o banco fechada", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar o banco", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void executaSQL(String sql) {
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        } catch (SQLException excecao) {
            JOptionPane.showMessageDialog(null, "Erro no comando SQL! \n Erro: " + excecao, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
