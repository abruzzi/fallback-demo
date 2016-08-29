package com.thoughtworks.fallback;

import com.thoughtworks.fallback.client.PersonServiceClient;
import com.thoughtworks.fallback.command.PersonCommand;
import com.thoughtworks.fallback.domain.Person;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class Main {


    public static void main(String[] args) {
        Person juntao = new Person("Juntao", 31);
        PersonCommand personCommand = new PersonCommand(juntao);

        Person result = personCommand.execute();
        System.err.println(result);

        PersonServiceClient person = Feign.builder().encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(PersonServiceClient.class, "http://localhost:8100");

        System.err.print(person.get(1));
    }
}
