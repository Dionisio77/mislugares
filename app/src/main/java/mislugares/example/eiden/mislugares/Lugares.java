package mislugares.example.eiden.mislugares;

/**
 * Created by Eiden on 30/12/2017.
 */

public interface Lugares {
    Lugar elemento(int id);
    void anyade(Lugar lugar);
    int nuevo();
    void borrar(int id);
    int tamanyo();
    void actualiza(int id, Lugar lugar);
}
