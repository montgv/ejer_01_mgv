import java.io.*;
import java.util.Scanner;

public class ejer_01_mgv {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean salir = false;
        int opcion;
        
        do {
            System.out.println("==========MENU==========");
            System.out.println("1. Crear un fichero binario.");
            System.out.println("2. Leer el fichero binario creado.");
            System.out.println("0. Salir.");
            System.out.print("Selecciona una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();
            
            switch (opcion) {
                case 1:
                    crearFichero();
                    break;
                case 2:
                    leerFichero();
                    break;
                case 0:
                    salir = true;
            }
        } while (!salir);
    }

    private static void crearFichero() {
        try {
            DataOutputStream dop = new DataOutputStream(new FileOutputStream("persona.dat"));

            System.out.print("Introduce su nombre completo: ");
            dop.writeUTF(sc.nextLine());

            System.out.print("Introduce su edad: ");
            dop.writeInt(sc.nextInt());
            sc.nextLine();

            System.out.print("Introduce tu ciudad de nacimiento: ");
            dop.writeUTF(sc.nextLine());

            System.out.println();

            dop.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerFichero() {
        try {
            DataInputStream dip = new DataInputStream(new FileInputStream("persona.dat"));

            String nombre = dip.readUTF();
            int edad = dip.readInt();
            String ciudad = dip.readUTF();

            System.out.println("Nombre: " +nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Ciudad de nacimiento: " + ciudad);
            System.out.println();

            dip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
