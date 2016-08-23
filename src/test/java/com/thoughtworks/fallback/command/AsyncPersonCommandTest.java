package com.thoughtworks.fallback.command;

import com.thoughtworks.fallback.domain.Person;
import org.junit.Test;
import rx.Observable;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AsyncPersonCommandTest {
    @Test
    public void should_return_person_async() {
        Person juntao = new Person("Juntao", 31);
        AsyncPersonCommand asyncPersonCommand = new AsyncPersonCommand(juntao);
        Observable<Person> observe = asyncPersonCommand.observe();

        assertThat(observe.toBlocking().first(), is(juntao));
    }
}
