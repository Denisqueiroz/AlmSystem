/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AlmSystem.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author TBO-002
 */
public class Conversoes {
    public static Date converterStringDate(String data) throws ParseException{
        if(data != null || !data.equals("")){
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Date novaData = (Date) fmt.parse(data);
            return novaData;
        }else{
            return null;
        }
    }
}
