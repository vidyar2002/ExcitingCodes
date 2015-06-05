package com.cms.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
public class UserControllerTest {
	
    @InjectMocks
    private UserController userController;
    
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
    
    @Test
    public void testLoadSignupPage() throws Exception {
        this.mockMvc.perform(get("/signup"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("template"))
                .andExpect(model().attributeExists("contentUrl"));
    }
    
   
}
