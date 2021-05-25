/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._piscina_ducoli;

import java.io.Serializable;
import java.time.*;

/**
 * questa classe rappresenta un accesso alla piscina. I suoi attributi sono:<br>
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
public class Accessi implements  Serializable
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
    //getter
    /**
     * Restituisce il codice id di un cliente
     * @return la variabile codiceID 
     */
    public int getCodiceID() 
    {
        return codiceID;
    }
    /**
     * Restituisce il nome del cliente che si trova nella piscina.
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
    //setter
    /**
     * modifica il valore della variabile codiceID di un cliente
     * @param codiceID  
     */
    public void setCodiceID(int codiceID) 
    {
        this.codiceID = codiceID;
    }
    /**
     * modifica il valore della variabile nome di un cliente
     * @param nome   
     */
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    /**
     * modifica il valore della variabile cognome di un cliente
     * @param Cognome 
     */
    
    public void setCognome(String Cognome)
    {
        this.Cognome = Cognome;
    }
    /**
     * modifica il valore della variabile dataIngresso di un cliente(anno,mese,giorno)
     * @param dataIngresso 
     */
    public void setDataIngresso(LocalDate dataIngresso)
    {
        this.dataIngresso = dataIngresso;
    }
    /**
     * modifica il valore della variabile dataUscita di un cliente(anno, mese, giorno)
     * @param dataUscita 
     */
    

    public void setDataUscita(LocalDate dataUscita)
    {
        this.dataUscita = dataUscita;
    }
    /**
     * modifica la variabile corsiaPiscina, cioè la corsia dove si trova un cliente
     * @param corsiaPiscina 
     */
    public void setCorsiaPiscina(int corsiaPiscina) 
    {
        this.corsiaPiscina = corsiaPiscina;
    }
    /**
     * modifica il valore dell'ora di entrata in piscina di un cliente (ora, minuti, secondi)
     * @param oraIngresso 
     */
    public void setOraIngresso(LocalTime oraIngresso) 
    {
        this.oraIngresso = oraIngresso;
    }
    /**
     * modifica il valore della variabile che assegna l'ora (ora, minuti, secondi) di uscita dalla piscina di un cliente
     * @param oraUscita 
     */
    public void setOraUscita(LocalTime oraUscita) 
    {
        this.oraUscita = oraUscita;
    }
    /**
     * metodo che restituisce una stringa contente tutte le informazioni di un cliente.
     * @return s una stringa contente tutte le informazioni di un cliente
     */
    
    
    public String toString()
    {
        String s="";
        s+="codice--> "+getCodiceID()+" nome--> "+getNome()+" cognome--> "+getCognome()+" data ingresso--> "+getDataIngresso()+" ora di accesso--> "+getOraIngresso();
        if(getDataUscita()!=null && getOraUscita()!=null)
            System.out.print("data di uscita--> " +getDataUscita()+" ora di uscita--> "+getOraUscita());
        
        return s;
    }
    
    
    
    
}
