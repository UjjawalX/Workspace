package main;

import model.SearchPhrase;
import model.Work;

import java.util.List;

public abstract class SearchWithStream {
    public abstract void findSearchPhrase(List<SearchPhrase> searchPhrases, List<Work> works);
}
