//classe abstrata Pessoa
//generalização de Cliente e Funcionario
public abstract class Pessoa implements IIdentificavel {
    private String nome;
    private String email;
    private String telefone;

    public Pessoa(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isValidEmail() {
        return email != null && email.contains("@") && email.contains(".");
    }

    public void removerPessoa() {
        System.out.println("Pessoa removida com sucesso.");
    }

    public abstract String getIdentificador(); // utilizado polimorfismo, em cliente retorna CPF e em funcionario
                                               // retorna matricula

}
