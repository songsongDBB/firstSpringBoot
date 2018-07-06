package com.dss.girl.repository;

import com.dss.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JpaRepository<Girl,Integer>      Integer表示该表主键的类型
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    /**
     * 通过年龄来查询女生，注意，方法名一定要这样写
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);
}
