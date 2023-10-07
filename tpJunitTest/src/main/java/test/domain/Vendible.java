package test.domain;

import test.exceptions.SinSuficientesIngredientesException;

public interface Vendible {
	public float getPrecioVenta();
	public void preparar() throws SinSuficientesIngredientesException;
}
