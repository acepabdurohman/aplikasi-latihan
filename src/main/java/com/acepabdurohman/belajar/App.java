package com.acepabdurohman.belajar;

import com.acepabdurohman.belajar.connection.KoneksiDatabase;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        KoneksiDatabase k = new KoneksiDatabase();
        k.getKoneksi();
    }
}
