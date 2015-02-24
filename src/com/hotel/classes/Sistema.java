/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.classes;

import com.hotel.enums.TipoServicoQuarto;
import java.util.ArrayList;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;

/**
 *
 * @author Helvis Lima
 */
public class Sistema {
    
    private static ArrayList<Contrato> listaDeContratos = new ArrayList<>();
    private static int count=0;
    private static double STRATEGY=1.0;
    private final static double FIM_DE_ANO=1.20;
    private final static double SAO_JOAO1=1.10;
    private final static double SAO_JOAO2=1.50;
    //private static Contrato contratoCorrente = null;
    private Sistema() {
    }
    
    public static int getcount(){
        count = count+1;
        return count;
    }
    
    public static boolean verifyFimDeAno(DateTime d1){
        DateTimeZone BRAZIL = DateTimeZone.forID("America/Sao_Paulo");
        DateTime di = new DateTime(2015, 12, 25, 0, 0, 0, BRAZIL);
        Duration dur = new Duration(di, d1);
        System.out.println("DURA "+dur.getStandardDays());
        if(dur.getStandardDays()>0&&dur.getStandardDays()<=7&&
                (d1.getDayOfMonth()==25||d1.getDayOfMonth()==26||d1.getDayOfMonth()==27||
                d1.getDayOfMonth()==28||d1.getDayOfMonth()==29||
                d1.getDayOfMonth()==30||d1.getDayOfMonth()==31)){
            return true;
        }else{
            return false;
        }        
    }
    
    public static boolean verifySaoJoaoOne(DateTime d1){
        DateTimeZone BRAZIL = DateTimeZone.forID("America/Sao_Paulo");
        DateTime di = new DateTime(2015, 6, 1, 0, 0, 0, BRAZIL);
        Duration dur = new Duration(di, d1);
        System.out.println("DUR "+dur.getStandardDays());
        for (int i = 1; i <= 23; i++) {
            if(dur.getStandardDays()>0&&d1.getDayOfMonth()==i && dur.getStandardDays()<=22){
                return true;
            }
        }
        return false;
    }
    
    public static boolean verifySaoJoaoTwo(DateTime d1){
        DateTimeZone BRAZIL = DateTimeZone.forID("America/Sao_Paulo");
        DateTime di = new DateTime(2015, 6, 1, 0, 0, 0, BRAZIL);
        Duration dur = new Duration(di, d1);
        for (int i = 23; i <= 31; i++) {
            if(dur.getStandardDays()>0&&d1.getDayOfMonth()==i && dur.getStandardDays()<=30){
                return true;
            }
        }
        return false;
    }

    public static double getSTRATEGY() {
        return STRATEGY;
    }

    public static void setSTRATEGY(int i) {
        if(i==1){
            STRATEGY = FIM_DE_ANO;
        }else if(i==2){
            STRATEGY = SAO_JOAO1;
        }else if(i==3){
            STRATEGY = SAO_JOAO2;
        }else{
            STRATEGY = 1;
        }
    }
    
    
    
    public static boolean isDisponivelTipoServicoQuarto(TipoServicoQuarto tp, int numq){
        int count=0;
        for (int i = 0; i < listaDeContratos.size(); i++) {
            for (int j = 0; j < listaDeContratos.get(i).getListaServicoBasico().size(); j++) {
                if (tp.getNome().equals(listaDeContratos.get(i).getListaServicoBasico().get(j).getTipo())){
                    count++;
                }
            }
        }
        count = count+numq;
        if(count>=tp.getTotalQuartos()){
            return false;
        }else{
            return true;
        }
    }
    
      
    
   public static ArrayList<Contrato> getListaDeContratos(){
       return listaDeContratos;
   }
   
   public static ArrayList<Contrato> getListaDeContratosFilterStatus(boolean s){
       return getListaContratosFiltering(s);
       
   }
   
   private static ArrayList<Contrato> getListaContratosFiltering(boolean bool){
       ArrayList<Contrato> ar = getListaDeContratos();
       ArrayList<Contrato> afiltering = new ArrayList<>();
       for (int i = 0; i < ar.size(); i++) {
           if(ar.get(i).getStatus()==bool){
               afiltering.add(ar.get(i));
           }
       }
       return afiltering;    
       
   }
   
   
   public static boolean addContrato(Contrato c){
        if (c != null){
            listaDeContratos.add(c);
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean addContrato(Hospede h, double vt){
        if(h != null){
            Contrato con = new Contrato(h, vt);
            listaDeContratos.add(con);
            return true;
        }else{
            return false;
        }
    }
    
    public static Contrato pesquisaContrato(int ID){
        for (int i = 0; i < listaDeContratos.size(); i++) {
            if(listaDeContratos.get(i).getID() == ID){
                return listaDeContratos.get(i);
            }
        }
        return null;
    }
    public static boolean removeContrato(int ID){
        Contrato c = pesquisaContrato(ID);
        if (c != null){
            for (int i = 0; i < listaDeContratos.size(); i++) {
                if(listaDeContratos.get(i).getID()==c.getID()){
                    listaDeContratos.remove(i);
                }
            }
            return true;
        }else{
            return false;
        }
    }
    
    public static int getRandom(){
        java.util.Random randomGenerator = new java.util.Random();
        int n = randomGenerator.nextInt(9999);
        return n;
    }
   
}
