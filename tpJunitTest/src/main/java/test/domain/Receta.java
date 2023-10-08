package test.domain;
import test.domain.Ingrediente;
import test.domain.ItemReceta;
import test.exceptions.FaltanteDeIngredientesException;

import java.util.ArrayList;
import java.util.List;

public class Receta {
	List<ItemReceta> ingredientes;
	String nombreInterno;
	int tiempoDeCoccion;
	private float precioVenta;
	private String receta;

	public Receta( String nombreInterno, int tiempoDeCoccion, float precioVenta, String receta) {
		super();
		this.ingredientes = new ArrayList<ItemReceta>();
		this.nombreInterno = nombreInterno;
		this.tiempoDeCoccion = tiempoDeCoccion;
		this.precioVenta = precioVenta;
		this.receta = receta;
	}
	
	public List<ItemReceta> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<ItemReceta> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
	public String getNombreInterno() {
		return nombreInterno;
	}
	public void setNombreInterno(String nombreInterno) {
		this.nombreInterno = nombreInterno;
	}
	public int getTiempoDeCoccion() {
		return tiempoDeCoccion;
	}
	public void setTiempoDeCoccion(int tiempoDeCoccion) {
		this.tiempoDeCoccion = tiempoDeCoccion;
	}
	public void addIngrediente(ItemReceta i) {
		
		ingredientes.add(i);
	}
	
	public void addIngrediente(Ingrediente ingrediente, int cantidad ) {
		ItemReceta item=new ItemReceta(ingrediente, cantidad);
		ingredientes.add(item);
	}
	
	public float calcularCosto() {
		float total = 0;
		
		for (ItemReceta item : ingredientes) {
			total += (item.getCantidad()) * (item.getIngrediente().getPrecioCompra());
		}
		
		return total;
	}

	public void chequearFaltanteIngredientes() throws FaltanteDeIngredientesException {
		//segun las palabras de receta verifico si se condicen con los items del arr ingredientes
		//no se me ocurre otra forma
		for (ItemReceta item : ingredientes) {
			String ingrediente = item.ingrediente.getNombre();
			int cantIngredientes = receta.split("\\s+|\n").length;
			if (cantIngredientes != ingredientes.size()) throw new FaltanteDeIngredientesException(nombreInterno);
			if (receta.contains(ingrediente) == false) throw new FaltanteDeIngredientesException(nombreInterno);
		}
	}

	public float getPrecioVenta() {
		return this.precioVenta;
	}

	public int getCantIngredientesReceta() {
		return receta.split("\\s+|\n").length;
	}

	@Override
	public String toString() {
		return nombreInterno;
	}

	public String getReceta() {
		return receta;
	}
}
