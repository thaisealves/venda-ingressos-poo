public class Funcionario extends Pessoa {
    private String matricula;

    public Funcionario(String nome, String email, String telefone, String matricula) {
        super(nome, email, telefone);
        this.matricula = matricula;
    }

    public String getmatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String getIdentificador() {
        return matricula;
    }
    
}
