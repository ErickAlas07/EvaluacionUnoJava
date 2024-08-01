package org.evaluacion.repositorio;

import org.evaluacion.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class ListRepositorio<T extends Producto> implements CrudRepositorio<T> {
    protected List<T> dataSource;

    public ListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public void crear(T t) {
        dataSource.add(t);
    }

    @Override
    public void editar(T t) {
        eliminar(t.getNombre());
        crear(t);
    }

    @Override
    public void eliminar(String nombre) {
        dataSource.removeIf(t -> t.getNombre().equals(nombre));
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }
}
