package org.example;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class Singleton
{
    private static final Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static Singleton singleton=null;
    String a;
    private static int flag=0;
    private Singleton()
    {

    }
    public static Singleton getinstance()
    {
        if(singleton==null)
        {
            singleton=new Singleton();
            flag=1;
        }
        return singleton;
    }
    public String connection()
    {
        a=(flag==1)?"connected":"not connected";
        return a;
    }
    public static String close()
    {
        singleton=null;
        flag=0;
        return "connection closed";
    }
    public static void main(String[] args)
    {
        int choice;
        String result;
        String connresult;
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            LOGGER.log(Level.INFO,"\n1)Connection make \n2)connection close \n3)exit");
            LOGGER.log(Level.INFO,"Choose any one of the option in the above: ");
            choice=sc.nextInt();
            if(choice==1)
            {
                Singleton singleton=Singleton.getinstance();
                int address=singleton.hashCode();
                LOGGER.log(Level.INFO,Integer.toString(address),address);
                connresult=singleton.connection();
                LOGGER.info(connresult);
            }
            else if(choice==2)
            {
                result=Singleton.close();
                LOGGER.info(result);
            }
            else if(choice==3)
            {
                break;
            }
        }
    }
}