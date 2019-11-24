import java.util.Arrays;

class PrimeNumbers {

    private boolean[] primeNumbers;

    PrimeNumbers(int size){
        InitPrimeNumbers(size);
    }

    private void InitPrimeNumbers(int size){

        primeNumbers = new boolean[size+1];

        Arrays.fill(primeNumbers, true);
        primeNumbers[0] = false;
        primeNumbers[1] = false;
    }

    boolean[] getPrimeNumbers(){
        return primeNumbers;
    }

    void setCompositeNumber(int compositeNumber){
        primeNumbers[compositeNumber] = false;
    }

    boolean isPrimeNumber(int number){
        return primeNumbers[number];
    }

    int getTotalNumbers(){
        return primeNumbers.length;
    }

}
