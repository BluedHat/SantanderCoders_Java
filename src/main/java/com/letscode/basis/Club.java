package com.letscode.basis;
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

public class Club implements Comparable<Club>{
    protected int position;
    protected String club;
    protected int points;
    protected int played;
    protected int won;
    protected int draw;
    protected int lost;
    protected int gf; /* Goal For (feitos)*/
    protected int ga; /* Goal Against (sofridos)*/
    protected int gd; /* Goal Difference*/    
    protected String lastMatch;

    @Override
    public int compareTo(Club o) {
        // TODO Auto-generated method stub
        return 0;
    }    
}

