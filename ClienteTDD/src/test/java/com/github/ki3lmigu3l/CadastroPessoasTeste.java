package com.github.ki3lmigu3l;

import com.github.ki3lmigu3l.model.CadastroPessoa;

import com.github.ki3lmigu3l.model.Pessoa;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CadastroPessoasTeste {

    @Test
    public void deveCriarCadastroDePessoa() {
        CadastroPessoa cadastro = new CadastroPessoa();
        Assertions.assertThat(cadastro.getPessoa()).isEmpty();
    }

    @Test
    public void deveAdicionarUmaPessoa() {
        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();
        cadastroPessoa.adicionar(pessoa);

        Assertions.assertThat(cadastroPessoa.getPessoa())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test
    public void naoDeveAdicionarPessoaComNomeVazio () {
        
    }
}
