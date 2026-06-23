import java.util.*;
public class Subset {

    public static List<List<Integer>> sub( int [] ab){
        List<List<Integer>> res=new ArrayList<>();
        back(0,ab,new ArrayList<>(),res);
        return res;
    }
    public static void back(int ind,int [] a,List<Integer> cur, List<List<Integer>> res){
        res.add(new ArrayList<>(cur));
        for(int i=ind ;i<a.length;i++) {
            cur.add(a[i]);
            back(i + 1, a, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        int a[]=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=s.nextInt();
        }
        System.out.print(sub(a));
    }
}
