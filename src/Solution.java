import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();


    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        List<String> reversedList = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             FileReader fr = new FileReader(bf.readLine())) {
            while (fr.ready()) {
                sb.append((char) fr.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sb.replace(sb.indexOf("\r"), sb.indexOf("\r") + 2, " ");
        Collections.addAll(list, sb.toString().split(" "));
        Collections.addAll(reversedList, sb.reverse().toString().split(" "));
        Collections.reverse(reversedList);

        list.forEach(System.out::println);

        for (int i = 0; i < list.size(); i++) {
            int finalI = i;
            String elToCompare = reversedList.get(i);

            for (int j = finalI + 1; j < list.size(); j++) {
                String el = list.get(j);
                System.out.println("el.length() - " + el + " = " + el.length());
                System.out.println("elToCompare - " + elToCompare + " = " + elToCompare.length());
                if (el.equals(elToCompare.trim())) {
                    Pair pair = new Pair();
                    pair.first = el;
                    pair.second = list.get(i);
                    result.add(pair);

                }
            }


        }
        result.forEach(System.out::println);
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
