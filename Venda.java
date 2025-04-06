public class Venda {

    // Encapsulamento com atributos privados e metodos publicos para acesso

    // agregação: venda usa cliente e funcionario mas nao é dono deles
    private Cliente cliente; // Associação: venda associada a um cliente
    private Funcionario funcionario; // Associação: venda associada a um funcionário
    private Ingresso ingresso; // Associação: venda associada a um ingresso

    // intanciação: contstrutor para criar um objeto Venda
    public Venda(Cliente cliente, Funcionario funcionario, Ingresso ingresso) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.ingresso = ingresso;
    }

    // Método para realizar a venda do ingresso
    public void venderIngresso() {
        // Atualiza os ingressos comprados no evento associado ao ingresso
        ingresso.getEvento().adicionarIngresso(ingresso);

        // Exibe informações da venda
        System.out.println("Venda realizada com sucesso!");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Funcionário: " + funcionario.getNome());
        System.out.println("Ingresso ID: " + ingresso.getId());
        System.out.println("Data da venda: " + ingresso.getDataCompra());
        System.out.println("Evento: " + ingresso.getEvento().getNome());
        System.out.println("Ingressos disponíveis no evento: " + ingresso.getEvento().ingressosDisponiveis() + "\n");
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

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }
}