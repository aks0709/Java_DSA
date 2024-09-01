package Company.Accenture;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        System.out.println(isPrime(198));
    }
    public static boolean isPrime(int num){
        int prime[]=new int[num+1];
        for(int i=2;i<=num;i++)
            prime[i]=1;

        for(int i=2;i<=Math.sqrt(num);i++){
            if(prime[i]==1)
            {
                for(int j=i*i;j<=num;j+=i)
                    prime[j]=0;
            }
        }
        return prime[num]==1;
    }
}
