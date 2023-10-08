package test.exceptions;

public class FaltanteDeIngredientesException extends Exception {

    private String receta;

    public FaltanteDeIngredientesException(String receta) {
        this.receta=receta;
    }

    public String toString() { return "La receta: "+receta+" no contiene todos los ingredientes necesarios";}
}
