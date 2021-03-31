package hfu.modgswe.aufgabe1;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldExtractor {
    private final int begin;
    private final int end;
    private String targetPropertyName;
    private String notationPattern;

    public FieldExtractor(int begin, int end, String targetPropertyName, String notationPattern) {
        this.begin = begin;
        this.end = end;
        this.targetPropertyName = targetPropertyName;
        this.notationPattern = notationPattern;
    }

    public void extractField(String line, Object targetObject) throws Exception {
       String value = line.substring(begin, end);
       setValue(targetObject, value);
    }

    private void setValue(Object targetObject, String value) throws Exception {
        Method method = targetObject.getClass().getMethod("set"+targetPropertyName, String.class);
        if(notationPattern != null){
            Matcher matcher = Pattern.compile(notationPattern).matcher(value);
            if (!matcher.matches()) {
                throw new Exception("Input does not match given pattern");
            }
        }
        method.invoke(targetObject, value);
    }

    @Override
    public String toString() {
        return "FieldExtractor{" +
                "begin=" + begin +
                ", end=" + end +
                ", targetPropertyName='" + targetPropertyName + '\'' +
                '}';
    }
}