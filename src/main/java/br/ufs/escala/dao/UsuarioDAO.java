package br.ufs.escala.dao;

import br.ufs.escala.transfer.Administrador;
import br.ufs.escala.transfer.Gestor;
import br.ufs.escala.transfer.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    public Usuario getUsuario(Usuario usuario) {
        ResultSet rs = null;

        try (PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM USUARIO U WHERE U.USUARIO  = ? AND U.SENHA = ? ")) {
            Usuario usuarioRetorno = null;
            pStmt.setObject(1, usuario.getUsuario());
            pStmt.setObject(2, usuario.getSenha());
            rs = pStmt.executeQuery();
            rs.next();
            String usuariologin = rs.getString("usuario");
            int idFuncionario = rs.getInt("id_funcionario");
            int tipoUsuario = rs.getInt("tipo_usuario");
            switch (tipoUsuario) {
                case 1:
                    usuarioRetorno = new Usuario(usuariologin, "");
                    break;
                case 2:
                    usuarioRetorno = new Administrador(usuariologin, "");
                    break;
                case 3:
                    usuarioRetorno = new Gestor(usuariologin, "");
                    break;
            }
            return usuarioRetorno;
        } catch (SQLException ex) {

            return null;
        }
    }
}
