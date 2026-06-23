import java.util.Scanner;

public class ANAGRAM {
    static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String a=s.nextLine();
        String b=s.nextLine();
        int n=a.length();
        int m=b.length();
        if(n!=m){
            System.out.print("NOT ANAGRAM");
            return;
        }

            int f[]= new int[256];
            for(int i=0;i<n;i++){
                f[a.charAt(i)]++;
                f[b.charAt(i)]++;
            }
            for(int i=0;i<n;i++){
                if(f[a.charAt(i)]!=2||f[b.charAt(i)]!=2){
                    System.out.println("NOT ANAGRAM");
                    return;
                }
            }
            System.out.println("ANAGRAM");



    }
}
