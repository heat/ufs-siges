package br.ufs.escala.businesslogic.fachada;

import br.ufs.escala.businesslogic.BusinessLogicFactory;
import br.ufs.escala.businesslogic.admin.AuthBL;
import br.ufs.escala.transfer.Usuario;

public class ServiceFacade {

    private static ServiceFacade instance;

    private ServiceFacade() {
    }

    public static ServiceFacade getInstance() {
        if (instance == null) {
            instance = new ServiceFacade();
        }
        return instance;
    }

    public Usuario authUser(Usuario usuario) {
        BusinessLogicFactory blFactory = BusinessLogicFactory.getInstance();
        AuthBL userBL = blFactory.getAuthBL();
        //TODO validar conforme regra usuario e senha
        Usuario usuarioRetorno = userBL.verificaUsuario(usuario);
        return usuarioRetorno;
    }
}
