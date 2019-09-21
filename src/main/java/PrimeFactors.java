import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeFactors {

    private List<Set<Integer>> primeFactors;
    private List<List<Integer>> allPrimeFactors;

    // Prime factors of numbers up to n
    public PrimeFactors(int n) {
        initializePrimeFactors(n);
        setPrimeFactors(n);
        setAllPrimeFactors(n);
    }

    private void initializePrimeFactors(int n) {
        primeFactors = new ArrayList<>(n);
        allPrimeFactors = new ArrayList<>(n);
        // set primes for 0 and 1
        primeFactors.add(null);
        primeFactors.add(null);
        allPrimeFactors.add(null);
        allPrimeFactors.add(null);
    }

    // Find all unique prime factors up to n
    private void setPrimeFactors(int n) {
        int number = 2;
        while (number <= n) {
            int factor = 2;
            // Lookup for first divisor up to square root of the number
            while (factor * factor <= number && number % factor != 0) {
                factor++;
            }

            // If it is a factor, then get the otherFactor's primes
            // and add this factor to those. The otherFactor's primes must have already
            // being found at this point as the factors of a number are less than the number itself
            // and all previous numbers are already computed.
            if (factor != number && number % factor == 0) {
                int otherFactor = number / factor;
                Set<Integer> factorsOf = primeFactors.get(otherFactor);
                Set<Integer> copyOfFactors = new HashSet<>(factorsOf);
                copyOfFactors.add(factor);
                primeFactors.add(number, copyOfFactors);
            }
            // Number has no divisors other than 1 and itself, then it is a prime number
            else {
                Set<Integer> primeSet = Set.of(number);
                primeFactors.add(number, primeSet);
            }
            number++;
        }
    }

    // Find all prime factors up to n
    private void setAllPrimeFactors(int n) {
        int number = 2;
        while (number <= n) {
            int factor = 2;
            // Lookup for first divisor up to square root of the number
            while (factor * factor <= number && number % factor != 0) {
                factor++;
            }

            // If it is a factor, then get the greaterFactor's primes
            // and add this factor to those. The otherFactor's primes must have already
            // being found at this point as the factors of a number are less than the number itself
            // and all previous numbers are already computed.
            if (number != factor && number % factor == 0) {
                int greaterFactor = number / factor;
                List<Integer> factorsOf = allPrimeFactors.get(greaterFactor);
                List<Integer> copyOfFactors = new ArrayList<>(factorsOf);
                copyOfFactors.add(0, factor);
                allPrimeFactors.add(number, copyOfFactors);
            }
            // Number has no divisors other than 1 and itself, then it is a prime number
            else {
                List<Integer> primeSet = new ArrayList<>(List.of(number));
                allPrimeFactors.add(number, primeSet);
            }
            number++;
        }
    }


    public List<Set<Integer>> getPrimeFactors() {
        return primeFactors;
    }

    public List<List<Integer>> getAllPrimeFactors() {
        return allPrimeFactors;
    }
}
