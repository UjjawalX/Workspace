package main;

import model.SearchPhrase;
import model.Work;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchWithSequentialStream extends SearchWithStream{
    /*public static void main(String[] args) throws IOException {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        //get Input from source


        //do the operation
        //give the output
        Long startTime = System.currentTimeMillis();
        System.out.println("Time started:" + new Date(System.currentTimeMillis()));
        BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream("Shakespeare-Complete-Works.doc")));
        BufferedWriter bufferOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Shakespeare-Complete-Works-write")));
        String str;
        int count = 0;
        boolean find = false;
        while ((str = buffer.readLine()) != null) {
            count++;
//            Pattern pattern = Pattern.compile("raj");
//            find = pattern.matcher(str).find();
//            if(find){
//                break;
            bufferOut.write(str);
//            }

        }
        System.out.println("file written");
        System.out.println("Tot lop:" + count);
        Long total_time = System.currentTimeMillis()-startTime;
        System.out.println("Time total: " + total_time);
        buffer.close();
        bufferOut.close();
    }*/
    public void findSearchPhrase(List<SearchPhrase> searchPhrases, List<Work> works){
    works.stream().forEach(work -> {
        searchPhrases.stream().forEach(searchPhrase -> {
            Matcher matcher = Pattern.compile("\\n").matcher(work.getBody());
            int line = 0;
            int startIndex = 0, lastIndex = 0;
            while(matcher.find()){
                line++;
                lastIndex = matcher.start();
                if(work.getBody().substring(startIndex,lastIndex).indexOf(searchPhrase.getSearchPhraseString())>-1){
                    searchPhrase.setNoOfOccurence(searchPhrase.getNoOfOccurence()+1);
                    searchPhrase.getLineNos().add(line+work.getLineNo());
                    searchPhrase.getTitles().add(work.getTitle());
                }
                startIndex = lastIndex+1;
            }
        });
    });

    }
}
