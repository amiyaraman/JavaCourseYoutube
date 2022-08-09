import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneNumber {
    public static void main(String[] args) {
        FindCombination("","23");
        String s="";
        System.out.println(s.isEmpty());


    }
    static List<String> MobileKey = Arrays.asList("India","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
    static ArrayList<String> mlist=new ArrayList<>();
    static void FindCombination(String p ,String digit){
        if(digit.isEmpty()){
            mlist.add(p);
            return;
        }
        int dig = digit.charAt(0)-'0';
        for (int i = 0; i < MobileKey.get(dig).length(); i++) {
            char ch =  MobileKey.get(dig).charAt(i);
            FindCombination(p+ch,digit.substring(1));
        }
//        for (int i = 0; i < digit.length(); i++) {
//
//            int parseInt = Integer.parseInt(String.valueOf(digit.charAt(i)));
//            for (int j = 0; j < MobileKey.get(parseInt).length(); j++) {
//                FindCombination(p+MobileKey.get(parseInt).charAt(j),digit.substring(i+1),lenght);
//            }
//
//        }
    }
}
