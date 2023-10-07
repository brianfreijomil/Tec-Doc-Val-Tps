package test.tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import test.domain.*;
import test.exceptions.SinSaldoException;

public class PedidoTest {

    static Usuario usuarioPrueba;
    static Pedido p;

    @BeforeClass
    public static void loadData() {

        //alta d ingredientes
        Ingrediente huevo=new Ingrediente("huevo", "unidades",240, 2400);
        Ingrediente harina=new Ingrediente("harina", "gramos",10000,5000);
        Ingrediente papa = new Ingrediente("Papa","gramos",20000,5000);
        Ingrediente sal = new Ingrediente("Sal","gramos",1000,2000);
        Ingrediente carnePicada = new Ingrediente("Carne picada","grmos",10000,20000);
        Ingrediente panHamburguesa = new Ingrediente("Pan de Hamburguesa","unidades",100,20000);
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
        Receta tortilla=new Receta("Tortilla",15,1000);
        tortilla.addIngrediente(ir4);
        tortilla.addIngrediente(ir5);

        Receta hamburguesa = new Receta("hamburguesa grande",5,2000);
        hamburguesa.addIngrediente(ir2);
        hamburguesa.addIngrediente(ir1);
        hamburguesa.addIngrediente(ir3);
        hamburguesa.addIngrediente(ir6);

        Receta papasFritas = new Receta("papas fritas",7,850);
        papasFritas.addIngrediente(ir5);
        papasFritas.addIngrediente(ir3);

        //alta de productos
        Producto p1= new ProductoBasico("Lata Coca Cola", 10, 20);
        Producto p2= new ProductoBasico("Lata Sprite", 10, 22);
        Producto p3= new ProductoElaborado("Retorti", 120);
        ((ProductoElaborado)p3).setReceta(tortilla);
        Producto p4= new ProductoElaborado("BIG O", 150);
        ((ProductoElaborado)p4).setReceta(hamburguesa);
        Producto p5= new ProductoElaborado("PATATAS", 120);
        ((ProductoElaborado)p3).setReceta(papasFritas);

        usuarioPrueba = new Usuario("Homero", 0, 100, "homerojsimpson@springfield.com");

        //alta de un pedido
        p = new Pedido();
        p.setUsuario(usuarioPrueba);
        p.agregarItem(new ItemPedido(1,p1));
        p.agregarItem(new ItemPedido(1, p3));

    }

    @BeforeClass
    public static void tearDownBeforeClass() throws Exception {
        System.out.println("---inicia PedidoTest---");
    }
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("---finaliza PedidoTest---");
    }

    //d. Un pedido reduce en saldo de un usuario
    @Test
    public void testPedidoReduceSaldoUsuario() throws SinSaldoException {
        float saldoInicial = usuarioPrueba.getSaldo();
        try {
            p.solicitarPedido();
            p.prepararPedido();
            p.terminarPedido();
            p.entregarPedido();
        } catch (SinSaldoException ex) { //chequeo saldo de usuario para realizar pago
            System.out.println("No posee saldo suficiente");
        }
        boolean state = saldoInicial > usuarioPrueba.getSaldo();
        //chequeo reduccion de saldo
        Assert.assertTrue("El saldo del usuario no se redujo", state);
    }

}
