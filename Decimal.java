import java.io.*;
import java.util.Scanner;
/**
 * This is the Decimal class, it is used for hexadecimal and binary conversions. It also validates  
 * decimal input before the conversion is done. 
 * 
 * @author Samuel Aguirre, ID: 011137110 
 * @version 9/5/2019
 */
public class Decimal
{
    private final static int BINBASE = 2;
    private final static int HEXABASE = 16;
    private final static long MAX = 4294967295L;

    private PrintWriter pw;
    private int hexNum;
    private long decimalNum;
    private String decimalNumString;
    private String binNum;
    private String convertedHex;

    /**
     * Constructor for class Decimal
     * 
     * @param pw, PrintWriter used to write to the output file
     * @author Samuel Aguirre, ID: 011137110
     */
    public Decimal(PrintWriter pw){
        this.pw = pw;
        binNum = "";
        convertedHex = "";
        decimalNumString = "";
        hexNum = 0;
    }

    /**
     * The decToBin() calls the inputDec(), toBin(), and outBin() to execute conversions for 
     * decimal to binary.
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @param pw, PrintWriter used to write to the output file
     */
    public void decToBin(){
        inputDec();
        toBin();
        outBin();

    }

    /**
     * User inputs decimal number to be converted, will also validate input. 
     * If input is invalid user is prompt to input decimal number again,  
     * the method is called again. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    private void inputDec(){

        // Scanner object
        Scanner in = new Scanner(System.in);

        
        System.out.print("Decimal Number Input: ");
        
        // checks to see if user inputs any chars 
        decimalNumString = in.nextLine();
        for(int i = 0; i < decimalNumString.length(); ++i){

            if(decimalNumString.charAt(i) >= 'A' || decimalNumString.charAt(i) < '0'){

                System.out.println("Invalid Input: " + decimalNumString + "\n");
                pw.println("Invalid Input:  " + decimalNumString + "\n");
                inputDec();
            }
        }

        // converts string into a long and determines if the decimal number is within range
        decimalNum = Long.parseLong(decimalNumString);
        if( decimalNum > MAX){
             System.out.println("Invalid Input: " + decimalNumString + "\n");
             pw.println("Invalid Input:  " + decimalNumString + "\n");
             inputDec();
        }
        
        pw.println("Decimal Number Input: " +  decimalNumString);
    }
    
    /**
     * The toBin() converts decimal number into a 32-bit binary number, uses a while loop
     * that includes the operators %, +=, and /
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    private void toBin(){

        binNum = "";
        decimalNum = Long.parseLong(decimalNumString);

        
        while(decimalNum > 0){
            binNum += decimalNum%BINBASE;
            decimalNum = decimalNum/BINBASE;

        }

        // will add any additional bits needed to make a 32-bit binary digit
        while(binNum.length() < 32){
            binNum += 0;
        }

    }

    /**
     * The outBin() puts the binNum into a StringBuilder object and then inserts a space 
     * to make nibbles. Then prints out the StringBuiulder object. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    private void outBin(){

        //Creates a stringbuilder object
        StringBuilder sb = new StringBuilder(binNum); 

        // reverses the stringbuilder object, then prints it out 
        sb.reverse();

        // for loop that inserts spaces to create nibbles 
        for(int i = 0; i < sb.length(); i += 5){

            sb = sb.insert(i, " ");
        }

        // prints out the converted decimal number (binary)
        System.out.println("Decimal To Binary: " + sb.toString() + "\n");
        pw.println("Decimal To Binary: " + sb.toString() + "\n");

    }

    /**
     * The decToHex() calls the inputDec(), toHex(), and outHex() to execute conversions for 
     * decimal to hexadecimal.
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    public void decToHex(){
        inputDec();
        toHex();
        outHex();
    }

    /**
     * The toHex() converts decimal number into a 8-bit hexadecimal number, uses a while loop
     * that includes the operators %, +=, and /. A switch statement assigns tempString1 to a string 
     * depending on the remainder. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    private void toHex(){

        // lcoal variable were better to use in the while loop as opposed to class variables
        String tempString1 = "";
        String tempString2 = "";
        decimalNum = Long.parseLong(decimalNumString);

        while(decimalNum > 0){
            //
            hexNum = (int)decimalNum%HEXABASE;
            decimalNum = (int)decimalNum/HEXABASE;
            tempString1 = Integer.toString(hexNum);

            //
            switch (tempString1) {
                case "10" : tempString1 = "A"; break;
                case "11" : tempString1 = "B"; break;
                case "12" : tempString1 = "C"; break;
                case "13" : tempString1 = "D"; break;
                case "14" : tempString1 = "E"; break;
                case "15" : tempString1 = "F"; break;

            }

            tempString2 += tempString1;
        }

        convertedHex = tempString2;

    }

    /**
     * The outHex(), prints out the converted binary number, a hexadecimal number. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    private void outHex(){

        //new stringbuilder object called sb
        StringBuilder sb = new StringBuilder(convertedHex);

        // appends 0 if the hexadecimal number is not 8-bits

        while(sb.length() < 8){
            sb.append("0");
        }

        // reverse the stringbuilder object
        sb.reverse();
        // prints out the converted decimal number (hexadeimal)
        System.out.println("Decimal To Hexadecimal:  " + sb.toString() + "\n"); 
        pw.println("Decimal To Hexadecimal:  " + sb.toString() + "\n");

    }
}
