package hfu.modgswe.aufgabe1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReaderStrategy {

    private String code;
    private String notationPattern;
    private Class target;
    private List<FieldExtractor> extractors = new ArrayList<>();

    public ReaderStrategy(String code, Class target) {
        this.code = code;
        this.target = target;
        this.notationPattern = null;
    }

    public ReaderStrategy(String code, Class target, String notationPattern){
        this.code = code;
        this.target = target;
        this.notationPattern = notationPattern;
    }

    public void addFieldExtractor(int begin, int end, String target) throws Exception {
        List list = targetPropertyNames();
        if (!list.contains(target))
            throw new Exception("NoFieldInTargetException");
        extractors.add(new FieldExtractor(begin, end, target, this.notationPattern));
    }

    private List targetPropertyNames() {
        List<String> actualFieldNames = new ArrayList<>();

        Field[] fields = target.getDeclaredFields();
        for (Field field : fields){
            actualFieldNames.add(field.getName());
        }
        return actualFieldNames;
    }

    public Object process(String line) throws Exception {
        Object result = target.getDeclaredConstructor().newInstance();
        for(FieldExtractor extractor : extractors){
            extractor.extractField(line, result);
        }
        return result;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ReaderStrategy{" +
                "code='" + code + '\'' +
                ", target=" + target +
                ", extractors=" + extractors +
                '}';
    }
}
