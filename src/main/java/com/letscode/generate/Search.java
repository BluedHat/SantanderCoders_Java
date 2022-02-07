package com.letscode.generate;

import java.util.ArrayList;

import com.letscode.basis.Club;

public class Search {    
    public static ArrayList<String> clubNames = new ArrayList<String>(); 
    public static int TheIndex(ArrayList<Club> clubList, String club, boolean mark){
      int elIndex = 0;      
    
        if (mark) {
          for (Club clubName : clubList) {
            if(clubName.getClub().equals(club)){
            elIndex = clubList.indexOf(clubName);}
           }     
        }           
      return elIndex;
    }

    public static boolean Check(ArrayList<Club> clubList, String club){
      
      boolean exist;
            if(clubNames.contains(club)){
               exist =  true;
            }
            else{
              clubNames.add(club);
              exist = false;
            }
      return exist;
    } 
    
}



