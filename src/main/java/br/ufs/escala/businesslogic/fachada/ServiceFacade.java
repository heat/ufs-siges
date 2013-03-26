package br.ufs.escala.businesslogic.fachada;

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
        return null;
    }
}
