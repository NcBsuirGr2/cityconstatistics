package com.citycon.mikestatistics.repositories;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

public abstract class AbstractRepository {
    protected JdbcOperations dao;
    protected String table;

    public AbstractRepository(JdbcOperations dao, String table) {
        this.dao = dao;
        this.table = table;
    }

    public int getCount() {
        int totalNum = dao.queryForObject("SELECT COUNT(*) FROM "+table, Integer.class);
        return totalNum;
    }
}
