/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authorshipandlinguisticsignatures;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RyanB
 */
public class CombineBooks {
    List<Float> tempReadInList  = new ArrayList<>();
    List<Float> readInList  = new ArrayList<>();
  
    private float numberOfBooks = 0;
    

    public void setTempReadInList(List<Float> tempReadIn) {
        tempReadInList.clear();
        tempReadInList = tempReadIn;
    }
    
    

    public void setNumberOfBooks(float numberOfBoo) {
        numberOfBooks = numberOfBoo;
    }

  
    
    
    public void Combine(){
       // System.out.println(tempReadInList);
        float add = 0;
        if(!readInList.isEmpty())
            for (int i = 0; i < readInList.size(); i++)
            {
                add = readInList.get(i) + tempReadInList.get(i);
                readInList.set(i, add);
            }
        else {
            readInList.addAll(tempReadInList);
         //   System.out.println(readInList);
        }
       // System.out.println(readInList);
    }
    
    
    
    public void AuthorsAverage(){
        float average = 0;
        for(int i = 0; i < readInList.size(); i++)
        {
            average = readInList.get(i)/numberOfBooks;
            readInList.set(i, average);
        }
        
    }

    public List<Float> getReadInList() {
       // System.out.println(readInList);
        return readInList;
    }
    
    
    
}
