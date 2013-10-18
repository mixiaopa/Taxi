package OO;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TaxiTest {

    private Taxi taxi;

    @Before
    public void setUp() throws Exception {
        taxi = new Taxi();
    }

    @org.junit.Test
    public void shouldCharge6WhenDistanceIs1() throws Exception {
        assertEquals(6, taxi.getFee(1, 0), 0.1);
    }

    @Test
    public void shouldCharge6WhenDistanceIs2() throws Exception {
        assertEquals(6, taxi.getFee(2, 0), 0.1);
    }

    @Test
    public void shouldChargeMoreThan6WhenDistanceMoreThan2() throws Exception {
        assertThat(taxi.getFee(2.1, 0) - 6 > 0, is(true));
    }

    @Test
    public void shouldCharge10WhenDistanceIs7() throws Exception {
        assertEquals(10.0, taxi.getFee(7, 0), 0.1);
    }

    @Test
    public void shouldCharge10p8WhenDistanceIs8() throws Exception {
        assertEquals(10.8, taxi.getFee(8, 0), 0.000001);
    }

    @Test
    public void shouldCharge12WhenDistanceIs9() throws Exception {
        assertEquals(12, taxi.getFee(9, 0), 0.000001);
    }

    @Test
    public void shouldCharge13p2WhenDistanceIs10() throws Exception {
        assertEquals(13.2, taxi.getFee(10, 0), 0.000001);
    }

    @Test
    public void shouldCharge6p25WhenDistanceIs1AndStopTimeIs1() throws Exception {
        double fee = taxi.getFee(1, 1);
        assertEquals(6.25, fee, 0.0000001);
    }

    @Test
    public void shouldCharge6p5WhenDistanceIs1AndStopTimeIs2() throws Exception {
        assertEquals(6.5, taxi.getFee(1, 2), 0.0000001);
        assertEquals(6, taxi.getFee(1, 0), 0.0000001);
    }

    @Test
    public void shouldCharge7AtLastWhenDistanceIs1AndStopTimeIs5() throws Exception {
        assertEquals("7", taxi.getFinalCharge(1, 5));
    }

    @Test
    public void shouldCharge6AtLastWhenDistanceIs1AndStopTimeIs1() throws Exception {
        assertEquals("6", taxi.getFinalCharge(1, 1));
    }

    @Test
    public void shouldSet7p5MilesAs8() throws Exception {
        assertEquals(8, taxi.convertMilesToInteger(7.5), 0.000001);
    }

    @Test
    public void shouldSet6p1MilesAs7() throws Exception {
        assertEquals(7, taxi.convertMilesToInteger(6.1), 0.000001);
    }
}
