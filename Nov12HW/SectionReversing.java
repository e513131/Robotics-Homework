public class SectionReversing{
    public static void main(String[] args){
        int[] arr = {2,2,3,4,5,6};
        print(arr);

        flippy(arr, 1, 5);
        print(arr);
    }

    static void flippy(int[] arr, int l, int u){
        if(u-l<=0)
            return;
        
        int temp = arr[l];
        arr[l]=arr[u];
        arr[u]=temp;
        flippy(arr, l+1, u-1);
    }

    static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
       }
       System.out.println();
    }
}