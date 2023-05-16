package catalinazoldi.teorie.selenium2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

          public class JavaExceptions {
              public static void main(String[] args) throws IOException {
                  //checkedExceptions();
                  //uncheckedException();
                  //System.out.println("Am executat functia main ");
              }

              //checked exceptions
              static void checkedExceptions() throws IOException {
                  FileReader fileReader = new FileReader((System.getProperty("user.dir")+"\\src\\test\\java\\catalinazoldi\\teorie\\selenium2\\text.txt"));
                  BufferedReader bufferedReader = new BufferedReader(fileReader);
                  System.out.println(bufferedReader.readLine());
                  fileReader.close();
              }

               //unchecked exceptions
              static void uncheckedException()  {



                  int result = 0;
                  try {
                      int a = 5;
                      int b = 3;
                      result = a / b;
                  } catch (NullPointerException | ArithmeticException e){
                     // System.out.println(e.getMessage());
                      // e.getStackTrace();
                      System.out.println("Catch 1: Nu se poate face impartirea la 0.");
                  } finally {
                      System.out.println("Am executat finally.");
                  }
                  System.out.println("Valoarea impartirii este:" + result);
              }

          }

