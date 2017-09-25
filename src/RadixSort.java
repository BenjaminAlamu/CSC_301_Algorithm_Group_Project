import java.util.ArrayList;

/**
 * Created by Alamu Benjamin on 9/22/2017.
 */
public class RadixSort {

    public static void main(String[] args) {
        int testData [] = {10,15,1,60,5,100,25,50};
        radSort(testData);
    }

    static void radSort(int [] arr){


        //Creating a multi dimensional array-list
        ArrayList<String> [] buckets = new ArrayList[10];
        for (int i =0; i<10; i++){
            buckets[i] = new ArrayList<>();
        }

        //Find maximum number in the data
        int max = arr[0];
        for (int i = 0; i<arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }

        //Get number of digits in maximum number
        int len = String.valueOf(max).length();

        //Pad numbers with zero and convert numbers to strings

        String [] padData = new String[arr.length];
        for(int i = 0; i <arr.length; i++){
            String pad = "";
            int elementLen = String.valueOf(arr[i]).length();
            if (elementLen < len){
                //Perform Magic
                int diff = len - elementLen;
                for (int j = 0; j < diff; j++){
                    pad += "0";
                }
                pad += String.valueOf(arr[i]);
                padData[i] = pad;

            }
            else{
                padData[i] = String.valueOf(arr[i]);
            }

        }

        //Loop through array and sort into their buckets.
        int pass = 1;
        for (int i = len-1; i>=0; i--){ //Loop through the each digit from right most digit

            for(int j = 0; j<padData.length; j++){ //Loop through each element in the array
                char in = padData[j].charAt(i);
                switch (in){    //Sort the data into their respective buckets
                    case '0':
                        buckets[0].add(padData[j]);
                        break;

                    case '1':
                        buckets[1].add(padData[j]);
                        break;

                    case '2':
                        buckets[2].add(padData[j]);
                        break;

                    case '3':
                        buckets[3].add(padData[j]);
                        break;

                    case '4':
                        buckets[4].add(padData[j]);
                        break;

                    case '5':
                        buckets[5].add(padData[j]);
                        break;

                    case '6':
                        buckets[6].add(padData[j]);
                        break;

                    case '7':
                        buckets[0].add(padData[j]);
                        break;

                    case '8':
                        buckets[0].add(padData[j]);
                        break;

                    case '9':
                        buckets[0].add(padData[j]);
                        break;
                }

            }

            //Print buckets
            System.out.println("Pass " + pass);
            pass++;
            for(int a = 0; a < buckets.length; a++){
                for(int b = 0; b < buckets[a].size(); b++){
                    System.out.println(buckets[a].get(b));
                }
            }

            //Load values into array
            int k = 0;
            for(int a = 0; a < buckets.length; a++){
                for(int b = 0; b < buckets[a].size(); b++){
                    padData[k] = buckets[a].get(b);
                    k++;
                }
            }

            //Clear data in arraylists
            for(int a = 0; a < 10; a++){
                buckets[a].clear();
            }

        }


        }
    }

