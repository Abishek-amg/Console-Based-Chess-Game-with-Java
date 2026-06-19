import java.util.*;
public class pro {
    public static void main(String[] args) {
        Scanner amg = new Scanner(System.in);
        char[][] a = new char[11][11];
        char x = '1';
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
            if (x <= '8') {
                a[i + 2][0] = x;
            }
            x = (char) (x + 1);
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
        System.out.println("P,p -- Pawn");
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
        System.out.print("Enter the position : ");
        String s=amg.nextLine();
    }
}