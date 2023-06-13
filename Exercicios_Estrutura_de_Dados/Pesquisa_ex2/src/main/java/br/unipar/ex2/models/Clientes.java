package br.unipar.ex2.models;

/**
 *
 * @author Laryssa
 */
public class Clientes {
    
    private int codigo;
    private String nome;
    private String dtNascimento;
    private String cpf;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cadastro{" + "codigo=" + codigo + ", nome=" + nome + ", dtNascimento=" + dtNascimento + ", cpf=" + cpf + '}';
    }
}
