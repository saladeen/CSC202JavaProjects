//---------------------------------------------------------------------------
// VocabularyDensity.java       by Dale/Joyce/Weems                 Chapter 5
//
// Displays the number of total words, unique words in the input text file,
// and the resulting vocabulary density.
// Input file indicated by a command line argument.
//---------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class VocabularyDensity
{
  public static void main(String[] args) throws IOException 
  {
    final int THRESHOLD = 3;
    final int CAPACITY = 1000;   // capacity of collection
    String[] fnames = args; // input file of text
    String word;                 // current word
    int numWords = 0;            // total number of words
    int uniqWords;               // number of unique words
    double density;              // vocabulary density

    CollectionInterface<String> combined = new ArrayCollection<String>(CAPACITY);
    int totalWords = 0;

    for (String file: fnames) {
      CollectionInterface<String> words = new ArrayCollection<String>(CAPACITY);

      // Set up file reading
      FileReader fin = new FileReader(file);
      Scanner wordsIn = new Scanner(fin);
      wordsIn.useDelimiter("[^a-zA-Z']+");  // delimiters are nonletters,'

      while (wordsIn.hasNext())      // while more words to process
      {
        word = wordsIn.next();          
        word = word.toLowerCase();
        if (!words.contains(word) && word.length() >= THRESHOLD)
          words.add(word);
          // check isn't really necessary
          combined.add(word);
        numWords++;
        totalWords++;
      }
      if (!words.isFull()) {
        density = (double)numWords/words.size();
        System.out.println("Analyzed file " + file);
        System.out.println("\n\tTotal words:  " + numWords);
        System.out.println("\tUnique words: " + words.size());
        System.out.printf("\n\tVocabulary density: %.2f\n", density);
      } else {
        System.out.println("list full");
      }
    }
    //combined analysis

    density = (double)totalWords/combined.size();
    System.out.print("Analyzed files: ");
    for (String i: fnames) {
      System.out.print(i + " ");
    }
    System.out.println("\n\tTotal words:  " + totalWords);
    System.out.println("\tUnique words: " + combined.size());
    System.out.printf("\n\tVocabulary density: %.2f\n", density);
  } 
} 