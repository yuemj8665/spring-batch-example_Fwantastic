package com.mjmj.example3;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/com.mjmj.example3/job3.xml"})
public class MyJobTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static AtomicBoolean isLaunched = new AtomicBoolean(false);

    private JobExecution jobExecution;

    @Before
    public void setUp(){
        Assert.assertEquals(ExitStatus.COMPLETED.getExitCode(), jobExecution.getExitStatus().getExitCode());
    }

    @Test
    public void testPersonCreated(){
        // jdbcTemplate을 사용 해 Person 테이블의 모든 row를 가져온다.
        List<Person> createdPersons = jdbcTemplate.query("SELECT * FROM PERSON",
                new BeanPropertyRowMapper<Person>(Person.class));
        System.out.println(createdPersons);

        // input.csv 라인 갯수와 Person 테이블의 row갯수가 일치하는지 확인
        Assert.assertEquals(2,createdPersons.size());


    }
}
