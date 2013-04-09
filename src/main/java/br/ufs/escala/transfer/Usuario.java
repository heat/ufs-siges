package br.ufs.escala.transfer;

public class Usuario {

    private String usuario;
    private String senha;
    private int tipoUsuario;

    protected Usuario(String usuario, String senha, int tipoUsuario)  {
        this.usuario = usuario;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }
    public Usuario(String usuario, String senha) {
         this(usuario, senha, 1);
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

    public boolean isUsuarioPapel() {
        return true;
    }
    public boolean isGestorPapel() {
        return false;
    }
    public boolean isAdministradorPapel() {
        return false;
    }
}
