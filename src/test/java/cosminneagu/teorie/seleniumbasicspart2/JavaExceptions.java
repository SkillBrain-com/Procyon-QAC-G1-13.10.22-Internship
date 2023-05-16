package cosminneagu.teorie.seleniumbasicspart2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JavaExceptions {

    public static void main(String[] args) throws IOException {
        //checkedException();
        //uncheckedException();
        //recursiv(5,1);
        //fun();
        System.out.println("Am executat functia main");
    }

    //checked exceptions
    static void checkedException() throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\Teo\\IdeaProjects\\Procyon-QAC-G1-13.10.22\\src\\test\\java\\teofilursan\\teorie\\seleniumbasicspart2\\text.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        System.out.println(bufferedReader.readLine());
        fileReader.close();
    }

    //unchecked exceptions
    static void uncheckedException() {
        int result = 0;
        try {
            int a = 5;
            int b = 0;
            result = a/b;
        } catch (NullPointerException | ArithmeticException e) {
            //System.out.println(e.getMessage());
            //e.printStackTrace();
            System.out.println("Catch 1: Nu se poate efectua impartirea la 0.");
        } finally {
            System.out.println("Am executat finally");
        }
        System.out.println("Valoarea impartirii este: " + result);
    }

    static void fun() {
        try {
            throw new NullPointerException("demo");
        } catch (NullPointerException e) {
            System.out.println("Caught inside fun().");
            throw e; // rethrowing the exception
        }
    }

    static void recursiv(int numar, int index) {
        if(numar !=0) {
            System.out.println(index);
            index++;
            recursiv(numar, index);
        }
    }
}