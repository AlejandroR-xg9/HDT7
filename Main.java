import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Txt/Diccionario.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                // quitar paréntesis
                linea = linea.replace("(", "").replace(")", "");

                // separar
                String[] partes = linea.split(",");

                String english = partes[0].trim().toLowerCase();
                String spanish = partes[1].trim();

                tree.insert(new Association<>(english, spanish));
            }
            } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nTraducción:");


try (BufferedReader br = new BufferedReader(new FileReader("Txt/texto.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {

                String[] palabras = linea.split(" ");

                for (String palabra : palabras) {

                    // limpiar signos básicos
                    String limpia = palabra.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    Association<String, String> res =
                        tree.search(new Association<>(limpia, null));

                    if (res != null) {
                        System.out.print(res.getValue() + " ");
                    } else {
                        System.out.print("*" + palabra + "* ");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
}
}
