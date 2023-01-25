package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder rsl = new StringBuilder();
        int count = evenElements.size();
        for (int i = 0; i < count / 2; i++) {
            rsl.append(evenElements.removeFirst());
            evenElements.removeFirst();
        }
        return String.valueOf(rsl);
    }

    private String getDescendingElements() {
        StringBuilder string = new StringBuilder();
        int count = descendingElements.size();
        for (int i = 0; i < count; i++) {
            string.append(descendingElements.removeLast());
        }
        return String.valueOf(string);
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}