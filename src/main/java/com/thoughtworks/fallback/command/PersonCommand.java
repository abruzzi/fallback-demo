package com.thoughtworks.fallback.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.thoughtworks.fallback.domain.Person;

public class PersonCommand extends HystrixCommand<Person> {
    private Person person;

    public PersonCommand(Person person) {
        super(HystrixCommandGroupKey.Factory.asKey("person"));
        this.person = person;
    }

    @Override
    protected Person run() {
        return person;
    }
}
