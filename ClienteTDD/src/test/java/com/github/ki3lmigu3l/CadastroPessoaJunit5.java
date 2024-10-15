package com.github.ki3lmigu3l;

import com.github.ki3lmigu3l.exception.CadastroVazioException;
import com.github.ki3lmigu3l.exception.PessoaSemNomeException;
import com.github.ki3lmigu3l.model.CadastroPessoa;
import com.github.ki3lmigu3l.model.Pessoa;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CadastroPessoaJunit5 {

    @Test
    @DisplayName("Deve criar um cadastro de Pessoa")
    public void deveCriarCadastroDePessoa() {
        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Assertions.assertThat(cadastroPessoa.getPessoa()).isEmpty();
    }

    @Test
    @DisplayName("Adicionar uma pessoa")
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

    @Test
    @DisplayName("Não deve adicionar pessoa com o campo nome vazio")
    public void naoDeveAdicionarPessoaComNomeVazio () {
        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();
        org.junit.jupiter.api.Assertions.assertThrows(PessoaSemNomeException.class, () -> cadastroPessoa.adicionar(pessoa));
    }

    @Test
    @DisplayName("Deve remover uma pessoa")
    public void removerUmaPessoa() {
        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Ezequiel");
        cadastroPessoa.adicionar(pessoa);

        cadastroPessoa.remover(pessoa);
        Assertions.assertThat(cadastroPessoa.getPessoa()).isEmpty();
    }

    @Test
    @DisplayName("Lança uma exceção ao tenter remover uma pessoa inexistente")
    public void lancaExceptionAoTentarRemoverPessoaInexistente() {
        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();
        org.junit.jupiter.api.Assertions.assertThrows(CadastroVazioException.class, () -> cadastroPessoa.remover(pessoa));

    }
}
