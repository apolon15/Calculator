import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        boolean stop;
        do {
            stop = true;
            Scanner sc = new Scanner(System.in);
            LinkedList<Double> listNumb = new LinkedList<Double>();
            LinkedList<Character> listChar = new LinkedList<Character>();
            StringBuffer sb = new StringBuffer();
            System.out.println("Введи строку для расчета");
            String userInput = sc.nextLine();
            String patternTest = ".*\\(?\\d+\\.*[*+-/].*\\d+\\)?";
            Pattern pTest = Pattern.compile(patternTest);
            Matcher mTest = pTest.matcher(userInput);
            if (!mTest.matches()) {//проверка на пустую строку
                System.out.println("Строка не валидна");
            } else {
                String exemp2 = userInput.replaceAll("[^*+-/()%√.,\\d]", "");//удалил все кроме чисел и математических знаков.
                String pattern = new String("\\(\\d+[*+-/]\\d+\\)");//регулярное выражение
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(exemp2);
                String part = null;//пустая строка

            }
        } while (stop);
    }public static double minus(double result, double digit) {//вычитание
        return result - digit;
    }

    public static double mult_div(double result, double digit, boolean bool) {//умножение либо деление.Зависит от true/false
        if (bool == true) {
            result = result * digit;//умножение
        }
        if (bool == false) {
            result = result / digit;//деление
        }
        return result;
    }

    public static double sum(double result, double digit) {//сложение
        return result + digit;
    }

    public static String[] getDigit(String str) {//получение цифр
        //была идея, но затерялась в мыслях
        double x = 0;
        if (str.contains("+-") || str.contains("*-") || str.contains("/-")) {
            Pattern p = Pattern.compile("(\\-\\d+)");
            Matcher m = p.matcher(str);
            if (m.find()) {
                x = Double.parseDouble(m.group(0));
            }
        }
        if (str.contains("--")) {
            Pattern p = Pattern.compile("(\\-\\d+)");
            Matcher m = p.matcher(str);
            if (m.find()) {
                x = Double.parseDouble(m.group(0)) * -1;
            }
        }
        String test[] = str.split("[/*+-]-?");
        return test;
    }

    public static String[] getMath(String str) {//получение математических знаков
        //TO DO для корректной работы с отрицательным числом. Идея пока не реализовалась
        if (str.contains("+-") || str.contains("*-") || str.contains("/-") || str.contains("--")) {


        }
        String test[] = str.split("\\d+\\.?\\d{0,}");

        return test;
    }
    //получение строки в нужном формате
    public static String getStr(String str) {
        str = str.replaceAll("[^*+-/()%√.,\\d]", "");
        return str;
    }
}