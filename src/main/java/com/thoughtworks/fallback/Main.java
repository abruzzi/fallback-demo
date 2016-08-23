package com.thoughtworks.fallback;

import com.thoughtworks.fallback.command.PersonCommand;
import com.thoughtworks.fallback.domain.Person;

public class Main {

    public static void main(String[] args) {
        Person juntao = new Person("Juntao", 31);
        PersonCommand personCommand = new PersonCommand(juntao);

        Person result = personCommand.execute();
        System.err.println(result);
    }
}
