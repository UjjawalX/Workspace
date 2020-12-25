package model;

import java.util.ArrayList;
import java.util.List;

public class SearchPhrase {
    String searchPhraseString;
    List<Integer> lineNos;
    List<String> titles;
    int noOfOccurence;

    public SearchPhrase(){
        setLineNos(new ArrayList<Integer>());
        setTitles(new ArrayList<String>());
    }

    public String getSearchPhraseString() {
        return searchPhraseString;
    }

    public void setSearchPhraseString(String searchPhraseString) {
        this.searchPhraseString = searchPhraseString;
    }

    public List<Integer> getLineNos() {
        return lineNos;
    }

    public void setLineNos(List<Integer> lineNos) {
        this.lineNos = lineNos;
    }



    public int getNoOfOccurence() {
        return noOfOccurence;
    }

    public void setNoOfOccurence(int noOfOccurence) {
        this.noOfOccurence = noOfOccurence;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }
}
