/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._piscina_ducoli;

import java.time.*;

/**
 *
 * @author FaustinoDucoli
 */
public class Accessi
{
    private int codiceID;
    private String nome;
    private String Cognome;
    private LocalDate dataIngresso;
    private LocalDate dataUscita;
    private int corsiaPiscina;
    private LocalTime oraIngresso;
    private LocalTime oraUscita;
    private final int N_MAX_CORSIE=5;

    public Accessi(String nome, String Cognome)
    {
        
        this.nome = nome;
        this.Cognome = Cognome;
    }

    
    public Accessi(Accessi a1)
    {
        this.codiceID=a1.getCodiceID();
        this.Cognome=a1.getCognome();
        this.nome=a1.getNome();
        this.dataIngresso=a1.getDataIngresso();
        this.dataUscita=a1.getDataUscita();
        this.oraIngresso=a1.getOraIngresso();
        this.oraUscita=a1.getOraUscita();
    }
    
    public Accessi()
    {
        codiceID=0;
        nome= "";
        Cognome="";
        
        
    }

    public int getCodiceID() 
    {
        return codiceID;
    }

    public String getNome() 
    {
        return nome;
    }

    public String getCognome() 
    {
        return Cognome;
    }

    public LocalDate getDataIngresso() 
    {
        return dataIngresso;
    }

    public LocalDate getDataUscita() 
    {
        return dataUscita;
    }

    public int getCorsiaPiscina() 
    {
        return corsiaPiscina;
    }

    public int getN_MAX_CORSIE() 
    {
        return N_MAX_CORSIE;
    }

    public LocalTime getOraIngresso() 
    {
        return oraIngresso;
    }

    public LocalTime getOraUscita() 
    {
        return oraUscita;
    }
    

    public void setCodiceID(int codiceID) 
    {
        this.codiceID = codiceID;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public void setCognome(String Cognome)
    {
        this.Cognome = Cognome;
    }

    public void setDataIngresso(LocalDate dataIngresso)
    {
        this.dataIngresso = dataIngresso;
    }

    public void setDataUscita(LocalDate dataUscita)
    {
        this.dataUscita = dataUscita;
    }

    public void setCorsiaPiscina(int corsiaPiscina) 
    {
        this.corsiaPiscina = corsiaPiscina;
    }

    public void setOraIngresso(LocalTime oraIngresso) 
    {
        this.oraIngresso = oraIngresso;
    }

    public void setOraUscita(LocalTime oraUscita) 
    {
        this.oraUscita = oraUscita;
    }
    
    
    public String toString()
    {
        String s="";
        s+="codice--> "+getCodiceID()+" cognome--> "+getCognome()+" nome--> "+getNome()+" data ingresso--> "+getDataIngresso()+" ora di accesso--> "+getOraIngresso();
        if(getDataUscita()!=null)
            System.out.print("data di uscita--> " +getDataUscita());
        
        return s;
    }
    
    
    
    
}
