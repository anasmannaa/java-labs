/* The sum of two binary digits problem */

/* This class was created to solve the problem of getting
the sum of two binaries, in the form of binary system digits.
Input Data:
Input the first binary number: 10
Input the second binary number: 11
Expected Output: 
110
*/

package com.anasmannaa;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySum {

    public static void sumTwoBinaries() {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert First Binary:");
        String firstBinaryString = in.nextLine();
        System.out.println("Insert Second Binary:");
        String secondBinaryString = in.nextLine();
        int length = firstBinaryString.length() > secondBinaryString.length() ? firstBinaryString.length() : secondBinaryString.length();
        int[] firstBinaryArray = createIntArray(firstBinaryString, length);
        int[] secondBinaryArray = createIntArray(secondBinaryString, length);
        int[] result = createSumArray(firstBinaryArray, secondBinaryArray, length);
        String binarySum = "Sum= ";
        for (int i = 0; i < result.length; i++) {
            binarySum += String.valueOf(result[i]);
        }
        System.out.println(binarySum);
    }

    private static int[] createIntArray(String numberString, int length) {
        int[] newArray = new int[length];
        for (int i = 0; i < numberString.length(); i++) {
            int digit = Character.getNumericValue(numberString.charAt(i));
            newArray[i] = digit;
        }
        return newArray;
    }

    private static int[] createSumArray(int[] firstArray, int[] secondArray, int length){
        int remainder = 0;
        int[] finalArray = new int[length];
        for (int i = length - 1; i > 0; i--) {
            if ((firstArray[i] + secondArray[i] + remainder) == 0) {
                finalArray[i] = 0;
            } else if ((firstArray[i] + secondArray[i] + remainder) == 1) {
                finalArray[i] = 1;
            } else if ((firstArray[i] + secondArray[i] + remainder) == 2) {
                finalArray[i] = 0;
                remainder = 1;
            } else if ((firstArray[i] + secondArray[i] + remainder) == 3) {
                finalArray[i] = 1;
                remainder = 1;
            }
        }
        if (firstArray[0] + secondArray[0] + remainder == 1) {
            finalArray[0] = 1;
        } else if (firstArray[0] + secondArray[0] + remainder == 2) {
            finalArray[0] = 0;
            int[] tempArray = new int[length + 1];
            tempArray[0] = 1;
            for (int i = 1; i <= finalArray.length; i++) {
                tempArray[i] = finalArray[i-1];
            }
            finalArray = tempArray;
        } else if (firstArray[0] + secondArray[0] + remainder == 3) {
            finalArray[0] = 1;
            int[] tempArray = new int[length + 1];
            tempArray[0] = 1;
            for (int i = 1; i <= finalArray.length; i++) {
                tempArray[i] = finalArray[i-1];
            }
            finalArray = tempArray;
        }
        return finalArray;
    }
}
