package com.smolano.registerproperty;

import com.smolano.registerproperty.entities.Property;
import com.smolano.registerproperty.repositories.PropertyRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase()
public class RegisterPropertyRepositoryTest {
    @Autowired
    private PropertyRepository propertyRepository;

    @Test
    public void shouldRegisterProperty() throws Exception {
        Property propertyFromRequest = new Property();
        propertyFromRequest.setLeaseValue(2);
        final Property propertyInDb = propertyRepository.saveAndFlush(propertyFromRequest);
        Assert.assertEquals(propertyFromRequest, propertyInDb);

    }
}
