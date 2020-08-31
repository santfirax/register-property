package com.smolano.registerproperty;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smolano.registerproperty.entities.Property;
import com.smolano.registerproperty.model.PropertyDTO;
import com.smolano.registerproperty.repositories.PropertyRepository;
import com.smolano.registerproperty.resource.IRegisterPropertyController;
import com.smolano.registerproperty.service.IRegisterProperty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(IRegisterPropertyController.class)
public class RegisterRepositoryControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IRegisterProperty registerProperty;
    @MockBean
    private PropertyRepository propertyRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldRegisterProperty() throws Exception {
        PropertyDTO propertyFromRequest = new PropertyDTO();
        propertyFromRequest.setLeaseValue(2);
        propertyFromRequest.setArea(2);
        propertyFromRequest.setForSale(true);
        propertyFromRequest.setForSale(true);
        propertyFromRequest.setNumberOfBathrooms(2);
        propertyFromRequest.setNumberOfRooms(2);
        this.mockMvc.perform(post("/property")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(propertyFromRequest)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void shouldGetPropertiesWithLeaseValueAndNumberOfRoomsAndAreaFilters() throws Exception {
        Property expensiveProperty = new Property();
        expensiveProperty.setLeaseValue(2000000);
        expensiveProperty.setArea(2);
        expensiveProperty.setForSale(true);
        expensiveProperty.setForSale(true);
        expensiveProperty.setNumberOfBathrooms(2);
        expensiveProperty.setNumberOfRooms(2);
        Property normalProperty = new Property();
        normalProperty.setLeaseValue(2000000);
        normalProperty.setArea(2);
        normalProperty.setForSale(true);
        normalProperty.setForSale(true);
        normalProperty.setNumberOfBathrooms(2);
        normalProperty.setNumberOfRooms(2);
        LinkedMultiValueMap<String, String> queriParams = new LinkedMultiValueMap();
        queriParams.add("leaseValue", "2000000.0");
        queriParams.add("numberOfRooms", "2");
        queriParams.add("area", "2.0");
        List<Property> properties= Arrays.asList(expensiveProperty,normalProperty);
        when(registerProperty.getPropertiesByLeaseValueAndNumberOfRoomsAndArea(2000000.0, 2, 2.0)).thenReturn(properties);
        this.mockMvc.perform(get("/property")
                .queryParams(queriParams))
                .andExpect(status().isOk())
                .andDo(print());
        verify(registerProperty,times(1)).getPropertiesByLeaseValueAndNumberOfRoomsAndArea(2000000.0,2,2.0);
    }

    @Test
    public void shouldNotResponseListOfPropertiesDueToLeaseValueParameterMissing() throws Exception {
        LinkedMultiValueMap<String, String> queriParams = new LinkedMultiValueMap();
        queriParams.add("numberOfRooms", "2");
        queriParams.add("area", "2.0");
        this.mockMvc.perform(get("/property")
                .queryParams(queriParams))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Required double parameter 'leaseValue' is not present"))
                .andDo(print());
    }

    @Test
    public void shouldNotResponseListOfPropertiesDueToNumberOfRoomsParameterMissing() throws Exception {
        LinkedMultiValueMap<String, String> queriParams = new LinkedMultiValueMap();
        queriParams.add("leaseValue", "2000000.0");
        queriParams.add("area", "2.0");
        this.mockMvc.perform(get("/property")
                .queryParams(queriParams))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Required int parameter 'numberOfRooms' is not present"))
                .andDo(print());
    }

    @Test
    public void shouldNotResponseListOfPropertiesDueToareaParameterMissing() throws Exception {
        LinkedMultiValueMap<String, String> queriParams = new LinkedMultiValueMap();
        queriParams.add("leaseValue", "2000000.0");
        queriParams.add("numberOfRooms", "2");
        this.mockMvc.perform(get("/property")
                .queryParams(queriParams))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Required double parameter 'area' is not present"))
                .andDo(print());
    }
}
