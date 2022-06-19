import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class B10993 {
    static int T = 0;
    static char[][] arr = {{'*'}};
    static char[][] recursive_function(int num){
        if(num == 1) return arr;
        int size = (int)Math.pow(2, num)-1;
        char[][] result = new char[size][size*2 -1];
        char[][] tmp  = recursive_function(num-1);
        /* tmp 배열 복사하기 */
        if(num % 2 == 1){
            for(int i = 0; i < tmp.length; i++){
                for(int j = 0; j < tmp[i].length; j++){
                    result[result.length-2-i][(size+1)/2+j] = tmp[tmp.length-1-i][j];
                }
            }
            for(int i = 0; i < result.length; i++){
                result[i][(result[i].length-1)/2-i] = '*';
                result[result.length-1][(result[i].length-1)/2-i] = '*';
                result[i][(result[i].length-1)/2 + i] = '*';
                result[result.length-1][(result[i].length-1)/2 + i] = '*';
            }
        }
        else{
            for(int i = 0; i < tmp.length; i++){
                for(int j = 0; j < tmp[i].length; j++){
                    result[i+1][(size+1)/2+j] = tmp[i][j];
                }
            }
            for(int i = 0; i < result.length; i++){
                result[i][i] = '*';
                result[0][i] = '*';
                result[i][(result[i].length-1) - i] = '*';
                result[0][result[i].length-1-i] = '*';
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        T = sc.nextInt();
        char[][] result = recursive_function(T);
        for(char[] tmp : result){
            for(char tmp2 : tmp){
                if(tmp2 == '\u0000') sb.append(' ');
                else
                    sb.append(tmp2);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
