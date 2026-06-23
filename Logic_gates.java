import java.util.Scanner;

public class Logic_gates {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("Enter the Binary input 1 : ");
        String a=s.nextLine();
        System.out.println("Enter the Binary input 2 : ");
        String b=s.nextLine();
        boolean z=true;
        while(z) {
            System.out.println("The options are :");
            System.out.println("1.Perform AND operation");
            System.out.println("2.Perform OR operation");
            System.out.println("3.Perform XOR operation");
            System.out.println("4.Perform NAND operation");
            System.out.println("5.Perform NOR operation");
            System.out.println("Others to EXIT");
            System.out.println("Enter the choice from the above options: ");
            int chioce = s.nextInt();
            switch (chioce){
                case 1:{
                   System.out.println(and(a,b));
                   break;
                }
                case 2:{
                    System.out.println(or(a,b));
                    break;
                }
                case 3:{
                    System.out.println(xor(a,b));
                    break;
                }
                case 4:{
                    System.out.println(nand(a,b));
                    break;
                }
                case 5:{
                    System.out.println("Enter 1 or 2 input to sent" );
                    int k=s.nextInt();
                    if(k==1){
                        System.out.println(nor(a));
                    } else if (k==2) {
                        System.out.println(nor(b));
                    }
                    else{
                        System.out.println(" Enter Valid number ");
                    }
                    break;
                }
                default: {
                    System.out.println("Exited from the operation");
                     z=false;
                }

            }
        }

    }
//    public static String check(String a,int m){
//        int n=a.length();
//       String b=
//    }
   public static String and(String a,String b){
        String f="";
        int n1=a.length();
        int n2=b.length();
        if(n1>n2){
            int c=n1-n2;
            n2=n1;
            for(int i=0;i<c;i++){
                b="0"+b;
            }

        }
        if(n2>n1) {
            int c = n2 - n1;
            n1 = n2;
            for (int i = 0; i < c; i++) {
                a = "0" + a;
            }
        }
        for(int i=0;i<n1;i++){
            char q=a.charAt(i);
            char w=b.charAt(i);
            if(q==w&& q=='1'&& w=='1'){
                f+="1";
            }
            else{
                f+="0";
            }
        }
        return f;
    }
    public static String or(String a,String b){
        String f="";
        int n1=a.length();
        int n2=b.length();
        if(n1>n2){
            int c=n1-n2;
            n2=n1;
            for(int i=0;i<c;i++){
                b="0"+b;
            }

        }
        if(n2>n1) {
            int c = n2 - n1;
            n1 = n2;
            for (int i = 0; i < c; i++) {
                a = "0" + a;
            }
        }
        for(int i=0;i<n1;i++) {
            char q = a.charAt(i);
            char w = b.charAt(i);
            if (q == w&& q=='0'&&w=='0') {
                f += "0";
            } else {
                f += "1";
            }
        }
        return f;

    }
    public static String nand(String a,String b){
        String f="";
        int n1=a.length();
        int n2=b.length();
        if(n1>n2){
            int c=n1-n2;
            n2=n1;
            for(int i=0;i<c;i++){
                b="0"+b;
            }

        }
        if(n2>n1) {
            int c = n2 - n1;
            n1 = n2;
            for (int i = 0; i < c; i++) {
                a = "0" + a;
            }
        }
        for(int i=0;i<n1;i++) {
            char q = a.charAt(i);
            char w = b.charAt(i);
            if (q == w && q=='1'&&w=='1') {
                f += "0";
            } else {
                f += "1";
            }
        }
        return f;

    }
    public static String xor(String a,String b){
        String f="";
        int n1=a.length();
        int n2=b.length();
        if(n1>n2){
            int c=n1-n2;
            n2=n1;
            for(int i=0;i<c;i++){
                b="0"+b;
            }

        }
        if(n2>n1) {
            int c = n2 - n1;
            n1 = n2;
            for (int i = 0; i < c; i++) {
                a = "0" + a;
            }
        }
        for(int i=0;i<n1;i++) {
            char q = a.charAt(i);
            char w = b.charAt(i);
            if (q == w ) {
                f += "0";
            } else {
                f += "1";
            }
        }
        return f;

    }
    public static String nor(String a){
        String f="";
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)=='1')
                f+="0";
            else
                f+="1";
        }
        return f;
    }

}
