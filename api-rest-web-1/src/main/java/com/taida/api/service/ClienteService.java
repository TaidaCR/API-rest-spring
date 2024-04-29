package com.taida.api.service;

import java.util.List;

import com.taida.api.entity.Cliente;

public interface ClienteService {
	//metodo para devolver los registros
	public List<Cliente> buscarTodos();
	//metodo para buscar un registro por id
	public Cliente buscarPorId(Long id);
	//metodo para registro
	public Cliente guardar(Cliente cliente);
	//metodo para eliminar
	public Cliente delete(Long id);
}
