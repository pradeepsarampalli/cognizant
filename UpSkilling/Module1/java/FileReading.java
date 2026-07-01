import java.io.*;
public class FileReading{
    public static void main(String[] args){
        String filepath="output.txt";
        try(FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr)){
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        } catch(IOException e){
            e.printStackTrace();
    }
}
}