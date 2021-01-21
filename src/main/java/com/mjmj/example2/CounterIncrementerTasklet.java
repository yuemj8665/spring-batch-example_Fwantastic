package com.mjmj.example2;


import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * JobExecutionContext에서 MY.COUNTER 값을 꺼내오고, 콘솔에 출력 한 다음, 카운터 + 1의 값을 저장한다.
 */
public class CounterIncrementerTasklet implements Tasklet {

    private static final String MY_COUNTER_KEY = "MY.COUNTER";
    private static final int DEFAULT_VALUE = 0;
    private Integer counter;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        // JobExecutionContext를 access 하는 방법.
        final ExecutionContext jobExecutionContext
                = chunkContext
                .getStepContext()
                .getStepExecution()
                .getJobExecution()
                .getExecutionContext();

        // setter를 통해 값이 지정되지 않은 경우 jobExecutionContext에서 값을 불러온다.
        // jobExecutionContext에 MY.COUNTER라는 키/페어가 없을 경우 0을 기본 값으로 가진다.
        if (counter == null) {
            counter = jobExecutionContext.getInt(MY_COUNTER_KEY, DEFAULT_VALUE);
        }

        // 콘솔에 카운터 값 출력.
        System.out.println("카운터: " + counter);

        // 카운터 + 1의 값을 jobExecutionContext에 저장.
        jobExecutionContext.put(MY_COUNTER_KEY, counter + 1);


        return RepeatStatus.FINISHED;
    }

    public void setCounter(final Integer counter) {
        this.counter = counter;
    }
}
