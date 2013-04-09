package br.ufs.escala.businesslogic.admin;

import br.ufs.escala.dao.UsuarioDAO;
import br.ufs.escala.transfer.Usuario;

import java.sql.Connection;

public class AuthBL {
    private Connection conn;

    public AuthBL(Connection conn) {
        this.conn = conn;
    }

    public Usuario verificaUsuario(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO(this.conn);
        Usuario usuarioRetorno = dao.getUsuario(usuario);
        return usuarioRetorno;
    }
}
