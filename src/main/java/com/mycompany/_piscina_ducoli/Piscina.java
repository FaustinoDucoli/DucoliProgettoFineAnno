/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._piscina_ducoli;

import eccezioni.EccezionePosizioneNonValida;
import java.time.LocalDateTime;

/**
 *
 * @author FaustinoDucoli
 */
public class Piscina 
{
    private Accessi[] elencoAccessi;
    private final int N_MAX_ACCESSI=5;
    private int nAccessiPresenti;
    public Piscina()
    {
        
        elencoAccessi= new Accessi[N_MAX_ACCESSI];
        this.nAccessiPresenti=0;
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
    
    public int eliminaAccesso(String NomeDaEliminare, String CognomeDaEliminare)
    {
        for(int i=0;i<elencoAccessi.length;i++)
        {
            if(elencoAccessi[i]!=null)
            {
                if(elencoAccessi[i].getNome().equals(NomeDaEliminare))
                {
                    if(elencoAccessi[i].getCognome().equals(CognomeDaEliminare))
                    {
                        elencoAccessi[i]=null;
                        this.nAccessiPresenti--;
                        return 0;
                    }
                    
                }
            }
            
        }
        return -1;
    }
    public String visualizzaOrdineAlfabetico() throws EccezionePosizioneNonValida
    {
        int c=0;
        int n=0;
        Accessi a;
        Accessi[] arrayAccessi= new Accessi[nAccessiPresenti];
        for(int i=0;i<nAccessiPresenti;i++)
        {
            a=getAccessi(i);
            if(a!=null && a.getDataUscita()==null)
            {
                arrayAccessi[c]=a;
                c++;
            }
            
        }
        for(int i=0;i<arrayAccessi.length;i++)
            if(arrayAccessi[i]!=null)
            {
                n++;
            }
            if(n==0)
            {
                return "non ci sono clienti";
            }
            else
            {
                arrayAccessi=Ordinatore.selectionSortAccessi(arrayAccessi);
                String s="";
                for(int i=0;i<arrayAccessi.length;i++)
                {
                    s=s+arrayAccessi.toString()+"\n";
                }
                return s;
            }
        
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
    
   
}
