package com.thoughtworks.fallback.command;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import com.thoughtworks.fallback.domain.Person;
import rx.Observable;

public class ObservablePersonCommand extends HystrixObservableCommand<Person>{
    private Person person;

    protected ObservablePersonCommand(Person person) {
        super(HystrixCommandGroupKey.Factory.asKey("person"));
        this.person = person;
    }

    @Override
    protected Observable<Person> construct() {
        return Observable.just(person);
    }
}
