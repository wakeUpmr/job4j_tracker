package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder rsl = new StringBuilder();
        Iterator<Character> iterator = evenElements.iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            char symbol = iterator.next();
            if (i % 2 == 0) {
                rsl.append(symbol);
            }
        }
        return rsl.toString();
    }

    private String getDescendingElements() {
        Iterator<Character> iterator = descendingElements.descendingIterator();
        StringBuilder rsl = new StringBuilder();
        while (iterator.hasNext()) {
            rsl.append(iterator.next());
        }
        return rsl.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}