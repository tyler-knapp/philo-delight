package dev.tknapp.philodelight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    public Menu(){}
    
    public void sayHello() throws IOException {
        System.out.println("Hello Again this is the menu");
        String selection = in.readLine();
        System.out.println("You selected " + selection);
    }
    
    public void selectMenuOption(){
        System.out.println("What option would you like to try?");
        System.out.println("1.) Create Account ");
        System.out.println("2.) Exit ");
    }
    
    
}
