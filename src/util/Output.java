/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 * @author Matthew
 * Replaces System.out.println(); with controllable printing.
 */
public class Output 
{
    private static int[] idArray;
    
    public static void updateArray()
    {
        if(Station.getDitigalIn(Config.stDigInDrive))
            addId(Config.IdDrive);
        
        else
            removeId(Config.IdDrive);
        
        if(Station.getDitigalIn(Config.stDigInAutonomous))
            addId(Config.IdAutonomous);
        
        else
            removeId(Config.IdAutonomous);
        
        if(Station.getDitigalIn(Config.stDigInRecorder))
            addId(Config.IdRecorder);
        
        else
            removeId(Config.IdRecorder);
        
        if(Station.getDitigalIn(Config.stDigInReplayer))
            addId(Config.IdReplayer);
        
        else
            removeId(Config.IdReplayer);
    }
    
    /**
     * Takes the idNum and checks if it is in the controlling array; returns true if contained.
     * @param id
     * @return 
     */
    private static boolean checkToPrint(int id)
    {
        for(int index = 0; index < idArray.length; index++)
            if(id == idArray[index])
                return true;
        
        return false;
    }
    
    /**
     * Prints out the inputed value if the id is in the idArray (to print).
     * @param id
     * @param value 
     */
    public static void println(int id, String value)
    {
        if(checkToPrint(id))
            System.out.println(value);
    }
    
    /**
     * Checks if the id to be added is included, if not adds it to the last position of the idArray (to print).
     * @param id 
     */
    public static void addId(int id)
    {
        if(checkToPrint(id))
            return;
        
        int[] newIdArray = new int[idArray.length + 1];
        
        for(int index = 0; index < newIdArray.length; index++)
        {
            if((index + 1) == newIdArray.length)
                newIdArray[index] = id;
            
            else
                newIdArray[index] = idArray[index];
        }
        
        idArray = newIdArray;
    }
    
    /**
     * Checks if the id to be removed is absent, if there removes it from the idArray (to print).
     * @param id 
     */
    public static void removeId(int id)
    {
        if(!checkToPrint(id))
            return;
        
        int[] newIdArray = new int[idArray.length - 1];
        
        for(int currentIndex = 0, newIndex = 0; currentIndex < idArray.length; currentIndex++)
        {
            if(idArray[currentIndex] == id)
                continue;
            
            newIdArray[newIndex++] = idArray[currentIndex];
        }
        
        idArray = newIdArray;
    }
    
    /**
     * Prints out the ids of the classes to be printed.
     */
    private static void printArray()
    {
        for(int i = 0; i < idArray.length; i++)
            System.out.println(idArray[i]);
    }
}
