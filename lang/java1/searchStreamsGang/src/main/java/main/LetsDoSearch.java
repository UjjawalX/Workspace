package main;

import model.SearchPhrase;
import model.Work;

import java.util.List;

public class LetsDoSearch {
    public static void main(String[] args) {
        InputSource searchPhInputSource = new SearchPhraseInputSource();
        InputSource workInputSource  = new WorkInputSource();
        try {
            List<SearchPhrase> searchPhrases = (List<SearchPhrase>) searchPhInputSource.read(LetsDoSearch.class.getClassLoader().getResourceAsStream("main/searchPhrases.txt"));

            List<Work> works = (List<Work>) workInputSource.read(LetsDoSearch.class.getClassLoader().getResourceAsStream("main/shakesworks.txt"));
            SearchWithStream searchWithSequentialStream = new SearchWithSequentialStream();
            searchWithSequentialStream.findSearchPhrase(searchPhrases,works);
            searchPhrases.stream().filter( searchPhrase -> searchPhrase.getLineNos().size() != 0).forEach(searchPhrase -> {
                System.out.print("\nFound searchPhrase : "+searchPhrase.getSearchPhraseString() +" at: ");
                searchPhrase.getLineNos().stream().forEach( a -> System.out.println(a+" "));
                searchPhrase.getTitles().stream().forEach( a -> System.out.println(a+" "));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
