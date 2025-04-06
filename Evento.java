import java.util.ArrayList;
import java.util.List;

public class Evento implements IAtualizarEstatistica {
    private String nome;
    private String data;
    private String local;
    private int id;
    static int proximoId = 1;
    private int capacidade;

    //coleções de ingressos comprados
    private List<Ingresso> ingressosComprados; // composição: evento dono de ingressos

    public Evento(String nome, String data, String local) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.id = proximoId++;
        this.capacidade = 100; //capacidade padrão caso eu nao quera definir
        this.ingressosComprados = new ArrayList<>();
    }

    //composição com a classe Ingresso
    //método para adicionar um ingresso à lista de ingressos comprados
    public void adicionarIngresso(Ingresso ingresso) {
        if (ingressosComprados.size() < capacidade) {
            ingressosComprados.add(ingresso);
        } else {
            System.out.println("Capacidade máxima atingida.");
        }
    }

    //método para remover um ingresso da lista de ingressos comprados
    //associação com a classe Ingresso
    public void removerIngresso(Ingresso ingresso) {
        ingressosComprados.remove(ingresso);
    }

    public List<Ingresso> getIngressosComprados() {
        return ingressosComprados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setIngressosComprados(List<Ingresso> ingressosComprados) {
        this.ingressosComprados = ingressosComprados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    //calculo da receita total do evento
    public double calcularReceita() {
        double receita = 0;
        for (Ingresso ingresso : ingressosComprados) {
            receita += ingresso.getPreco();
        }
        return receita;
    }

    //ingressos disponíveis no evento
    public int ingressosDisponiveis() {
        return capacidade - ingressosComprados.size();
    }

    //sobrescrita de método da interface IAtualizarEstatistica
    @Override
    public void atualizarEstatistica() {
        System.out.println("Atualizando estatísticas do evento: " + nome);
        System.out.println("Ingressos disponíveis: " + ingressosDisponiveis());
        System.out.println("Receita total: R$ " + calcularReceita());
    }

}
