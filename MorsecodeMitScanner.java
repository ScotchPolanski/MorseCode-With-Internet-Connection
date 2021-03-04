import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


public class MorsecodeMitScanner {


    public static void main(String[] args) 
    {
        do {
            String line = null;                                                                                               // Funktion fragt Internetverbindung ab
            BufferedReader reader;                                                                                            // und nimmt IP
            try {
                URLConnection con = new URL("http://www.google.de").openConnection();
                con.connect();

                reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                line = reader.readLine();
            } catch (Exception e) {
            }

            if ((line) != null) {
                System.out.println("Internetverbindung aktiv");
                try {
                    System.out.println("Aktuelle IP: " + InetAddress.getLocalHost().getHostAddress());
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("Nicht aktiv");
            }                                                                                                               // bis hier missachten
        
        System.out.println("");
        Scanner scanner = new Scanner(System.in);   	                                                                    // Scanner wird zugewiesen
        System.out.println("=== Morse Konverter ===");
        System.out.println("Eingabe: ");
        String ausgabe = scanner.nextLine();
        WriteFile(ausgabe);                                                                              // Eingabe
        System.out.println("Vor der Konvertierung: " + ausgabe);
        ausgabe = ausgabe.replaceAll("", " ");                                                                              // ersetzt Leerzeichen
        ausgabe = ausgabe.replace(",", "");                                                                                 // ersetzt Kommastellen
        ausgabe = ausgabe.toLowerCase();                                                                                    // Großbuchstaben -> Kleinbuchstaben
        System.out.println("Nach der Konvertierung: ");
        Kodieren(ausgabe);                                                                                                  // Funktion "Kodieren" wird aufgerufen
        System.out.println();
        System.out.println("Druecke Enter zum Wiederholen");
        try                                                                                                                 // try-catch Block (für Wiederholen bei [Enter])
        {
            System.in.read();
            System.in.skip(System.in.available());
        }
        catch(Exception e) {e.printStackTrace();}
        System.out.println();
        }while(true);                                                                                                       // gewollte Endlosschleife                                                                              
    }

    static String verzeichnis(char a) {                                                                                     // "Verzeichnis" vom Mörsecode
        switch (a)                                                                                                          // durch die Umwandlung in Main nur Kleinbuchstaben
        { 
            case 'a': 
                return ".- "; 
            case 'b': 
                return "-... ";
            case 'c': 
                return "-.-. "; 
            case 'd': 
                return "-.. "; 
            case 'e': 
                return ". "; 
            case 'f': 
                return "..-. "; 
            case 'g': 
                return "--. "; 
            case 'h': 
                return ".... "; 
            case 'i': 
                return ".. "; 
            case 'j': 
                return ".--- "; 
            case 'k': 
                return "-.- "; 
            case 'l': 
                return ".-.. "; 
            case 'm': 
                return "-- "; 
            case 'n': 
                return "-. "; 
            case 'o': 
                return "--- "; 
            case 'p': 
                return ".--. "; 
            case 'q': 
                return "--.- "; 
            case 'r': 
                return ".-. "; 
            case 's': 
                return "... "; 
            case 't': 
                return "- "; 
            case 'u': 
                return "..- "; 
            case 'v': 
                return "...- "; 
            case 'w': 
                return ".-- "; 
            case 'x': 
                return "-..- "; 
            case 'y': 
                return "-.-- "; 
            case 'z': 
                return "--.. ";                                                                                 // kein Default sonst Bug
        } 
        return "";                                                                                              // keine Void Funktion -> muss was zurückgeben
    }
    static void Kodieren(String ausgabe)                                                                        // Funktion die Zeichenkette in Morsecode überführt (AUFGABENSTELLUNG)
    { 
        for (int i = 0;i<ausgabe.length(); i++)                                                                 // for - Schleife geht durch Buchstaben
            System.out.print(verzeichnis(ausgabe.charAt(i)));                                                   // und gibt sie wie im Verzeichnis definiert ist aus
    }


        public static void CreateFile(String[] args) 
        {
          try {
            File myObj = new File("IP.txt");                                                                    // IP.txt Datei wird erstellt
            if (myObj.createNewFile()) {
              System.out.println("Datei erstellt: " + myObj.getName());
            } else {
              System.out.println("Datei existiert bereits.");
            }
          } catch (IOException e) {
            System.out.println("Fehler.");
            e.printStackTrace();
          }
        }

    public static void WriteFile(String ausgabe) {                                                               // schreibt IP in Datei "IP.txt"
        try {
          FileWriter myWriter = new FileWriter("IP.txt");
          myWriter.write("=== Made by Marlon ===");
          myWriter.write("\n");
          myWriter.write(InetAddress.getLocalHost().getHostAddress());
          myWriter.close();
        } catch (IOException e) {
          System.out.println("Fehler");
          e.printStackTrace();
        }
    }
}
