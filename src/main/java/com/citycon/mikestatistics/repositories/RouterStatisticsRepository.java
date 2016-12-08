package com.citycon.mikestatistics.repositories;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RouterStatisticsRepository extends AbstractRepository {
    protected String GET_MAX_CONNECTIONS_ROUTER = "select R.Name, count(*) as connections from " +
            "Router R join RouterConnection Con on (R.ID=Con.ID_From or R.ID=Con.ID_To) " +
            "group by R.Name order by connections desc limit 1;";

    protected String GET_INACTIVE_ROUTERS_NUM = "select count(*) from Router where In_Service=0";
    protected String GET_CONNECTIONS_NUM = "select count(*) from RouterConnection";

    @Autowired
    public RouterStatisticsRepository(JdbcOperations dao) {
        super(dao, "Router");
    }

    public Map<String, Object> getMaxConnectionRouter() {
        return dao.queryForMap(GET_MAX_CONNECTIONS_ROUTER);
    }
    public Integer getInactiveRoutersNum() {
        return dao.queryForObject(GET_INACTIVE_ROUTERS_NUM, Integer.class);
    }
    public float getAverageConnections() {
        int totalRouters = getCount();
        float totalConnections = dao.queryForObject(GET_CONNECTIONS_NUM, Float.class);
        float avg = totalConnections/totalRouters;
        LoggerFactory.getLogger("com.citycon.mikestatistics.repositories").debug("avg routers: {}->{}", avg, ((int)(avg*100))/100.0f);
        return ((int)(avg*100))/100.0f;
    }
}
