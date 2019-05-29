package util;


import java.util.ArrayList;
import java.util.List;

public class Word {
    public static void main(String[] argv) {
        int b[] ={1,3,6,14};
        for(int i = 1; i <= 30; i++){
            System.out.print("4."+String.valueOf(i)+": " + "4." + String.valueOf(i) + " ");
            for(int j = 0;j < 4;j++){
                int k = i - b[j];
                String str = "";
                if (k > 0){
                    str = "4."+String.valueOf(k);
                }
                System.out.print(str);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
        /**
        a = new String[100];
        b = new String[100];
        for (int i = 0; i < 36; i++) {
            a[i] = new String("");
            b[i] = new String("");
        }
        int count = 1;
        int i = 0;
        while (true){
            a[i] = a[i] + "U" + String.valueOf(count) + " " + "U" + String.valueOf(count + 1) + " ";
            a[i + 1] = a[i + 1] + "U" + String.valueOf(count) + " " + "U" + String.valueOf(count + 1) + " ";
            a[i + 3] = a[i + 3] + "U" + String.valueOf(count) + " " + "U" + String.valueOf(count + 1) + " ";
            a[i + 6] = a[i + 6] + "U" + String.valueOf(count) + " " + "U" + String.valueOf(count + 1) + " ";
            a[i + 14] = a[i + 14] + "U" + String.valueOf(count) + " " + "U" + String.valueOf(count + 1) + " ";
            count += 2;
            i++;
            if (count > 57)
                break;
        }
        int day = 1;
        i = 0;
        while (true){
            b[i] = b[i] + "U" + String.valueOf(day) + " " ;
            b[i + 1] = b[i + 1] + "U" + String.valueOf(day) + " " ;
            b[i + 3] = b[i + 3] + "U" + String.valueOf(day) + " ";
            b[i + 6] = b[i + 6] + "U" + String.valueOf(day) + " " ;
            b[i + 14] = b[i + 14] + "U" + String.valueOf(day) + " " ;
            day++;
            i++;
            if (day > 30)
                break;
        }
        for (int j = 0; j < 36; j++) {
            int k = j + 1;
            System.out.println("第" + k + "天: " + "红宝书 " + a[j] + "恋恋有词 " + b[j]);
        }
    }**/
}