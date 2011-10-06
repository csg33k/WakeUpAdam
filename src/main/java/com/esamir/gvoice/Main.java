package com.esamir.gvoice;


import java.io.IOException;
import com.techventus.server.voice.Voice;
import java.util.Properties;
import java.io.InputStream;

public class  Main
{
    private static String username = null;;
    private static String pass = null;
    private static String phone = null;


    public static void readProperties()
    {
        Properties p = new Properties();
        try
        {
            InputStream in = Main.class.getResourceAsStream("/google_voice.properties");
            if(in == null)
            {
                System.out.println("Could not read jar resource /google_voice.properties using class defaults");
                return;
            }
            p.load(in);
        }
        catch(IOException f) 
        {
            System.err.println("Could not load properties, it is null ... using class defautls");
            f.printStackTrace();
            return;
        }//end outer try

        //Load Data
        if(p.get("google.username") != null)
            username = (String) p.get("google.username");

        if(p.get("google.password") != null)
            pass = (String) p.get("google.password");

        if(p.get("google.phone") != null)
            phone = (String) p.get("google.phone");

    }
    
    public static void text(String message, String phone)
    {
    	try {
    		Voice voice = new Voice(username, pass);
    		System.out.println("Sending a wake up call to adam @ " + phone);
    		voice.sendSMS(phone, "Hello Adam, I am your wake up bot, If you're not already awake, you should be.");
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    public static void call(String phone)
    {
    	try {
    		Voice voice = new Voice(username, pass);
    		System.out.println("Sending a wake up call to adam @ " + phone);
    		//voice.sendSMS(phone, "Hello Adam, I am your wake up bot, If you're not already awake, you should be.");
    		// *sad panda* wish I could send a wave file and hang up as a call.
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		System.out.println(e.getMessage());
    	}
    }    
    
    
    public static void main(String args[] ) 
    {
        readProperties();
        if(phone == null || pass == null || username == null)
        {
            System.err.println("Property file is invalid.. please check your settings and try again");
            System.exit(-1);
        }
        text("Hello Adam, I am your wake up bot, If you're not already awake, you should be.", phone);
        

    }
}

