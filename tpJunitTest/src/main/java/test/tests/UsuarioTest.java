package test.tests;

import org.junit.*;
import test.domain.Usuario;
import test.exceptions.CorreoElectronicoInvalidoException;

import java.util.ArrayList;
import java.util.Random;

public class UsuarioTest {

    static ArrayList<Usuario> usuarios;


    @BeforeClass
    public static void cargarUsuarios() throws Exception{

        Usuario u1 =new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
        Usuario u2 =new Usuario("Barney Gomez", 0, 0, "el14gomez@springfield.com");
        Usuario u3 =new Usuario("Edna Krabappel", 1, 0, "ednak@springfield.com");
        Usuario u4 =new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");

        usuarios = new ArrayList<>();

        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        usuarios.add(u4);
    }

    //TESTEOS:
    //a. Se pueden agregar usuarios repetidos
    //b. No se puede crear un usuario con un correo electrónico inválido (contiene @)

    @BeforeClass
    public static void tearDownBeforeClass() throws Exception {
        System.out.println("---inicia UsuarioTest---");
    }
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("---finaliza UsuarioTest---");
    }

    @Test
    public void testAgregarUsuario() { //agrego un usuario
        int cantUsuariosBefore = usuarios.size();
        usuarios.add(new Usuario("Lionel Messi", 1, 1000, "lionelmessi@gmail.com"));
        int cantUsuariosAfter = usuarios.size();
        Assert.assertEquals(cantUsuariosBefore+1,cantUsuariosAfter);
    }

    @Test
    public void testAgregarUsuarioRepetido() { //agreo un usuario que ya existe
        Usuario ur = new Usuario("Lionel Messi", 1, 1000, "lionelmessi@gmail.com");
        usuarios.add(ur);
        Usuario uGuardado = usuarios.get(4); //en la posicion 4 esta el primer messi agreado
        //si los comparo como objetos no son lo mismo por la posicion en memoria, peor tienen los mimsos datos
        Assert.assertEquals("No se recibio la misma persona que se esperaba",ur.toString(),uGuardado.toString());
    }

    @Test
    public void testCrearUnUsuarioConEmail_Valido() {
        String usuarioEmail = "pepe@Sandgmail.com";
        Integer posicionCaracter = usuarioEmail.indexOf("@");
        boolean state = posicionCaracter>=0;
        Assert.assertTrue("el correo electronico debe contener -> @ ",state);
        Usuario uprueba = new Usuario("Pepe Sand", 0, 250, usuarioEmail);
    }

    @Test
    public void testCrearUnUsuarioConEmail_Invalido() {
        String usuarioEmail = "pepeSandgmail.com";
        Integer posicionCaracter = usuarioEmail.indexOf("@");
        boolean state = posicionCaracter>=0;
        Assert.assertTrue("el correo electronico debe contener -> @ ",state);
        //preguntar si esta bien esto
        Usuario uprueba = new Usuario("Pepe Mujica", 1, 300, usuarioEmail);
    }

}
