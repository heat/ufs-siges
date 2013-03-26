package br.ufs.escala.ui;

import br.ufs.escala.transfer.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginFormUI {

    private String usuario = "Onezino Gabriel Moreira";
    private String senha;

    public String login() {
        return "success";
    }

    private void sessionRegister(Usuario user) {
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
