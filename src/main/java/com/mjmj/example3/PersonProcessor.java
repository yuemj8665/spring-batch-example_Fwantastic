package com.mjmj.example3;

import org.springframework.batch.item.ItemProcessor;


/**
 * Person의 풀 네임을 이름과 성으로 쪼갬.
 * 예로 풀 네임이 Suji Bae라면 firstName = Suji, lastName = Bae가 된다.
 */
public class PersonProcessor implements ItemProcessor<Person, Person> {

    private static final String SPACE=" ";

    @Override
    public Person process(Person person) throws Exception {
        String[] names = person.getFullName().split(SPACE);
        person.setFirstName(names[0]);
        person.setLastName(names[1]);

        return person;
    }
}
