import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FileHandler{
    
    private int index = 0;
    
    public FileHandler() {
    }

    public void attemptCreateFile()throws IOException{
        File file = new File("medlemmer.txt");
        File file2 = new File("klubresultater.txt");
        File file3 = new File("stævnedatabase.txt");
        File file4 = new File("stævneresultater.txt");
        
        try{
            if (!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            System.out.println("");
        }
        
        try{
            if (!file2.exists()){
                file2.createNewFile();
            }
        }catch (IOException e){
            System.out.println("");
        }
        
        try{
            if (!file3.exists()){
                file3.createNewFile();
            }
        }catch (IOException e){
            System.out.println("");
        }
        
        try{
            if (!file4.exists()){
                file4.createNewFile();
            }
        }catch (IOException e){
            System.out.println("");
        }
    }

    //read from file methods
    
    public void readFromMedlemmer(ArrayList<Medlem> medlemsDatabase) throws Exception{
        try{
            FileInputStream fi = new FileInputStream("medlemmer.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);
            boolean shouldContinue = true;
            Object obj = null;
            while (shouldContinue){
                if(fi.available() != 0){
                    obj = (Medlem) oi.readObject();
                    medlemsDatabase.add((Medlem) obj);
                    index++;
                } else {
                   shouldContinue = false;
                }
            }
            fi.close();
            oi.close();
        }catch (Exception e){
        }
    }

    public void readFromKlubresultater(ArrayList<Resultat> klubresultater) throws Exception{
        try{
            FileInputStream fi = new FileInputStream("klubresultater.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);
            boolean shouldContinue = true;
            Object obj = null;
            while (shouldContinue){
                if(fi.available() != 0){
                    obj = (Resultat) oi.readObject();
                    klubresultater.add((Resultat) obj);
                    index++;
                } else {
                   shouldContinue = false;
                }
            }
            fi.close();
            oi.close();
        }catch (Exception e){
        }
    }
    
    public void readFromStævneDatabase(ArrayList<Stævne> stævneDatabase) throws Exception{
        try{
            FileInputStream fi = new FileInputStream("stævnedatabase.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);
            boolean shouldContinue = true;
            Object obj = null;
            while (shouldContinue){
                if(fi.available() != 0){
                    obj = (Stævne) oi.readObject();
                    stævneDatabase.add((Stævne) obj);
                    index++;
                } else {
                   shouldContinue = false;
                }
            }
            fi.close();
            oi.close();
        }catch (Exception e){
        }
    }
    
    //write to file methods
    
    public void writeToMedlemmer(ArrayList<Medlem> database) throws Exception{
        index = 0;
        try{
            FileOutputStream f = new FileOutputStream("medlemmer.txt");
            ObjectOutputStream o = new ObjectOutputStream(f);
            if(!database.isEmpty()){
                while (index < database.size()){
                    o.writeObject(database.get(index));
                    index++;
                }
            }
            f.close();
            o.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void writeToKlubresultater(ArrayList<Resultat> klubresultater) throws Exception{
        index = 0;
        try{
            FileOutputStream f = new FileOutputStream("klubresultater.txt");
            ObjectOutputStream o = new ObjectOutputStream(f);
            if(!klubresultater.isEmpty()){
                while (index < klubresultater.size()){
                    o.writeObject(klubresultater.get(index));
                    index++;
                }
            }
            f.close();
            o.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void writeToStævneDatabase(ArrayList<Stævne> stævneDatabase) throws Exception{
        index = 0;
        try{
            FileOutputStream f = new FileOutputStream("stævnedatabase.txt");
            ObjectOutputStream o = new ObjectOutputStream(f);
            if(!stævneDatabase.isEmpty()){
                while (index < stævneDatabase.size()){
                    o.writeObject(stævneDatabase.get(index));
                    index++;
                }
            }
            f.close();
            o.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}