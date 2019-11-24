public class Main {

    public static void main(String[] args) throws InterruptedException {

        final int TOTAL_NUMBERS = 100000000;

        SequentialSieve sequentialSieve;
        ParallelSieve parallelSieve;

        PrimeNumbers primeNumbersSequential;
        PrimeNumbers primeNumbersParallel;

        boolean[] primes;
        long executionTime;
        int totalPrimes;

        primeNumbersSequential = new PrimeNumbers(TOTAL_NUMBERS);
        sequentialSieve = new SequentialSieve(primeNumbersSequential);

        primeNumbersParallel = new PrimeNumbers(TOTAL_NUMBERS);
        parallelSieve = new ParallelSieve(2, primeNumbersParallel);

        // SEQUENTIAL
        for(int i = 0; i < 1; i++) {
            executionTime = CalculateSequentialSiveEfficiency(sequentialSieve);
            primes = primeNumbersSequential.getPrimeNumbers();
            totalPrimes = CountAllPrimeNumbers(primes);
            PrintResults(totalPrimes, TOTAL_NUMBERS, executionTime);
        }

        // PARALLEL
        for(int i = 0; i < 1; i++) {
            executionTime = CalculateParallelSiveEfficiency(parallelSieve);
            primes = primeNumbersParallel.getPrimeNumbers();
            totalPrimes = CountAllPrimeNumbers(primes);
            PrintResults(totalPrimes, TOTAL_NUMBERS, executionTime);
        }

    }

    private static void PrintResults(int totalPrimes, int n, long executionTime){
        System.out.println("There are a total of " + totalPrimes + " prime numbers in the interval [2;" + n + "]");
        System.out.println("Algorithm execution time: " + executionTime + " milliseconds.");
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

    private static long CalculateParallelSiveEfficiency(ParallelSieve parallelSieve) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        parallelSieve.start();
        parallelSieve.join();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

}
