package main;

import model.SearchPhrase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SearchPhraseInputSource extends InputSource {
    @Override
    public List<SearchPhrase> read(InputStream inputStream) throws Exception {
        List<SearchPhrase> searchPhrases = new ArrayList<>();

        try (BufferedReader buff = new BufferedReader(new InputStreamReader(inputStream))) {
            String strLine;
            StringBuffer buffer = new StringBuffer();
            while ((strLine = buff.readLine()) != null) {
                SearchPhrase searchPhrase = new SearchPhrase();
                searchPhrase.setSearchPhraseString(strLine);
                searchPhrases.add(searchPhrase);
            }
        }
        return searchPhrases;
    }
}
