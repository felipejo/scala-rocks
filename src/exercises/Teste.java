package exercises;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Teste {

    public static void main(String[] args) {
        List<List<String>> listOfLists = Teste.getListOfLists();

        List<String> list = listOfLists.stream().flatMap(List::stream).collect(toList());

        System.out.println(findSecondLargestNumberInList());
    }

    /**
     * The flatMap method on Stream can certainly flatten those lists for you,
     * but it must create Stream objects for element, then a Stream for the result.
     * @param listOfLists
     * @return
     */
    public List<String> generateListOfStringFrom(List<List<String>>listOfLists){
        return listOfLists.stream().flatMap(List::stream).collect(toList());
    }


    public List<String> anotherWayToGenerateListOfStringFrom(List<List<String>>listOfLists){
        return listOfLists.stream().reduce(new ArrayList<>(),(list1, list2) ->{
            list1.addAll(list2);
            return list1;
        });
    }

    /**
     * Returns a list of strings from a List of Lists;
     * This way is better to use with a larger amount of data and can be a very good alternative to flatMap, becuase
     * it won't create new streams for each iteration;
     * @param listOfLists
     * @return
     */
    private List<String> optimalGenerationOfListOfStrings(List<List<String>>listOfLists){
        List<String> result = new ArrayList<>();
        listOfLists.forEach(result::addAll);
        return result;
    }


    private List<String> reverseStringsFromList(List<String> strings){
        return strings.stream().map(a -> new StringBuilder(a).reverse().toString()).collect(Collectors.toList());

    }

    public String reverseTraditional(String input) {

        if (input == null) {
            return input;
        }

        String output = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            output = output + input.charAt(i);
        }

        return output;
    }

    public static List<List<String>> getListOfLists(){
        List primaryList = new ArrayList();

        List secondList = null;
        for(int x =0; x ==10; x++) {
            secondList = new ArrayList();
            for (int i = 0; i < 10; i++) {
                secondList.add("aaaa_" + i);
            }
            primaryList.add(secondList);
        }
        return primaryList;
    }


    public static Integer findSecondLargestNumberInList(){
        List ints = Arrays.asList(100,14, 46, 47, 94, 94, 52, 86, 36, 94, 89 );

        return ( Integer) ints.stream().sorted(Comparator.reverseOrder()).limit(2).skip(1).findFirst().get();

    }

    public static Integer anotherWayToFind2ndLargest(){
        List<Integer> ints = Arrays.asList(100,14, 46, 47, 94, 94, 52, 86, 36, 94, 89 );
        int largest = 0;
        int secondLargest = 0;
        for (Integer i: ints) {
            if (i > largest) {
                secondLargest = largest;
                largest = i;
            }
            else if (i > secondLargest) {
                secondLargest = i;
            }
        }
        return secondLargest;
    }

    public Integer TraditionalindSecondLargestNumberFromList(List<Integer> listOfIntegers){
        int largest = 0;
        int secondLargest = 0;
        int sizeOfList = listOfIntegers.size();
        for (int i = 0; i < sizeOfList; i++){
            int number = listOfIntegers.get(i);
            if (number > largest)
            {
                secondLargest = largest;
                largest = number;
            }
            else if (number > secondLargest)
            {
                secondLargest = number;
            }
        }
        return secondLargest;
    }
}

