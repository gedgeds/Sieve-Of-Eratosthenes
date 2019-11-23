import java.util.Arrays;

class SequentialSieve {

    private boolean[] arrayOfPrimes;

    SequentialSieve(int size){
        InitializePrimes(size);
    }

    private void InitializePrimes(int size){

        arrayOfPrimes = new boolean[size+1];

        Arrays.fill(arrayOfPrimes, true);
        arrayOfPrimes[0] = false;
        arrayOfPrimes[1] = false;
    }

    void CalculatePrimeNumbers(){
        for(int i = 2; i*i <= arrayOfPrimes.length; i++){
            if(arrayOfPrimes[i]){
                for(int j = i+i; j < arrayOfPrimes.length; j += i){
                    arrayOfPrimes[j] = false;
                }
            }
        }
    }

    boolean[] getPrimeNumbers(){
        return arrayOfPrimes;
    }

}
