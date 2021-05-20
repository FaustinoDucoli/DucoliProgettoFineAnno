/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._piscina_ducoli;

import java.time.LocalDateTime;

/**
 *
 * @author FaustinoDucoli
 */
public class Piscina 
{
    private Accessi[] elencoAccessi;
    private final int N_MAX_ACCESSI=5;
    public Piscina()
    {
        elencoAccessi= new Accessi[N_MAX_ACCESSI];
    }
    
    public int aggiungiCliente(Accessi a1)
    {
        for(int i=0;i<elencoAccessi.length;i++)
        {
            if(elencoAccessi[i]==null)
            {
                elencoAccessi[i]=new Accessi(a1);
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
                System.out.println(elencoAccessi.toString());
            }
        }
    }
    
}
