package sample.handlers;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NumeroTest {

    @Test
    public void testCreate() {
        Numero nu1 = Numero.createNumero(1);
        assertNotNull(nu1);
        assertThat(nu1.toInt(), is(1));
    }

    @Test
    public void testAdd() {
        Numero nu1 = Numero.createNumero(1);
        Numero nu3 = Numero.createNumero(3);
        Numero nu4 = nu1.add(nu3);
        assertThat(nu4.toInt(), is(4));
    }

}
