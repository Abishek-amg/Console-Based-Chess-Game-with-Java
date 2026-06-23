import java.util.Scanner;

public class Freq {
    static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    String a=s.nextLine();
    int n=a.length();
  // char w[]=a.toCharArray();
    int f[]=new int[256];
    for(int i=0;i<n;i++){
        f[a.charAt(i)]++;
        //f[w[i]]++;
    }
    for(int i=0;i<n;i++){
        char q=a.charAt(i);
        if(f[q]>0){
            System.out.println(q+"-"+f[q]);
            f[q]=0;
        }
    }
    }
}
