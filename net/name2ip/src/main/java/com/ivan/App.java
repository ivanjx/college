package com.ivan;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        String host = null;

        try
        {
            Scanner input = new Scanner(System.in);
            System.out.print("Input host name: ");
            host = input.next();
            input.close();
            InetAddress address = InetAddress.getByName(host);
            System.out.println(String.format("IP address: %s", address));
        }
        catch (UnknownHostException ex)
        {
            System.out.println(String.format("Tidak bisa mendapatkan %s atau jaringan kusut.", host));
        }
    }
}
