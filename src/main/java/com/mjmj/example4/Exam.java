package com.mjmj.example4;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Comparator;

@Getter @Setter
public class Exam {
    private String className;
    private String studentName;

    //시험점수, 0~100점
    private double score;

    //시험등급, A~F
    private String grade;

    @Getter
    public static enum Grade{
        A("A",90)
        ,B("B",80)
        ,C("C",70)
        ,D("D",60)
        ,F("F",0);

        private final String grade;
        private final double score;

        private Grade(String grade, double score){
            this.grade = grade;
            this.score = score;

        }

        public static String convertScore(double score){
            return Arrays.stream(values()).filter(grade -> grade.score < score )
                    .max(Comparator.comparing(grade-> grade.score)).get().getGrade();

        }
    }
}
