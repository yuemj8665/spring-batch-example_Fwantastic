package com.mjmj.example4;


import org.springframework.batch.item.ItemProcessor;

/**
 * 시험 점수 0-100점 스케일을 A-F 스케일로 변환한다.
 */
public class ExamProcessor implements ItemProcessor<Exam, Exam> {
    @Override
    public Exam process(Exam exam) throws Exception {
        exam.setGrade(Exam.Grade.convertScore(exam.getScore()));
        return null;
    }
}
