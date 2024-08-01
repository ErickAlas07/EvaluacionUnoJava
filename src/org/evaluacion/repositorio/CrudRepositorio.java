package org.evaluacion.repositorio;

import java.util.List;

public interface CrudRepositorio<T> {
    void crear(T t);
    void editar(T t);
    void eliminar(String nombre);
    List<T> listar();
}
