package com.github.ki3lmigu3l;

import com.github.ki3lmigu3l.exception.CadastroVazioException;
import com.github.ki3lmigu3l.exception.PessoaSemNomeException;
import com.github.ki3lmigu3l.model.CadastroPessoa;

import com.github.ki3lmigu3l.model.Pessoa;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CadastroPessoasTeste {

    @Test
    public void deveCriarCadastroDePessoa() {
        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Assertions.assertThat(cadastroPessoa.getPessoa()).isEmpty();
    }

    @Test
    public void deveAdicionarUmaPessoa() {
        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Ezequiel");
        cadastroPessoa.adicionar(pessoa);

        Assertions.assertThat(cadastroPessoa.getPessoa())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test(expected = PessoaSemNomeException.class)
    public void naoDeveAdicionarPessoaComNomeVazio () {
        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();
        cadastroPessoa.adicionar(pessoa);
    }

    @Test
    public void removerUmaPessoa() {
        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Ezequiel");
        cadastroPessoa.adicionar(pessoa);

        cadastroPessoa.remover(pessoa);
        Assertions.assertThat(cadastroPessoa.getPessoa()).isEmpty();
    }

    @Test(expected = CadastroVazioException.class)
    public void lancaExceptionAoTentarRemoverPessoaInexistente() {
        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();
        cadastroPessoa.remover(pessoa);
    }
}
