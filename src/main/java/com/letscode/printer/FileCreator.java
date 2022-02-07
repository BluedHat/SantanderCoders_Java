package com.letscode.printer;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.letscode.basis.Match;
import com.letscode.generate.Core2;
import com.letscode.generate.Organize;
import com.letscode.generate.Search;

import com.opencsv.CSVWriter;

public class FileCreator {  
    public static void PrintRanking()throws IOException { 
        FileWriter ranking = new FileWriter("src/main/java/com/letscode/output/ranking.csv");
            CSVWriter rankingFile = new CSVWriter(ranking);     
            try {
                String[] header = {"Classificação", "Club","Pontos","Jogos","Vitorias", "Empates","Derrotas","Gols Pro", "Gols Sofridos","Saldo de Gols","Ultima Partida"};
                         rankingFile.writeNext(header);
                int total = Core2.Ranking.size();
                int i = 0;
                List<String[]> data = new ArrayList<String[]>();
                while(i < total){
                   data.add(new String[] {
                       String.valueOf(Core2.Ranking.get(i).getPosition()),
                                      Core2.Ranking.get(i).getClub().toUpperCase(),
                       String.valueOf(Core2.Ranking.get(i).getPoints()),
                       String.valueOf(Core2.Ranking.get(i).getPlayed()),
                       String.valueOf(Core2.Ranking.get(i).getWon()),
                       String.valueOf(Core2.Ranking.get(i).getDraw()),
                       String.valueOf(Core2.Ranking.get(i).getLost()),
                       String.valueOf(Core2.Ranking.get(i).getGf()),
                       String.valueOf(Core2.Ranking.get(i).getGa()),
                       String.valueOf(Core2.Ranking.get(i).getGd()),
                                      Core2.Ranking.get(i).getLastMatch()}); 

                       i++;                
                }
                  rankingFile.writeAll(data);
                  rankingFile.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }                 

    public static void PrintClubsMatch()throws IOException {
        for (String Nome : Search.clubNames) {
            FileWriter nomeDoTime = new FileWriter("src/main/java/com/letscode/output/"+ Nome +".csv");
            CSVWriter  teamFile = new CSVWriter(nomeDoTime); 
            try {
                String[] header = { "Data", "Club1","Placar","x","Placar","Club2"};
                         teamFile.writeNext(header);
                List<String[]> data = new ArrayList<String[]>();                

                   for (Match partida : Organize.partidas) {
                         if(partida.getHome().equals(Nome)){
                             data.add(new String[]{
                                                  partida.getMatchDate(),
                                                  partida.getHome(),
                                   String.valueOf(partida.getHomeGoals()),
                                                  "x",
                                                  partida.getGuest(),
                                   String.valueOf(partida.getGuestGoals()) 
                             });}
                         else if(partida.getGuest().equals(Nome)){
                                data.add(new String[]{
                                                     partida.getMatchDate(),
                                                     partida.getGuest(),
                                      String.valueOf(partida.getGuestGoals()),
                                                     "x",
                                                     partida.getHome(),
                                      String.valueOf(partida.getHomeGoals()) 
                                });       
                         } 

                   }                  
                   teamFile.writeAll(data); 
                   teamFile.close(); 
            }
            catch(IOException e) {
                e.printStackTrace();
            };
        }                
    }      
}





    
