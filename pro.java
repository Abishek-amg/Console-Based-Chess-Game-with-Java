import java.util.*;
public class pro {
    public static void main(String[] args) {
        Scanner amg = new Scanner(System.in);
        char[][] a = new char[11][11];
        char x = '8';
        char y = 'a';
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                a[i][j]='.';
            }
        }
        a[0][0]=a[10][0]=a[0][10]=a[1][0]= a[0][1]=' ';
        a[1][1]=a[10][10]=a[10][1]=a[1][10]='+';
        for (int i = 0; i < 11; i++) {
            // 12345678
            if (x >= '1') {
                a[i + 2][0] = x;
            }
            x = (char) (x - 1);
            // abcdefgh
            if (y <= 'h') {
                a[0][i + 2] = y;
            }
            y = (char) (y + 1);
            // ---------
            if (i >= 2 && i <= 9) {
                a[1][i] = '-';
                a[10][i] = '-';
            }
            // |||||||||
            if (i >= 2 && i <= 9) {
                a[i][1] = '|';
                a[i][10] = '|';
            }
            //Pawns
            if(i>=2&&i<=9){
                a[3][i]='p';
                a[8][i]='P';
            }
        }
        //Lowercase -- Black
        a[2][2]=a[2][9]='r';
        a[2][3]=a[2][8]='n';
        a[2][4]=a[2][7]='b';
        a[2][5]='k';
        a[2][6]='q';
        a[9][2]=a[9][9]='R';
        a[9][3]=a[9][8]='N';
        a[9][4]=a[9][7]='B';
        a[9][5]='K';
        a[9][6]='Q';
        //Console Initial Outputs
        System.out.println("--Black : Lowercase [p,n,r,b,q,k]");
        System.out.println("--White : Uppercase [P,N,R,B,Q,K]");
        System.out.println("P,p -- Solider");
        System.out.println("N,n -- Knight");
        System.out.println("R,r -- Rook");
        System.out.println("B,b -- Bishop");
        System.out.println("Q,q -- Queen");
        System.out.println("K,k -- King");
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
        while (true) {
            System.out.print("Enter your Move : ");
            String input = amg.nextLine();
            String[] parts = input.split(" ");
            if (parts.length == 2) {
                identify(parts[0], parts[1], a);
            }
        }
    }
    public static void identify(String f,String t,char [][]a){
        int f1 = '8' - f.charAt(1) + 2;
        int f2 = f.charAt(0) - 'a' + 2;
        int t1 = '8' - t.charAt(1) + 2;
        int t2 = t.charAt(0) - 'a' + 2;
        if(a[f1][f2]=='r'){
            brook(f1,f2,t1,t2,a);
        }
        else if(a[f1][f2]=='R'){
            wrook(f1,f2,t1,t2,a);
        }
        else if(a[f1][f2]=='b'){
            bbishop(f1,f2,t1,t2,a);
        }
        else if(a[f1][f2]=='B'){
            wbishop(f1,f2,t1,t2,a);
        }
        else if(a[f1][f2]=='k'){
            bking(f1,f2,t1,t2,a);
        }
        else if(a[f1][f2]=='K'){
            wking(f1,f2,t1,t2,a);
        }
        else if(a[f1][f2]=='q'){
            bqueen(f1,f2,t1,t2,a);
        }
        else  if(a[f1][f2]=='Q'){
            wqueen(f1,f2,t1,t2,a);
        }
        else if(a[f1][f2]=='p'){
            bpawn(f1,f2,t1,t2,a);
        }
        else if(a[f1][f2]=='P'){
            wpawn(f1,f2,t1,t2,a);
        }
        else if(a[f1][f2]=='n'){
            bknight(f1,f2,t1,t2,a);
        }
        else if(a[f1][f2]=='N'){
            wknight(f1,f2,t1,t2,a);
        }
    }
    public static void wrongInput(char [][]a){
        System.out.print("Enter valid Move : ");
        Scanner amg=new Scanner(System.in);
        String s=amg.nextLine();
        String[] parts = s.split(" ");
        if (parts.length == 2) {
            identify(parts[0], parts[1], a);
        }
        else {
            System.out.println("Invalid format. Use: e2 e4");
        }
    }
    public static void bqueen(int f1,int f2,int t1,int t2,char a[][]){
    }
    public static void wqueen(int f1,int f2,int t1,int t2,char a[][]){
    }
    public static void bking(int f1,int f2,int t1,int t2,char a[][]){
    }
    public static void wking(int f1,int f2,int t1,int t2,char a[][]){
    }
    public static void wknight(int a,int b,int c,int d,char[][] y){
        int row=a>c?a-c:c-a;
        int col=b>d?b-d:d-b;
        if((row==2&&col==1)||(row==1&&col==2)){
            if(c>=2&&c<=9&&d>=2&&d<=9){
                char t=y[c][d];
                if(t=='P'||t=='N'||t=='R'||t=='B'||t=='Q'||t=='K'){
                    System.out.println("Invalid Move");
                    displayWhite(y);
                }
                else{
                    y[c][d]='N';
                    y[a][b]='.';
                    if(t=='p'||t=='n'||t=='r'||t=='b'||t=='q'){
                        System.out.println("One Coin Captured");
                    }
                    System.out.println("Moved Successfully");
                    displayBlack(y);
                }
            }
            else{
                System.out.println("Invalid Move");
                displayWhite(y);
            }
        }
        else{
            System.out.println("Invalid Move");
            displayWhite(y);
        }
    }
    public static void bknight(int a, int b, int c, int d, char[][] y) {
        int row=a>c?a-c:c-a;
        int col=b>d?b-d:d-b;
        if((row==2&&col==1)||(row==1&&col==2)){
            if(c>=2&&c<=9&&d>=2&&d<=9){
                char t=y[c][d];
                if(t=='p'||t=='n'||t=='r'||t=='b'||t=='q'||t=='k'){
                    System.out.println("Invalid Move");
                    displayBlack(y);
                }
                else{
                    y[c][d]='n';
                    y[a][b]='.';
                    if(t=='P'||t=='N'||t=='R'||t=='B'||t=='Q'){
                        System.out.println("One Coin captured");

                    }
                    System.out.println("Moved Successfully");
                    displayWhite(y);
                }
            }
            else{
                System.out.println("Invalid Move");
                displayBlack(y);
            }
        }
        else{
            System.out.println("Invalid Move");
            displayBlack(y);
        }
    }
    public static void bbishop(int f1,int f2,int t1,int t2,char a[][]){
    }
    public static void wbishop(int f1,int f2,int t1,int t2,char a[][]){
    }
    public static void bpawn(int f1,int f2,int t1,int t2,char a[][]){
        if((t1-f1)>2){
            System.out.println("Invalid Move ! -- Enter Valid Move");
            displayBlack(a);
        }
        else if(a[t1][t2]=='.'&&a[f1+1][f2]=='.'&&f2==t2){
            if(f1==3){
                a[t1][t2]=a[f1][f2];
                a[f1][f2]='.';
                System.out.println("Moved Successfully !");
                displayWhite(a);
            }
            else if(f1!=8&&(t1-f1)==1){
                a[t1][t2]=a[f1][f2];
                a[f1][f2]='.';
                System.out.println("Moved Successfully !");
                displayWhite(a);
            }
            else{
                System.out.println("Invalid Move ! -- Enter Valid Move");
                displayBlack(a);
            }
        }
        else if((a[f1+1][f2-1]>=65&&a[f1+1][f2-1]<=90)||(a[f1+1][f2+1]>=65&&a[f1+1][f2+1]<=90)&&(f1!=3)){
            a[t1][t2]=a[f1][f2];
            a[f1][f2]='.';
            System.out.println("Moved Successfully !");
            System.out.println("One Coin Captured");
            displayWhite(a);
        }
        else{
            System.out.println("Invalid Move ! -- Enter Valid Move");
            displayBlack(a);
        }
    }
    public static void wpawn(int f1,int f2,int t1,int t2,char a[][]){
        if((f1-t1)>2){
            System.out.println("Invalid Move ! -- Enter Valid Move");
            displayWhite(a);
        }
        //First Pawn's Move
        else if(a[t1][t2]=='.'&&a[f1-1][f2]=='.'&&f2==t2){
            if(f1==8){
                a[t1][t2]=a[f1][f2];
                a[f1][f2]='.';
                System.out.println("Moved Successfully !");
                displayBlack(a);
            }
            else if(f1!=8&&(f1-t1)==1){
                a[t1][t2]=a[f1][f2];
                a[f1][f2]='.';
                System.out.println("Moved Successfully !");
                displayBlack(a);
            }
            else{
                System.out.println("Invalid Move ! -- Enter Valid Move");
                displayWhite(a);
            }
        }
        //Next Pawn's Move
        else if((a[f1-1][f2+1]>=97&&a[f1-1][f2+1]<=122)||(a[f1-1][f2-1]>=97&&a[f1-1][f2-1]<=122)&&(f1!=8)){
            a[t1][t2]=a[f1][f2];
            a[f1][f2]='.';
            System.out.println("Moved Successfully !");
            System.out.println("One Coin Captured");
            displayBlack(a);
        }
        else{
            System.out.println("Invalid Move ! -- Enter Valid Move");
            displayWhite(a);
        }
        //System.out.println(f1+" "+f2+" "+t1+" "+t2);
    }
    public static void wrook(int a,int b,int c,int d,char y[][]){
        int row=a>c?a-c:c-a;
        int col=b>d?b-d:d-b;
        int k,l,m,n;
        k=a>c?c:a;
        l=a<c?c:a;
        m=b>d?d:b;
        n=b<d?d:b;
        if(row>0&&col==0||row==0&&col>0){
        if(row>0&&col==0){
            for(int i=k;i<l;i++){
                if(y[c][d]=='P'||y[c][d]=='N'||y[c][d]=='R'||y[c][d]=='B'||y[c][d]=='Q'){
                    System.out.println("Invalid input ! -- Enter Valid Move");
                    return;
                }
            }
            if(y[c][d]=='p'||y[c][d]=='n'||y[c][d]=='r'||y[c][d]=='b'||y[c][d]=='q') {
                System.out.println("One Coin Captured");
            }
                y[a][b] = '.';
                y[c][d] = 'R';
                System.out.println("Moved Successfully !");
                displayBlack(y);


            }
        else if (row==0&&col>0) {
            for(int i=m;i<n;i++){
                if(y[c][d]=='P'||y[c][d]=='N'||y[c][d]=='R'||y[c][d]=='B'||y[c][d]=='Q'){
                    System.out.println("Invalid input ! -- Enter Valid Move");
                    return;
                }
            }
            if(y[c][d]=='p'||y[c][d]=='n'||y[c][d]=='r'||y[c][d]=='b'||y[c][d]=='q') {
                System.out.println("One Coin Captured");
            }
                y[a][b] = '.';
                y[c][d] = 'R';

                System.out.println("Moved Successfully !");
                displayBlack(y);


            }

        }
        else
            System.out.println("Invalid input ! -- Enter Valid Move");
    }
    public static void brook(int f1,int f2,int t1,int t2,char a[][]){
    }
    public static void displayWhite(char a[][]){
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("Now White's Turn-----");
    }
    public static void displayBlack(char a[][]){
        for (int i = 0; i<11 ; i++) {
            for (int j = 0; j<11 ; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("Now Black's Turn-----");
    }
}