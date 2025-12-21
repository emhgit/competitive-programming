package templates;

/**
 * This class contains utility methods that I would rather not memorize
 */
public class Utils {

    /**
     * This method determines whether the number parameter is prime
     * 
     * @param n The number whose primeness will be determined
     * @return If the parameter is prime or not
     */
    static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    /**
     * This method returns the greatest common divisor, c, of a and b using Euclid's
     * Extended Algorithm; \mathcal{O}(n \log{n})
     * 
     * @param a The first multiple of c
     * @param b The second multiple of c
     * @return The greatest common divisor, c, of a and b
     */
    static long gcd(long a, long b) {
        long dividend = Math.max(a, b), quotient = Math.min(a, b), remainder = dividend % quotient;
        while (remainder != 0) {
            dividend = quotient;
            quotient = remainder;
            remainder = dividend % quotient;
        }
        return quotient;
    }

    /**
     * This method returns a boolean array of size n + 1, where the ith index is
     * true if the ith number is prime, false otherwise;
     * Calculated using the Sieve of Eratosthenes; \mathcal{O}(n \log{n})
     * 
     * @param n The size of the boolean array
     * @return A boolean array of size n + 1, where the ith index is true if the ith
     *         number is prime, false otherwise
     */
    static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
