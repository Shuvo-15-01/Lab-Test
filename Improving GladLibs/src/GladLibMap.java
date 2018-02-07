import edu.duke.*;

import java.io.File;
import java.util.*;

public class GladLibMap {
    private HashMap<String, ArrayList<String> >myMap;
    private Random myRandom;
    private static String dataSourceURL = "https://github.com/Rusho-RU/CSE-2211-Object-Oriented-Programming-and-Design-Methods/tree/master/Improving%20GladLibs/Resource/GladLibs";
    private static String getDataSourceDirectory = "C:\\Users\\pc\\Downloads\\GladLibs";

    public GladLibMap(){
        myMap = new HashMap<String, ArrayList<String>>();
        myRandom = new Random();
        initializeFromSource(dataSourceURL);
    }

    public GladLibMap(String source){
        myMap = new HashMap<String, ArrayList<String>>();
        myRandom = new Random();
        initializeFromSource(source);
    }

    private ArrayList<String> readIt (String source){
        ArrayList<String> list = new ArrayList<String>();

        if(source.startsWith("http")){
            URLResource urlResource = new URLResource(source);
            for(String line : urlResource.lines())
                list.add(line);
        }

        else{
            FileResource fileResource = new FileResource(source);
            for(String word : fileResource.lines())
                list.add(word);
        }

        return list;
    }

    private void initializeFromSource(String source){
        String[] category = {"adjective", "animal", "color", "country", "fruit", "name", "noun", "timeframe", "verb"};

        for(int i=0; i<9; i++)
            myMap.put(category[i], readIt(source + "/" + category[i] + ".txt"));
    }

    private String randomFrom(ArrayList<String> list){
        int index = myRandom.nextInt(list.size());
        return list.get(index);
    }

    private String getSubstitute(String label){
        if(label.equals("number"))
            return Integer.toString(myRandom.nextInt(100));
        if(!myMap.containsKey(label))
            return "**Unknown**";
        return randomFrom(myMap.get(label));
    }

    private String processWord(String str){
        int start = str.indexOf('<');
        int end = str.indexOf('>');
        if(start == -1 || end == -1)
            return str;
        String prefix = str.substring(0, start);
        String suffix = str.substring(end+1);
        String mid = getSubstitute(str.substring(start+1, end));
        return prefix + mid + suffix;
    }

    private String fromTemplate(String source){
        String story = "";
        if(source.startsWith("http")){
            URLResource urlResource = new URLResource(source);
            for(String word : urlResource.words())
                System.out.println(word);
        }

        else{
            FileResource fileResource = new FileResource(source);
            for(String word : fileResource.words())
                story += processWord(word) + " ";
        }
        return story;
    }

    private void printOut(String str, int breaker){
        int count = 0;
        for(String word : str.split("\\s+")){
            if(count + word.length() > breaker){
                System.out.println();
                count = 0;
            }
            System.out.print(word + " ");
            count += word.length() + 1;
        }
    }

    public void makeStory(){
        String story = fromTemplate(dataSourceURL + "/madtemplate.txt");
        printOut(story, 70);
    }

    public static void main(String args[]){
        GladLibMap obj = new GladLibMap();
        obj.makeStory();
    }
}
