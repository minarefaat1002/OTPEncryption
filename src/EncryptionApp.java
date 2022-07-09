import java.util.*;

public class EncryptionApp {
    private Scanner scanner;
    private ArrayList<Character> list;
    private ArrayList<Character> key;
    private char character;
    private String line;
    private char[] lettersOfMessage;
    public EncryptionApp() {
        scanner = new Scanner(System.in);      // for getting data from the user.
        list = new ArrayList();
        key = new ArrayList();
        character = ' '; // the starting character that we're using
        generateNewKey();
        askQuestion();
    }
    private void askQuestion(){
        // asking the user what they want to do ?
        // generate a new key , get the current key,encrypt message , decrypt message
        // or do you want to quit the program?
        while(true){
            System.out.println("what do you want to do?");
            System.out.println("(newkey) for newkey , (getkey) for getKey,(encryption) for encryption ," +
                                " (decryption) for decryptoin, (quit) for quite");
            String response = this.scanner.nextLine().toLowerCase();
            switch(response){
                case "newkey":
                    generateNewKey();
                    break;
                case "getkey":
                    getKey();
                    break;
                case "encryption":
                    encrypt();
                    break;
                case "decryption":
                    decrypt();
                    break;
                case "quit":
                    quit();
                    break;
                default:
                    System.out.println("Please enter a valid answer!");
            }
        }

    }
    private void generateNewKey(){
        character = ' '; // the starting character.
        list.clear(); // to make sure the list is empty.
        key.clear();  // to make sure the key is new.
        for(int i = 32;i<127;i++){
            list.add(Character.valueOf(character));
            character++; // this line increments the ascii code of character
        }
        key = new ArrayList<>(list);
        Collections.shuffle(key);     // to shuffle the key and get a random key
        System.out.println("A new key has been generated");
    }
    private void getKey(){
        // to retrieve the current key
        System.out.println("The current key :");
        for(Character letter:list){
            System.out.print(letter);
        }
        System.out.println();
        for(Character letter:key){
            System.out.print(letter);
        }
        System.out.println();
    }
    private void encrypt(){
        // to encrypt the message
        System.out.println("enter a message to be encrypted");
        String message = scanner.nextLine();
        lettersOfMessage = message.toCharArray();
        for(int i=0;i<lettersOfMessage.length;i++){
            for(int j=0;j<list.size();j++){
                if(lettersOfMessage[i]==list.get(j)){
                    lettersOfMessage[i] = key.get(j);
                    break;
                }
            }
        }
        System.out.println("Encrypted");
        for(char letter: lettersOfMessage){
            System.out.print(letter);
        }
        System.out.println();
    }
    private void decrypt(){
        // to decrypt the message
        System.out.println("enter a message to be decrtypted ");
        String message = scanner.nextLine();
        lettersOfMessage = message.toCharArray();
        for(int i=0;i<lettersOfMessage.length;i++){
            for(int j=0;j<key.size();j++){
                if(lettersOfMessage[i]==key.get(j)){
                    lettersOfMessage[i] = list.get(j);
                    break;
                }
            }
        }
        System.out.println("Decrypted");
        for(char letter: lettersOfMessage){
            System.out.print(letter);
        }
        System.out.println();
    }
    private void quit(){
        // to quite the program
        System.out.println("Good bye!");
        System.exit(0);
    }
}
