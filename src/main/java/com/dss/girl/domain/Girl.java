package com.dss.girl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Girl {

    @Id             //主键
    @GeneratedValue        //自增
    private Integer id;

    private String cupSize;

    /**
     * 表单验证，最小值是18
     */
    @Min(value = 18, message = "未成年少女禁止入内")
    private Integer age;

    @NotNull(message = "金额不能为空")
    private Float amount;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", amount=" + amount +
                '}';
    }
}
