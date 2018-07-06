package com.dss.girl.service;

import com.dss.girl.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void testFindOneById(){
        Girl girl = girlService.findOneById(13);
        Assert.assertEquals(new Integer(18), girl.getAge());
    }
}
