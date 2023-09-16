import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            
            char[][] board=new char[3][3];
            
            printBoard(board);
            int[] indexes;
            for (int i = 0; i < 9; i++) {
              checkWin(board);
              System.out.print("\nTurn: ");
              if(i%2==0){
                System.out.println("X");
                
               indexes=askUser(board);
                board[indexes[0]][indexes[1]]='X';
                for (int j = 0; j < board.length; j++) {
                  System.out.println("");
                  for (int j2 = 0; j2 < board.length; j2++) {
                    System.out.print("  "+board[j][j2]);
                    
                  
                }
                
                
              }}else if(i%2==1){
                System.out.println("O\n");
                indexes=askUser(board);
                board[indexes[0]][indexes[1]]='O';
                for (int j = 0; j < board.length; j++) {
                  
                  
                  System.out.println("");
                  for (int j2 = 0; j2 < board.length; j2++) {
                    System.out.print("  "+board[j][j2]);
                    if(checkWin(board)==3){
                    System.out.println("O wins");break;
                    
                  }
                    

                  }
                }
              }
              System.out.println("\n");
              if(checkWin(board)==3){
                    System.out.println("X wins");break;
                  }
              else if(checkWin(board)==-3){

                System.out.println("O wins");break;
              }
              if(i>=9){
                System.out.println("It's a tie!");
              }
            }

            scan.close();
        }

    public static void printBoard(char[][] board){
        for (int i = 0; i < board.length; i++) {
            System.out.println("");
            for (int j = 0; j < board.length; j++) {
              board[i][j]='_';
              System.out.print("  "+board[i][j]);
            }
            System.out.println();
        }
    }   

    public static int[] askUser(char[][] board){
      int spot[]=new int[2];
      System.out.println();
      
      while(true){
        System.out.print("pick the row and column: ");
        int pickRow=scan.nextInt();
        int pickColumn=scan.nextInt();
        
        if(board[pickRow][pickColumn]=='X'||board[pickRow][pickColumn]=='O'){
        System.out.println("Spot taken, try again:");
        continue;
        
      }else{
        spot[0]=pickRow;
        spot[1]=pickColumn;
        break;
      }
      
      }

      return spot;
    }

   
    public static int checkWin(char board[][]){
      int count=0;
      
      
      
     int rows = checkRows(board);

     if (Math.abs(rows) == 3){
      
      return rows;
     }

     int columns = checkColumns(board);

     if (Math.abs(columns) == 3) {

      return columns;
     }

     int right = checkRight(board);

     if(Math.abs(right)==3){
      
      return right;
     }

     int left = checkLeft(board);

     if(Math.abs(left)==3){

      return left;
     }


      return count;
    }
    public static int checkRows(char[][] board) {
      int count = 0;
      for (int i = 0; i < board.length; i++) {
        count=0;
        for (int j = 0; j < board.length; j++) {
          if(board[i][j]=='X'){
          count++;
        }else if(board[i][j]=='O'){
          count--;
        }
        }
        if (count==3 || count==-3){
          break;
        }
      }

      return count;
  }
  
  
  public static int checkColumns(char[][] board) {
      int count = 0;
      for (int i = 0; i < board.length; i++) {
        count=0;
        for (int j = 0; j < board.length; j++) {
          if(board[j][i]=='X'){
          count++;
        }else if(board[j][i]=='O'){
          count--;
        }
        }
        if (count==3 || count==-3){
          break;
        }
      }
      return count;
  }
  
  
  public static int checkLeft(char[][] board) {
      int count = 0;
      for (int i = 0; i < board.length; i++) {
        switch (board[i][i]) {
          case 'X':count++;break;
          case 'O':count--;break;
          
        }
      }
      return count;
  }
  
  
  public static int checkRight(char[][] board) {
      int count = 0;
      
      int k = board.length - 1;
      for (int i = 0; i <board.length; i++)
      {
        switch (board[i][k--]) {
          case 'X':count++;break;
          case 'O':count--;break;
          
        }
      }
      
    
      return count;
  }
  


}
