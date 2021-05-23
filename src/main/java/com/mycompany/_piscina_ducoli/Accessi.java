/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._piscina_ducoli;

import java.time.*;

/**
 * questa classe rappresenta un accesso alla piscina. I suoi attributi sono:
 * codiceIdentificativo<br>
 * nome<br>
 * cognome<br>
 * la data di accesso (anno, mese, giorno) <br>
 * l'ora di accesso <br>
 * la data di uscita (anno, mese, giorno)<br>
 * l'ora di uscita <br>
 * il numero di corsie<br>
 * N_MAX_CORSIE: una costante che dice il numero massimo di corsie della piscina.<br>
 * 
 * @author FaustinoDucoli
 * @version 1.0
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
    /**
     * Costruttore della classe Accessi. Consente di istanziare un nuovo accesso.
     * @param nome nome del cliente
     * @param Cognome cognome del cliente
     */
    public Accessi(String nome, String Cognome)
    {
        
        this.nome = nome;
        this.Cognome = Cognome;
    }
    /**
     * Costruttore di copia della classe Accessi
     * @param a1 Accesso a1, di cui viene creata una copia.
     */
    
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
    /**
     * Costruttore di default della classe Accessi. <br>
     * Assegna ad ogni parametro un valore di default: <br>
     * alle stringhe una stringa vuota, agli interi 0.<br>
     */
    public Accessi()
    {
        codiceID=0;
        nome= "";
        Cognome="";
        
        
    }
    /**
     * Restituisce il codice id di un cliente
     * @return la variabile codiceID 
     */
    public int getCodiceID() 
    {
        return codiceID;
    }
    /**
     * Restituisce il nome del clienteche si trova nella piscina.
     * @return la variabile nome
     */

    public String getNome() 
    {
        return nome;
    }
    /**
     * Restituisce il cognome del cliente che si trova nella piscina.
     * @return la variabile cognome
     */
    public String getCognome() 
    {
        return Cognome;
    }
    /**
     * Restituisce la data di ingresso alla piscina di un cliente (anno, mese, giorno)
     * @return dataIngresso
     */
    public LocalDate getDataIngresso() 
    {
        return dataIngresso;
    }
    /**
     * Restituisce la data di uscita dalla piscina di un cliente (anno, mese, giorno)
     * @return dataUscita
     */
    public LocalDate getDataUscita() 
    {
        return dataUscita;
    }
    /**
     * Restituisce il numero di corsia di un cliente (max 5)
     * @return corsiaPiscina
     */
    public int getCorsiaPiscina() 
    {
        return corsiaPiscina;
    }
    /**
     * Restituisce l'ora di ingresso alla piscina di un cliente 
     * @return oraIngresso
     */
    public LocalTime getOraIngresso() 
    {
        return oraIngresso;
    }
    /**
     * Restituisce l'ora di uscita alla piscina di un cliente
     * @return oraUscita
     */

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
            System.out.print("data di uscita--> " +getDataUscita()+" ora di uscita--> "+getOraUscita());
        
        return s;
    }
    
    
    
    
}
