package com.thoughtworks.fallback;

import com.thoughtworks.fallback.client.PersonServiceClient;
import com.thoughtworks.fallback.command.PersonCommand;
import com.thoughtworks.fallback.domain.Person;
import feign.Feign;
import feign.Param;
import feign.hystrix.HystrixFeign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class Main {


    public static void main(String[] args) {
        basicHystrixCommand();
        feignWithHystrixFallback();
        feign();
    }

    private static void feignWithHystrixFallback() {
        PersonServiceClient fallback = new PersonServiceClient() {
            @Override
            public Person get(@Param("id") long id) {
                return new Person("fallback", 0);
            }

            @Override
            public Person create(Person person) {
                return person;
            }
        };

        PersonServiceClient client = HystrixFeign.builder().
                encoder(new JacksonEncoder()).
                decoder(new JacksonDecoder()).
                target(PersonServiceClient.class, "http://localhost:8100", fallback);

        System.err.println(client.get(1));
    }

    private static void feign() {
        PersonServiceClient client = Feign.builder().
                encoder(new JacksonEncoder()).
                decoder(new JacksonDecoder()).
                target(PersonServiceClient.class, "http://localhost:8100");

        System.err.print(client.get(1));
    }

    private static void basicHystrixCommand() {
        Person juntao = new Person("Juntao", 31);
        PersonCommand personCommand = new PersonCommand(juntao);

        Person result = personCommand.execute();
        System.err.println(result);
    }

}
