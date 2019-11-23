public class Main {

    public static void main(String[] args) {

        final int TOTAL_NUMBERS = 1000;
        SequentialSieve sequentialSieve;
        boolean[] primes;
        long executionTime;
        int totalPrimes;

        sequentialSieve = new SequentialSieve(TOTAL_NUMBERS);
        executionTime = CalculateSequentialSiveEfficiency(sequentialSieve);
        primes = sequentialSieve.getPrimeNumbers();
        totalPrimes = CountAllPrimeNumbers(primes);
        PrintResults(primes, totalPrimes, TOTAL_NUMBERS, executionTime);
    }

    private static void PrintResults(boolean[] primes, int totalPrimes, int n, long executionTime){
        System.out.println("There are a total of " + totalPrimes + " prime numbers in the interval [2;" + n + "]");
        for(int i = 0; i < primes.length; i++){
            if(primes[i]){
                System.out.println(i);
            }
        }
        System.out.println("Sequential algorithm execution time: " + executionTime + " milliseconds.");
    }

    private static int CountAllPrimeNumbers(boolean[] primes){
        int count = 0;
        for (boolean prime : primes) {
            if (prime) {
                count++;
            }
        }
        return count;
    }

    private static long CalculateSequentialSiveEfficiency(SequentialSieve sequentialSieve){

        long startTime = System.currentTimeMillis();
        sequentialSieve.CalculatePrimeNumbers();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
