package com.codewithdevesh.osproject.Algorithms;

import java.util.ArrayList;

public class Fifo {
    int totalHits;
    ArrayList<Integer> hitList = new ArrayList<>();
    /*------------------function for getting layout for visualization---------------------*/
    public int[][] performFifo(int[] pages, int frames) {

        /*-------------------initializing the arrays of layout and buffer----------------*/
        int[]buffer = new int[frames];
        int[][]layout = new int[pages.length][frames];
        int pointer=0,hit=0,fault=0;

          for(int j=0;j<frames;j++){
              buffer[j]=-1;
          }

        /*-------------checking if pages exist then increase hit counter ----------------------*/
          for(int i=0;i< pages.length;i++){
              int search=-1;
              for(int j=0;j<frames;j++){
                  if(buffer[j]==pages[i]){
                      search=j;
                      hitList.add(i);
                      hit++;
                      break;
                  }
              }
              /*---------- checking if page already exist then increase fault counter----------------------------*/
              if(search==-1){
                  buffer[pointer]=pages[i];
                  fault++;
                  pointer++;
                  if(pointer==frames){
                      pointer=0;
                  }
              }
              /*------------------copying elements in 2d array for visualization----------------*/
              System.arraycopy(buffer, 0, layout[i], 0, frames);
          }
        /*------------------------storing no of hits----------------*/
          totalHits=hit;

          return layout;
    }
    /*---------------- function for getting number of hits -----------------*/
    public int getHits(){
        return totalHits;
    }

    // getting hit list to identify hits in table
    public ArrayList<Integer> getHitList(){
        return hitList;
    }
}

/* Complexity Analysis
Time Complexity - O(f)+O(n*f)  f = no of frames, n = no of page inputs
Space Complexity - O(f)+O(n*f)
 */
