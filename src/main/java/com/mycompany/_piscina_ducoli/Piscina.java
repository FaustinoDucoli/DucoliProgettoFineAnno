/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._piscina_ducoli;

import eccezioni.EccezionePosizioneNonValida;
import file.FileExeption;
import file.TextFile;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * questa classe rappresenta una piscina. I suoi attributi sono:<br>
 * elencoAccessi[]: un array di Accessi<br>
 * nAccessiPresenti<br>
 * N_MAX_ACCESSI: una costante che dice il numero massimo di accessi della piscina.<br>
 * 
 * @author FaustinoDucoli
 * @version 1.0
 */
public class Piscina implements Serializable
{
    //attributi
    private Accessi[] elencoAccessi;
    private final int N_MAX_ACCESSI=5;
    private int nAccessiPresenti=0;
    Accessi a=new Accessi();
    //costruttori
    /**
     * costruttore della classe piscina <br>
     * istanzia l'array<br>
     * inizializza il numero di accessi alla piscina.
     */
    public Piscina()
    {
        
        elencoAccessi= new Accessi[N_MAX_ACCESSI];
        this.nAccessiPresenti=0;
    }
    /**
     * metodo che indica il valore la costante N_MAX_ACCESSi<br>
     * ossia la variabile che indica il numero massimo del clienti che possono stare in piscina.
     * @return N_MAX_ACCESSI
     */

    public int getN_MAX_ACCESSI()
    {
        return N_MAX_ACCESSI;
    }
    /**
     * metodo che indica il valore della varibile nAccessiPresenti<br>
     * ossia la variabile che indica quanti clienti sono presenti in quel momento in piscina
     * @return nAccessiPresenti
     */
    public int getnAccessiPresenti()
    {
        return nAccessiPresenti;
    }
    /**
     * metodo che consente di aggiungere un cliente alla piscina<br>
     * e posizionarlo nell array.
     * all'utente verrà chiesto il nome e il cognome e verranno assegnate in automatico:<br>
     * data e ora di ingresso, codice identificativo e il numero di corsia.<br>
     * se l'accesso va a buon fine il metodo restituisce 0 che indica che l'aggiunta è avvenuta in modo corretto<br>
     * se invece l'aggiunta fallisce restituisce -1.
     * @param a1 un accesso utilizzando il costruttore di copia.
     * @return 0
     * @return -1 
     */
    
    public int aggiungiCliente(Accessi a1)
    {
        for(int i=0;i<elencoAccessi.length;i++)
        {
            if(elencoAccessi[i]==null)
            {
                elencoAccessi[i]=new Accessi(a1);
                this.nAccessiPresenti++;
                return 0;
            }
            
        }
        return -1;
              
    }
    /**
     * metodo che visualizza tutti i clienti sia entrati che usciti.<br>
     * per ogni clienti verranno mostrati:<br>
     * codiceID, nome, cognome, data di ingresso, ora di ingresso.<br>
     * se il cliente è già uscito dalla piscina verranno mostrate anche la data e l'ora di uscita.
     */
    public void visualizzaClienti()
    {
        for(int i=0;i<elencoAccessi.length;i++)
        {
            if(elencoAccessi[i]!=null)
            {
                System.out.println(elencoAccessi[i].toString());
            }
        }
    }
        /**
     * metodo che restituisce una stringa con tutti i clienti presenti in piscina.<br>
     * per ogni clienti verranno mostrati:<br>
     * codiceID, nome, cognome, data di ingresso, ora di ingresso.<br>
     * se non ce nessun cliente il metodo restituisce una stringa con un messaggio di non presenza di alcun cliente.
     */
    
