package com.ivan;

import java.net.InetAddress;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        try
        {
            Scanner input = new Scanner(System.in);
            System.out.print("Input IP address lokal atau komputer di jaringan: ");
            String host = input.next();
            input.close();

            try
            {
                InetAddress address = InetAddress.getByName(host);
                System.out.println(String.format("Host name: %s", address.getHostName()));
            }
            catch (Exception ex)
            {
                throw new Exception("Invalid IP");
            }
        }
        catch (Exception ex)
        {
            System.out.println(String.format("Error: ", ex.getMessage()));
        }
    }
}
