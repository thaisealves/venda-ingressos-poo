//especialização: Funcionario extende Pessoa
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

    public void cadastrarEvento(Evento evento, Repositorio<Evento> repositorio) {
        if (repositorio != null) {
            repositorio.adicionar(evento);
        } else {
            System.out.println("Erro ao cadastrar evento: repositório inválido.");
        }
    }

    public void removerEvento(Evento evento, Repositorio<Evento> repositorio) {
        if (repositorio != null) {
            repositorio.remover(evento);
        } else {
            System.out.println("Erro ao remover evento: repositório inválido.");
        }
    }

    public void registrarVenda(Evento evento, Cliente cliente, Repositorio<Venda> repositorio, double valor) {
        if (evento == null || cliente == null) {
            System.out.println("Erro ao registrar venda: evento ou cliente inválido.");
            return;
        }
        if (repositorio != null) {
            Ingresso ingresso = new Ingresso(evento, cliente, this, valor);
            Venda venda = new Venda(cliente, this, ingresso);
            repositorio.adicionar(venda);
            venda.venderIngresso();
        } else {
            System.out.println("Erro ao registrar venda: repositório inválido.");
        }

    }

    @Override
    public String getIdentificador() {
        return matricula;
    }

}
