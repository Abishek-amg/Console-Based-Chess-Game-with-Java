import java.util.Scanner;

public class Factorial {
    public static int fact(int n){
        if(n==0){
            return 1;
        }
        return n*fact(n-1);
    }
   /* public static int fac(int n,int ans){
        if(n==0){
            return ans;
        }
        ans=ans*n;
        n--;
        return  fac(n,ans);
    }*/
   public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
       // int ans=1;
        System.out.println(fact(n));
        //System.out.println(fac(n ,ans));
    }


}
