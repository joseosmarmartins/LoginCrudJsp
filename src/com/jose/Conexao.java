package com.jose;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private static Connection conexao = null;

    public static Connection conectar() {
        if (conexao != null) {
            return conexao;
        }

        try {
            Class.forName(ConfiguracaoBD.driver);

            conexao = DriverManager.getConnection(ConfiguracaoBD.url, ConfiguracaoBD.usuario, ConfiguracaoBD.senha);

            System.out.println("Conectado");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexao;
    }

    public static void fecharConexao(){
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao =null;
    }
}
