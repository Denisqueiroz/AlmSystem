/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.util;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author TBO-002
 */
public class Conversoes {
    
    public static Date converterStringDate(String date) throws ParseException {
        if(date != null || !date.equals("")){
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
         //   SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        //   Date novaData = (Date) fmt.parse(data);
            Date novaData = formato.parse(date); 
            return novaData;
            
        }else{
            return null;
        }
    }
}
