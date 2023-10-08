package test.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StockTest {

    @BeforeClass
    public static void loadData() {

    }

    @BeforeClass
    public static void tearDownBeforeClass() throws Exception {
        System.out.println("---inicia StockTest---");
    }
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("---finaliza StockTest---");
    }

    /*g. La reposición de stock aumenta el número de ítems disponibles.*/

    @Test
    public void testReposicionStock() {

    }
}
