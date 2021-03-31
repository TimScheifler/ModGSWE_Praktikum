package hfu.modgswe.aufgabe1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Reader {

    private HashMap<String, ReaderStrategy> strategies = new HashMap<>();

    public List<Object> process(String file){

        List<Object> list = new ArrayList();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                processLine(line, list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private void processLine(String line, List<Object> result) throws Exception {
       if(isBlank(line)) return;
       if(isComment(line)) return;
        //IRGENDWO AB HIER
        String typeCode = getTypeCode(line);
        System.out.println("TypeCode: "+typeCode);
        ReaderStrategy strategy = strategies.get(typeCode);
        System.out.println("ReaderStrategy: " + strategy);
        if(strategy == null){
            throw new Exception("Strategy could not be found!");
        }
        result.add(strategy.process(line));
        System.out.println("----------------------");
    }

    /**
     * method to assign concrete
     * reader strategy classes, one for each target class (here
     * ServiceCall and Usage).
     * @param arg the ReaderStrategy
     */
    public void addStrategy(ReaderStrategy arg){
        strategies.put(arg.getCode(), arg);
    }

    private boolean isBlank(String line) { return line.isBlank(); }
    private boolean isComment(String line) {
        return line.startsWith("#");
    }
    private String getTypeCode(String line){
        return line.substring(0,4);
    }
}