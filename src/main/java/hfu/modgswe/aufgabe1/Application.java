package hfu.modgswe.aufgabe1;

import hfu.modgswe.aufgabe1.Pojo.Move;
import hfu.modgswe.aufgabe1.Pojo.ServiceCall;
import hfu.modgswe.aufgabe1.Pojo.Usage;

public class Application {

    private static String a1_a = ".\\src\\main\\resources\\a1_a.txt";
    private static String a1_b = ".\\src\\main\\resources\\a1_b.txt";

    public static void main(String[] args) throws Exception {
        Application application = new Application();
        Reader reader = new Reader();
        application.configure(reader);
        reader.process(a1_a);
    }

    private void configure(Reader target) throws Exception {
        target.addStrategy(configureServiceCall());
        target.addStrategy(configureUsage());
        target.addStrategy(configureChess());
    }

    private ReaderStrategy configureServiceCall() throws Exception {
        ReaderStrategy result = new ReaderStrategy("SVCL", ServiceCall.class);
        result.addFieldExtractor(4, 18, "CustomerName");
        result.addFieldExtractor(19, 23, "CustomerID");
        result.addFieldExtractor(24, 27, "CallTypeCode");
        result.addFieldExtractor(28, 35, "DateOfCallString");
        return result;
    }

    private ReaderStrategy configureUsage() throws Exception {
        ReaderStrategy result = new ReaderStrategy("USGE", Usage.class);
        result.addFieldExtractor(4, 8, "CustomerID");
        result.addFieldExtractor(9, 22, "CustomerName");
        result.addFieldExtractor(23, 30, "ReadDate");
        return result;
    }

    private ReaderStrategy configureChess() throws Exception {
        String notationPattern = "MOVE([0-9])+.|([SLTDK]?([a-h]?[1-8]?x?)?[a-h]([2-7]|[18]))|((?<!M)O(-O){0,2})";

        ReaderStrategy result = new ReaderStrategy("MOVE", Move.class, notationPattern);
        result.addFieldExtractor(0, 8, "MoveID");
        result.addFieldExtractor(9, 13, "OriginField");
        result.addFieldExtractor(14, 19, "TargetField");
        return result;
    }
}