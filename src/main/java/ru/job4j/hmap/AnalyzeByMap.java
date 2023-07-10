package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        int sum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return (double) sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> avgScore = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int subjectCount = 0;
            int studentTotalScore = 0;
            for (Subject subject : pupil.subjects()) {
                studentTotalScore += subject.score();
                subjectCount++;
            }
            avgScore.add(new Label(pupil.name(), (double) studentTotalScore / subjectCount));
        }
        return List.copyOf(avgScore);
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> avgScoreBySubject = new ArrayList<>();
        Map<String, Integer> subjectScore = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScore.put(subject.name(),
                        subjectScore.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String key : subjectScore.keySet()) {
            avgScoreBySubject.add(new Label(key,
                    (double) subjectScore.get(key) / pupils.size()));
        }
        return List.copyOf(avgScoreBySubject);
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> avgScore = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int studentTotalScore = 0;
            for (Subject subject : pupil.subjects()) {
                studentTotalScore += subject.score();
            }
            avgScore.add(new Label(pupil.name(), studentTotalScore));
        }
        avgScore.sort(Comparator.reverseOrder());
        return avgScore.get(0);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> avgScoreBySubject = new ArrayList<>();
        Map<String, Integer> subjectScore = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScore.put(subject.name(),
                        subjectScore.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String key : subjectScore.keySet()) {
            avgScoreBySubject.add(new Label(key, subjectScore.get(key)));
        }
        avgScoreBySubject.sort(Comparator.reverseOrder());
        return avgScoreBySubject.get(0);
    }
}