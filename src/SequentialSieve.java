class SequentialSieve {

    private PrimeNumbers primeNumbers;

    SequentialSieve(PrimeNumbers primeNumbers){
        this.primeNumbers = primeNumbers;
    }

    void CalculatePrimeNumbers(){
        for(int i = 2; i*i <= primeNumbers.getTotalNumbers(); i++){
            if(primeNumbers.isPrimeNumber(i)){
                for(int j = i+i; j < primeNumbers.getTotalNumbers(); j += i){
                    primeNumbers.setCompositeNumber(j);
                }
            }
        }
    }

}
