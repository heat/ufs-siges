package br.ufs.escala.ui;

import br.ufs.escala.businesslogic.fachada.ServiceFacade;
import br.ufs.escala.transfer.Usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@RequestScoped
public class LoginFormUI extends DefaultUI {

    private String login = "";
    private String senha = "";

    public String logarse() {
        try {

            Usuario usuario = new Usuario(this.login, this.senha);
            ServiceFacade serviceFacade = ServiceFacade.getInstance();
            Usuario usuarioLog = serviceFacade.authUser(usuario);
            sessionRegister(usuarioLog);
            if (usuarioLog != null) {
                return "success";
            }
            return "error";
        } catch (Exception e) {
            return "error";
        }
    }

    public String sair() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return "sair";
    }

    private void sessionRegister(Usuario user) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("usuario", user);
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
