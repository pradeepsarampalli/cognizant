import java.io.*;
public class FileWriting{
    public static void main(String[] args) {
        String content = """
The Common Young Writers Program 
welcomes high school students passionate 
about creative writing to join us for a 
two week intensive on the craft of fiction.
This virtual course includes daily 
synchronous and asynchronous work for 
students excited to learn the building
blocks of fiction (scene, character, plot,
image) and write and revise their own stories
in a short period of time.
""";
        String filePath = "output.txt";
        try{
            FileWriter fw=new FileWriter(filePath);
            fw.write(content);
            System.out.println("Content written to file successfully.");
            fw.close();
        }
        catch(IOException e){
            System.out.println("An error occurred: " + e.getMessage());
        }

    }
}