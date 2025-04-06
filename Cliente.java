//especializacao: cliente extende a classe Pessoa
public class Cliente extends Pessoa {
    private String cpf;

    public Cliente(String nome, String email, String telefone, String cpf) {
        super(nome, email, telefone);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getIdentificador() {
        return cpf;
    }
}
