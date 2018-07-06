package com.dss.girl.service;

import com.dss.girl.Exception.GirlException;
import com.dss.girl.domain.Girl;
import com.dss.girl.enums.ResultEnum;
import com.dss.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 一次性插入两个女生
     */
    @Transactional
    public void insertTwoGirl(){

        Girl girlA = new Girl();
        girlA.setCupSize("B");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("FFFF");
        girlB.setAge(16);
        girlRepository.save(girlB);
    }

    public void getAgeById(Integer id) throws GirlException{

        Girl girl = girlRepository.findById(id).get();

        Integer age = girl.getAge();

        System.out.println("age=====" + age);

        if(age < 10){
            //返回：你还在上小学, 返回code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            //返回：你在上初中，返回code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过id查找一个女生
     * @param id
     * @return
     */
    public Girl findOneById(Integer id){
        return girlRepository.findById(id).get();
    }
}
