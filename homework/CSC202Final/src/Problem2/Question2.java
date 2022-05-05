package Problem2;

import java.util.Scanner;

public class Question2{
	
	public static void main(String[] args) { 
		new Question2 ();
	}
	
	public Question2 () { 
		BinarySearchTree<Integer> tree1 = new BinarySearchTree <>(); 
		BinarySearchTree<Integer> tree2 = new BinarySearchTree <>(); 		
		Scanner input = new Scanner(System.in); 
		System.out.print("How many integers will you insert to tree1? "); 
			int n1 = input.nextInt(); 
		System.out.println("Enter " + n1 + " integers for tree1: "); 
			for (int i = 0; i < n1; i++) { 
				tree1.add(input.nextInt()); 			}
		System.out.print("How many integers will you insert to tree2? "); 
			int n2 = input.nextInt(); 
		System.out.println("Enter " + n1 + " integers for tree2: "); 
			for (int i = 0; i < n2; i++) { 
				tree2.add(input.nextInt()); 			}
		System.out.println("The two trees have the same shape? " + tree1.hasSameShape(tree2)); 	}
}

