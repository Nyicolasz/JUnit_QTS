/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controle;

import conexao.Conexao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Admin
 */
public class frm_clienteTest {

    private Conexao con_pizzaria;
    private frm_cliente cliente;

    public frm_clienteTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        con_pizzaria = new Conexao();
        cliente = new frm_cliente();
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of preencherTabela method, of class frm_cliente.
     */
    @Test
    public void testPreencherTabela() {
        System.out.println("preencherTabela");
        frm_cliente instance = new frm_cliente();
        instance.preencherTabela();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of posicionarRegistro method, of class frm_cliente.
     */
    @Test
    public void testPosicionarRegistro() {
        System.out.println("posicionarRegistro");
        frm_cliente instance = new frm_cliente();
        instance.posicionarRegistro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar_Dados method, of class frm_cliente.
     */
    @Test
    public void testMostrar_Dados() {
        System.out.println("mostrar_Dados");
        frm_cliente instance = new frm_cliente();
        instance.mostrar_Dados();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testeGravar() {

        System.out.println("Gravar_Dados");
        cliente.btngravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = "teste";
                String telefone = "teste";
                String endereco = "teste";

                try {
                    String insert_sql = "insert into cliente (nome_cliente, telefone_cliente, endereco_cliente) values ('" + nome + "','" + telefone + "','" + endereco + "')";
                    con_pizzaria.statement.executeUpdate(insert_sql);
                    JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!", "mensagem do programa", JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

    }

    @Test
    public void testeAlterar() {
        System.out.println("Alterar Dados");

        cliente.btnalterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = "testeAlterar";
                String telefone = "testeAlterar";
                String endereco = "testeAlterar";
                String tcod = "1";

                String sql = "";
                String msg = "";

                try {
                    if (tcod.equals("")) {
                        sql = "insert into cliente (nome_cliente, telefone_cliente, endereco_cliente) values ('" + nome + "','" + telefone + "','" + endereco + "')";
                        msg = "Gravação de um novo registro";
                    } else {
                        sql = "update cliente set nome_cliente='" + nome + "', telefone_cliente='" + telefone + "', endereco_cliente='" + endereco + "' where cod_cliente=" + tcod;
                        msg = "Alteração de registro";
                    }
                    con_pizzaria.statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso.", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    @Test
    public void testeExcluir() {

        cliente.btnexcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql = "";

                String nome = "testeAlterar";
                String telefone = "testeAlterar";
                String endereco = "testeAlterar";
                String tcod = "2";

                String msg = "";

                try {
                    sql = "delete from cliente where cod_cliente = " + tcod;
                    int excluir = con_pizzaria.statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso.", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    con_pizzaria.executaSQL("select * from cliente order by cod_cliente");
                    con_pizzaria.resultset.first();
                } catch (SQLException excecao) {
                    JOptionPane.showMessageDialog(null, "Erro na exclusão: " + excecao, "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        ;
    }

    );
    }

 @Test
    public void testeMostrar() {
        cliente.preencherTabela();

    }
}
