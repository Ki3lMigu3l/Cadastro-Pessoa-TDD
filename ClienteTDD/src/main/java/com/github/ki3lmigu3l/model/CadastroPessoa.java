package com.github.ki3lmigu3l.model;

import com.github.ki3lmigu3l.exception.CadastroVazioException;
import com.github.ki3lmigu3l.exception.PessoaSemNomeException;

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
        if (pessoa.getNome() == null) {
            throw new PessoaSemNomeException();
        }
        this.pessoas.add(pessoa);
    }

    public void remover(Pessoa pessoa) {
        if (!pessoas.contains(pessoa)) {
            throw new CadastroVazioException();
        }
        this.pessoas.remove(pessoa);
    }
}
