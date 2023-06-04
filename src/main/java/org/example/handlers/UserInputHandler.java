package org.example.handlers;
import java.util.Scanner;
public class UserInputHandler {

    private static Scanner scanner = new Scanner(System.in);

    public static MenuOptions getMenuOptionFromUser()
    {
     return MenuOptions.values()[getSelectedOptionFromUser()-1];
    }

    private static int getSelectedOptionFromUser() {
        int result = getIntigerFormUser();
        scanner.nextLine();
        if(result>0 && result<MenuOptions.values().length+1){
            return result;
        }
        else {
            System.out.println("You selected non existing option " + result );
            System.out.println("Pleas try agian");
            return getSelectedOptionFromUser();
        }
    }

    private static int getIntigerFormUser() {
        while(!scanner.hasNext()){
            scanner.nextLine();
            System.out.println("It is not intiger. Try agian");
    }
        return scanner.nextInt();
}}
