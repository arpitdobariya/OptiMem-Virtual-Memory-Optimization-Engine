package com.codewithdevesh.osproject.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class LRU {
    int hit;
    int fault;
    ArrayList<Integer>hitList = new ArrayList<>();
    /*------------------function for getting layout for visualization---------------------*/
    public int[][] performLRU(int[]pages,int frames){
        /*-------------------This 2D array is used to represent all data in Tabular form.-------------*/
        int[][] layout = new int[pages.length][frames];
        int[] buffer = new int[frames];
        ArrayList<Integer> stack = new ArrayList<>();
        boolean isFull = false;
        int pointer = 0;

        /*----------------Filled buffer array with -1.----------------*/
        Arrays.fill(buffer,-1);

        for(int i = 0; i < pages.length; i++)
        {
            /*-----------------Here,stack has track of pages that inserted.---------------*/
            if(stack.contains(pages[i]))
            {
                /*----------------if new page is already exist in stack then we remove that page and again insert into stack-----------*/
                stack.remove(stack.indexOf(pages[i]));
            }
            stack.add(pages[i]);

            /*--------------Here, we search page in buffer array, if page is present in buffer array then Page hit occurs.-----------*/
            int search = -1;
            for(int j = 0; j < frames; j++)
            {
                if(buffer[j] == pages[i])
                {
                    search = j;
                    hitList.add(i);
                    hit++;
                    break;
                }
            }

            // if page is didn't present in buffer array then we insert into buffer array implementing LRU.
            if(search == -1)
            {
                /*------------Here, if buffer is full then we use stack to find least recently used page.---------*/
                if(isFull)
                {
                    int min_loc = pages.length;
                    for(int j = 0; j < frames; j++)
                    {
                        if(stack.contains(buffer[j]))
                        {
                            int temp = stack.indexOf(buffer[j]);
                            if(temp < min_loc)
                            {
                                min_loc = temp;
                                pointer = j;
                            }
                        }
                    }
                }
                /*-----------Here, we insert new page at pointer index and increment the value of Page faults.------*/
                buffer[pointer] = pages[i];
                fault++;
                pointer++;
                if(pointer == frames)
                {
                    pointer = 0;
                    isFull = true;
                }
            }

            /*----------Here, we copy the buffer array into layout array.------*/
            System.arraycopy(buffer, 0, layout[i], 0, frames);
        }

        return layout;
    }
    /*---------------- function for getting number of hits -----------------*/
    public int getHits(){
        return hit;
    }

    // getting hit list to identify hits in table
    public ArrayList<Integer> getHitList(){
        return hitList;
    }
}

/* complexity analysis
Time Complexity - O(n*f)
Space Complexity - O(n*f) n= no of page inputs, f = no of frames
2d array for visualization,buffer for storing temporary values
 */

