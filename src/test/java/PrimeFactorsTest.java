import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PrimeFactorsTest {

    @Test
    public void getPrimeFactors() {
        PrimeFactors primeFactors = new PrimeFactors(1000);
        List<Set<Integer>> factors = primeFactors.getPrimeFactors();

        Set<Integer> primeFactorsOf = Set.of(2);
        assertEquals(primeFactorsOf, factors.get(2));
        assertEquals(primeFactorsOf, factors.get(4));

        primeFactorsOf = Set.of(2, 3);
        assertEquals(primeFactorsOf, factors.get(6));
        assertEquals(primeFactorsOf, factors.get(12));

        primeFactorsOf = Set.of(2, 5);
        assertEquals(primeFactorsOf, factors.get(10));
        assertEquals(primeFactorsOf, factors.get(100));

        primeFactorsOf = Set.of(2, 13);
        assertEquals(primeFactorsOf, factors.get(26));

        primeFactorsOf = Set.of(2, 5, 7);
        assertEquals(primeFactorsOf, factors.get(70));

        primeFactorsOf = Set.of(13, 7);
        assertEquals(primeFactorsOf, factors.get(91));

        primeFactorsOf = Set.of(2, 5, 53);
        assertEquals(primeFactorsOf, factors.get(530));

        primeFactorsOf = Set.of(7, 103);
        assertEquals(primeFactorsOf, factors.get(721));
    }

    @Test
    public void getAllPrimeFactors() {
        PrimeFactors primeFactors = new PrimeFactors(1000);
        List<List<Integer>> factors = primeFactors.getAllPrimeFactors();

        List<Integer> primeFactorsOf = List.of(2, 2, 2);
        assertEquals(primeFactorsOf, factors.get(8));

        primeFactorsOf = List.of(2, 2, 5);
        assertEquals(primeFactorsOf, factors.get(20));

        primeFactorsOf = List.of(2, 2, 2, 3);
        assertEquals(primeFactorsOf, factors.get(24));

        primeFactorsOf = List.of(2, 3, 5, 11);
        assertEquals(primeFactorsOf, factors.get(330));

        primeFactorsOf = List.of(2, 5, 7);
        assertEquals(primeFactorsOf, factors.get(70));

        primeFactorsOf = List.of(2, 5, 53);
        assertEquals(primeFactorsOf, factors.get(530));
    }
}