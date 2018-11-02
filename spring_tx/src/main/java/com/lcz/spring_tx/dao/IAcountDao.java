package com.lcz.spring_tx.dao;

import com.lcz.spring_tx.domain.Acount;

public interface IAcountDao {

    /**
     * 根据用户ID查询用户信息
     * @param id 用户ID
     * @return
     */
    Acount findAcountById(Integer id);

    /**
     * 根据用户名称查看用户信息
     * @param sourceName  用户名称
     * @return
     */
    Acount findAcountByName(String sourceName);

    /**
     * 更新用户账号金额信息
     * @param acount
     */
    void updateAcount(Acount acount);
}
