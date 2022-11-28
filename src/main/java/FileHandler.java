import java.io.*;
import java.util.ArrayList;

public class FileHandler{
    
    private int index = 0;
    
    public FileHandler() {
    }

    public void attemptCreateFile()throws IOException{
        File file = new File("medlemmer.txt");
        try{
            if (!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            System.out.println("");
        }
    }
    /*
    public void readFromFile() throws Exception{    
        try{
            FileInputStream fi = new FileInputStream("medlemmer.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);
            boolean shouldContinue = true;
            Object obj = null;
            while (shouldContinue){
                if(fi.available() != 0){
                    obj = (Medlem) oi.readObject();
                    database.addMedlemToDatabase((Medlem) obj);
                    numberOfMembers++;
                } else {
                   shouldContinue = false;
                }
            }
            fi.close();
            oi.close();
        }catch (Exception e){
            
        }
    }
*/
    public void writeToFile(ArrayList<Medlem> database) throws Exception{
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
     
}