package dataStructures.Algorithms;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();
        Map<String, Spaces> amountMap = new HashMap<>();
        List<String> inputSpaces = Arrays.asList(inputString.split(","));
        inputSpaces = inputSpaces.stream().filter(Objects::nonNull).collect(Collectors.toList());
        for(int i=0;i<inputSpaces.size()-1;i++){
            String givenInput = in.nextLine();
            String[] lineInput = givenInput.split("=");
            amountMap.put(lineInput[0].trim(), getSpace(lineInput[1].trim().split(" ")));
        }
        TreeMap<Integer, String> resultMap = new TreeMap<>();
        int max = getAmount(amountMap,inputSpaces, resultMap);
        StringBuilder result = new StringBuilder(new String());
        int count = 0;
        for(Map.Entry<Integer,String> entry : resultMap.entrySet()){
            if(count == 0)
                result = new StringBuilder(getString(max, entry.getKey(), entry.getValue()));
            else
                result.insert(0, getString(max, entry.getKey(), entry.getValue()) + " = ");
            ++count;
        }
        System.out.println(result);
    }

    private static String getString(int amount, int value, String str) {
        return (amount/value)+str;
    }

    private static int getAmount(Map<String, Spaces> amountMap, List<String> inputSpaces, TreeMap<Integer, String> resultMap) {
        int max = 0;
        for (String inputSpace : inputSpaces) {
            int amount = 1;
            if(inputSpace != null)
                 amount = getAmount(inputSpace,amountMap, 1);
            resultMap.put(amount,inputSpace);
            if(max < amount)
                max = amount;
        }
        return max;
    }

    private static Integer getAmount(String inputSpace, Map<String, Spaces> amountMap, int sum) {
        while(true) {
            if (inputSpace != null && amountMap.containsKey(inputSpace)) {
                sum = sum * (getAmountFrom(amountMap.get(inputSpace)));
                inputSpace = amountMap.get(inputSpace).getSpace();
            }
            else
                break;
        }
        return sum;
    }

    private static int getAmountFrom(Spaces spaces) {
        return spaces.getAmount() == 0 ? 1 : spaces.getAmount();
    }


    private static Spaces getSpace(String[] equivalentSpace){
        Spaces spaces = new Spaces();
        spaces.setAmount(Integer.parseInt(equivalentSpace[0]));
        spaces.setSpace(equivalentSpace[1]);
        return spaces;
    }
}

class Spaces{
    private int amount;
    private String space;

    public int getAmount() {
        return amount;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

}