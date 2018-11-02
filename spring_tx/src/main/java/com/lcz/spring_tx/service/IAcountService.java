package com.lcz.spring_tx.service;

import com.lcz.spring_tx.domain.Acount;

public interface IAcountService {

    /**
     *根据用户ID查找用户信息
     * @param id
     * @return
     */
    Acount findAcountById(Integer id);

    /**
     * 转账
     * @param sourceName 转账人
     * @param trageName 收款人
     * @param money  转账金额
     */
    void transfer(String sourceName,String trageName,float money);

}
