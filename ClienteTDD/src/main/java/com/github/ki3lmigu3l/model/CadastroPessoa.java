package com.github.ki3lmigu3l.model;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoa {
    private List<Pessoa> pessoas;

    public CadastroPessoa() {
        this.pessoas = new ArrayList<>();
    }

    public List<Pessoa> getPessoa() {
        return this.pessoas;
    }

    public void adicionar(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }
}
