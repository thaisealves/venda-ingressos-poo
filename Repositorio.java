import java.util.ArrayList;
import java.util.List;

//classe genérica
public class Repositorio<T> {
    private List<T> lista;

    public Repositorio() {
        this.lista = new ArrayList<>();
    }

    //metodo generico
    public void adicionar(T item) {
        lista.add(item);
    }

    // sobrecarga do método adicionar para permitir a adição de uma lista de itens
    public void adicionar(List<T> itens) {
        lista.addAll(itens);
    }

    public void remover(T item) {
        lista.remove(item);
    }

    public List<T> listar() {
        return lista;
    }

    public T buscar(String identificador) {
        for (T item : lista) {
            if (item instanceof IIdentificavel) {
                IIdentificavel identificavel = (IIdentificavel) item;
                if (identificavel.getIdentificador().equals(identificador)) {
                    return item;
                }
            }
        }
        return null;
    }

}
