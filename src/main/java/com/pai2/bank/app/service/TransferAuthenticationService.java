package com.pai2.bank.app.service;


import javax.ejb.Stateless;
import java.security.SecureRandom;


@Stateless(name = "TransferAuthenticationService", mappedName = "TransferAuthenticationService")
public class TransferAuthenticationService {

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();
    final int length = 8;

    public String generateCode(){

        StringBuilder sb = new StringBuilder( length );
        for( int i = 0; i < length; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

}
