package com.taida.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taida.api.dao.ProductoDao;
import com.taida.api.entity.Producto;

@Service
public class ProductoServiceImpl implements ProductoService{

	
	@Autowired
	private ProductoDao productoDao;
	
	@Override
	@Transactional
	public Producto registro(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto busquedaPorId(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	public Producto eliminar(Long id) {
		Producto clienteBorrado = productoDao.findById(id).orElse(null);
		productoDao.deleteById(id);
		
		return clienteBorrado;
	}

	@Override
	public boolean activo(Long id) {
	    boolean sol = false;
	    Optional <Producto> productoOptional = productoDao.findById(id);
	    if (productoOptional.isPresent()) {
	        sol = true;
	    }
	    return sol;
	}

	@Override
	public List<Producto> buscarTodos() {
		
		return (List<Producto>) productoDao.findAll();
	}
}
