package br.ufs.escala.transfer;

public class Administrador extends Usuario {
    public Administrador(String usuario, String senha) {
        super(usuario, senha, 2);
    }
}
