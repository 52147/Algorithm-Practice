public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        // Initialize the isPrime array
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        // Apply Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count primes
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountPrimes solution = new CountPrimes();
        System.out.println(solution.countPrimes(10)); // Output: 4 (2, 3, 5, 7)
        System.out.println(solution.countPrimes(0));  // Output: 0
        System.out.println(solution.countPrimes(1));  // Output: 0
    }
}
