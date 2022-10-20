package com.xiong.service;

import com.xiong.mapper.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, timeout = 5, rollbackFor = {NullPointerException.class, ArithmeticException.class})
public class PersonService {
    @Autowired
    private PersonDao personDao;

    /**
     * 最朴素的版本, 实现了功能, 但是不是事务, 可能存在各种故障问题
     *
     * @param from  转账人
     * @param to    收款人
     * @param money 转账金额
     */
    public void changeV1(String from, String to, int money) {
        personDao.add(to, money);
//        假设二个基本操作之间发生异常, 则数据库处于不一致状态
        System.out.println(1 / 0);
        personDao.reduce(from, money);
    }


    public void changeV2(String from, String to, int money) {
//        捕获异常
        personDao.add(to, money);
//        假设二个基本操作之间发生异常, 则数据库处于不一致状态
//        System.out.println(1 / 0);
        personDao.reduce(from, money);
    }
}
