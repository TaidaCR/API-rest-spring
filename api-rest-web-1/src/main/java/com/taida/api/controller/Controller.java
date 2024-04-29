package com.taida.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taida.api.entity.Cliente;
import com.taida.api.entity.Producto;
import com.taida.api.service.ClienteService;
import com.taida.api.service.ProductoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "**")
public class Controller {
	
	@Autowired
	private ClienteService servicio;
	
	
	//metodo get que devuelve todos los clientes
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return servicio.buscarTodos();
	}
	
	//metodo get que devuelve un solo registro dado el id
	@GetMapping("/clientes/{id}") 
	public Cliente show(@PathVariable Long id){
		return servicio.buscarPorId(id);
	}
	
	//metodo post para guardar un nuevo cliente
	@PostMapping("/clientes")
	public Cliente create(@RequestBody Cliente cliente) {
		return servicio.guardar(cliente);
	}
	
	//metodo put para actualizar un registro de cliente existente
	@PutMapping("/clientes/{id}")
	public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente clienteUpdate = servicio.buscarPorId(id);
		clienteUpdate.setNombre(cliente.getNombre());
		clienteUpdate.setApellido(cliente.getApellido());
		clienteUpdate.setEmail(cliente.getEmail());
		clienteUpdate.setTelefono(cliente.getTelefono());
		clienteUpdate.setCreatedAt(cliente.getCreatedAt());
		
		return servicio.guardar(clienteUpdate);
	}
	
	//metodo delete para borrar
	@DeleteMapping("/clientes/{id}")
	public Cliente delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
	
	@Autowired
	private ProductoService servicioProd;
	
	@PostMapping("/productos")
	public Producto registrar(@RequestBody Producto producto){
		return servicioProd.registro(producto);
	}
	
	@PutMapping("/productosAct")
	public Producto actualizar(@RequestBody Producto producto, @PathVariable Long id) {
		Producto productoActualizar = servicioProd.busquedaPorId(id);
		productoActualizar.setCategoria(producto.getCategoria());
		productoActualizar.setNombre(producto.getNombre());
		productoActualizar.setTipo(producto.getTipo());
		productoActualizar.setDescripcion(producto.getDescripcion());
		productoActualizar.setPrecio_compra(producto.getPrecio_compra());
		productoActualizar.setPrecio_venta(producto.getPrecio_compra());
		productoActualizar.setActivo(producto.getActivo());
		
		return servicioProd.registro(producto);
	}
	
	@GetMapping("/productos/{id}")
	public Producto buscarPorId(@PathVariable Long id) {
		return servicioProd.busquedaPorId(id);
	}
	
	@DeleteMapping("/productos/{id}")
	public Producto deleteProd(@PathVariable Long id) {
		return servicioProd.eliminar(id);
	}
	
	@GetMapping("/productosActivos")
	public boolean devolverActivo(@PathVariable Long id) {
		return servicioProd.activo(id);
	}
	
	@GetMapping("/productos")
	public List<Producto> getTodos() {
		return servicioProd.buscarTodos();
	}
	
}
