/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peraa0837
 */
public class SortSearch {

    public void swap(int[] array, int p1, int p2) {
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }

    public void swapString(String[] array, int p1, int p2) {
        String temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }

    //Problem 1
    public void efficientSelectionSort(int[] array) {
        //keep track of which position we are sorting
        for (int position = 0; position < array.length; position++) {
            int lowest = position;
            //go through the rest looking for a smaller number
            for (int i = position + 1; i < array.length; i++) {
                //have we found smaller?
                if (array[i] < array[position] && array[i] < array[lowest]) {
                    lowest = i;
                }
            }
            swap(array, lowest, position);
        }
    }

    //Problem 2
    public int smallestMissingNumber(int[] array) {
        int number = 0;
        //sort array to begin
        efficientSelectionSort(array);
        if (array[0] != 0) {
            return 0;
        }
        //checks the gap from each position to the next
        for (int position = 0; position < array.length; position++) {
            number = array[position] + 1;
            if (array[position + 1] != number) {
                return array[position] + 1;
            }
        }
        return 0;

    }

    //problem 3
    public int countOnes(int[] array) {
        int ones = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                ones++;
            }
        }
        return ones;
    }

    //problem 4
    public int[] countingSort(int[] array) {
        //create needed arrays and variables
        int pos = 0;
        int[] tracker = new int[101];
        int[] answer = new int[array.length];
        //go through each position of the given array and add one to the
        //position of the tracker array that corresponds to the value of the given array
        for (int i = 0; i < array.length; i++) {
            tracker[array[i]]++;
        }
        //set the answer array positions to the correct numbers in a sorted order
        for (int p = 0; p < tracker.length; p++) {
            for (int x = 0; x < tracker[p]; x++) {
                answer[pos] = p;
                pos++;
            }

        }
        //return the completed sorted array
        return answer;
    }

    //problem 5
    public void stringInsertionSort(String[] array) {
        // start going through the array
        for (int i = 0; i < array.length - 1; i++) {
            // store position
            int position = i;
            // check values beside each other 
            //if value is greater than zero, array[position] is before array[position+1] 
            while (position >= 0 && array[position].compareTo(array[position + 1]) > 0) {
                // if out of place, swap it downwards
                // until correct position is reached 
                swapString(array, position, position + 1);
                position--;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SortSearch test = new SortSearch();

        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            //make a random number
            numbers[i] = (int) (Math.random() * 101);

        }
        System.out.println("PROBLEM 1: ");
        System.out.println("BEFORE");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        //SORT HERE
        test.efficientSelectionSort(numbers);

        System.out.println("AFTER");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        System.out.println("-----------------------");

        int[] smallNumbers = new int[10];
        //make a random number
        smallNumbers[0] = 0;
        smallNumbers[1] = 1;
        smallNumbers[2] = 2;
        smallNumbers[3] = 3;
        smallNumbers[4] = 4;
        smallNumbers[5] = 6;
        smallNumbers[6] = 7;
        smallNumbers[7] = 8;
        smallNumbers[8] = 9;
        smallNumbers[9] = 10;


        System.out.println("PROBLEM 2: ");
        System.out.println("BEFORE");
        for (int i = 0; i < smallNumbers.length; i++) {
            System.out.println(smallNumbers[i]);
        }
        //SORT HERE
        test.efficientSelectionSort(smallNumbers);

        System.out.println("AFTER");
        for (int i = 0; i < smallNumbers.length; i++) {
            System.out.println(smallNumbers[i]);
        }
        int answer = test.smallestMissingNumber(smallNumbers);
        System.out.println("The smallest missing number is " + answer);

        System.out.println("-----------------------");

        int[] binaryNumbers = new int[10];
        for (int i = 0; i < binaryNumbers.length; i++) {
            //make a random number
            binaryNumbers[i] = (int) (Math.random() * 2);

        }

        System.out.println("PROBLEM 3: ");

        System.out.println("ARRAY");
        for (int i = 0; i < binaryNumbers.length; i++) {
            System.out.println(binaryNumbers[i]);
        }
        int answer2 = test.countOnes(binaryNumbers);
        System.out.println("The amount of ones is " + answer2);

        System.out.println("---------------------------");

        int[] numbers2 = new int[101];
        for (int i = 0; i < numbers2.length; i++) {
            //make a random number
            numbers2[i] = (int) (Math.random() * 101);

        }

        System.out.println("PROBLEM 4: ");
        System.out.println("BEFORE");
        for (int i = 0; i < numbers2.length; i++) {
            System.out.println(numbers2[i]);
        }

        System.out.println("AFTER");
        //SORT HERE
        test.countingSort(numbers2);
        int[] ans = test.countingSort(numbers2);
        for (int i = 0; i < numbers2.length; i++) {
            System.out.println(ans[i]);


        }

        System.out.println("------------------------------");

        String[] words = new String[10];
        words[0] = "B";
        words[1] = "A";
        words[2] = "G";
        words[3] = "P";
        words[4] = "Z";
        words[5] = "T";
        words[6] = "H";
        words[7] = "S";
        words[8] = "F";
        words[9] = "Y";

        System.out.println("BEFORE");
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

        test.stringInsertionSort(words);

        System.out.println("AFTER");
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

    }
}
