//--------------------------------------------------------------------
// HigherLower.java         by Dale/Joyce/Weems              Chapter 6
//
// Plays Higher or Lower? with user through command line interface. 
//--------------------------------------------------------------------
         // Card, CardDeck
import java.util.Scanner;

public class HigherLower 
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    char reply;
    int chips = 100;
    int currentBet;
    
    Card card1, card2;
    CardDeck deck = new CardDeck();
    deck.shuffle(); 
        
    System.out.println("Welcome to \"Higher or Lower\". Good luck!");

    // #21
    while(deck.hasNextCard() && chips>0) {
      // First card
      card1 = deck.nextCard(); 
      System.out.println("\nFirst Card: " + card1);

      //get bet
      System.out.println("how many chips would you like to bet? minimum 1");
      currentBet = scan.nextInt();
      if (currentBet <= 0) {
        currentBet = 1;
      } else if (currentBet > chips) {
        currentBet = chips;
      }

      // Get prediction
      System.out.print("Higher (H) or Lower (L)? > ");
      reply = scan.next().toUpperCase().charAt(0);
      // changing nextLine to next fixed everything, huh

      // Second card    
      card2 = deck.nextCard();
      System.out.println("\nSecond Card: " + card2);

      // Determine and display results    
      if ((card2.compareTo(card1) > 0) && (reply == 'H')) {
        chips+=currentBet;
        System.out.println("Correct! You now have: " + chips + " chips");
      }
      else if ((card2.compareTo(card1) < 0) && (reply == 'L')) {
        chips+=currentBet;
        System.out.println("Correct! You now have: " + chips + " chips");
      }
      else if ((card2.compareTo(card1) == 0)) {
        chips-=currentBet*2;
        System.out.println("Equal! Double loss, you now have: " + chips + " chips");
      }
      else
        chips-=currentBet;
        System.out.println("Incorrect, you now have: " + chips + " chips");
      }
  }
}