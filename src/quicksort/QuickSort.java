package quicksort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author todyerutz @ plainintricacy.wordpress.com
 * 
 * Java version of a quicksort algorithm for numbers.
 * 
 * Based on this reddit daily challenge:
 * http://goo.gl/OFxxHj
 * 
 * Input: List of numbers to be sorted, each separated by one space.
 * Output: Sorted version of given list, using quicksort.
 * 
 */
public class QuickSort {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your list of numbers:");
        String q = input.nextLine();
        input.close();
        String parts[] = q.split(" ");
        List<Double> numbers = new ArrayList<>();
        for(int i=0; i<parts.length; i++){
            numbers.add(Double.parseDouble(parts[i]));
        }
        System.out.println("\nUnsorted list:");
        System.out.println(numbers + "\n");
        System.out.println("Sorted list:");
        System.out.println(quicksort(numbers));
    }
    
    public static List<Double> quicksort(List<Double> x){
        List<Double> Smaller = new ArrayList<>();
        List<Double> Greater = new ArrayList<>();
        List<Double> Similar = new ArrayList<>();
        
        if(x.size()<=1){
            return x;
        }
        Double pivot =  x.get(new Random().nextInt(x.size()));
        for(int i=0; i<x.size(); i++){
            if(x.get(i)<pivot){
                Smaller.add(x.get(i));
            }else if(x.get(i)==pivot){
                Similar.add(x.get(i));
            }else{
                Greater.add(x.get(i));
            }
        }
        if(Smaller.isEmpty()&&Greater.isEmpty()){
            return Similar;
        }
        
        Smaller=quicksort(Smaller);
        Greater=quicksort(Greater);
        
        List<Double> result = new ArrayList<>();
        result.clear();
        result.addAll(Smaller);
        result.addAll(Similar);
        result.addAll(Greater);
        return result;
    }
}
