package com.saturn.level.StringProcess.WordSeperate;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;

public class WordSeperate {

    public static void main(String[] args) {

        WordSeperate wordSeperate = new WordSeperate();

        String src = "  java   is   a language!";
        //  String lastWord = wordSeperate.getLastWord(src);

        String lastWord = wordSeperate.getLastWord1(src);
        System.out.println("lastWord:" + lastWord);
    }


    /**
     * 用库函数
     *
     * @param src
     * @return
     */
    public String getLastWord(String src) {

        StringTokenizer stringTokenizer = new StringTokenizer(src, " !");
        String lastWord = null;
        while (stringTokenizer.hasMoreElements()) {
            lastWord = stringTokenizer.nextElement().toString();
        }

        return lastWord;
    }

    /**
     * 生死，不依赖库
     *
     * @param src
     * @return
     */
    public String getLastWord1(String src) {


        String result = null;

         int word=0;

        List<String> allWords = new ArrayList<>();

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < src.length(); i++) {

            if(src.charAt(i)==' ')
            {
                if(word!=0)
                {
                    //提取一个单词
                    allWords.add(temp.toString());
                    temp.setLength(0);
                }
                else
                {
                    System.out.println("before is empty also");
                }

                word=0;
            }
            else
            {
                temp.append(src.charAt(i));
                word=1;
                //追加字母
            }

        }

        if(temp.length()>0)
        {
            allWords.add(temp.toString());
        }

        if (allWords.size() > 0) {
            result = allWords.get(allWords.size() - 1);
        }

        return result;


    }
}
