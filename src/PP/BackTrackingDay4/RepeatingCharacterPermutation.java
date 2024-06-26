package PP.BackTrackingDay4;

public class RepeatingCharacterPermutation {
    public static void GP(char[] arr,int index){
        if(index>= arr.length){
            for(int i=0;i< arr.length;i++)
                System.out.print(arr[i]);
            System.out.println();
            return;
        }
        else {
            for(int i=index;i<arr.length;i++){

                swap(arr,i,index);  //swap
                GP(arr,index+1);
                swap(arr,i,index);  //Un swap
            }
        }
    }
    public static void swap(char arr[],int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        //we can't use set or hashMAp

    }
}
