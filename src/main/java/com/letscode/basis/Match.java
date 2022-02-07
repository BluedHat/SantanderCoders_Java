package com.letscode.basis;

import java.util.Comparator;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode

public class Match implements Comparable<Match>{
    protected String matchDate;
    protected String home;
    protected int homeGoals;
    protected String guest;
    protected int guestGoals; 

class clubCompare implements Comparator<Match>
{
    @Override
    
    public int compare(Match o1, Match o2)    
     {
         return o1.home.compareTo(o2.guest);    
     }
 }

 class GoalsCompare implements Comparator<Match>
{
    @Override
    public int compare(Match o1, Match o2)
     {  int whoWins = Integer.compare(homeGoals, guestGoals);
        return whoWins;
    
     }
 }

@Override
public int compareTo(Match o) {
    // TODO Auto-generated method stub
    return 0;
}
}
