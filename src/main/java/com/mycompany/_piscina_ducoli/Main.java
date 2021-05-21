/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._piscina_ducoli;

import eccezioni.EccezionePosizioneNonValida;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        String[] vociMenu= new String[7];
        vociMenu[0] = "Esci";
        vociMenu[1] = "Aggiungi un cliente";
        vociMenu[2] = "Visualizza Clienti";
        vociMenu[3] = "Rimuovi cliente";
        vociMenu[4] = "Visualizza elenco clienti in ordine alfabetico";
        vociMenu[5] = "Esporta libri in formato csv";
        vociMenu[6] = "Salva dati";
        
        Menu menu= new Menu(vociMenu);
        /*
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
                    
                    Accessi a= new Accessi();
                    int esitoOK;
                    System.out.println("nome--> ");
                    a.setNome(tastiera.nextLine());
                    System.out.println("cognome--> ");
                    a.setCognome(tastiera.nextLine());
                    a.setDataIngresso(LocalDate.now());
                    a.setOraIngresso(LocalTime.now());
                   nCorsieOccupate++;
                   esitoOK=p1.aggiungiCliente(a);
                   if(esitoOK==0)
                       System.out.println("aggiunta avvenuta correttamente.");
                   else
                       System.out.println("cliente non registrato correttamente.");


                    
                    try
                    {
                          a.setAccessi(a);
                          System.out.println("inserimento avvenuto correttamente!");
                    }
                    catch(EccezionePosizioneNonValida e1)
                    {
                        System.out.println(e1.toString());
                    }
                     
                    
                   
                    
                   
                    System.out.println("premi un pulsante per continuare.!");
                    tastiera.nextLine();
                    break;
                }
                 case 2:
                {
                   p1.visualizzaClienti();
        
                    break;
                }
                 case 3:
                {
                    //elimina libro
                    System.out.println("ripiano [1..4]-->");
                    ripiano = tastiera.nextInt();
                    System.out.println("posizione [1..14]-->");
                    posizione = tastiera.nextInt();
                    try
                    {
                        s1.rimuoviLibro(ripiano, posizione);
                        System.out.println("libro eliminato correttamente");
                    }
                    catch(EccezionePosizioneNonValida e1)
                    {
                        System.out.println(e1.toString());
                    }
                     catch(EccezionePosizioneVuota e2)
                    {
                        System.out.println(e2.toString());       
                    }
                    
                    
                   
                    System.out.println("premi un pulsante per continuare.");
                    tastiera.nextLine();
                    break;
                
                    
                        
                }
                 case 4:
                {
                    //cerca libro in base  ad Autore
                    String[] elencoTitoli;
                    String autore;
                    System.out.println("Autore-->");
                    autore = tastiera.nextLine();
                    try
                    {
                        elencoTitoli = s1.elencoTitoliAutore(autore);
                         if (elencoTitoli == null)
                        System.out.println("nessun libro di "+autore);
                    else
                    {
                        for (int i=0;i<elencoTitoli.length;i++)
                             System.out.println(elencoTitoli[i]);
                    }
                    }
                    catch(EccezionePosizioneNonValida e1)
                    {
                        System.out.println(e1.toString());
                    }
                    
                   
                    System.out.println("premi un pulsante per continuare.");
                    tastiera.nextLine();
                    break;
                }
                 case 5:
                {
                    System.out.println(s1.toString()); 
                    System.out.println("premi un pulsante per continuare.");
                    tastiera.nextLine();
                    break;
                }
                 case 6:
                 {
                     try
                     {
                         System.out.println(s1.elencoAlfabeticoLibri());
                     }
                     catch(EccezionePosizioneNonValida e1)
                     {
                         System.out.println(e1.toString());
                     }
                     
                     break;
                 }
                 case 7:
                 {
                     Libro[] elencoLibri;
                     try
                     {
                         elencoLibri=s1.elencoLibriOrdinatiPrezzo();
                     for(int i=0;i<elencoLibri.length;i++)
                     {
                         System.out.println(elencoLibri[i].toString() +" € " + elencoLibri[i].prezzo());
                     }
                     }
                     catch(EccezionePosizioneNonValida e1)
                     {
                         System.out.println(e1.toString());
                     }
                     
                     break;
                 }
                 case 8:
                 {
                     Libro[] elencoLibri;
                     try
                     {
                         elencoLibri=s1.elencoLibriAlfabeticoAutoreTitolo();
                     for(int i=0;i<elencoLibri.length;i++)
                     {
                         System.out.println(elencoLibri[i].toString() +" € " + elencoLibri[i].prezzo());
                     }
                     }
                     catch(EccezionePosizioneNonValida e1)
                     {
                         System.out.println(e1.toString());
                     }
                     
                     break;
                 }
                 case 9:
                 {
                     try
                     {
                        s1.esportaLibriCsv(nomeFileCSV);
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
                 case 10:
                 {//serializzazione
                     try 
                     {
                         s1.salvaScaffale(nomeFileBinario);
                         System.out.println("Dati salvati correttamente");
                     } catch (IOException ex) 
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
        
        */
        
        
       
        
        
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
                   a1.setDataIngresso(LocalDate.now());
                   a1.setOraIngresso(LocalTime.now());
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
                 case 4:
                 {
                    try
                    {
                        System.out.println(p1.visualizzaOrdineAlfabetico());
                    }
                    catch(EccezionePosizioneNonValida ex)
                    {
                        System.out.println(ex.toString());
                    }
                     break;
                
                 }
                 case 5:
                 {
                     break;
                 }
                 case 6:
                 {
                     break;
                 }
            }
             
        }while(sceltaUtente!=0);
       
        
    }



}
