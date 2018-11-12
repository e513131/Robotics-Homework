import java.util.Arrays;

public class ConsecutiveSwapping{
    public static void main(String[] args){
        int num = 213153;
        char[] arr = toArr(num);
        swapper(arr);
        System.out.print(arr);
    }

    static char[] toArr(int num){
        String str = Integer.toString(num);
        char[] arr = str.toCharArray();
        return arr;
    }

    static void swapper(char[] arr){
        
        for(int i = 0; i<arr.length-1; i+=2){
            char temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;    
        }
    }
}

