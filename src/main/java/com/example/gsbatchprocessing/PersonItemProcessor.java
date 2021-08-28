package com.example.gsbatchprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(final Person person) throws Exception {
        final String fname = person.getFname();
        final String lname= person.getLname();

        final Person trasformedPerson = new Person(fname, lname);

        log.info(" converting ("+person+") into (" + trasformedPerson+")");
        return trasformedPerson;
    }
}
