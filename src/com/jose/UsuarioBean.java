package com.jose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsuarioBean implements Serializable {

    private List<Usuario> usuarioList = new ArrayList<>();

    public List<Usuario> getUsuarioList() {
        return UsuarioDAO.usuarios();
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
}
