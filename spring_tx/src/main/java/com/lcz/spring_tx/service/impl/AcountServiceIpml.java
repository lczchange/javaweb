package com.lcz.spring_tx.service.impl;

import com.lcz.spring_tx.dao.IAcountDao;
import com.lcz.spring_tx.domain.Acount;
import com.lcz.spring_tx.service.IAcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("acountService")
@Transactional(readOnly = false,propagation = Propagation.REQUIRED)
public class AcountServiceIpml implements IAcountService {

    @Autowired
    private IAcountDao acountDao;

    /*public void setAcountDao(IAcountDao acountDao) {
        this.acountDao = acountDao;
    }*/

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Acount findAcountById(Integer id) {
        Acount acount = acountDao.findAcountById(id);
        return acount;
    }

    @Override
    public void transfer(String sourceName, String trageName, float money) {
        //根据用户名称查找用户信息
        Acount sourceAcount = acountDao.findAcountByName(sourceName);
        Acount trageAcount = acountDao.findAcountByName(trageName);

        //修改两个用户的金额信息
        sourceAcount.setMoney(sourceAcount.getMoney() - money);
        trageAcount.setMoney(trageAcount.getMoney() + money);
//         int i = 1/0;
        //更新用户信息
        acountDao.updateAcount(sourceAcount);
        acountDao.updateAcount(trageAcount);

    }
}
