package com.taida.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taida.api.entity.Producto;

@Repository
public interface ProductoDao extends CrudRepository<Producto, Long>{

}
