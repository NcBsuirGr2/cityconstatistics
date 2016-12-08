package com.citycon.mikestatistics.repositories;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CityStatisticsRepository extends AbstractRepository {
    protected String GET_MAX_ROUTERS_CITY = "select C.name, count(*) as routers from " +
            "(City C join Router R on C.ID=R.City_id) group by C.name order by routers desc limit 1;";

    protected String GET_MAX_CONNECTIONS_CITY = "select C.name, count(*) as connections from City C join " +
            "(Router R join RouterConnection Con on (R.ID=Con.ID_From or R.ID=Con.ID_To)) on " +
            "C.ID=R.City_id group by C.name order by connections desc limit 1;";

    protected String GET_CONNECTIONS_NUM = "select count(*) from RouterConnection";

    @Autowired
    public CityStatisticsRepository(JdbcOperations dao) {
        super(dao, "City");
    }

    public Map<String, Object> getMaxRouterCity() {
        return dao.queryForMap(GET_MAX_ROUTERS_CITY);
    }
    public Map<String, Object> getMaxConnectionCity() {
        return dao.queryForMap(GET_MAX_CONNECTIONS_CITY);
    }
    public float getAverageConnections() {
        int totalCities = getCount();
        float totalConnections = dao.queryForObject(GET_CONNECTIONS_NUM, Float.class);
        float avg = totalConnections/totalCities;
        return ((int)(avg*100))/100.0f;
    }
}