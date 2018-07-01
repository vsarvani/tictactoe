package tictactoe4;

import java.util.Scanner;
public class TicTacToe4 {
	private static final int ROWS = 3; 
	private static final int COLUMNS = 3;

    public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args)
  {

    final int SIZE = 3;
    char[][] board = new char[SIZE][SIZE]; 

    resetBoard(board); 
    
    System.out.println("===== TIC-TAC-TOE GAME!! =====\n");
    showBoard(board);

    
    System.out.print("  Which team do you want to play, \"x\" or \"o\"? ");
    char userSymbol = sc.next().toLowerCase().charAt(0);
    char compSymbol = (userSymbol == 'x') ? 'o' : 'x';

    
    System.out.println();
    System.out.print("  Do you want to go first (y/n)? ");
    char ans = sc.next().toLowerCase().charAt(0);

    int turn; 
    int remainCount = SIZE * SIZE;

    
    if (ans == 'y') {
      turn = 0;
      userPlay(board, userSymbol);
    }
    else {
      turn = 1;
      compPlay(board, compSymbol); 
    }
    
    showBoard(board);
    remainCount--;

    
    boolean done = false;
    int winner = -1; 

    while (!done && remainCount > 0) {
      
      done = isGameWon(board, turn, userSymbol, compSymbol);

      if (done)
        winner = turn; 
      else {
        
        turn = (turn + 1 ) % 2;

        if (turn == 0)
          userPlay(board, userSymbol);
        else
          compPlay(board, compSymbol);

        
        showBoard(board);
        remainCount--;
      }
    }

   
    if (winner == 0)
      System.out.println("\n** YOU WON.  CONGRATULATIONS!! **");
    else if (winner == 1)
      System.out.println("\n** YOU LOST..  Maybe next time :) **");
    else
      System.out.println("\n** DRAW... **");

  }

  public static void resetBoard(char[][] brd)
  {
    for (int i = 0; i < brd.length; i++)
      for (int j = 0; j < brd[0].length; j++)
        brd[i][j] = ' ';
  }
  

 
  public static void showBoard(char[][] brd)
  {
    int numRow = brd.length;
    int numCol = brd[0].length;

    System.out.println();

    
    System.out.print("    ");
    for (int i = 0; i < numCol; i++)
      System.out.print(i + "   ");
    System.out.print('\n');

    System.out.println();

    
    for (int i = 0; i < numRow; i++) {
      System.out.print(i + "  ");
      for (int j = 0; j < numCol; j++) {
        if (j != 0)
          System.out.print("|");
        System.out.print(" " + brd[i][j] + " ");
      }

      System.out.println();

      if (i != (numRow - 1)) {
        
        System.out.print("   ");
        for (int j = 0; j < numCol; j++) {
          if (j != 0)
            System.out.print("+");
          System.out.print("---");
        }
        System.out.println();
      }
    }
    System.out.println();
  }

  
  
  public static void userPlay(char[][] brd, char usym)
  {
	  int rowIndex, colIndex;
	  if(usym == 'X' || usym == 'x'){
    System.out.print("\nEnter the row indices for player 'X' (0-2)    : ");
        rowIndex = sc.nextInt();
     System.out.print("Enter the column indices for player 'X' (0-2) : ");
    colIndex = sc.nextInt();
	  }
	  else{
		  System.out.print("\nEnter the row indices for player 'O' (0-2)     : ");
	        rowIndex = sc.nextInt();
	      System.out.print("\nEnter the column indices for player 'O' (0-2) : ");
	    colIndex = sc.nextInt();
	  }

    while (brd[rowIndex][colIndex] != ' ') {
      System.out.print("\n!! The cell is already taken.\nEnter the row indices: ");
      rowIndex = sc.nextInt();
      System.out.print("\n!! The cell is already taken.\nEnter the column indices: ");
      colIndex = sc.nextInt();
    }

    brd[rowIndex][colIndex] = usym;
  }
