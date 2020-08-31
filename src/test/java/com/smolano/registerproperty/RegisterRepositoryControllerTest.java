package com.smolano.registerproperty;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smolano.registerproperty.entities.Property;
import com.smolano.registerproperty.model.PropertyDTO;
import com.smolano.registerproperty.resource.IRegisterPropertyController;
import com.smolano.registerproperty.service.IRegisterProperty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(IRegisterPropertyController.class)
public class RegisterRepositoryControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IRegisterProperty registerProperty;
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
        List<Property> propertyList = new ArrayList<>();
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
//        given(registerProperty.getPropertiesByLeaseValueAndNumberOfRoomsAndArea(2000000, 2, 2)).willReturn(propertyList);
        LinkedMultiValueMap<String, String> queriParams = new LinkedMultiValueMap();
        queriParams.add("leaseValue", "2000000.0");
        queriParams.add("numberOfRooms", "2");
        queriParams.add("area", "2.0");
        this.mockMvc.perform(get("/property")
                .queryParams(queriParams))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
