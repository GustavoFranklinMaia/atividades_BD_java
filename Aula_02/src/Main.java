//ATIVIDADE COM JSOUP 17/08/23

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws IOException {

        File arquivo_test = new File("aulaBD.txt");

        arquivo_test.createNewFile();

        FileWriter escreve_no_Arquivo = new FileWriter("aulaBD.txt");

        Document doc = Jsoup.connect("https://www.python.org/").get();

        escreve_no_Arquivo.write(String.valueOf(doc.getElementsByTag("title")));
    }
}