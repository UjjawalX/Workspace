package main;

import model.SearchPhrase;

import java.util.Spliterator;
import java.util.function.Consumer;

public class PhraseMatchSpliterator<SearchPhrase> implements Spliterator<SearchPhrase> {
    @Override
    public boolean tryAdvance(Consumer<? super SearchPhrase> action) {
        return false;
    }

    @Override
    public Spliterator<SearchPhrase> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return 0;
    }
}
