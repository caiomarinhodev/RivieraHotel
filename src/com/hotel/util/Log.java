/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.util;

import javax.swing.JOptionPane;

/**
 *
 * @author Helvis Lima
 */
public class Log {
   private String message, TAG, method;
   private int type;

    public Log() {
                
    }
    
    
    public static void view(String TAG, String message, String method, int type, Exception e){
        
       
        if(type==1){
            JOptionPane.showMessageDialog(null, TAG + " \n "+message+" \n "+method+" \n ");
        }else{
            System.out.println(TAG+" - "+message+" - "+method);
        }
    }
   
   
}
