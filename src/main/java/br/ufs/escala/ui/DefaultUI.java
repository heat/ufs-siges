package br.ufs.escala.ui;

import br.ufs.escala.transfer.Usuario;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class DefaultUI {
	public Usuario getUsuario() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Object obj = session.getAttribute("usuario");
        if(obj == null) {
            return null;
        }
        Usuario usuario = (Usuario)obj;

        return usuario;
	}

    public String rotaEscala() {
        return "escala";
    }
    public String rotaPermuta() {
        return "permuta";
    }
}