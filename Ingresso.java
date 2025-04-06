import java.util.Date;

public class Ingresso implements IIdentificavel {
    private int id;
    private Evento evento;
    private Cliente cliente;
    private Funcionario funcionario;
    private Date dataCompra;
    private double preco;

    // atributo estático para gerar IDs únicos
    static int proximoId = 1;

    public Ingresso(Evento evento, Cliente cliente, Funcionario funcionario, double preco) {
        this.id = proximoId++;
        this.evento = evento;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.dataCompra = new Date();
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String getIdentificador() {
        return String.valueOf(id); // Converte o ID (int) para String, cada getIdentificador tem um retorno
                                   // diferente
    }
}
