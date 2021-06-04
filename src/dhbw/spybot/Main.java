package dhbw.spybot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args)
        throws IOException
        {

            String[][] map = new String[18][10];
            String levelName;
            String[] output = new String[12];
            BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Info:");
            System.out.println("****************************************************");
            System.out.println("For Null use X");
            System.out.println("For Sand use S");
            System.out.println("For Grass use G");
            System.out.println("For Dirt use D");
            System.out.println("For Water use W");
            System.out.println("For Street use R");
            System.out.println("For Forest use F");
            System.out.println("****************************************************");


            System.out.println("Input your level name");
            levelName = obj.readLine();

        for(int y = 0; y < map[0].length; y++ ){
            for(int x = 0; x < map.length; x++ ){
                System.out.println("Input state of [" + x + "][" + y + "]");
                String str = obj.readLine();

                if(str.equals("")){
                    str = "X";
                }
                map[x][y] = str;
            }
        }
        output[0] = "public final static int[][] " + levelName + " = {";
        for(int y = 0; y < map[0].length; y++ ){
            output[y + 1] = "\t{";
            for(int x = 0; x < map.length; x++ ){
                output[y + 1] += "," + map[x][y];
            }
            output[y + 1] += "}";
        }
        output[11] = "};";

        for(int i = 0; i < output.length; i++ ){
            System.out.println(output[i]);
        }
    }
}
