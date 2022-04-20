//---------------------------------------------------------------------------
// CSPeople.java            by Dale/Joyce/Weems                     Chapter 6
//
// Reads information about famous computer scientists from the file 
// input/FamousCS.txt. Allows user to indicate if they wish to see the list 
// sorted by name or by year of birth.
//---------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class CSPeople
{
  public static void main(String[] args) throws IOException 
  {
    // Get user's display preference
    Scanner scan = new Scanner(System.in);
    int choice;
    System.out.println("Would you like the list sorted...\n1. by first name?\n2. by last name?\n3. by year of birth, increasing? \n4. by year of birth, decreasing?\n5. by length of fact?");
    System.out.print("\nHow would you like to see the information > ");
    choice = scan.nextInt();
    
    // Instantiate sorted list
    SortedABList<FamousPerson> people;
    if (choice == 1)
      people = new SortedABList<FamousPerson>(FamousPerson.firstNameAlphabeticalComparator()); // by first name, alphabetically
    else if (choice == 2)
      people = new SortedABList<FamousPerson>(FamousPerson.lastNameAlphabeticalComparator()); // by last name, alphabetically
    else if (choice == 3)
      people = new SortedABList<FamousPerson>(FamousPerson.yearOfBirthComparator()); // by year increasing
    else if (choice == 4)
      people = new SortedABList<FamousPerson>(FamousPerson.decreasingYearOfBirthComparator()); // by year decreasing
    else
      people = new SortedABList<FamousPerson>(FamousPerson.factComparator()); // by length of fact
    
    // Set up file reading
    FileReader fin = new FileReader("src/FamousCS.txt");
    Scanner info = new Scanner(fin);
    info.useDelimiter("[,\\n]");  // delimiters are commas, line feeds
    FamousPerson person;
    String fname, lname, fact;
    int year;

    // Read the info from the file and add it to the list
    while (info.hasNext())      
    {
      fname = info.next();   lname = info.next();
      year = info.nextInt(); fact = info.next();
      person = new FamousPerson(fname, lname, year, fact);
      people.add(person);
    }
    
    // Display the list, using the advanced for loop
    System.out.println();
    for (FamousPerson fp: people)
       System.out.println(fp);
    scan.close();
    fin.close();
    info.close();
  } 
} 