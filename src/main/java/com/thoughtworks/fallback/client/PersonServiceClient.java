package com.thoughtworks.fallback.client;

import com.thoughtworks.fallback.domain.Person;
import feign.Param;
import feign.RequestLine;

public interface PersonServiceClient {
    @RequestLine(value = "GET /people/{id}")
    Person get(@Param("id") long id);

    @RequestLine(value = "POST /people")
    Person create(Person person);
}
