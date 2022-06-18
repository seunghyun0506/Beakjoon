import java.util.Scanner;

public class B17214 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tmp;
        StringBuilder sb = new StringBuilder();

        String str = sc.nextLine();
        if(str.indexOf("x") < 0){//상수항만 있음
            tmp = Integer.parseInt(str);

            if(tmp == 1 || tmp == -1)//1 or -1이면 숫자 생략
                sb.append((tmp <0)? "-x" : "x");
            else if(tmp == 0) tmp =0;
            else
                sb.append(tmp).append("x");
        }

        else if(str.indexOf("x") == str.length()-1){ //일차항만 있을 때
            tmp = Integer.parseInt(str.substring(0, str.indexOf("x")))/2;
            if(tmp == 1 || tmp == -1)//1 or -1이면 숫자 생략
                sb.append((tmp <0)? "-xx" : "xx");

            else
                sb.append(tmp).append("xx");
        }
        else{
            tmp = Integer.parseInt(str.substring(0, str.indexOf("x")))/2;
            if(tmp == 1 || tmp == -1)//1 or -1이면 숫자 생략
                sb.append((tmp <0)? "-xx" : "xx");

            else
                sb.append(tmp).append("xx");

            tmp = Integer.parseInt(str.substring(str.indexOf("x")+1, str.length()));

            if(tmp == 1 || tmp == -1)//1 or -1이면 숫자 생략
                sb.append((tmp <0)? "-x" : "+x");
            else if(tmp == 0) tmp =0;
            else
                sb.append(tmp>0? "+"+tmp : tmp).append("x");
        }
        sb.append(sb.length() == 0 ? "W" : "+W");
        System.out.println(sb);
    }
}
