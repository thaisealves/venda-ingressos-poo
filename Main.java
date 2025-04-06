public class Main {
    public static void main(String[] args) {
        // Criando repositórios
        Repositorio<Funcionario> repositorioFuncionarios = new Repositorio<>();
        Repositorio<Evento> repositorioEventos = new Repositorio<>();
        Repositorio<Venda> repositorioVendas = new Repositorio<>();
        Repositorio<Cliente> repositorioClientes = new Repositorio<>();

        // Criando funcionários
        Funcionario funcionario1 = new Funcionario("Maria", "maria@email.com", "9876-5432", "MAT-001");
        Funcionario funcionario2 = new Funcionario("Carlos", "carlos@email.com", "1234-5678", "MAT-002");

        // Adicionando funcionários ao repositório
        repositorioFuncionarios.adicionar(funcionario1);
        repositorioFuncionarios.adicionar(funcionario2);

        // Listando funcionários
        System.out.println("\nLista de Funcionários:");
        for (Funcionario funcionario : repositorioFuncionarios.listar()) {
            System.out.println("Nome: " + funcionario.getNome() + ", Matrícula: " + funcionario.getIdentificador());
        }

        // Removendo um funcionário
        repositorioFuncionarios.remover(funcionario1); // Removendo o funcionário 1 não vai aparecer na busca e vai
                                                       // entrar no erro

        // Listando funcionários após remoção
        System.out.println("\nLista de Funcionários após remoção:");
        for (Funcionario funcionario : repositorioFuncionarios.listar()) {
            System.out.println("Nome: " + funcionario.getNome() + ", Matrícula: " + funcionario.getIdentificador());
        }

        // Criando clientes
        Cliente cliente1 = new Cliente("João", "joao@email.com", "1234-5678", "123.456.789-00");
        Cliente cliente2 = new Cliente("Ana", "ana@email.com", "8765-4321", "987.654.321-00");

        repositorioClientes.adicionar(cliente1);
        repositorioClientes.adicionar(cliente2);

        // Funcionário 1 cadastra eventos
        Evento evento1 = new Evento("Show de Rock", "2025-04-10", "Estádio");
        Evento evento2 = new Evento("Teatro Musical", "2025-05-15", "Teatro Municipal");

        funcionario1.cadastrarEvento(evento1, repositorioEventos);
        funcionario1.cadastrarEvento(evento2, repositorioEventos);

        // Listando eventos cadastrados
        System.out.println("\nEventos cadastrados:");
        for (Evento evento : repositorioEventos.listar()) {
            System.out.println(
                    "Evento: " + evento.getNome() + ", Data: " + evento.getData() + ", Local: " + evento.getLocal());
        }

        // Funcionário 2 registra vendas para o evento 1
        funcionario2.registrarVenda(evento1, cliente1, repositorioVendas, 150.00);
        funcionario2.registrarVenda(evento1, cliente2, repositorioVendas, 200.00);

        // Listando vendas realizadas
        System.out.println("\nVendas realizadas:");
        for (Venda venda : repositorioVendas.listar()) {
            System.out.println("Cliente: " + venda.getCliente().getNome() + ", Evento: "
                    + venda.getIngresso().getEvento().getNome() + ", Valor: R$ " + venda.getIngresso().getPreco());
        }

        // Funcionário 1 remove o evento 2
        funcionario1.removerEvento(evento2, repositorioEventos);

        // Listando eventos após remoção
        System.out.println("\nEventos após remoção:");
        for (Evento evento : repositorioEventos.listar()) {
            System.out.println(
                    "Evento: " + evento.getNome() + ", Data: " + evento.getData() + ", Local: " + evento.getLocal());
        }

        // Exibindo informações do evento 1 após as vendas
        System.out.println("\nInformações do Evento 1:");
        System.out.println("Nome do Evento: " + evento1.getNome());
        System.out.println("Data do Evento: " + evento1.getData());
        System.out.println("Local do Evento: " + evento1.getLocal());
        System.out.println("Capacidade Total: " + evento1.getCapacidade());
        System.out.println("Ingressos Vendidos: " + evento1.getIngressosComprados().size());
        System.out.println("Ingressos Disponíveis: " + evento1.ingressosDisponiveis());
        System.out.println("Receita Total: R$ " + evento1.calcularReceita());

        System.out.println("\n\nBuscando informações:");
        // Buscando cliente pelo CPF
        Cliente clienteBuscado = repositorioClientes.buscar("123.456.789-00");
        if (clienteBuscado != null) {
            System.out.println("Cliente encontrado: " + clienteBuscado.getNome());
        } else {
            System.out.println("Cliente não encontrado.");
        }

        // Buscando funcionário pela matrícula
        Funcionario funcionarioBuscado = repositorioFuncionarios.buscar("MAT-001");
        if (funcionarioBuscado != null) {
            System.out.println("Funcionário encontrado: " + funcionarioBuscado.getNome());
        } else {
            System.out.println("Funcionário não encontrado.");
        }

        // Buscando evento pelo id
        Evento eventoBuscado = repositorioEventos.buscar("1");
        if (eventoBuscado != null) {
            System.out.println("Evento encontrado: " + eventoBuscado.getNome());
        } else {
            System.out.println("Evento não encontrado.");
        }
    }
}