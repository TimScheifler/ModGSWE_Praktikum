package hfu.modgswe.aufgabe1;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldExtractor {
    private final int begin;
    private final int end;
    private final String targetPropertyName;
    private final String notationPattern;

    public FieldExtractor(int begin, int end, String targetPropertyName, String notationPattern) {
        this.begin = begin;
        this.end = end;
        this.targetPropertyName = targetPropertyName;
        this.notationPattern = notationPattern;
    }

    public void extractField(String line, Object targetObject) throws Exception {
        String value = line.substring(begin, end + 1);
        setValue(targetObject, value);
    }

    private void setValue(Object targetObject, String value) throws Exception {
        String tmp = value.replaceAll("\\s","");
        Method method = targetObject.getClass().getMethod("set"+targetPropertyName, String.class);

        if(notationPattern != null){
            Pattern pattern = Pattern.compile(notationPattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(tmp);
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