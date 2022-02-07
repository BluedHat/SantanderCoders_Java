package com.letscode.generate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import com.letscode.basis.Club;
import com.letscode.basis.Match;

public class Core2 {
    public static ArrayList<Club> listClubs = new ArrayList<Club>(); //tabela
    public static ArrayList<Club> Ranking = new ArrayList<Club>(); //tabela
    public static Set<Match> getMatch = new HashSet<>(); // lista de jogos

    public static ArrayList<Club> SetClubHome(Match jogo){      
           int Who1 = Integer.compare(jogo.getHomeGoals(),jogo.getGuestGoals()); //pega o numero de gols para ver quem ganhou
           boolean check = Search.Check(listClubs, jogo.getHome());
        //calcular dados do dono da casa 
        //quando é o primeiro jogo do clube 
           if(check == false) {
            listClubs.add((Club) Club.builder()                                               
                     .club(jogo.getHome())
                     .points(0) 
                     .played(+1)
                     .won (((Who1==1) ?+1:+0))
                     .draw(((Who1==0) ?+1:+0))
                     .lost(((Who1==-1)?+1:+0))
                     .gf(jogo.getHomeGoals())
                     .ga(jogo.getGuestGoals())
                     .gd((jogo.getHomeGoals() - jogo.getGuestGoals()))                       
                     .lastMatch(jogo.getGuest().substring(0,4).toUpperCase())                        
                     .build());}             

           else {
                //Qdo o clube já está na tabela
                int position = Search.TheIndex(listClubs, jogo.getHome(),check); 
                listClubs.set(position, Club.builder() 
                         .club(listClubs.get(position).getClub())   
                         .points(listClubs.get(position).getWon()*3 + listClubs.get(position).getDraw())                                           
                         .played(listClubs.get(position).getPlayed()+1)
                         .won (((Who1==1) ?listClubs.get(position).getWon()+1 :listClubs.get(position).getWon()))
                         .draw(((Who1==0) ?listClubs.get(position).getDraw()+1:listClubs.get(position).getDraw()))
                         .lost(((Who1==-1)?listClubs.get(position).getLost()+1:listClubs.get(position).getLost()))
                         .gf(listClubs.get(position).getGf() + jogo.getHomeGoals())
                         .ga(listClubs.get(position).getGa() + jogo.getGuestGoals())
                         .gd(listClubs.get(position).getGf() + jogo.getHomeGoals() - listClubs.get(position).getGa() - jogo.getGuestGoals())                         
                         .lastMatch(jogo.getGuest().substring(0,4).toUpperCase())    
                         .build()); 
                }  
    return listClubs;
    }     

    public static ArrayList<Club> SetClubGuest(Match jogo){      
      int Who2 = Integer.compare(jogo.getGuestGoals(),jogo.getHomeGoals()); //pega o numero de gols para ver quem ganhou
      boolean check2 = Search.Check(listClubs, jogo.getGuest());
   //calcular dados do dono da casa 
   //quando é o primeiro jogo do clube 
      if(check2 == false) {
       listClubs.add((Club) Club.builder()                                               
                .club(jogo.getGuest())
                .points(0) 
                .played(+1)
                .won (((Who2==1) ?+1:+0))
                .draw(((Who2==0) ?+1:+0))
                .lost(((Who2==-1)?+1:+0))
                .gf(jogo.getGuestGoals())
                .ga(jogo.getHomeGoals())                
                .gd((jogo.getGuestGoals() - jogo.getHomeGoals())) 
                .lastMatch(jogo.getHome().substring(0,4).toUpperCase())                        
                .build());}             

      else {
           //Qdo o clube já está na tabela
           int position = Search.TheIndex(listClubs, jogo.getGuest(),check2); 
           listClubs.set(position, Club.builder() 
                    .club(listClubs.get(position).getClub())  
                    .points(listClubs.get(position).getWon()*3 + listClubs.get(position).getDraw())                                            
                    .played(listClubs.get(position).getPlayed()+1)
                    .won (((Who2==1) ?listClubs.get(position).getWon()+1 :listClubs.get(position).getWon()))
                    .draw(((Who2==0) ?listClubs.get(position).getDraw()+1:listClubs.get(position).getDraw()))
                    .lost(((Who2==-1)?listClubs.get(position).getLost()+1:listClubs.get(position).getLost()))
                    .gf(listClubs.get(position).getGf() + jogo.getGuestGoals())
                    .ga(listClubs.get(position).getGa() + jogo.getHomeGoals())
                    .gd(listClubs.get(position).getGf() + jogo.getGuestGoals() - listClubs.get(position).getGa() - jogo.getHomeGoals())
                    .lastMatch(jogo.getHome().substring(0,4).toUpperCase())    
                    .build()); 
           }         
    return listClubs;
    } 

    public static ArrayList<Club> Table() {
        getMatch = Organize.partidas;
        for (Match match : getMatch) {
            SetClubHome (match);
            SetClubGuest (match);
        }
      return listClubs; 
    }  
    
    public static ArrayList<Club> TableSort() {  
      listClubs.sort(Comparator.comparing(Club::getPoints,  Comparator.reverseOrder())
                               .thenComparing(Club::getWon, Comparator.reverseOrder())
                               .thenComparing(Club::getGf,  Comparator.reverseOrder()));
      for (Club time : listClubs) {
               boolean check3 = Search.Check(listClubs, time.getClub());
               int counter2 = Search.TheIndex(listClubs, time.getClub(), check3); 
                     listClubs.set(counter2, Club.builder() 
                              .position(counter2 + 1)
                              .club(listClubs.get(counter2).getClub())  
                              .points(listClubs.get(counter2).getWon()*3 + listClubs.get(counter2).getDraw())                                            
                              .played(listClubs.get(counter2).getPlayed())
                              .won (listClubs.get(counter2).getWon())
                              .draw(listClubs.get(counter2).getDraw())
                              .lost(listClubs.get(counter2).getLost())
                              .gf(listClubs.get(counter2).getGf())
                              .ga(listClubs.get(counter2).getGa())
                              .gd(listClubs.get(counter2).getGf() - listClubs.get(counter2).getGa())
                              .lastMatch(listClubs.get(counter2).getLastMatch() .substring(0,4).toUpperCase())    
                              .build()); }
      Ranking = listClubs ;
      return Ranking; 
    }  
}



