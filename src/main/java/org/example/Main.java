package org.example;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class Singleton
{
    private static final Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static Singleton singleton=null;
    private Singleton()
    {

    }
    public static Singleton getinstance()
    {
        if(singleton==null)
        {
            singleton=new Singleton();
        }
        LOGGER.log(Level.INFO,Singleton.connection());
        return singleton;
    }
    public static String connection()
    {
        return "Connected";
    }
    public static String close()
    {
        singleton=null;
        return "connection closed";
    }
    public static void main(String[] args)
    {
        int choice;
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            LOGGER.log(Level.INFO,"\n1)Connection make \n2)connection close \n3)exit");
            LOGGER.log(Level.INFO,"Choose any one of the option in the above: ");
            choice=sc.nextInt();
            if(choice==1)
            {
                Singleton singleton=Singleton.getinstance();
                LOGGER.log(Level.INFO,"",singleton.hashCode());
            }
            else if(choice==2)
            {
                LOGGER.log(Level.INFO,Singleton. close());
            }
            else if(choice==3)
            {
                break;
            }
        }
    }
}