    public String visualizzaClientiPresenti()
    {
        String s="";
        if(nAccessiPresenti==0)
        {
           s+="non ci sono clienti";
            return s; 
        }
            
        for(int i=0;i<N_MAX_ACCESSI;i++)
        {
            if(elencoAccessi[i]!=null && a.getDataUscita()==null && a.getOraUscita()==null)
            {
                s+=elencoAccessi[i]+"\n";
            }
        }
        return s;
    }
    /**
     * metodo che registra l'uscita di un cliente dalla piscina<br>
     * il metodo una volta ricevuti come parametri nome e cognome del cliente da eliminare assegna ad esso la data e ora di uscita
     * @param NomeCliente cioè il nome del cliente da rimuovere da rimuovere dalla piscina
     * @param CognomeCliente cioè il cognome del cliente da rimuovere dalla piscina
     * restituisce un intero:<br>
     * @return  0 se l'uscita è andata a buon fine.<br>
     * @return -1 se l'uscita è fallita.
     */
    public int uscitaCliente (String NomeCliente, String CognomeCliente)
    {
        if (nAccessiPresenti==0)
                System.out.println("non ci sono clienti");
        
        for(int i=0;i<elencoAccessi.length;i++)
        {
            if(elencoAccessi[i]!=null)
            {
                if(elencoAccessi[i].getNome().equals(NomeCliente))
                {
                    if(elencoAccessi[i].getCognome().equals(CognomeCliente))
                    {
                        elencoAccessi[i].setDataUscita(LocalDate.now());
                        elencoAccessi[i].setOraUscita(LocalTime.now());
                        this.nAccessiPresenti--;
                        return 0;
                    }
                    
                }
            }
            
        }
        return -1;
    }
    /**
     * metodo che mostra all'utente i clienti presenti in una determinata data e ora<br>
     * in ordine alfabetico
     * @return arrayOrdinato un array ordinato in ordine alfabetico di clienti presenti in una certa data e ora
     * @param data giorno mese e anno da confrontare 
     * @param ora ora da confrontare
     */
    public Accessi[] visualizzaOrdineAlfabeti1co(LocalDate data, LocalTime Ora) 
    {
        int n=0;
        for (int i=0;i<nAccessiPresenti;i++)
        {
            if(elencoAccessi[i]!=null)
                n++;
            
        }
        if(n==0)
            return null;
        Accessi[] arrayOrdinato = new Accessi[n];
        int posizione=0;
        for(int i=0;i<n;i++)
        {
            if(elencoAccessi[i]!=null)
            {
                if(elencoAccessi[i].getDataIngresso().getYear()==data.getYear())
                {
                    if(elencoAccessi[i].getDataIngresso().getMonth()==data.getMonth())
                    {
                        if(elencoAccessi[i].getDataIngresso().getDayOfMonth()==data.getDayOfMonth())
                        {
                             if(elencoAccessi[i].getOraIngresso().getHour()==Ora.getHour())
                               {
                                    if(elencoAccessi[i].getDataUscita()==null && elencoAccessi[i].getOraUscita()==null)
                                       {
                                            arrayOrdinato[posizione]=elencoAccessi[i];
                                            posizione++;
                                       }
                               }
                        }
                    }
                }
               
                
            }
            
        }
        
        
        arrayOrdinato=Ordinatore.selectionSortAccessi(arrayOrdinato);
        return arrayOrdinato;
    }
    /**
     * Metodo che setta gli accessi con un eccezione
     * @param Accesso
     * @throws EccezionePosizioneNonValida  se la posizione dell'array non è valida<br>
     * alza un eccezione che verrà gestita nel main.
     */
    public void setAccessi(Accessi Accesso) throws EccezionePosizioneNonValida 
    {
        try
        {
            elencoAccessi[nAccessiPresenti]=Accesso;
            nAccessiPresenti++;
            System.out.println(nAccessiPresenti);
        }
        catch(ArrayIndexOutOfBoundsException e1) 
       {
         throw new EccezionePosizioneNonValida(nAccessiPresenti,0);
       }
    }
    /**
     * metodo che ci dice il numero di accessi
     * @param a1 un Accesso 
     * @return a un Accesso
     * @throws EccezionePosizioneNonValida 
     */
    public Accessi getAccessi(int a1) throws EccezionePosizioneNonValida
    {
        Accessi a;
        try
        {
            a=elencoAccessi[a1];
            return a;
        }
        catch(ArrayIndexOutOfBoundsException e1)
        {
            throw new EccezionePosizioneNonValida(a1,0);
        }
        
    }
    /**
     * metodo che esporta tutte le informazione dei clienti in un formato csv<br>
     * ovvero tutte le informazioni separati da un ";"
     * @param nomeFile il nome del file di testo su cui salvare le informazioni in csv
     * @throws IOException eccezione che dice che non si può accedere al file
     * @throws EccezionePosizioneNonValida solleva un eccezione che dice che la posizione non è valida
     * @throws FileExeption se il file non si trova viene sollevata un eccezione che dice che ce un errore
     * tutte le eccezioni verranno gestite nel main.
     */
    public void esportaAccessiCsv(String nomeFile) throws IOException, EccezionePosizioneNonValida, FileExeption
    {
      TextFile f1= new TextFile(nomeFile, 'W');
      String rigaDaScrivere="";
      Accessi a;
      for(int i=0;i<nAccessiPresenti;i++)
      {
              if(getAccessi(i)!=null)
              {
                  a=getAccessi(i);
                  rigaDaScrivere=i+"; "+a.getNome()+"; "+a.getCognome()+"; "+a.getDataIngresso()+"; "+a.getOraIngresso();
                  
                  try 
                  {
                      f1.toFile(rigaDaScrivere);
                  } 
                  catch (FileExeption ex) 
                  {
                      f1.close();
                      throw new FileExeption("Errore in scrittura!");
                  }
              }
          
      }
      f1.close();
      
   }
    /**
     * metodo che salva tutti i dati della piscina (le informazioni dei clienti)<br>
     * in un file binario.
     * @param nomeFile il nome del file binario.
     * @throws FileNotFoundException eccezione che viene sollevata se il file non si trova
     * @throws IOException eccezione che viene sollevata in caso non si riesca ad accedere al file.
     * le eccezioni verranno gestite nel main.
     */
    public void salvaPiscina(String nomeFile) throws FileNotFoundException, IOException
  {
      FileOutputStream f1=new FileOutputStream(nomeFile);
      ObjectOutputStream outputStream=new ObjectOutputStream(f1);
      outputStream.writeObject(this);
      outputStream.flush();
      outputStream.close();
  }
  /**
   * metodo che all'avvio del programma carica la piscina (file binario) <br>
   * con tutte le informazioni salvate all'ultimo salvataggio.
   * @param nomeFile il nome del file binario
   * @return p restituisce una Piscina p, con le informazioni dei clienti
   * @throws FileNotFoundException eccezione che si solleva se il file non si trova
   * @throws IOException eccezione che si solleva se non si accede al file.
   * @throws FileExeption eccezione che si solleva dicendo il motivo per cui si è sollevata
   */
  public Piscina caricaPiscina(String nomeFile) throws FileNotFoundException, IOException, FileExeption 
  {
      FileInputStream f1=new FileInputStream(nomeFile);
      ObjectInputStream inputStream=new ObjectInputStream(f1);
      Piscina p;
       try 
       {
           p=(Piscina)inputStream.readObject();
           inputStream.close();
            return p;
       } 
       catch (ClassNotFoundException ex) 
       {
          inputStream.close();
          throw new FileExeption("Errore nella lettura del file");
       }
       
  }
           
}
