package com.jose;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public static Usuario porId(int id) {
        Usuario usuario = new Usuario();

        try {
            Statement statement = Conexao.conectar().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from usuario where id = " + id);

            while (resultSet.next()) {
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setEmail(resultSet.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public static Usuario porNomeSenha(String nome, String senha) {
        Usuario usuario = new Usuario();

        try {
            Statement statement = Conexao.conectar().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from usuario where nome = '" + nome + "' and senha = '" + senha + "'");

            while (resultSet.next()) {
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public static List<Usuario> usuarios() {
        List<Usuario> usuarioList = new ArrayList<>();

        try {
            Statement statement = Conexao.conectar().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from usuario");

            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));
                usuarioList.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarioList;
    }

    public static void adicionarUsuario(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement("insert into usuario(nome, cpf, email, senha) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getCpf());
            preparedStatement.setString(3, usuario.getEmail());
            preparedStatement.setString(4, usuario.getSenha());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editaUsuario(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement("update usuario set nome = '" + usuario.getNome() +
                    "', cpf = '" + usuario.getCpf() + "', email = '" + usuario.getEmail() + "', senha = '" + usuario.getSenha() + "' WHERE id = " + usuario.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletaUsuario(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = Conexao.conectar().prepareStatement("delete from usuario WHERE id = " + usuario.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
