package org.example.Test;

import org.example.bean.Users;

import java.util.HashMap;
import java.util.Map;

public class Leecode {

    public static boolean backspaceCompare(String S, String T) {
        StringBuffer SB = new StringBuffer();
        StringBuffer NB = new StringBuffer();
        int count = 0;
        for (int i = S.length()-1;i>= 0 ;i--){
            char tt =S.charAt(i);
            if(tt == '#'){
                count++;
                continue;
            }
            if(count>0){
                count--;
                continue;
            }else {
                SB.append(tt);
            }

        }

        count = 0;
        for (int i = T.length()-1;i>= 0 ;i--){
            char tt =T.charAt(i);
            if(tt == '#'){
                count++;
                continue;
            }
            if(count>0){
                count--;
                continue;
            }else {
                NB.append(tt);
            }

        }

        if(SB.toString().equals(NB.toString())){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {

    }
}
