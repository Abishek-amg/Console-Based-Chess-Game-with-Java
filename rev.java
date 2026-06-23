import java.util.Scanner;

public class rev {
    static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String a=s.nextLine();
        System.out.println(rev(a));

    }
    public static String rev(String a){
        int n=a.length();
        String x="";
        for(int i=n-1;i>=0;i--){
            x+=a.charAt(i);
        }
        return x;
    }
}
