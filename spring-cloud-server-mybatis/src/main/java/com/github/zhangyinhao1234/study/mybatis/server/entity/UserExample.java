package com.github.zhangyinhao1234.study.mybatis.server.entity;

import javax.persistence.Entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.github.zhangyinhao1234.study.mybatis.base.BaseEntity;

@Entity
@Table(name = "ces_tcm_bi_example")
public class UserExample extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
