/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._piscina_ducoli;

/**

 * 
 * 
 * @author FaustinoDucoli
 */
public class Ordinatore
{
    public static void scambia(int v[],int posizione1,int posizione2)
    {
        int c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    public static void scambia(String v[],int posizione1,int posizione2)
    {
        String c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    public static void scambia(Accessi v[],int posizione1,int posizione2)
    {
        Accessi a;
        a=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=a;
    }
    public static Accessi[] selectionSortAccessi(Accessi[] a)
    {
        Accessi[] ordinato=new Accessi[a.length];

        //Creo un array di copia
        //che sarà il vettore ordinato restituito
        for (int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];

        //Applico l'algoritmo 
        //selection sort all'array di copia
        for (int i=0;i<ordinato.length-1;i++)
        {
            for (int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[i]!=null)
                {
                    if(ordinato[j].getNome().compareToIgnoreCase(ordinato[i].getNome())<0)
                    scambia(ordinato,i,j);
                }
                
            }
        }
        return ordinato;

        /*Accessi[] ordinatoCorretto=new Accessi[a.length];
        for(int i=0;i<a.length;i++)
        {
            ordinatoCorretto[i]=ordinato[i];
        }
        return ordinatoCorretto;*/
    }
    
    public static int[] selectionSortDecrescente(int[] a)
    {
        int[] ordinato=new int[a.length];
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        for(int i=0;i<=ordinato.length-2;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j]>ordinato[i])
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    public static String[] selectionSortCrescente(String[] a)
    {
        String[] ordinato=new String[a.length];
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        for(int i=0;i<=ordinato.length-2;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].compareToIgnoreCase(ordinato[i])<0)
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    public static String[] selectionSortDecrescente(String[] a)
    {
        String[] ordinato=new String[a.length];
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        for(int i=0;i<=ordinato.length-2;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].compareToIgnoreCase(ordinato[i])>0)
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    
    public static String[] bubbleSortCrescente(String a[])
    {
        String[] ordinato=new String[a.length];
        boolean scambioAvvenuto=false;
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        do
        {
            scambioAvvenuto=false;
            for(int i=0;i<ordinato.length-1;i++)
            {
                if(ordinato[i].compareToIgnoreCase(ordinato[i+1])>0)
                {
                    scambia(ordinato,i,i+1);
                    scambioAvvenuto=true;
                }
            }
        }while(scambioAvvenuto);
        
        return ordinato;
    }
    
    public static String[] bubbleSortDecrescente(String a[])
    {
        String[] ordinato=new String[a.length];
        boolean scambioAvvenuto=false;
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        do
        {
            scambioAvvenuto=false;
            for(int i=0;i<ordinato.length-1;i++)
            {
                if(ordinato[i].compareToIgnoreCase(ordinato[i+1])<0)
                {
                    scambia(ordinato,i,i+1);
                    scambioAvvenuto=true;
                }
            }
        }while(scambioAvvenuto);
        
        return ordinato;
    }
}
