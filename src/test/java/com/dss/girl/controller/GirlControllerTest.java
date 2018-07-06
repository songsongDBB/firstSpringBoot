package com.dss.girl.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc           //测试controller api必须要加的注解
public class GirlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * MockMvcRequestBuilders.get("url")表示url是以get的方式进行请求
     * @throws Exception
     */
    @Test
    public void girlList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/girlList")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}