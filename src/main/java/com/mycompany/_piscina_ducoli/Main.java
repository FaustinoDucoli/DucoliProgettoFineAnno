/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._piscina_ducoli;

import java.time.LocalDateTime;
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
        Piscina p1=new Piscina();
        int nCorsieOccupate=0;
        Scanner tastiera= new Scanner(System.in);
        String[] vociMenu= new String[5];
        
        
        vociMenu[0] = "Esci";
        vociMenu[1] = "Aggiungi cliente";
        vociMenu[2] = "Visualizza clienti presenti";
        vociMenu[3] = "Memorizza l'uscita di un cliente";
        vociMenu[4] = "visualizza i clienti presenti ad una determinata data e ora";
        
        Menu menu= new Menu(vociMenu);
        do
        {
            sceltaUtente=menu.sceltaMenu();
             switch(sceltaUtente)
        {
                case 0:
                {
                System.out.println("L'applicazione terminerà");
                 break;
                }
                case 1:
                {
                if(nCorsieOccupate>=5)
                  {
                    System.out.println("la piscina è piena, impossibile accedere!");
                    break;
                  }
                Accessi a1=new Accessi();
                int esitoOk;
                System.out.println("nome Cliente--> ");
                a1.setNome(tastiera.nextLine());
                System.out.println("cognome Cliente--> ");
                a1.setCognome(tastiera.nextLine());
                a1.setDataIngresso(LocalDateTime.now());
                nCorsieOccupate++;
                esitoOk=p1.aggiungiCliente(a1);
                if(esitoOk==0)
                    System.out.println("aggiunta avvenuta correttamente.");
                else
                    System.out.println("cliente non registrato correttamente.");
                
                break;
                
                
                }
                case 2:
                {
                p1.visualizzaClienti();
                break;
                }
             case 3:
            {
                
            }
                 case 4:
                 {
                
              }
            }
        }while(sceltaUtente!=0);
       
        
    }
}
