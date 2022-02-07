import com.letscode.basis.Match;
import com.letscode.generate.Core2;
import com.letscode.generate.Organize;
import com.letscode.printer.FileCreator;
import com.letscode.reader.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class Main {
    // static File footballResults = new File("src/main/java/com/letscode/input/sample.txt");
       static File footballResults = new File("src/main/java/com/letscode/input/santander811matchesResult.csv");
    // static File footballResults = new File("src/main/java/com/letscode/input/CollectionsClubs.csv");
    static Set<String> imported;
    static Set<Match> splited;
    public static void main(String[] args){
        System.out.println("Welcome to my place");
        try {
            imported = FileHandler.elReader(footballResults);
            Organize.Split(imported);
            Organize.HomeMatch();
            Organize.GuestMatch();
            Core2.Table();
            Core2.TableSort(); 
            FileCreator.PrintRanking();
            FileCreator.PrintClubsMatch();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("End");
    }
}
