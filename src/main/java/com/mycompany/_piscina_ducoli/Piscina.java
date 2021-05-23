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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author FaustinoDucoli
 */
public class Piscina 
{
    private Accessi[] elencoAccessi;
    private final int N_MAX_ACCESSI=5;
    private int nAccessiPresenti=0;
    Accessi a=new Accessi();
    public Piscina()
    {
        
        elencoAccessi= new Accessi[N_MAX_ACCESSI];
        this.nAccessiPresenti=0;
    }

    public int getN_MAX_ACCESSI()
    {
        return N_MAX_ACCESSI;
    }

    public int getnAccessiPresenti()
    {
        return nAccessiPresenti;
    }
    
    public String toString()
    {
        String s="";
        for(int i=0;i<N_MAX_ACCESSI;i++)
        {
            if(elencoAccessi[i]!=null)
            {
                s+=elencoAccessi[i].toString()+"\n";
            }
        }
        return s;
    }
    
    public int aggiungiCliente(Accessi a1)
    {
        for(int i=0;i<elencoAccessi.length;i++)
        {
            if(elencoAccessi[i]==null)
            {
                elencoAccessi[i]=new Accessi(a1);
                this.nAccessiPresenti++;
                nAccessiPresenti++;
                return 0;
            }
            
        }
        return -1;
              
    }
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
    
    public int uscitaCliente (String NomeCliente, String CognomeCliente)
    {
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
    public Accessi[] visualizzaOrdineAlfabetico() 
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
        for(int i=0;i<nAccessiPresenti;i++)
        {
            //if per controllo per data e ora
            if(elencoAccessi[i]!=null)
            {
              arrayOrdinato[posizione]=elencoAccessi[i];
               posizione++;  
            }
            
        }
        
        arrayOrdinato=Ordinatore.selectionSortAccessi(arrayOrdinato);
        return arrayOrdinato;
    }
    
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
    public void salvaPiscina(String nomeFile) throws FileNotFoundException, IOException
  {
      FileOutputStream f1=new FileOutputStream(nomeFile);
      ObjectOutputStream outputStream=new ObjectOutputStream(f1);
      outputStream.writeObject(this);
      outputStream.flush();
      outputStream.close();
  }
  
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
