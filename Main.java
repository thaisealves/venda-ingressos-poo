public class Main {
    public static void main(String[] args) {
        // Criando um evento
        Evento evento = new Evento("Show de Rock", "2025-04-10", "Estádio");
        evento.setCapacidade(100); // Definindo a capacidade do evento

        // Criando cliente e funcionário
        Cliente cliente = new Cliente("João", "joao@email.com", "1234-5678", "123.456.789-00");
        Funcionario funcionario = new Funcionario("Maria", "maria@email.com", "9876-5432", "MAT-001");
        // ^- funionario responsável por cadastrar os ingressos e gerenciar vendas

        // Criando ingressos
        Ingresso ingresso1 = new Ingresso(evento, cliente, funcionario, 150.00);
        Ingresso ingresso2 = new Ingresso(evento, cliente, funcionario, 150.00);

        // Realizando vendas
        Venda venda1 = new Venda(cliente, funcionario, ingresso1);
        venda1.venderIngresso();

        Venda venda2 = new Venda(cliente, funcionario, ingresso2);
        venda2.venderIngresso();

        // Exibindo informações do evento após as vendas
        System.out.println("\nInformações do Evento:");
        System.out.println("Nome do Evento: " + evento.getNome());
        System.out.println("Data do Evento: " + evento.getData());
        System.out.println("Local do Evento: " + evento.getLocal());
        System.out.println("Capacidade Total: " + evento.getCapacidade());
        System.out.println("Ingressos Vendidos: " + evento.getIngressosComprados().size());
        System.out.println("Ingressos Disponíveis: " + evento.ingressosDisponiveis());
        System.out.println("Receita Total: R$ " + evento.calcularReceita());
    }
}