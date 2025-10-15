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
}
