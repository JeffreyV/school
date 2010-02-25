package be.xios.util;

import java.io.*;


/**
 * Deze hulpklas (utility class) bevat enkel statische methodes
 * die het erg vereenvoudigen om van de console prompt invoer te
 * lezen.
 *
 */

public final class Console {
   private static BufferedReader in = null;
   
   static {
      in = new BufferedReader(new InputStreamReader(System.in));
   }
   
   /**
    * lees een String waarde van de invoer. Let op: ook spaties
    * zijn invoer!! Bij fouten wordt <code>null</code> teruggegeven,
    * indien er geen invoer is (enkel return), wordt er de lege String ("")
    * teruggegeven.
    *
    * @return een String, dit is alles wat de gebruiker heeft
    *         ingegeven, behalve het newline-teken (return).
    */
   public static String readString() {
      String result = null;
      try {
         result = in.readLine();
      } catch (IOException e) {
      }
      return result;
   }
   
   /**
    * lees een char waarde van de invoer. Let op: ook spaties
    * zijn invoer!! Bij fouten wordt een spatie teruggegeven,
    * indien er geen invoer is (enkel return), wordt er een spatie (' ')
    * teruggegeven.
    *
    * @return een ingelezen char, eventueel ' '
    *
    */
   public static char readChar() {
      char result = ' ';
      try {
         result = in.readLine().charAt(0);
      } catch (IOException e) {
      }
      return result;
   }
   
   /**
    * lees een int waarde van de invoer. Let op: bij ongeldige
    * invoer, wordt 0 teruggegeven.
    *
    * @return een ingelezen geheel getal, eventueel 0
    */
   public static int readInt() {
      int result = 0;
      try {
         result = Integer.parseInt(in.readLine());
      } catch (IOException e) {
      } catch (NumberFormatException e) {
      }
      return result;
   }
   
   /**
    * lees een double waarde van de invoer. Let op: bij ongeldige
    * invoer, wordt 0 teruggegeven.
    *
    * @return een ingelezen double getal, eventueel 0
    */
   public static double readDouble() {
      double result = 0;
      try {
         result = Double.parseDouble(in.readLine());
      } catch (IOException e) {
      } catch (NumberFormatException e) {
      }
      return result;
   }
   
   /**
    * lees een long waarde van de invoer. Let op: bij ongeldige invoer,
    * wordt 0 teruggegeven.
    *
    * @return een ingelezen long getal, eventueel 0
    */
   public static long readLong() {
      long result = 0;
      try {
         result = Long.parseLong(in.readLine());
      } catch (IOException e) {
      } catch (NumberFormatException e) {
      }
      return result;
   }
   
   /**
    * lees een float waarde van de invoer. Let op: bij ongeldige invoer,
    * wordt 0 teruggegeven.
    *
    * @return een ingelezen float getal, eventueel 0
    */
   public static float readFloat() {
      float result = 0;
      try {
         result = Float.parseFloat(in.readLine());
      } catch (IOException e) {
      } catch (NumberFormatException e) {
      }
      return result;
   }

   /**
    * lees een boolean waarde van de invoer. Let op: bij ongeldige invoer,
	* wordt false teruggegeven.
    *
    * @return een ingelezen boolean waarde, eventueel false
    */
   public static boolean readBoolean() {
      String result = null;
      try {
         result = in.readLine();
      } catch (IOException e) {
      }
	  if (result.equals("true")) {
		return true;
	  }
	  else {
      	return false;
	  }
   }
}
