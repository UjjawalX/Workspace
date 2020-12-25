package main;

import model.Work;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkInputSource extends InputSource {
    @Override
    public List<Work> read(InputStream inputStream) throws Exception {
        List<Work> works = new ArrayList<>();
        try (BufferedReader buff = new BufferedReader(new InputStreamReader(inputStream))) {
            String strLine;
            StringBuffer buffer = new StringBuffer();
            Pattern pattern1 = Pattern.compile("THE END");
            Pattern pattern2 = Pattern.compile("\\n");
            Pattern pattern3 = Pattern.compile("\\d*");
            int lineContinuous = 0, lineFirst = 0;
            while ((strLine = buff.readLine()) != null) {
//                strLine = strLine.replaceAll("\\d*\\n","");
                ++lineContinuous;
                buffer = buffer.append(strLine).append(System.lineSeparator());
                if (pattern1.matcher(strLine).find()) {
                    Work work = new Work();
                    work.setBody(buffer.toString());
                    work.setLineNo(lineFirst);
                    lineFirst = lineContinuous;
                    Matcher matcher = pattern2.matcher(buffer.toString());
                    int startIndex = 0, lastIndex = 0;
                    while (matcher.find()) {
                        lastIndex = matcher.start();
                        String firstLine = buffer.toString().substring(startIndex, lastIndex);
                        if (!"".equals(firstLine.trim()) && !pattern3.matcher(firstLine).matches()) {
                            work.setTitle(firstLine);

                            break;
                        }
                        startIndex = lastIndex + 1;
                    }
                    ;
                    works.add(work);
                    buffer.delete(0, buffer.length());
                }
            }
        }
        return works;
    }
}
