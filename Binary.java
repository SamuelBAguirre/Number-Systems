import java.io.*;
import java.util.Scanner;
/**
 * This is the Binaary class, it is used for decimal and hexadecimal conversions. It also validates binary
 * input before the conversion is done. 
 *
 * @author Samuel Aguirre, ID: 011137110
 * @version 9/6/2019
 */
public class Binary
{
    private final static int BASE = 2;
    private final static int ASCII_ZERO = 48;

    private PrintWriter  pw;
    private String binaryNum;
    private StringBuilder hex;
    private int outputDecimal;

    /**
     * Constructor for class Binary
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @param pw, PrintWriter used to write to the output file
     */
    public Binary(PrintWriter pw)
    {
        this.pw = pw;
        outputDecimal = 0;
        binaryNum = "";
    }

    /**
     * The binToDec() calls the inputBin(), toDec(), and outDec() to execute conversions for 
     * binary to decimal.
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    public void binToDec(){
        inputBin();
        toDec();
        outDec();
    }

    /**
     * User inputs binary number to be converted, will also validate input. 
     * If input is invalid user is prompt to input binary number again,  
     * the method is called again. Will also remove any spaces for later conversions. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    private void inputBin(){
        Scanner in = new Scanner(System.in);

        // user input
        System.out.print("Binary Number Input: ");
        binaryNum = in.nextLine();
        pw.println("Binary Number Input: " + binaryNum);

        // removes any spcaes the user may have inputed 
        binaryNum = binaryNum.replaceAll(" ", "");

        
        // checks if the binary number is valid
        for(int i = 0; i < binaryNum.length(); ++i){

            if((binaryNum.charAt(i)) > '1' || (binaryNum.charAt(i)) < '0'){

                System.out.println("Invalid Input: " + binaryNum + "\n");
                pw.println("Invalid Input: " + binaryNum + "\n");
                inputBin();
            }
        }

    }

    /**
     * The toDec() converts a binary digit to decimal number, uses a for loop to iterate through 
     * binaryNum and mulitplies it with the appopriate number. Then adds it to tempInt
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    private void toDec(){
        
        int binNum = 0;
        int tempInt = 0;
        int exp = binaryNum.length();

        for (int i = 0; i < binaryNum.length(); ++i){
            // binNum = 1 or 0 
            binNum = binaryNum.charAt(i)-ASCII_ZERO; 
            
            tempInt += binNum * Math.pow(BASE, --exp);
        }

        
        outputDecimal = tempInt;
    }

    /**
     * The outDec(), prints out the converted binary number, a decimal number. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    private void outDec(){

        System.out.println("Binary to Decimal: " + outputDecimal + "\n");
        pw.println("Binary to Decimal: " + outputDecimal + "\n");

    }

    /**
     * The binToHex() calls the inputHex(), toHex(), and outHex() to execute conversions for 
     * binary to hexadecimal.
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    public void binToHex(){
        inputBin();
        toHex();
        outHex();
    }

    /**
     * The toHex() uses three StringBuilder objects, in the case that the user does not input a 32-bit
     * binary number. The StingBuilders will append the need zeros. Then a for loop is used to interate through 
     * the StringBuilder (temp) object and set the appopriate char at each i for the hex StringBuilder object. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    private void toHex(){
        hex = new StringBuilder("00000000");

        StringBuilder bin = new StringBuilder(binaryNum); 
        StringBuilder temp = new StringBuilder("");

        // adds zeros for the binary number, which allows the user to add any binary digit below 32-bits
        while (bin.length() + temp.length() < 32){
            temp.append("0");   
        }

        // appends binaryNum to temp
        temp = temp.append(binaryNum);

        for(int i = 0, j = 0; i < temp.length(); i += 4, ++j){
            if(temp.substring(i, i + 4).equals("0000")){
                hex.setCharAt(j,'0'); 
            }
            else if(temp.substring(i, i+4).equals("0001")){
                hex.setCharAt(j, '1');
            }
            else if(temp.substring(i, i+4).equals("0010")){
                hex.setCharAt(j, '2');
            }
            else if(temp.substring(i, i+4).equals("0011")){
                hex.setCharAt(j, '3');
            }
            else if(temp.substring(i, i+4).equals("0100")){
                hex.setCharAt(j, '4');
            }
            else if(temp.substring(i, i+4).equals("0101")){
                hex.setCharAt(j, '5');
            }
            else if(temp.substring(i, i+4).equals("0110")){
                hex.setCharAt(j, '6');
            }
            else if(temp.substring(i, i+4).equals("0111")){
                hex.setCharAt(j, '7');
            }
            else if(temp.substring(i, i+4).equals("1000")){
                hex.setCharAt(j, '8');
            }
            else if(temp.substring(i, i+4).equals("1001")){
                hex.setCharAt(j, '9');
            }
            else if(temp.substring(i, i+4).equals("1010")){
                hex.setCharAt(j, 'A');
            }
            else if(temp.substring(i, i+4).equals("1011")){
                hex.setCharAt(j, 'B');
            }
            else if(temp.substring(i, i+4).equals("1100")){
                hex.setCharAt(j, 'C');
            }
            else if(temp.substring(i, i+4).equals("1101")){
                hex.setCharAt(j, 'D');
            }
            else if(temp.substring(i, i+4).equals("1110")){
                hex.setCharAt(j, 'E');
            }
            else if(temp.substring(i, i+4).equals("1111")){
                hex.setCharAt(j, 'F');
            }
        }

    }

    /**
     * The outHex() prints the converted binary number, a hexadecimal number. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    private void outHex(){

        System.out.println("Binary To Hexadecimal: " + hex.toString() + "\n");
        pw.println("Binary To Hexadecimal: " + hex.toString() + "\n");

    }
}
