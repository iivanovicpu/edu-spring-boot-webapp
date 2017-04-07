package hr.edupsy.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdaptiveRuleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Find all customers, thanks Java 8, you can create a custom RowMapper like this :
    public List<AdaptiveRule> findAll() {

        List<AdaptiveRule> result = jdbcTemplate.query(
                "SELECT id, learningstyleid, intelligencetypeid, ruleid,ruledata, mark FROM adaptive_rules",
                (rs, rowNum) -> new AdaptiveRule(rs.getInt("id"),
                        rs.getInt("learningstyleid"), rs.getInt("intelligencetypeid"), rs.getInt("ruleid"), rs.getString("ruledata"), rs.getString("mark"), "", "", ""));
        for (AdaptiveRule adaptiveRule : result) {
            System.out.println(adaptiveRule);
        }
        return result;

    }

    // Add new customer
    public void addCustomer(String name, String email) {

        jdbcTemplate.update("INSERT INTO customer(name, email, created_date) VALUES (?,?,?)",
                name, email, new Date());

    }


}