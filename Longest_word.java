import java.util.Scanner;

public class Longest_word {
    static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        int n=a.length();
        int c=0,max=0,t=0;
        for(int i=0;i<n;i++){
            char q=a.charAt(i);
            if(q==' '){
                if(max<c) {
                    max = c;
                    t = i;
                }
                c=0;

                }
            if(
                    q==a.charAt(n-1)){
                if (max < c) {
                    max = c;
                    t = i+1;
                }
                c = 0;
            }
            c++;
        }
        int e=t,k=t-max;
        System.out.println(a.substring(k,e));
       /* for(int i=k;i<=e;i++){
            System.out.print(a.charAt(i));
        }*/
    }

}
