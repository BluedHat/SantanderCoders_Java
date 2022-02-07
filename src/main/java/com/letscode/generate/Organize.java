package com.letscode.generate;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.letscode.basis.Match;
import static java.util.stream.Collectors.groupingBy;
import java.util.*;


public class Organize {
    public  static Set<Match> partidas = new HashSet<>();
    public  static List<String> match;
    public  static ArrayList<Match> history;
    public  static Map<String, List<Match>> orderByHome;
    public  static Map<String, List<Match>> orderByGuest;
    

    public static Set<Match> Split(Set<String> imported){
        imported.forEach((e)->{
                  match = Splitter.on(CharMatcher.anyOf(";"))
                                  .omitEmptyStrings()
                                  .trimResults(CharMatcher.whitespace())                             
                                  .splitToList(e.toString()); 

                  partidas.add((Match) Match.builder()                                               
                                               .home(match.get(0))
                                               .guest(match.get(1)) 
                                               .homeGoals(Integer.parseInt(match.get(2)))                                                                                     
                                               .guestGoals(Integer.parseInt(match.get(3)))
                                               .matchDate(match.get(4))
                                               .build());                                             
                                });                               
        return  partidas;
    };

    public static Map<String, List<Match>> HomeMatch(){ 
        orderByHome =
        partidas.stream()
                .collect(groupingBy(Match::getHome));            
    System.out.println(orderByHome);        
        return (orderByHome);    
    }
    
    public static Map<String, List<Match>> GuestMatch(){ 
        orderByGuest =
        partidas.stream()
               .collect(groupingBy(Match::getGuest));

    System.out.println(orderByGuest);
    return orderByGuest;
    }
}
