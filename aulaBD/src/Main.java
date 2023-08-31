import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws IOException {

//        File arquivo = new File("aulaBD.txt");
//        arquivo.createNewFile();

        FileWriter escreve_no_Arquivo = new FileWriter("aulaBD.txt");

        Document doc = Jsoup.connect("https://www.python.org/").get();

        String title = String.valueOf(doc.getElementsByTag("title"));
        escreve_no_Arquivo.write(title);

        escreve_no_Arquivo.flush();
        escreve_no_Arquivo.close();
    }
}