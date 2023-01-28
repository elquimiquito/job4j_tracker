package ru.job4j.hmap;

import java.util.*;
public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0d;
        int i = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                i++;
            }
        }
        return sum / i;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double sum = 0d;
        int i = 0;
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                i++;
            }
            labels.add(new Label(pupil.name(), sum / i));
            sum = 0;
            i = 0;
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> scores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scores.put(subject.name(), scores.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String name : scores.keySet()) {
            labels.add(new Label(name,  (double) scores.get(name) / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double sum = 0d;
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            labels.add(new Label(pupil.name(), sum));
            sum = 0;
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> scores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scores.put(subject.name(), scores.getOrDefault(subject.name(), 0) + subject.score());
        }
    }
        for (String name : scores.keySet()) {
            labels.add(new Label(name,  scores.get(name)));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}