//Sarvani
  
  //sarvani
  public static void compPlay(char[][] brd, char csym)
  {
    
       if(csym == 'o' || csym == 'O'){ 
    	   System.out.println("My PC turn : "+csym);
    	   if((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[0][2] == ' ')){
 	          brd[0][2] = csym;
 	          
 	      }
 	      else if((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[0][2] == 'O' || brd[0][2] == 'o') && (brd[0][1] == ' ')){
 	          brd[0][1] = csym;
 	          
 	      }
 	      else if((brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[0][2] == 'O' || brd[0][2] == 'o') && (brd[0][0] == ' ')){
 	          brd[0][0] = csym;
 	          
 	      }
 	      //2nd row double entry
 	      else if((brd[1][0] == 'O' || brd[1][0] == 'o') && (brd[1][1] == 'O' || brd[1][1] == 'o') && (brd[1][2] == ' ')){
 	          brd[1][2] = csym;
 	          
 	      }
 	      else if((brd[1][0] == 'O' || brd[1][0] == 'o') && (brd[1][2] == 'O' || brd[1][2] == 'o') && (brd[1][1] == ' ')){
 	          brd[1][1] = csym;
 	          
 	      }
 	      else if((brd[1][1] == 'O' || brd[1][1] == 'o') && (brd[1][2] == 'O' || brd[1][2] == 'o') && brd[1][0] == ' '){
 	          brd[1][0] = csym;
 	          
 	      }
 	      //3rd row double entry
 	      else if((brd[2][0] == 'O' || brd[2][0] == 'o') && (brd[2][1] == 'O' || brd[2][1] == 'o') && (brd[2][2] == ' ')){
 	          brd[2][2] = csym;
 	          
 	      }
 	      else if((brd[2][1] == 'o' || brd[2][1] == 'o') && (brd[2][2] == 'O' || brd[2][2] == 'o') && brd[2][0] == ' '){
 	          brd[2][0] = csym;
 	          
 	      }
 	      else if((brd[2][0] == 'O' || brd[2][0] == 'o') && (brd[2][2] == 'O' || brd[2][2] == 'o') && (brd[2][1] == ' ')){
 	          brd[2][1] = csym;
 	          
 	      }
 	      //1st column
 	      else if((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[1][0] == 'O' || brd[1][0] == 'o') && brd[2][0] == ' '){
 	          brd[2][0] = csym;
 	          
 	      }
 	      else if((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[2][0] == 'O' || brd[2][0] == 'o') && (brd[1][0] == ' ')){
 	          brd[1][0] = csym;
 	          
 	      }
 	      else if((brd[1][0] == 'O' || brd[1][0] == 'o') && (brd[2][0] == 'O' || brd[2][0] == 'o') && brd[0][0] == ' '){
 	          brd[0][0] = csym;
 	          
 	      }
 	      //2nd column
 	      else if((brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[1][1] == 'O' || brd[1][1] == 'o') && brd[2][1] == ' '){
 	          brd[2][1] = csym;
 	          
 	      }
 	      else if((brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[2][1] == 'O' || brd[2][1] == 'o') && brd[1][1] == ' '){
 	          brd[1][1] = csym;
 	          
 	      }
 	      else if((brd[1][1] == 'O' || brd[1][1] == 'o') && (brd[2][1] == 'O' || brd[2][1] == 'o') && (brd[0][1] == ' ')){
 	          brd[0][1] = csym;
 	          
 	      }
 	      //3rd column
 	      else if((brd[0][2] == 'O' || brd[0][2] == 'o') && (brd[1][2] == 'O' || brd[1][2] == 'o') && (brd[2][2] == ' ')){
 	          brd[2][2] = csym;
 	          
 	      }
 	      else if((brd[0][2] == 'O' || brd[0][2] == 'o') && (brd[2][2] == 'O' || brd[2][2] == 'o') && (brd[1][2] == ' ')){
 	          brd[1][2] = csym;
 	          
 	      }
 	      else if((brd[1][2] == 'O' || brd[1][2] == 'o') && (brd[2][2] == 'O' || brd[2][2] == 'o') && (brd[0][2] == ' ')){
 	          brd[0][2] = csym;
 	          
 	      }
 	      
      //1st row double entry
 	      else if((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[0][2] == ' ')){
          brd[0][2] = csym;
          
      }
      else if((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[0][2] == 'X' || brd[0][2] == 'x') && (brd[0][1] == ' ')){
          brd[0][1] = csym;
          
      }
      else if((brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[0][2] == 'X' || brd[0][2] == 'x') && (brd[0][0] == ' ')){
          brd[0][0] = csym;
          
      }
      //2nd row double entry
      else if((brd[1][0] == 'X' || brd[1][0] == 'x') && (brd[1][1] == 'X' || brd[1][1] == 'x') && (brd[1][2] == ' ')){
          brd[1][2] = csym;
          
      }
      else if((brd[1][0] == 'X' || brd[1][0] == 'x') && (brd[1][2] == 'X' || brd[1][2] == 'x') && (brd[1][1] == ' ')){
          brd[1][1] = csym;
          
      }
      else if((brd[1][1] == 'X' || brd[1][1] == 'x') && (brd[1][2] == 'X' || brd[1][2] == 'x') && (brd[1][0] == ' ')){
          brd[1][0] = csym;
          
      }
      //3rd row double entry
      else if((brd[2][0] == 'X' || brd[2][0] == 'x') && (brd[2][1] == 'X' || brd[2][1] == 'x') && brd[2][2] == ' '){
          brd[2][2] = csym;
          
      }
      else if((brd[2][1] == 'X' || brd[2][1] == 'x') && (brd[2][2] == 'X' || brd[2][2] == 'x') && (brd[2][0] == ' ')){
          brd[2][0] = csym;
          
      }
      else if((brd[2][0] == 'X' || brd[2][0] == 'x') && (brd[2][2] == 'X' || brd[2][2] == 'x') && (brd[2][1] == ' ')){
          brd[2][1] = csym;
          
      }
      //1st column
      else if((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[1][0] == 'X' || brd[1][0] == 'x') && (brd[2][0] == ' ')){
          brd[2][0] = csym;
          
      }
      else if((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[2][0] == 'X' || brd[2][0] == 'x') && (brd[1][0] == ' ')){
          brd[1][0] = csym;
          
      }
      else if((brd[1][0] == 'X' || brd[1][0] == 'x') && (brd[2][0] == 'X' || brd[2][0] == 'x') && (brd[0][0] == ' ')){
          brd[0][0] = csym;
          
      }
      //2nd column
      else if((brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[1][1] == 'X' || brd[1][1] == 'x') && (brd[2][1] == ' ')){
          brd[2][1] = csym;
          
      }
      else if((brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[2][1] == 'X' || brd[2][1] == 'x') && (brd[1][1] == ' ')){
          brd[1][1] = csym;
          
      }
      else if((brd[1][1] == 'X' || brd[1][1] == 'x') && (brd[2][1] == 'X' || brd[2][1] == 'x') && (brd[0][1] == ' ')){
          brd[0][1] = csym;
          
      }
      //3rd column
      else if((brd[0][2] == 'X' || brd[0][2] == 'x') && (brd[1][2] == 'X' || brd[1][2] == 'x') && (brd[2][2] == ' ')){
          brd[2][2] = csym;
          
      }
      else if((brd[0][2] == 'X' || brd[0][2] == 'x') && (brd[2][2] == 'X' || brd[2][2] == 'x') && (brd[1][2] == ' ')){
          brd[1][2] = csym;
          
      }
      else if((brd[1][2] == 'X' || brd[1][2] == 'x') && (brd[2][2] == 'X' || brd[2][2] == 'x') && (brd[0][2] == ' ')){
          brd[0][2] = csym;
          
          
          
      }
    
      else if((((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[0][1] == 'X' || brd[0][1] == 'x')) &&
    		  ((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[0][2] == 'X' || brd[0][2] == 'x')) && 
    		  ((brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[0][2] == 'X' || brd[0][2] == 'x')) && 
    		  ((brd[1][0] == 'X' || brd[1][0] == 'x') && (brd[1][1] == 'X' || brd[1][1] == 'x')) && 
    		  ((brd[1][0] == 'X' || brd[1][0] == 'x') && (brd[1][2] == 'X' || brd[1][2] == 'x')) && 
    		  ((brd[1][1] == 'X' || brd[1][1] == 'x') && (brd[1][2] == 'X' || brd[1][2] == 'x')) && 
    		  ((brd[2][0] == 'X' || brd[2][0] == 'x') && (brd[2][1] == 'X' || brd[2][1] == 'x')) && 
    		  ((brd[2][1] == 'X' || brd[2][1] == 'x') && (brd[2][2] == 'X' || brd[2][2] == 'x')) && 
    		  ((brd[2][0] == 'X' || brd[2][0] == 'x') && (brd[2][2] == 'X' || brd[2][2] == 'x')) && 
    		  ((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[1][0] == 'X' || brd[1][0] == 'x')) && 
    		  ((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[2][0] == 'X' || brd[2][0] == 'x')) && 
    		  ((brd[1][0] == 'X' || brd[1][0] == 'x') && (brd[2][0] == 'X' || brd[2][0] == 'x')) && 
    		  ((brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[1][1] == 'X' || brd[1][1] == 'x')) && 
    		  ((brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[2][1] == 'X' || brd[2][1] == 'x')) && 
    		  ((brd[1][1] == 'X' || brd[1][1] == 'x') && (brd[2][1] == 'X' || brd[2][1] == 'x')) && 
    		  ((brd[0][2] == 'X' || brd[0][2] == 'x') && (brd[1][2] == 'X' || brd[1][2] == 'x')) && 
    		  ((brd[0][2] == 'X' || brd[0][2] == 'x') && (brd[2][2] == 'X' || brd[2][2] == 'x')) && 
    		  ((brd[1][2] == 'X' || brd[1][2] == 'x') && (brd[2][2] == 'X' || brd[2][2] == 'x')) &&
    		  ((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[0][0] != ' ' || brd[0][0] != ' ')) && 
    		  ((brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[0][1] != ' ' || brd[0][1] != ' ')) && 
    		  ((brd[0][2] == 'X' || brd[0][2] == 'x') && (brd[0][2] != ' ' || brd[0][2] != ' ')) && 
    		  ((brd[1][0] == 'X' || brd[1][0] == 'x') && (brd[1][0] != ' ' || brd[1][0] != ' ')) && 
    		  ((brd[1][1] == 'X' || brd[1][1] == 'x') && (brd[1][1] != ' ' || brd[1][1] != ' ')) && 
    		  ((brd[1][2] == 'X' || brd[1][2] == 'x') && (brd[1][2] != ' ' || brd[1][2] != ' ')) && 
    		  ((brd[2][0] == 'X' || brd[2][0] == 'x') && (brd[2][0] != ' ' || brd[2][0] != ' ')) && 
    		  ((brd[2][1] == 'X' || brd[2][1] == 'x') && (brd[2][1] != ' ' || brd[2][1] != ' ')) && 
    		  ((brd[2][2] == 'X' || brd[2][2] == 'x') && (brd[2][2] != ' ' || brd[2][2] != ' ')))){
    	  for (int i1 = 0; i1 < brd.length; i1++) {
    	      for (int j1 = 0; j1 < brd[0].length; j1++) {
    	        if (brd[i1][j1] == ' ') { // empty cell
    	          brd[i1][j1] = csym;
    	          return;
    	        }
    	      }
      }
    	
      }
      //01, 10, 12
      else if((brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[1][0] == 'X' || brd[1][0] == 'x') && (brd[1][2] == 'X' || brd[1][2] == 'x')){
     	 for (int i1 = 0; i1 < brd.length; i1++) {
    	      for (int j1 = 0; j1 < brd[0].length; j1++) {
    	        if (brd[i1][j1] == ' ') { // empty cell
    	          brd[i1][j1] = csym;
    	          return;
    	        }
    	      }
     	 }
      }
      //01, 20, 22
     	 else if((brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[2][0] == 'X' || brd[2][0] == 'x') && (brd[2][2] == 'x')){
     		 for (int i1 = 0; i1 < brd.length; i1++) {
        	      for (int j1 = 0; j1 < brd[0].length; j1++) {
        	        if (brd[i1][j1] == ' ') { // empty cell
        	          brd[i1][j1] = csym;
        	          return;
        	        }
        	      }
    	  }
     	 }
      //01, 10, 21
     	 else if((brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[1][0] == 'X' || brd[1][0] == 'x') && (brd[2][1] == 'X' || brd[2][1] == 'x')){
     		 for (int i1 = 0; i1 < brd.length; i1++) {
        	      for (int j1 = 0; j1 < brd[0].length; j1++) {
        	        if (brd[i1][j1] == ' ') { // empty cell
        	          brd[i1][j1] = csym;
        	          return;
        	        }
        	      }
    	  }
     	 }
      //02, 10, 22
     	 else if((brd[0][2] == 'X' || brd[0][2] == 'x') && (brd[1][0] == 'X' || brd[1][0] == 'x') && (brd[2][2] == 'X' || brd[2][2] == 'x')){
     		 for (int i1 = 0; i1 < brd.length; i1++) {
        	      for (int j1 = 0; j1 < brd[0].length; j1++) {
        	        if (brd[i1][j1] == ' ') { // empty cell
        	          brd[i1][j1] = csym;
        	          return;
        	        }
        	      }
    	  }
     	 }
      //01, 12, 21
     	 else if((brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[1][2] == 'X' || brd[1][2] == 'x') && (brd[2][1] == 'X' || brd[2][1] == 'x')){
     		 for (int i1 = 0; i1 < brd.length; i1++) {
        	      for (int j1 = 0; j1 < brd[0].length; j1++) {
        	        if (brd[i1][j1] == ' ') { // empty cell
        	          brd[i1][j1] = csym;
        	          return;
        	        }
        	      }
    	  }
     	 }
      //00, 12, 20
     	 else if((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[1][2] == 'X' || brd[1][2] == 'x') && (brd[2][0] == 'X' || brd[2][0] == 'x')){
     		 for (int i1 = 0; i1 < brd.length; i1++) {
        	      for (int j1 = 0; j1 < brd[0].length; j1++) {
        	        if (brd[i1][j1] == ' ') { // empty cell
        	          brd[i1][j1] = csym;
        	          return;
        	        }
        	      }
    	  }
     	 }
     		 //10, 12, 21
     		 else if((brd[1][0] == 'X' || brd[1][0] == 'x') && (brd[1][2] == 'X' || brd[1][2] == 'x') && (brd[2][1] == 'X' || brd[2][1] == 'x')){
     			 for (int i1 = 0; i1 < brd.length; i1++) {
     	    	      for (int j1 = 0; j1 < brd[0].length; j1++) {
     	    	        if (brd[i1][j1] == ' ') { // empty cell
     	    	          brd[i1][j1] = csym;
     	    	          return;
     	    	        }
     	    	      }
     		  }
     		 }
     	 //00, 02, 21
     		 else if((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[0][2] == 'X' || brd[0][2] == 'x') && (brd[2][1] == 'X' || brd[2][1] == 'x')){
     			 for (int i1 = 0; i1 < brd.length; i1++) {
     	    	      for (int j1 = 0; j1 < brd[0].length; j1++) {
     	    	        if (brd[i1][j1] == ' ') { // empty cell
     	    	          brd[i1][j1] = csym;
     	    	          return;
     	    	        }
     	    	      }
     		  }
     		 }
      //diagonals
     if((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[1][1] == 'X' || brd[1][1] == 'x')){
          brd[2][2] = csym;
          
      }
      else if((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[2][2] == 'X' || brd[2][2] == 'x')){
          brd[1][1] = csym;
          
      }
      else if((brd[1][1] == 'X' || brd[1][1] == 'x') && (brd[2][2] == 'X' || brd[2][2] == 'x')){
          brd[0][0] = csym;
          
      }
      else if((brd[0][2] == 'X' || brd[0][2] == 'x') && (brd[1][1] == 'X' || brd[1][1] == 'x')){
          brd[2][0] = csym;
          
      }
      else if((brd[1][1] == 'X' || brd[1][1] == 'x') && (brd[2][0] == 'X' || brd[2][0] == 'x')){
          brd[0][2] = csym;
          
      }
      else if((brd[0][2] == 'X' || brd[0][2] == 'x') && (brd[2][0] == 'X' || brd[2][0] == 'x')){
          brd[1][1] = csym;
          
      }
      
      else if((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[0][0] != ' ' || brd[0][0] != ' ')){
          brd[1][1] = csym;
          return;
      }
      else if((brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[0][1] != ' ' || brd[0][1] != ' ')){
          brd[1][1] = csym;
          return;
      }
      else if((brd[0][2] == 'X' || brd[0][2] == 'x') && (brd[0][2] != ' ' || brd[0][2] != ' ')){
          brd[1][1] = csym;
          return;
      }
      //2nd row single
      else if((brd[1][0] == 'X' || brd[1][0] == 'x') && (brd[1][0] != ' ' || brd[1][0] != ' ')){
          brd[1][1] = csym;
          return;
      }
      else if((brd[1][1] == 'X' || brd[1][1] == 'x') && (brd[1][1] != ' ' || brd[1][1] != ' ')){
          brd[1][0] = csym;
          return;
      }
      else if((brd[1][2] == 'X' || brd[1][2] == 'x') && (brd[1][2] != ' ' || brd[1][2] != ' ')){
          brd[1][1] = csym;
          return;
      }
      //3rd row single
      else if((brd[2][0] == 'X' || brd[2][0] == 'x') && (brd[2][0] != ' ' || brd[2][0] != ' ')){
          brd[1][1] = csym;
          return;
      }
      else if((brd[2][1] == 'X' || brd[2][1] == 'x') && (brd[2][1] != ' ' || brd[2][1] != ' ')){
          brd[1][1] = csym;
          return;
      }
      else if((brd[2][2] == 'X' || brd[2][2] == 'x') && (brd[2][2] != ' ' || brd[2][2] != ' ')){
          brd[1][1] = csym;
          return;
      }
      
       }
       
       
       else if(csym == 'x' || csym == 'X'){
    	   System.out.println("My PC turn : "+csym);
    	 //1st row double entry
  	      if((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[0][2] == ' ')){
           brd[0][2] = csym;
           
       }
       else if((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[0][2] == 'X' || brd[0][2] == 'x') && brd[0][1] == ' '){
           brd[0][1] = csym;
           
       }
       else if((brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[0][2] == 'X' || brd[0][2] == 'x') && brd[0][0] == ' '){
           brd[0][0] = csym;
           
       }
       //2nd row double entry
       else if((brd[1][0] == 'X' || brd[1][0] == 'x') && (brd[1][1] == 'X' || brd[1][1] == 'x') && brd[1][2] == ' '){
           brd[1][2] = csym;
           
       }
       else if((brd[1][0] == 'X' || brd[1][0] == 'x') && (brd[1][2] == 'X' || brd[1][2] == 'x') && brd[1][1] == ' '){
           brd[1][1] = csym;
           
       }
       else if((brd[1][1] == 'X' || brd[1][1] == 'x') && (brd[1][2] == 'X' || brd[1][2] == 'x') && brd[1][0] == ' '){
           brd[1][0] = csym;
           
       }
       //3rd row double entry
       else if((brd[2][0] == 'X' || brd[2][0] == 'x') && (brd[2][1] == 'X' || brd[2][1] == 'x') && brd[2][2] == ' '){
           brd[2][2] = csym;
           
       }
       else if((brd[2][1] == 'X' || brd[2][1] == 'x') && (brd[2][2] == 'X' || brd[2][2] == 'x') && brd[2][0] == ' '){
           brd[2][0] = csym;
           
       }
       else if((brd[2][0] == 'X' || brd[2][0] == 'x') && (brd[2][2] == 'X' || brd[2][2] == 'x') && brd[2][1] == ' '){
           brd[2][1] = csym;
           
       }
       //1st column
       else if((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[1][0] == 'X' || brd[1][0] == 'x') && brd[2][0] == ' '){
           brd[2][0] = csym;
           
       }
       else if((brd[0][0] == 'X' || brd[0][0] == 'x') && (brd[2][0] == 'X' || brd[2][0] == 'x') && brd[1][0] == ' '){
           brd[1][0] = csym;
           
       }
       else if((brd[1][0] == 'X' || brd[1][0] == 'x') && (brd[2][0] == 'X' || brd[2][0] == 'x') && brd[0][0] == ' '){
           brd[0][0] = csym;
           
       }
       //2nd column
       else if((brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[1][1] == 'X' || brd[1][1] == 'x') && brd[2][1] == ' '){
           brd[2][1] = csym;
           
       }
       else if((brd[0][1] == 'X' || brd[0][1] == 'x') && (brd[2][1] == 'X' || brd[2][1] == 'x') && brd[1][1] == ' '){
           brd[1][1] = csym;
           
       }
       else if((brd[1][1] == 'X' || brd[1][1] == 'x') && (brd[2][1] == 'X' || brd[2][1] == 'x') && brd[0][1] == ' '){
           brd[0][1] = csym;
           
       }
       //3rd column
       else if((brd[0][2] == 'X' || brd[0][2] == 'x') && (brd[1][2] == 'X' || brd[1][2] == 'x') && brd[2][2] == ' '){
           brd[2][2] = csym;
           
       }
       else if((brd[0][2] == 'X' || brd[0][2] == 'x') && (brd[2][2] == 'X' || brd[2][2] == 'x') && brd[1][2] == ' '){
           brd[1][2] = csym;
           
       }
       else if((brd[1][2] == 'X' || brd[1][2] == 'x') && (brd[2][2] == 'X' || brd[2][2] == 'x') && brd[0][2] == ' '){
           brd[0][2] = csym;
           
       }
     
    	 //1st row double entry
       else if((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[0][2] == ' ')){
    	          brd[0][2] = csym;
    	          
    	      }
    	      else if((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[0][2] == 'O' || brd[0][2] == 'o') && (brd[0][1] == ' ')){
    	          brd[0][1] = csym;
    	          
    	      }
    	      else if((brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[0][2] == 'O' || brd[0][2] == 'o') && (brd[0][0] == ' ')){
    	          brd[0][0] = csym;
    	          
    	      }
    	      //2nd row double entry
    	      else if((brd[1][0] == 'O' || brd[1][0] == 'o') && (brd[1][1] == 'O' || brd[1][1] == 'o') && (brd[1][2] == ' ')){
    	          brd[1][2] = csym;
    	          
    	      }
    	      else if((brd[1][0] == 'O' || brd[1][0] == 'o') && (brd[1][2] == 'O' || brd[1][2] == 'o') && (brd[1][1] == ' ')){
    	          brd[1][1] = csym;
    	          
    	      }
    	      else if((brd[1][1] == 'O' || brd[1][1] == 'o') && (brd[1][2] == 'O' || brd[1][2] == 'o') && (brd[1][0] == ' ')){
    	          brd[1][0] = csym;
    	          
    	      }
    	      //3rd row double entry
    	      else if((brd[2][0] == 'O' || brd[2][0] == 'o') && (brd[2][1] == 'O' || brd[2][1] == 'o') && (brd[2][2] == ' ')){
    	          brd[2][2] = csym;
    	          
    	      }
    	      else if((brd[2][1] == 'o' || brd[2][1] == 'o') && (brd[2][2] == 'O' || brd[2][2] == 'o') && (brd[2][0] == ' ')){
    	          brd[2][0] = csym;
    	          
    	      }
    	      else if((brd[2][0] == 'O' || brd[2][0] == 'o') && (brd[2][2] == 'O' || brd[2][2] == 'o') && (brd[2][1] == ' ')){
    	          brd[2][1] = csym;
    	          
    	      }
    	      //1st column
    	      else if((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[1][0] == 'O' || brd[1][0] == 'o') && (brd[2][0] == ' ')){
    	          brd[2][0] = csym;
    	          
    	      }
    	      else if((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[2][0] == 'O' || brd[2][0] == 'o') && (brd[1][0] == ' ')){
    	          brd[1][0] = csym;
    	          
    	      }
    	      else if((brd[1][0] == 'O' || brd[1][0] == 'o') && (brd[2][0] == 'O' || brd[2][0] == 'o') && (brd[0][0] == ' ')){
    	          brd[0][0] = csym;
    	          
    	      }
    	      //2nd column
    	      else if((brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[1][1] == 'O' || brd[1][1] == 'o') && (brd[2][1] == ' ')){
    	          brd[2][1] = csym;
    	          
    	      }
    	      else if((brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[2][1] == 'O' || brd[2][1] == 'o') && (brd[1][1] == ' ')){
    	          brd[1][1] = csym;
    	          
    	      }
    	      else if((brd[1][1] == 'O' || brd[1][1] == 'o') && (brd[2][1] == 'O' || brd[2][1] == 'o') && (brd[0][1] == ' ')){
    	          brd[0][1] = csym;
    	          
    	      }
    	      //3rd column
    	      else if((brd[0][2] == 'O' || brd[0][2] == 'o') && (brd[1][2] == 'O' || brd[1][2] == 'o') && (brd[2][2] == ' ')){
    	          brd[2][2] = csym;
    	          
    	      }
    	      else if((brd[0][2] == 'O' || brd[0][2] == 'o') && (brd[2][2] == 'O' || brd[2][2] == 'o') && (brd[1][2] == ' ')){
    	          brd[1][2] = csym;
    	          
    	      }
    	      else if((brd[1][2] == 'O' || brd[1][2] == 'o') && (brd[2][2] == 'O' || brd[2][2] == 'o') && (brd[0][2] == ' ')){
    	          brd[0][2] = csym;
    	          
    	      }
    	      
    	      else if((((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[0][1] == 'O' || brd[0][1] == 'o')) &&
    	    		  ((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[0][2] == 'O' || brd[0][2] == 'o')) && 
    	    		  ((brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[0][2] == 'O' || brd[0][2] == 'o')) && 
    	    		  ((brd[1][0] == 'O' || brd[1][0] == 'o') && (brd[1][1] == 'O' || brd[1][1] == 'o')) && 
    	    		  ((brd[1][0] == 'O' || brd[1][0] == 'o') && (brd[1][2] == 'O' || brd[1][2] == 'o')) && 
    	    		  ((brd[1][1] == 'O' || brd[1][1] == 'o') && (brd[1][2] == 'O' || brd[1][2] == 'o')) && 
    	    		  ((brd[2][0] == 'O' || brd[2][0] == 'o') && (brd[2][1] == 'O' || brd[2][1] == 'o')) && 
    	    		  ((brd[2][1] == 'O' || brd[2][1] == 'o') && (brd[2][2] == 'O' || brd[2][2] == 'o')) && 
    	    		  ((brd[2][0] == 'O' || brd[2][0] == 'o') && (brd[2][2] == 'O' || brd[2][2] == 'o')) && 
    	    		  ((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[1][0] == 'O' || brd[1][0] == 'o')) && 
    	    		  ((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[2][0] == 'O' || brd[2][0] == 'o')) && 
    	    		  ((brd[1][0] == 'O' || brd[1][0] == 'o') && (brd[2][0] == 'O' || brd[2][0] == 'o')) && 
    	    		  ((brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[1][1] == 'O' || brd[1][1] == 'o')) && 
    	    		  ((brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[2][1] == 'O' || brd[2][1] == 'o')) && 
    	    		  ((brd[1][1] == 'O' || brd[1][1] == 'o') && (brd[2][1] == 'O' || brd[2][1] == 'o')) && 
    	    		  ((brd[0][2] == 'O' || brd[0][2] == 'o') && (brd[1][2] == 'O' || brd[1][2] == 'o')) && 
    	    		  ((brd[0][2] == 'O' || brd[0][2] == 'o') && (brd[2][2] == 'O' || brd[2][2] == 'o')) && 
    	    		  ((brd[1][2] == 'O' || brd[1][2] == 'o') && (brd[2][2] == 'O' || brd[2][2] == 'o')) &&
    	    		  ((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[0][0] != ' ' || brd[0][0] != ' ')) && 
    	    		  ((brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[0][1] != ' ' || brd[0][1] != ' ')) && 
    	    		  ((brd[0][2] == 'O' || brd[0][2] == 'o') && (brd[0][2] != ' ' || brd[0][2] != ' ')) && 
    	    		  ((brd[1][0] == 'O' || brd[1][0] == 'o') && (brd[1][0] != ' ' || brd[1][0] != ' ')) && 
    	    		  ((brd[1][1] == 'O' || brd[1][1] == 'o') && (brd[1][1] != ' ' || brd[1][1] != ' ')) && 
    	    		  ((brd[1][2] == 'O' || brd[1][2] == 'o') && (brd[1][2] != ' ' || brd[1][2] != ' ')) && 
    	    		  ((brd[2][0] == 'O' || brd[2][0] == 'o') && (brd[2][0] != ' ' || brd[2][0] != ' ')) && 
    	    		  ((brd[2][1] == 'O' || brd[2][1] == 'o') && (brd[2][1] != ' ' || brd[2][1] != ' ')) && 
    	    		  ((brd[2][2] == 'O' || brd[2][2] == 'o') && (brd[2][2] != ' ' || brd[2][2] != ' ')))){
    	    	  for (int i1 = 0; i1 < brd.length; i1++) {
    	    	      for (int j1 = 0; j1 < brd[0].length; j1++) {
    	    	        if (brd[i1][j1] == ' ') { // empty cell
    	    	          brd[i1][j1] = csym;
    	    	          return;
    	    	        }
    	    	      }
    	      }
    	    	
    	      }
    	      //01, 10, 12
    	      else if((brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[1][0] == 'O' || brd[1][0] == 'o') && (brd[1][2] == 'O' || brd[1][2] == 'o')){
    	     	 for (int i1 = 0; i1 < brd.length; i1++) {
    	    	      for (int j1 = 0; j1 < brd[0].length; j1++) {
    	    	        if (brd[i1][j1] == ' ') { // empty cell
    	    	          brd[i1][j1] = csym;
    	    	          return;
    	    	        }
    	    	      }
    	     	 }
    	      }
    	      //01, 20, 22
    	     	 else if((brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[2][0] == 'O' || brd[2][0] == 'o') && (brd[2][2] == 'O' || brd[2][2] == 'O')){
    	     		 for (int i1 = 0; i1 < brd.length; i1++) {
    	        	      for (int j1 = 0; j1 < brd[0].length; j1++) {
    	        	        if (brd[i1][j1] == ' ') { // empty cell
    	        	          brd[i1][j1] = csym;
    	        	          return;
    	        	        }
    	        	      }
    	    	  }
    	     	 }
    	      //01, 10, 21
    	     	 else if((brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[1][0] == 'O' || brd[1][0] == 'o') && (brd[2][1] == 'O' || brd[2][1] == 'o')){
    	     		 for (int i1 = 0; i1 < brd.length; i1++) {
    	        	      for (int j1 = 0; j1 < brd[0].length; j1++) {
    	        	        if (brd[i1][j1] == ' ') { // empty cell
    	        	          brd[i1][j1] = csym;
    	        	          return;
    	        	        }
    	        	      }
    	    	  }
    	     	 }
    	      //02, 10, 22
    	     	 else if((brd[0][2] == 'O' || brd[0][2] == 'o') && (brd[1][0] == 'O' || brd[1][0] == 'o') && (brd[2][2] == 'O' || brd[2][2] == 'o')){
    	     		 for (int i1 = 0; i1 < brd.length; i1++) {
    	        	      for (int j1 = 0; j1 < brd[0].length; j1++) {
    	        	        if (brd[i1][j1] == ' ') { // empty cell
    	        	          brd[i1][j1] = csym;
    	        	          return;
    	        	        }
    	        	      }
    	    	  }
    	     	 }
    	      //01, 12, 21
    	     	 else if((brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[1][2] == 'O' || brd[1][2] == 'o') && (brd[2][1] == 'O' || brd[2][1] == 'o')){
    	     		 for (int i1 = 0; i1 < brd.length; i1++) {
    	        	      for (int j1 = 0; j1 < brd[0].length; j1++) {
    	        	        if (brd[i1][j1] == ' ') { // empty cell
    	        	          brd[i1][j1] = csym;
    	        	          return;
    	        	        }
    	        	      }
    	    	  }
    	     	 }
    	      //00, 12, 20
    	     	 else if((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[1][2] == 'O' || brd[1][2] == 'o') && (brd[2][0] == 'O' || brd[2][0] == 'o')){
    	     		 for (int i1 = 0; i1 < brd.length; i1++) {
    	        	      for (int j1 = 0; j1 < brd[0].length; j1++) {
    	        	        if (brd[i1][j1] == ' ') { // empty cell
    	        	          brd[i1][j1] = csym;
    	        	          return;
    	        	        }
    	        	      }
    	    	  }
    	     	 }
    	     		 //10, 12, 21
    	     		 else if((brd[1][0] == 'O' || brd[1][0] == 'o') && (brd[1][2] == 'O' || brd[1][2] == 'o') && (brd[2][1] == 'O' || brd[2][1] == 'o')){
    	     			 for (int i1 = 0; i1 < brd.length; i1++) {
    	     	    	      for (int j1 = 0; j1 < brd[0].length; j1++) {
    	     	    	        if (brd[i1][j1] == ' ') { // empty cell
    	     	    	          brd[i1][j1] = csym;
    	     	    	          return;
    	     	    	        }
    	     	    	      }
    	     		  }
    	     		 }
    	     	 //00, 02, 21
    	     		 else if((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[0][2] == 'O' || brd[0][2] == 'o') && (brd[2][1] == 'O' || brd[2][1] == 'o')){
    	     			 for (int i1 = 0; i1 < brd.length; i1++) {
    	     	    	      for (int j1 = 0; j1 < brd[0].length; j1++) {
    	     	    	        if (brd[i1][j1] == ' ') { // empty cell
    	     	    	          brd[i1][j1] = csym;
    	     	    	          return;
    	     	    	        }
    	     	    	      }
    	     		  }
    	     		 }
    	      //diagonals
    	     if((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[1][1] == 'O' || brd[1][1] == 'o')){
    	          brd[2][2] = csym;
    	          
    	      }
    	      else if((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[2][2] == 'O' || brd[2][2] == 'o')){
    	          brd[1][1] = csym;
    	          
    	      }
    	      else if((brd[1][1] == 'O' || brd[1][1] == 'o') && (brd[2][2] == 'O' || brd[2][2] == 'o')){
    	          brd[0][0] = csym;
    	          
    	      }
    	      else if((brd[0][2] == 'O' || brd[0][2] == 'o') && (brd[1][1] == 'O' || brd[1][1] == 'o')){
    	          brd[2][0] = csym;
    	          
    	      }
    	      else if((brd[1][1] == 'O' || brd[1][1] == 'o') && (brd[2][0] == 'O' || brd[2][0] == 'o')){
    	          brd[0][2] = csym;
    	          
    	      }
    	      else if((brd[0][2] == 'O' || brd[0][2] == 'o') && (brd[2][0] == 'O' || brd[2][0] == 'o')){
    	          brd[1][1] = csym;
    	          
    	      }
    	      
    	      else if((brd[0][0] == 'O' || brd[0][0] == 'o') && (brd[0][0] != ' ' || brd[0][0] != ' ')){
    	          brd[1][1] = csym;
    	          return;
    	      }
    	      else if((brd[0][1] == 'O' || brd[0][1] == 'o') && (brd[0][1] != ' ' || brd[0][1] != ' ')){
    	          brd[1][1] = csym;
    	          return;
    	      }
    	      else if((brd[0][2] == 'O' || brd[0][2] == 'o') && (brd[0][2] != ' ' || brd[0][2] != ' ')){
    	          brd[1][1] = csym;
    	          return;
    	      }
    	      //2nd row single
    	      else if((brd[1][0] == 'O' || brd[1][0] == 'o') && (brd[1][0] != ' ' || brd[1][0] != ' ')){
    	          brd[1][1] = csym;
    	          return;
    	      }
    	      else if((brd[1][1] == 'O' || brd[1][1] == 'o') && (brd[1][1] != ' ' || brd[1][1] != ' ')){
    	          brd[1][0] = csym;
    	          return;
    	      }
    	      else if((brd[1][2] == 'O' || brd[1][2] == 'o') && (brd[1][2] != ' ' || brd[1][2] != ' ')){
    	          brd[1][1] = csym;
    	          return;
    	      }
    	      //3rd row single
    	      else if((brd[2][0] == 'O' || brd[2][0] == 'o') && (brd[2][0] != ' ' || brd[2][0] != ' ')){
    	          brd[1][1] = csym;
    	          return;
    	      }
    	      else if((brd[2][1] == 'O' || brd[2][1] == 'o') && (brd[2][1] != ' ' || brd[2][1] != ' ')){
    	          brd[1][1] = csym;
    	          return;
    	      }
    	      else if((brd[2][2] == 'O' || brd[2][2] == 'o') && (brd[2][2] != ' ' || brd[2][2] != ' ')){
    	          brd[1][1] = csym;
    	          return;
    	      }
    	      
    	    
       }
   }
  
  //Jason
  public static boolean isGameWon(char[][] brd, int turn, char usym, char csym)
  {
    char sym;
    if (turn == 0)
      sym = usym;
    else
      sym = csym;

    int i, j;
    boolean win = false;
    for (i = 0; i < brd.length && !win; i++) {
      for (j = 0; j < brd[0].length; j++) {
        if (brd[i][j] != sym)
          break;
      }
      if (j == brd[0].length)
        win = true;
    }
    for (j = 0; j < brd[0].length && !win; j++) {
      for (i = 0; i < brd.length; i++) {
        if (brd[i][j] != sym)
          break;
      }
      if (i == brd.length)
        win = true;
    }
    if (!win) {
      for (i = 0; i < brd.length; i++) {
        if (brd[i][i] != sym)
          break;
      }
      if (i == brd.length)
        win = true;
    }
    if (!win) {
      for (i = 0; i < brd.length; i++) {
        if (brd[i][brd.length - 1 - i] != sym)
          break;
      }
      if (i == brd.length)
        win = true;
    }
    return win;
  }
}
//Jason
