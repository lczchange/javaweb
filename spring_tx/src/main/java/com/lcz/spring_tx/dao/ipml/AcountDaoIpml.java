package com.lcz.spring_tx.dao.ipml;

import com.lcz.spring_tx.dao.IAcountDao;
import com.lcz.spring_tx.domain.Acount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("acountDao")
public class AcountDaoIpml  implements IAcountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Acount findAcountById(Integer id) {
        List<Acount> acountList = jdbcTemplate.query("select * from account where id =? ", new AcountRowMapper(), id);
        return acountList.isEmpty() ? null : acountList.get(0);
    }

    @Override
    public Acount findAcountByName(String sourceName) {
        List<Acount> acountList = jdbcTemplate.query("select * from account where name=?", new AcountRowMapper(), sourceName);
        if (acountList == null) {
            return null;
        }
        if (acountList.size() > 1) {
            throw new RuntimeException("结果集不唯一，不是只有一个账户，将无法进行转账操作");
        }
        return acountList.get(0);
    }

    @Override
    public void updateAcount(Acount acount) {
        jdbcTemplate.update("update account set money = ? where id =?", acount.getMoney(), acount.getId());
    }

    class AcountRowMapper implements RowMapper<Acount> {

        @Override
        public Acount mapRow(ResultSet resultSet, int i) throws SQLException {
            Acount acount = new Acount();
            acount.setId(resultSet.getInt("id"));
            acount.setName(resultSet.getString("name"));
            acount.setMoney(resultSet.getFloat("money"));
            return acount;
        }
    }
}
