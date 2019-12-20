import java.util.Scanner;
import java.util.ArrayList;




class Main {
      public static String[] info = new String[8];
      public static ArrayList<String> results = new ArrayList<String>();


  public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);  // Create a Scanner object
         System.out.println("Enter EVERYTHING all LOWERCASE we will deal with caps ;)");

    System.out.println("Enter First Name");
    info[0] = scan.nextLine();  // Read user input
     System.out.println("Enter Last Name");
    info[1] = scan.nextLine();  // Read user input
     System.out.println("Enter Pet Name (if none hit enter)");
    info[2] = scan.nextLine();  // Read user input
     System.out.println("Enter Street Name");
    info[3] = scan.nextLine();  // Read user input
     System.out.println("Enter Zip Code");
    info[4] = scan.nextLine();  // Read user input
     System.out.println("Enter Birth Month");
    info[5] = scan.nextLine();  // Read user input
     System.out.println("Enter Birth Day");
    info[6] = scan.nextLine();  // Read user input
     System.out.println("Enter Birth Year");
    info[7] = scan.nextLine();  // Read user input

    genbase(); 
    replace();
    prefix();
    suffix();
    caps();

    System.out.println(results);





  }

  public static void genbase(){
    for(int x = 0; x < info.length; x++){
      results.add(info[x]);
    }
  }


  //Stack overflow stuff (it does the cap permutations because my code would be way longer...)
  static void newFunction(String str){
    int numOfCombos = 1 << str.length();  
    for (int i = 0; i < numOfCombos; i++) {
      char[] combinations = str.toCharArray();
      for (int j = 0; j < str.length(); j++) {
          if (((i >> j) & 1) == 1 ) {
              combinations[j] = Character.toUpperCase(str.charAt(j));
          }
      }
      results.add(new String(combinations));
    }
  }

//method to call the stack overflow stuff
  public static void caps(){
    for(int x = 0; x < info.length; x++) newFunction(info[x]);
  }

  public static void replace(){
    for(int x = 8; x < info.length+8; x++){
      String temp = "";
      for(int y = 0; y < info[x-8].length(); y++){
        if(info[x-8].substring(y, y+1).equals("s")) temp = temp + "$";
        else if(info[x-8].substring(y, y+1).equals("a")) temp = temp + "4";
        else if(info[x-8].substring(y, y+1).equals("e")) temp = temp + "3";
        else if(info[x-8].substring(y, y+1).equals("o")) temp = temp + "0"; 
        else if(info[x-8].substring(y, y+1).equals("l")) temp = temp + "1"; 
        else temp = temp + info[x-8].substring(y, y+1);
      }
              results.add(temp);

      
    }
  }

  public static void prefix(){
    /*123
    12345
    1
    birthday month, year, date
    zipcode*/
    int temp = results.size();
    for(int i = 0; i < temp; i++){
      results.add("123" + results.get(i));
      results.add("12345" + results.get(i));
      results.add("1" + results.get(i));
      results.add(results.get(4) + results.get(i));
      results.add(results.get(5) + results.get(i));
      results.add(results.get(6) + results.get(i));
      results.add(results.get(7) + results.get(i));
    }
  }

  public static void suffix(){
   /*!
   01
   1
   birthday
   lastname
   first letter of lastname
   zipcode*/
 int temp = results.size();
    for(int i = 0; i < temp; i++){
      results.add(results.get(i) + "01");
      results.add(results.get(i) + "!");
      results.add(results.get(i) + "1");
      results.add(results.get(i) + results.get(1));
      results.add(results.get(i) + results.get(1).substring(0, 1));

      results.add(results.get(i) + results.get(4));
      results.add(results.get(i) + results.get(5));
      results.add(results.get(i) + results.get(6));
      results.add(results.get(i) + results.get(7));
    }
   

  }

  public static void println(){

  }
}
