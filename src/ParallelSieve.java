class ParallelSieve extends Thread{

    private PrimeNumbers primeNumbers;
    private int prime;
    private boolean lastThread;
    private ParallelSieve next;

    ParallelSieve(int prime, PrimeNumbers primeNumbers){
        super ("Filter" + prime);
        this.prime = prime;
        this.primeNumbers = primeNumbers;
        lastThread = true;
    }

    public void run () {
        try {
            CalculateCompositeNumbers();
        }
        catch (InterruptedException ignored) {}
    }

    private void CalculateCompositeNumbers() throws InterruptedException{

        if(prime + prime < primeNumbers.getTotalNumbers()){
            primeNumbers.setCompositeNumber(prime + prime);
        }

        for(int i = prime; i*i < primeNumbers.getTotalNumbers(); i++){
            if (primeNumbers.isPrimeNumber(i) && i % prime != 0) {
                next = new ParallelSieve(i, primeNumbers);
                next.start();
                lastThread = false;
                break;
            }
        }

        for(int i = prime+prime; i < primeNumbers.getTotalNumbers(); i += prime){
            primeNumbers.setCompositeNumber(i);
        }

        if(!lastThread){
            next.join();
        }

    }

}
