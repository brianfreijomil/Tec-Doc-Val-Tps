package test.tests;

import org.junit.*;
import org.junit.jupiter.api.RepeatedTest;
import test.domain.*;
import test.exceptions.FaltanteDeIngredientesException;

import java.util.ArrayList;
import java.util.Random;

public class RecetaTest {

    static Receta recetaDePrueba;
    static ArrayList<Receta> recetas;

    //c. Una receta está compuesta por uno o más ingredientes

    @BeforeClass
    public static void cargarDatos() throws Exception {

        //alta d ingredientes
        Ingrediente huevo=new Ingrediente("Huevo", "unidades",240, 2400);
        Ingrediente harina=new Ingrediente("harina", "gramos",10000,5000);
        Ingrediente papa = new Ingrediente("Papa","gramos",20000,5000);
        Ingrediente sal = new Ingrediente("Sal","gramos",1000,2000);
        Ingrediente carnePicada = new Ingrediente("Carnepicada","grmos",10000,20000);
        Ingrediente panHamburguesa = new Ingrediente("PandeHamburguesa","unidades",100,20000);
        Producto gaseosaCola = new ProductoBasico("Coca Cola", 10,20);
        Producto agua = new ProductoBasico("Agua",10,22);

        //alta de items
        ItemReceta ir1= new ItemReceta(huevo,1);
        ItemReceta ir2 = new ItemReceta(carnePicada, 100);
        ItemReceta ir3 =new ItemReceta(sal, 20);
        ItemReceta ir4 = new ItemReceta(huevo,4);
        ItemReceta ir5 = new ItemReceta(papa, 3);
        ItemReceta ir6 = new ItemReceta(panHamburguesa, 1);

        //alta de recetas
        Receta tortilla=new Receta("Tortilla",15,1000, "Huevo Papa");
        tortilla.addIngrediente(ir4);
        tortilla.addIngrediente(ir5);

        Receta hamburguesa = new Receta("hamburguesa grande",5,2000, "Carnepicada Huevo Sal PandeHamburguesa");
        hamburguesa.addIngrediente(ir2);
        hamburguesa.addIngrediente(ir1);
        hamburguesa.addIngrediente(ir3);
        hamburguesa.addIngrediente(ir6);

        Receta papasFritas = new Receta("papas fritas",7,850, "Papa Sal");
        papasFritas.addIngrediente(ir5);
        //papasFritas.addIngrediente(ir3);

        recetas=new ArrayList<>();

        recetas.add(tortilla);
        recetas.add(hamburguesa);
        recetas.add(papasFritas);
    }

    @BeforeClass
    public static void tearDownBeforeClass() throws Exception {
        System.out.println("---inicia RecetaTest---");
    }
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("---finaliza RecetaTest---");
    }

    //genero una receta al azar para el test
    @Before
    public void elegirUnaRecetaAlAzar() throws Exception {
        Random generadorAleatorios = new Random();
        int numeroAleatorio = generadorAleatorios.nextInt(RecetaTest.recetas.size());
        recetaDePrueba = recetas.get(numeroAleatorio);
    }
    @Test
    public void testComprobarMinimoIngredientesReceta() {
        long cantIngredientes = recetaDePrueba.getIngredientes().size();
        boolean state=(cantIngredientes>=1);
        Assert.assertTrue("Las recetas deben tener minimo 1 ingrediente y esta no tiene ninguno: "+recetaDePrueba,state);
    }

    //f. No es posible realizar una receta si no se cuenta con todos los ingredientes

    //opciones
    // 1) agregar un atributo a receta que describa sus ingredientes y
    //  despues chequear con ese atributo y los items en el arr de la receta
    // 2) verificar con el arreglo sabiendo cuales son (no tiene mucho sentido?)
    @Test
    public void testFaltanteIngredientesEnReceta() {
        for (Receta r: recetas) {
            try {
                r.chequearFaltanteIngredientes();
            } catch (FaltanteDeIngredientesException e) {
                throw new RuntimeException(e);
            }
        }
        //another way
        /*
        int cantIngrReal = recetaDePrueba.getIngredientes().size();
        int cantIngredientes = recetaDePrueba.getCantIngredientesReceta();
        Assert.assertEquals("La cantidad de ingredientes de Receta.receta debe ser igual a la cantidad de Receta.ingredientes.size", cantIngredientes, cantIngrReal);
        if (cantIngredientes == cantIngrReal) {
            boolean ingredientesStatus = true;
            for (ItemReceta item : recetaDePrueba.getIngredientes()) {
                String ingrediente = item.getIngrediente().getNombre();
                ingredientesStatus = (recetaDePrueba.getReceta().contains(ingrediente));
                Assert.assertTrue("Faltan ingredientes En la Receta", ingredientesStatus);
            }
        }
        */
    }



}
