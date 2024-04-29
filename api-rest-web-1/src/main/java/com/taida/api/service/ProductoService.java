package com.taida.api.service;

import java.util.List;

import com.taida.api.entity.Producto;

public interface ProductoService {
	public List<Producto>buscarTodos();
	//metodo registrar un producto
	public Producto registro (Producto producto);
	//metodo buscar un producto
	public Producto busquedaPorId(Long id);
	//metodo para eliminar
	public Producto eliminar(Long id);
	
	public boolean activo(Long id);
}
