package com.ivan;

import java.net.InetAddress;

public class App 
{
    public static void main( String[] args )
    {
         try
         {
            InetAddress host = InetAddress.getLocalHost();
            System.out.println(String.format("Nama host anda: %s", host.getHostName()));
            System.out.println(String.format("Identitas komputer lengkap: %s", host));
         }
         catch (Exception ex)
         {
            System.out.println(String.format("Error: ", ex.getMessage()));
         }
    }
}
