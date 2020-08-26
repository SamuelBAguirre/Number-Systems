import java.io.*;
import java.util.Scanner;
/**
 * This is the Hexadecimal class, it is used for decimal and binary conversions. It also validates  
 * hexadecimal input before the conversion is done. 
 *
 * @author Samuel Aguirre, ID: 011137110
 * @version 9/4/2019
 */
public class Hexadecimal
{
    private final static int BASE = 16;
    private final static int TEN = 10;
    private final static int ELEVEN = 11;
    private final static int TWELVE = 12;
    private final static int THIRTEEN = 13;
    private final static int FOURTEEN = 14;
    private final static int FIFTHTEEN = 15;

    private PrintWriter pw;
    StringBuilder temp;
    private StringBuilder bin;
    private String hexadecimalNum;
    private int outputDec;

    /**
     * Constructor for objects of class Hexadecimal
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @param pw, PrintWriter used to write to the output file 
     */
    public Hexadecimal(PrintWriter pw)
    {
        // initialise instance variables
        this.pw = pw;
        hexadecimalNum = "";
        outputDec = 0;

    }

    /**
     * The hexToDec() calls the inputHex(), toDec(), and outDec() to execute conversions for 
     * hexadecimal to decimal. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    public void hexToDec(){
        inputHex();
        toDec();
        outDec();

    }

    /**
     * User inputs hexdecimal number to be converted, will also validate input. 
     * If input is invalid user is prompt to input hexadecimal number again,  
     * the method is called again. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    private void inputHex(){

        Scanner in = new Scanner(System.in);

        // user input 
        System.out.print("HexaDecimal Number Input: ");
        hexadecimalNum = in.nextLine();
        pw.println("HexaDecimal Number Input: " + hexadecimalNum);
        
        // Checks to see if input is valid
        for(int i = 0; i < hexadecimalNum.length(); ++i){
         
            if(hexadecimalNum.charAt(i) > 'F' || hexadecimalNum.charAt(i) < '0'){
             
                System.out.println("Invalid Input: " + hexadecimalNum + "\n");
                pw.println("Invalid Input: " + hexadecimalNum + "\n");
                inputHex();
            }
        }

    }

    /**
     * This method, toDec(), converts the hexadecimal number into a decimal number. 
     * Uses a for loop and traverses the hexadecimalNum string character by character, comparing
     * each char's ASCII value with the ASCII value of A, B, C, D, E, or F. Then if true, 
     * a local int var will be assigned to a specific constant, which will be used in the mathematical conversion.
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    private void toDec(){

        int hexNum = 0;
        int tempInt = 0;
        int exp = hexadecimalNum.length();

        for (int i = 0; i < hexadecimalNum.length(); ++i){
            //
            hexNum = hexadecimalNum.charAt(i) - '0';

            //
            if(hexadecimalNum.charAt(i) == 'A'){

                hexNum = TEN; 
            }
            else  if (hexadecimalNum.charAt(i) == 'B'){ 

                hexNum = ELEVEN;
            }
            else if (hexadecimalNum.charAt(i) == 'C'){

                hexNum = TWELVE;
            }
            else if (hexadecimalNum.charAt(i) == 'D'){

                hexNum = THIRTEEN;
            }
            else if (hexadecimalNum.charAt(i) == 'E'){

                hexNum =  FOURTEEN;
            }
            else if (hexadecimalNum.charAt(i) == 'F'){

                hexNum = FIFTHTEEN;
            }

            tempInt += hexNum * Math.pow(BASE, --exp);
        }
        outputDec = tempInt;
    }

    /**
     * Prints out the converted hexadecimal number, a decimal number. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    private void outDec(){
        //
        System.out.println("Hexadecimal to Decimal: " + outputDec + "\n");
        pw.println("Hexadecimal to Decimal: " + outputDec + "\n");
    }

    /**
     * The hexToBin() calls the inputHex(), toBin(), and outBin() to execute conversions for 
     * hexadecimal to binary.
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    public void hexToBin(){
        inputHex();
        toBin();
        outBin();

    }

    /**
     * The toBin() iterates through hexadecimalNum string char by char, using the StringBuilder object, it will
     * append the apporpriate binary digit for each char in hexadecimalNum.
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    private void toBin(){

        bin = new StringBuilder("");

        for(int i = 0; i < hexadecimalNum.length(); i++){
            if(hexadecimalNum.substring(i, i+1).equals("0")){
                bin.append("0000"); 
            }
            else if(hexadecimalNum.substring(i, i+1).equals("1")){
                bin.append("0001");
            }
            else if(hexadecimalNum.substring(i, i+1).equals("2")){
                bin.append("0010");
            }
            else if(hexadecimalNum.substring(i, i+1).equals("3")){
                bin.append("0011");
            }
            else if(hexadecimalNum.substring(i, i+1).equals("4")){
                bin.append("0100");
            }
            else if(hexadecimalNum.substring(i, i+1).equals("5")){
                bin.append("0101");
            }
            else if(hexadecimalNum.substring(i, i+1).equals("6")){
                bin.append("0110");
            }
            else if(hexadecimalNum.substring(i, i+1).equals("7")){
                bin.append("0111");
            }
            else if(hexadecimalNum.substring(i, i+1).equals("8")){
                bin.append("1000");
            }
            else if(hexadecimalNum.substring(i, i+1).equals("9")){
                bin.append("1001");
            }
            else if(hexadecimalNum.substring(i, i+1).equals("A")){
                bin.append("1010");
            }
            else if(hexadecimalNum.substring(i, i+1).equals("B")){
                bin.append("1011");
            }
            else if(hexadecimalNum.substring(i, i+1).equals("C")){
                bin.append("1100");
            }
            else if(hexadecimalNum.substring(i, i+1).equals("D")){
                bin.append("1101");
            }
            else if(hexadecimalNum.substring(i, i+1).equals("E")){
                bin.append("1110");
            }
            else if(hexadecimalNum.substring(i, i+1).equals("F")){
                bin.append("1111");
            }
        }
    }

    /**
     * The outBin() first adds "0000" if needed and then spaces-out the binary number into nibbles. 
     * Then prints out the converted hexadecimal number, a 32-bit binary number. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    private void outBin(){

        temp = new StringBuilder("");
        
        // will add any nibbles, "0000", to create a 32-bit binary number
        while(bin.length() + temp.length() <32){
            bin.append("0000");
        }
        
        // will append both StringBuilder objects together in order to create a 32 bit number 
        temp.append(bin);
        
        // adds spaces inbetween nibbles
        for(int i = 0; i < temp.length(); i += 5){

            temp = temp.insert(i, " ");
        }

        System.out.println("Hexadecimal To Binary: "+ temp.toString() + "\n");
        pw.println("Hexadecimal To Binary: "+ temp.toString() + "\n");

    }
}
