package dataStructures.Algorithms;

public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = new int[]{1,6,6,6,6,6,6,6,6,6,6,6};
        System.out.println("Result::"+binarySerach(arr, 1));
    }

    public static int binarySerach(int arr[], int result){
        int first = 0;
        int last = arr.length -1;
        int returnValue = -1;
        while(first <= last){
            int mid = (first + last)/ 2;
            if(arr[mid] == result) {
                System.out.println(arr[mid]);
                returnValue = mid;
                last = mid - 1;
            }
            else if(result < arr[mid]){
                last = mid - 1;
            }
            else{
                first = mid + 1;
            }
        }
        return returnValue;
    }
}
