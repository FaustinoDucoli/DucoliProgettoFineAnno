/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._piscina_ducoli;

import eccezioni.EccezionePosizioneNonValida;
import file.FileExeption;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.InputMismatchException;
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
        int codice=1;
        Scanner tastiera= new Scanner(System.in);
        String[] vociMenu= new String[8];
        vociMenu[0] = "Esci";
        vociMenu[1] = "Aggiungi un cliente";
        vociMenu[2] = "Visualizza Clienti entrati e usciti";
        vociMenu[3] = "Visualizza clienti presenti";
        vociMenu[4] = "Rimuovi cliente";
        vociMenu[5] = "Visualizza elenco clienti in ordine alfabetico";
        vociMenu[6] = "Esporta libri in formato csv";
        vociMenu[7] = "Salva dati";
        
        String nomeFileCSV="Piscina.txt";
        String nomeFileBinario="Piscina.bin";
        
        Menu menu= new Menu(vociMenu);
        
        //deserializzazione
        
        try 
        {
            
            p1=p1.caricaPiscina(nomeFileBinario);
            System.out.println("Dati caricati correttamente");
        }
        catch (IOException ex) 
        {
            System.out.println("Impossibile accedere al file. I dati non sono stati caricati");
        }
        catch (FileExeption ex) 
        {
            System.out.println("Errore di lettura dal file. I dati non sono stati caricati");
        }
        
     
        do
        {
            try
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
                       a1.setDataIngresso(LocalDate.now());
                       a1.setOraIngresso(LocalTime.now());
                       nCorsieOccupate++;
                       a1.setCodiceID(codice);
                       codice++;
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
                       String s="";
                       s=p1.visualizzaClientiPresenti();
                        System.out.println(s);
                        break;
                            
                    }
                    case 4:
                    {
                         String nome,cognome;
                         System.out.println("inserisci il nome da eliminare--> ");
                         nome=tastiera.nextLine();
                         System.out.println("cognome da eliminare--> ");
                         cognome=tastiera.nextLine();
                         int esitoOk;
                         esitoOk=p1.eliminaAccesso(nome, cognome);
                         if(esitoOk==0)
                             System.out.println("eliminazione avvenuta correttamente!");
                         
                         else
                             System.out.println("eliminazione non avvenuta correttamente!");

                         break;

                    }
                     case 5:
                    {
                        Accessi[] arrayAccessi;

                        arrayAccessi=p1.visualizzaOrdineAlfabetico();
                        if(arrayAccessi==null)
                            System.out.println("nessun cliente presente");

                        for(int i=0;i<arrayAccessi.length;i++)
                        {
                            System.out.println(arrayAccessi[i]);
                        }

                        break;

                    }
                     case 6:
                    {
                         try
                         {
                            p1.esportaAccessiCsv(nomeFileCSV);
                             System.out.println("esportazione avvenuta correttamente!");
                         }
                         catch(IOException e1)
                         {
                             System.out.println("Impossibile accedere al file, i libri non sono stati salvati.");
                         }
                         catch(EccezionePosizioneNonValida | FileExeption  e2)
                         {
                             System.out.println(e2.toString());
                         }
                         break;
                    }
                     case 7:
                    {

                         //serializzazione
                         try 
                         {
                             p1.salvaPiscina(nomeFileBinario);
                             System.out.println("Dati salvati correttamente");
                         } 
                         catch (IOException ex) 
                         {
                             System.out.println("Impossibile accedere al file. I dati non sono stati salvati");

                         }
                         break;
                    }
             
                }
            }
                
            catch(InputMismatchException | NumberFormatException e1)
            {
                tastiera.nextLine();
                System.out.println("Input non corretto");
            }
                 
             
        }while(sceltaUtente!=0);
       
        
    }



}
