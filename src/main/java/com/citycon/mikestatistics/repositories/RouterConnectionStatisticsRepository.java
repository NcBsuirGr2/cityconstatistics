package com.citycon.mikestatistics.repositories;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RouterConnectionStatisticsRepository extends AbstractRepository {
    protected String GET_INACTIVE_CONNECTIONS_NUM = "select count(*) from Router R join RouterConnection C on " +
            "(R.ID=C.ID_To or R.ID=C.ID_From) where R.In_Service=0;";

    @Autowired
    public RouterConnectionStatisticsRepository(JdbcOperations dao) {
        super(dao, "RouterConnection");
    }

    public Integer getInactiveConnectionsNum() {
        return dao.queryForObject(GET_INACTIVE_CONNECTIONS_NUM, Integer.class);
    }
}
