package com.laurens.kanbanboard;

import com.laurens.kanbanboard.utilities.DatabaseDummyData;

public class App 
{
    public static void main( String[] args )
    {
        DatabaseDummyData demo = new DatabaseDummyData();
        demo.run();
    }
}
