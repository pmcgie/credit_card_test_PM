package com.clara;

import java.util.Scanner;

public class CreditCard {

    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Ask user for credit card number. store number as a String.
        System.out.println("Please enter the credit card number, digits only:");
        String ccNumber = stringScanner.nextLine();
        boolean isValid = isValidCreditCard(ccNumber);

        if (isValid) {
            System.out.println("This seems to be a valid credit card number");
        } else {
            System.out.println("This is **not** a valid credit card number.");
        }

        //Close scanners.
        stringScanner.close();
        numberScanner.close();
    }

    public static boolean isValidCreditCard(String cc) {

        //Set starting decision to true
        boolean Decision = true;

        //Set initial position
        int cc_Pos = 1;

        //Set initial value
        int cc_val = 0;
        int Calc_Num = 0;
        int New_val = 0;

        //Place string into int array
        String Numbers [] = cc.split("");
        int [] Num_List = new int[Numbers.length];

        //Run through equation and validation
        for (int x = 0; x < cc.length();x++) {

            //Parse into integer
            Num_List[x] = Integer.parseInt(Numbers[x]);

            //Check position to determine calculation
            if (cc_Pos % 2 != 0) {
                Calc_Num = (Num_List[x] * 2);
            } else {
                Calc_Num = Num_List[x];
            }

            //If number * 2 is greater than 10 split number for calc and add both numbers
            if (Calc_Num >= 10) {
                //Set conditions
                String New_Num = Integer.toString(Calc_Num);
                String [] Split_Num = New_Num.split("");
                int[] Split_Nums = new int[Split_Num.length];

                for (int y = 0; y < Split_Num.length; y++) {
                    New_val = New_val + Split_Nums[y];
                    cc_val = cc_val + New_val;
                }

            } else {
                cc_val = cc_val + Calc_Num;
            }
            //Define cc position
            cc_Pos = cc_Pos+1;
        }



        //Determine Decision
        if (cc_val % 10 == 0) {
            Decision = true;
        } else {
            Decision = false;
        }

        return Decision;
    }
}
