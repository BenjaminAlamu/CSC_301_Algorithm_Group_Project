import java.util.ArrayList;

/**
 * Created by Alamu Benjamin on 9/26/2017.
 */
public class BucketSort {

    public static void main(String[] args) {
        int arr [] = {22,45,12,8,10,6,72,81,33,18,50,14};

        BuckSort(arr);
    }

    static void BuckSort(int input []){
        int bucket = 10;

        ArrayList<Integer> sortedElements = new ArrayList<>();
        //Create buckets
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i =0; i<10; i++){
            buckets[i] = new ArrayList<>();
        }

        //Calculate Max and Min
        int max = input[0];
        int min = input[0];

        for (int i = 0; i < input.length; i++){
            if (input[i] < min){
                min = input[i];
            }

            if (input[i] > max){
                max = input[i];
            }
        }

        //Calculate the divider
        double divider = (max + 1.0)/ bucket;


        for(int i=0; i<input.length; i++){
            int j = (int) Math.floor(input[i]/divider);
            buckets[j].add(input[i]);
        }



        //Sort the buckets with a stable sorting algorithm
        for(int i = 0; i<buckets.length;i++){
            int arr [] = new int [buckets[i].size()]; //Create an an the size of each bucket
            for (int j = 0; j<buckets[i].size(); j++){
                arr[j] = buckets[i].get(j); //Fill elements of the array with the elements of the buckets
            }
            arr = insertionSort(arr); //Sort the array with the insertion sort method
            for(int k = 0; k<arr.length; k++){      //Fill the buckets with the sorted element
                sortedElements.add(arr[k]);
            }
        }

        //Print values of buckets
        for(int i = 0; i<sortedElements.size();i++){
            System.out.println(sortedElements.get(i));
        }

    }

     static int [] insertionSort(int arr []){
        for(int i =1; i<arr.length; i++){
            int curElement = arr[i];
            int k;
            for(k = i-1; k>=0 && arr[k]>curElement; k--){
                arr[k+1] = arr[k];
            }
            arr[k+1] = curElement;
        }
        return arr;
    }
}
