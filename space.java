import java.util.Scanner;

public class space
{
   public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String a=s.nextLine();
        System.out.print(Space(a));
    }
    public static String Space(String b){
       String a="";
        for(int i=0;i<b.length();i++){
            if(b.charAt(i)!=' ')
                a+=b.charAt(i);
        }
        return a;
    }
}
