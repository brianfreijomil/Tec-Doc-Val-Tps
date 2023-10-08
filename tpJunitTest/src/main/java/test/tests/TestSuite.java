package test.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UsuarioTest.class,
        AlmacenTest.class,
        RecetaTest.class,
        PedidoTest.class,
        StockTest.class,
})
public class TestSuite {
}
