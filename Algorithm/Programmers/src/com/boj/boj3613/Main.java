package com.boj.boj3613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static String ERROR_MESSAGE = "Error!";
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String varName = bf.readLine();
        String result = "";
        // 언어 형식을 반환한다.
        LanguageType type = getLanguageType(varName);

        //언어 형식에 따른 로직을 수행한다.
        switch (type){
            case JAVA:
                result = convertJavaToCpp(varName);
                break;
            case CPP:
                result = convertCppToJava(varName);
                break;
            default:
                result = ERROR_MESSAGE;
                break;
        }

        // 결과를 반환한다.
        System.out.println(result);

    }
    static LanguageType getLanguageType(String varName){
        if(varName.charAt(0) == '_' || varName.charAt(varName.length()-1)=='_')
            return LanguageType.ERROR;

        boolean javaFlag = false;
        boolean cppFlag = false;

        for (int i = 0; i < varName.length(); i++) {
            char alphabet = varName.charAt(i);
            if(alphabet == '_'){
                cppFlag = true;
            }
            else if(alphabet-'a' < 0)
                javaFlag = true;
        }

        return javaFlag && cppFlag ? LanguageType.ERROR : !javaFlag && cppFlag ? LanguageType.CPP : LanguageType.JAVA;
    }

    static String convertJavaToCpp(String varName){
        if(varName.charAt(0)-'a' < 0 ){
            return ERROR_MESSAGE;
        }
        StringBuilder sb= new StringBuilder();
        char[] alphabets = varName.toCharArray();
        for (char alphabet : alphabets) {
            if(alphabet - 'a' >= 0){
                sb.append(alphabet);
                continue;
            }
            sb.append('_').append((char)((alphabet - 'A') + 'a'));
        }
        String result = sb.toString();
        return result;
    }

    static String convertCppToJava(String varName){
        StringBuilder sb = new StringBuilder();
        boolean upperFlag = false;

        char[] alphabets = varName.toCharArray();
        for (char alphabet : alphabets) {
            if(alphabet == '_'){
                if(upperFlag){
                    return ERROR_MESSAGE;
                }
                upperFlag = true;
                continue;
            }
            if(!upperFlag){
                sb.append(alphabet);
            }else{
                sb.append((char)((alphabet - 'a') + 'A'));
                upperFlag = false;
            }
        }

        String result = sb.toString();
        return result;
    }

    enum LanguageType{
        JAVA, CPP, ERROR
    }
}
