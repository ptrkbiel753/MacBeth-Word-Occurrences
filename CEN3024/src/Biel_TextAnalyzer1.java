/**
 * Author Name: Patrick Biel
 * Date: 11/08/2020
 * Program Name: biel_TextAnalyzer1
 * Purpose: The purpose of this program is to identify the number of occurrences of each word in Shakespeare's play "Macbeth"
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * This class analyzes text from a text file and generates console output of word occurrences
 * @author Patrick Biel
 * Version 1.0
 */
public class Biel_TextAnalyzer1
{   
    public static void main(String[] args) 
    {   
    
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
        BufferedReader reader = null;
        try
        {
        /**
         * Creating BufferedReader object
         */
            reader = new BufferedReader(new FileReader("Macbeth.txt"));
        /**
         * Reading the first line into currentLine
         */
            String currentLine = reader.readLine();
            while (currentLine != null)
            {   
            
                String[] words = currentLine.toLowerCase().split(" ");
            
                for (String word : words)
                {
                
                    if(wordCountMap.containsKey(word))
                    {   
                        wordCountMap.put(word, wordCountMap.get(word)+1);
                    }
                    /**
                     * otherwise inserting the word as key and 1 as its value
                     */
                        else
                   {
                       wordCountMap.put(word, 1);
                   }
               }
               /**
                * Reading next line into currentLine
                */
                   currentLine = reader.readLine();
           }
           
               Set<Entry<String, Integer>> entrySet = wordCountMap.entrySet();
          
              List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(entrySet);
          
              Collections.sort(list, new Comparator<Entry<String, Integer>>() 
          {
              @Override
              public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) 
              {
                  return (e2.getValue().compareTo(e1.getValue()));
              }
          });
          
              System.out.println("Word occurrences of text file :");
              for (Entry<String, Integer> entry : list) 
          {
              if (entry.getValue() > 1)
                 {
                     System.out.println(entry.getKey() + " : "+ entry.getValue());
                 }
             }
         } 
             catch (IOException e) 
         {
             e.printStackTrace();
         }
             finally
         {
             try
         {
             reader.close();           //Closing the reader
         }
             catch (IOException e) 
         {
             e.printStackTrace();
         }
    }
}   
}