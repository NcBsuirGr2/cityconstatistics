package com.citycon.mikestatistics.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserStatisticsRepository extends AbstractRepository {
    private String USER_BY_GROUPS = "SELECT U.group, COUNT(*) as count FROM " +
                "(`User` U INNER JOIN `Grant` G ON U.group=G.idGrant) GROUP BY U.group;";

    @Autowired
    public UserStatisticsRepository(JdbcOperations dao) {
        super(dao, "User");
    }

    public List<Map<String, Object>> getUsersByGroups() {
        List<Map<String, Object>> groups = dao.queryForList(USER_BY_GROUPS);
        Logger logger = LoggerFactory.getLogger("com.citycon.mikestatistics.springconfig");
        logger.debug("Admins in system {}", groups.get(0));
        return groups;
    }
}
