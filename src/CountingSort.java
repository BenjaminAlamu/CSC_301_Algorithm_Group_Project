/**
 * Created by Alamu Benjamin on 9/25/2017.
 */
public class CountingSort {

    public static void main(String[] args) {
        int arr [] = {9,4,2,8,2,4};
        countSort(arr);
    }

    static void countSort(int inputArray []){
        int min = inputArray[0];
        int max = inputArray[0];


        //Get Minimum and maximum element in input array
        for (int i = 0; i < inputArray.length; i++){
            if (inputArray[i] < min){
                min = inputArray[i];
            }

            if (inputArray[i] > max){
                max = inputArray[i];
            }
        }

        int countArray [] = new int [max+1];
        int sumCountArray [] = new int [max+1];

        //Fill count array and sumCountArray with default values of zeros
        for(int i = 0; i<countArray.length;i++){
            countArray[i] = 0;
            sumCountArray[i] = 0;
        }

        //Find the number of occurences of each number
       for(int i = 0; i < inputArray.length; i++){
            countArray[inputArray[i]]++;
       }

       //Print out the count array
       for(int i=0; i<countArray.length; i++){
           System.out.print(countArray[i] + " ");
       }


        sumCountArray[0] = countArray[0];  //Set the initial element to the sum-count-array to be equal to the first element of the countArray
        for (int i = 1; i<countArray.length; i++){
            sumCountArray[i] = sumCountArray[i-1] + countArray[i];
        }

        //Print out the sum-count array
        System.out.println();
        for(int i=0; i<sumCountArray.length; i++){
            System.out.print(sumCountArray[i] + " ");
        }

        //Create an output array and save the sorted value in it
        int outputArray [] = new int[inputArray.length];
        System.out.println();
        for(int i = 0; i <inputArray.length; i++){
            outputArray[sumCountArray[inputArray[i]] - 1] = inputArray[i];
            sumCountArray[inputArray[i]]--;
        }

        //Print out the output array
        System.out.println();
        for(int i=0; i<outputArray.length; i++){
            System.out.print(outputArray[i] + " ");
        }

    }
}
