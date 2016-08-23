package com.thoughtworks.fallback.command;

import com.thoughtworks.fallback.domain.Person;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PersonCommandTest {

    @Test
    public void should_return_person_object() {
        Person juntao = new Person("Juntao", 31);
        PersonCommand personCommand = new PersonCommand(juntao);

        Person result = personCommand.execute();

        assertThat(result.getName(), is(juntao.getName()));
        assertThat(result.getAge(), is(juntao.getAge()));
    }
}