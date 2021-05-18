/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._piscina_ducoli;

import java.util.Scanner;

/**
 *
 * @author FaustinoDucoli
 */
public class Main 
{
    public static void main(String[] args)
    {
        int sceltaUtente =-1;
        Scanner tastiera= new Scanner(System.in);
        String[] vociMenu= new String[5];
        
        vociMenu[0] = "Esci";
        vociMenu[1] = "Aggiungi cliente";
        vociMenu[2] = "Visualizza clienti presenti";
        vociMenu[3] = "Memorizza l'uscita di un cliente";
        vociMenu[4] = "visualizza i clienti presenti ad una determinata data e ora";
        
        Menu menu= new Menu(vociMenu);
        
        switch(sceltaUtente)
        {
            case 0:
            {
                System.out.println("L'applicazione terminerà");
                 break;
            }
            case 1:
            {
                Accessi a1=new Accessi();
                System.out.println("nome Cliente--> ");
                a1.setNome(tastiera.nextLine());
                
                
            }
            case 2:
            {
                
            }
            case 3:
            {
                
            }
            case 4:
            {
                
            }
        }
        
    }
}
