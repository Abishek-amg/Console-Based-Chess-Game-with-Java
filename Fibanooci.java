import java.util.Scanner;

public class Fibanooci {
    public static int fibo(int a,int b,int n){
       if(n==0){
           return a;
       }
       System.out.print(a+" ");
        int t=a;
        a=a+b;
        b=t;
        n--;
       return  fibo(a,b,n);
    }
    public static int fibon(int n){
        if(n==0||n==1){
            return n;
        }
        return fibon(n-1)+fibon(n-2);

    }
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        int a= 0,b=1;
        fibo(a,b,n);
        System.out.println();
       // System.out.println(fibo(a,b,n));
        for(int c=0;c<n;c++){
            System.out.print(fibon(c)+" ");
        }
    }

}
