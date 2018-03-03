package Homework2;

import java.io.PrintStream;
import java.util.Scanner;

public class PrimaryZip
{
  static Scanner input = new Scanner(System.in);
  
  public static void main(String[] args)
  {
    ZipToBarcode object = new ZipToBarcode();
    
    BarcodeToZip object2 = new BarcodeToZip();
    for (;;)
    {
      System.out.println("Welcome to the Zip Code homework! ");
      System.out.println("1. Zip code to barcode: ");
      System.out.println("2. Barcode to zip code ");
      System.out.println("3. Exit Program");
      System.out.println();
      System.out.println("Which of these optons would you like to choose?");
      int User = input.nextInt();
      if (User == 1)
      {
        object.convert();
        System.out.println();
        System.out.println();
      }
      else if (User == 2)
      {
        object2.convert2();
      }
      else if (User == 3)
      {
        System.out.println("Program will now close! Thank you.");
        System.exit(1);
      }
      else
      {
        System.out.println("This number is not part of the menu! Try again.");
        System.out.println();
      }
    }
  }
}