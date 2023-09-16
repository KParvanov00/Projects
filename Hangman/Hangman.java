import java.util.Arrays;
import java.util.Scanner;


public class HangmanNEW {
    static Scanner scan=new Scanner(System.in);
    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        
        String wordIndex=words[randoWord()];
        char[] word=new char[wordIndex.length()]; 
        int gallowIndex=0;
        char[] space=new char[word.length];
        char[] misess=new char[6];
        for (int k = 0; k < wordIndex.length(); k++) {
             word[k]=wordIndex.charAt(k);     
        }   
            for (int j = 0; j < word.length; j++) {
            space[j]='_';
        }
            while(true) {
                System.out.println(gallows[gallowIndex]);
                System.out.print("Word: ");   
            for (int j = 0; j < word.length; j++) {
                System.out.print(space[j]+" ");  
            }
                System.out.println("\n");
                System.out.print("\nMisses: ");
            for (int j = 0; j < misess.length; j++) {
                System.out.print(misess[j]);
            }
                System.out.println("\n");
                System.out.print("\nGuess: ");

            String guessInput0=scan.nextLine();
            char guessInput=guessInput0.charAt(0);
            boolean checking=checkGuess(word, guessInput);

            if(checking==true){
                updatePlaceholders(space, guessInput,word);
            }
            if(checking==false){                
                misess[gallowIndex]=guessInput;
                gallowIndex++;
            }
                System.out.println("\n");
            if(gallowIndex>=6){
                System.out.println("\n"+gallows[gallowIndex]);
                System.out.println("RIP!");
                System.out.print("The word was: ");
                for (int j = 0; j < word.length; j++) {
                    System.out.print(word[j]);
                }               
                System.exit(0);
            }
            if(Arrays.equals(word, space)){
                System.out.println("Good Work!");
                System.exit(0);
            }
        }
    }
    public static void updatePlaceholders(char[] space,char guessInput, char[] word){ 
        for (int i = 0; i < space.length; i++) {
            if (word[i]==guessInput){
                space[i]=guessInput;
           }    
        }
    }
    public static boolean checkGuess(char[]word,char guessInput){
            for (int i = 0; i < word.length; i++) {
                if(guessInput==word[i]){
                    return true;
                }
            }
            return false;
    }
    public static int randoWord(){ 
            double randomWord=Math.random()*words.length+1;
            return (int)randomWord;
    }
    

}





