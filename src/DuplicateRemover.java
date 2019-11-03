import java.util.*;
import java.io.*;

class DuplicateRemover {
    //use HashSet to store the unique words in a hashtable
    Set<String> uniqueWords = new HashSet<String>();

    public void remove(String dataFile) {
        BufferedReader reader;
        try {
            //create a new buffered reader
            reader = new BufferedReader(new FileReader(dataFile));
            String word = reader.readLine();
            while (word != null) {
                //store the word in uniqueWords
                uniqueWords.add(word);
                word = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String outputFile) {
        try {
            //create a printwriter
            PrintWriter pw = new PrintWriter(new FileWriter(outputFile));

            for (String word: uniqueWords) {
                //write words line by line
                pw.println(word);
            }

            //finally close the stream
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Application {
    public static void main(String[] args) {
        //create the object of DuplicateRemove and then call the remove and write methods.
        DuplicateRemover duplicateRemover = new DuplicateRemover();
        duplicateRemover.remove("problem1.txt");
        duplicateRemover.write("unique_words.txt");
    }
}
