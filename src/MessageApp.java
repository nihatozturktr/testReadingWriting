import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class MessageApp {
    public static void main(String[] args) {



        Path messagePath = Path.of("/../../FromNihatOzturkToPearl/Message.txt");
        Path animalPath = Path.of("/../../FromNihatOzturkToPearl/Animal.txt");
        ///Users

        try {
            if (Files.notExists(messagePath.getParent())) {
                Files.createDirectory(messagePath.getParent());
                Files.createDirectory(animalPath.getParent());

            }

            if(Files.notExists(messagePath)){
                Files.createFile(messagePath);
                Files.createFile(animalPath);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(messagePath.toString())
        )){

            bufferedWriter.write("Welk kledingstuk denkt alleen maar aan zichzelf?\n" +
                    "Antwoord: Asosjaal.”");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            FileWriter fileWriter = new FileWriter(String.valueOf(messagePath));
            fileWriter.write("Live as if you will die tomorrow, learn as if you will live forever.");
            fileWriter.write("Mahatma Gandhi");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(messagePath)))){
            String line=null;
            while ((line = reader.readLine())!=null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("----------ANIMAL PATH-------------");


        Pokemon pokemon = new Pokemon("Pidgeot",false);

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(animalPath.toString())
        )){

            bufferedWriter.write(pokemon.getName()+" "+pokemon.getEdible());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileReader fileReader = new FileReader(animalPath.toString());
             BufferedReader bufferedReader = new BufferedReader(fileReader)){

            String line;
            while ((line= bufferedReader.readLine())!=null){
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }





    }

}
