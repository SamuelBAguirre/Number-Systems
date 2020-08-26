import java.io.*;
import java.util.Scanner;
/**
 * The Menu class allows the user to select a conversion, as welll as allow them to exit the program.
 *
 * @author Samuel Aguirre, ID: 011137110
 * @version 9/6/2019
 */
public class Menu
{
    
    private PrintWriter pw;

    /**
     * Constructor for class Binary
     * @param pw, PrintWriter used to write to the output file
     */
    public Menu(PrintWriter pw){
    
        this.pw = pw;
    }

    /**
     * Displays a menu for the user, prompting for a conversion type.
     *
     * @author Samuel Aguirre, ID: 011137110
     * @return void
     */
    public void display()
    {
        System.out.println("Choose A Conversion: ");
        System.out.println("1) Decimal to Binary: ");
        System.out.println("2) Decimal to Hexadecimal: ");
        System.out.println("3) Binary to Decimal: ");
        System.out.println("4) Binary to Hexadecimal: ");
        System.out.println("5) Hexadecimal to Decimal: ");
        System.out.println("6) Hexadecimal to Binary: ");
        System.out.println("7) To Exit Program:  \n");
        
        pw.println("Choose A Conversion: ");
        pw.println("1) Decimal to Binary: ");
        pw.println("2) Decimal to Hexadecimal: ");
        pw.println("3) Binary to Decimal: ");
        pw.println("4) Binary to Hexadecimal: ");
        pw.println("5) Hexadecimal to Decimal: ");
        pw.println("6) Hexadecimal to Binary: ");
        pw.println("7) To Exit Program:  \n");
    }
    
    /**
     * The getSelection() grabs the user's selection and returns it.
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return choice, used for conversion type
     */
    public int getSelection(){
        
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        System.out.println("Conversion Option: "+ choice);
        pw.println("Conversion Option: " + choice);
        
        while(choice > 7 || choice < 1) {
            System.out.println("[ERROR]-Invalid Choice: " + choice);
            pw.println("[ERROR]-Invalid Choice" + choice);
            choice = in.nextInt();
        }
        
        return choice;
    }
}
