/*
 * Copyright 1999-2017 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.bvt.proxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;

import junit.framework.TestCase;

import org.junit.Assert;

import com.alibaba.druid.proxy.DruidDriver;
import com.alibaba.druid.stat.JdbcStatManager;
import com.alibaba.druid.util.JdbcUtils;

public class StatementTest extends TestCase {

    private static String create_url = "jdbc:wrap-jdbc:filters=default,commonLogging,log4j:name=statementTest:jdbc:derby:memory:statementTest;create=true";

    protected void setUp() throws Exception {
        Class.forName("com.alibaba.druid.proxy.DruidDriver");

        Connection conn = DriverManager.getConnection(create_url);

        createTable();

        conn.close();
    }

    private void createTable() throws SQLException {
        Connection conn = DriverManager.getConnection(create_url);
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE T_PRE_STMT_TEST (ID INTEGER GENERATED BY DEFAULT AS IDENTITY, NAME VARCHAR(50), BIRTHDATE TIMESTAMP)");
        stmt.close();
        conn.close();
    }

    private void dropTable() throws SQLException {
        Connection conn = DriverManager.getConnection(create_url);
        Statement stmt = conn.createStatement();
        stmt.execute("DROP TABLE T_PRE_STMT_TEST");
        stmt.close();
        conn.close();
    }

    protected void tearDown() throws Exception {
        dropTable();
        DruidDriver.getProxyDataSources().clear();
        Assert.assertEquals(0, JdbcStatManager.getInstance().getSqlList().size());
    }

    public void test_stmt() throws Exception {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(create_url);

            stmt = conn.createStatement();
            stmt.execute("INSERT INTO T_PRE_STMT_TEST (ID, NAME, BIRTHDATE) VALUES (1, 'A', NULL)");
            stmt.execute("INSERT INTO T_PRE_STMT_TEST (ID, NAME, BIRTHDATE) VALUES (11, 'A1', NULL)",
                         Statement.NO_GENERATED_KEYS);
            stmt.execute("INSERT INTO T_PRE_STMT_TEST (ID, NAME, BIRTHDATE) VALUES (12, 'A2', NULL)", new int[] { 1 });
            stmt.execute("INSERT INTO T_PRE_STMT_TEST (ID, NAME, BIRTHDATE) VALUES (12, 'A3', NULL)",
                         new String[] { "ID" });
            stmt.executeUpdate("INSERT INTO T_PRE_STMT_TEST (ID, NAME, BIRTHDATE) VALUES (2, 'B', NULL)");
            stmt.executeUpdate("INSERT INTO T_PRE_STMT_TEST (ID, NAME, BIRTHDATE) VALUES (3, 'C', NULL)",
                               Statement.NO_GENERATED_KEYS);
            stmt.executeUpdate("INSERT INTO T_PRE_STMT_TEST (ID, NAME, BIRTHDATE) VALUES (4, 'D', NULL)",
                               new int[] { 1 });
            stmt.executeUpdate("INSERT INTO T_PRE_STMT_TEST (ID, NAME, BIRTHDATE) VALUES (5, 'E', NULL)",
                               new String[] { "ID" });
            try {
                stmt.cancel();
            } catch (SQLFeatureNotSupportedException ex) {
            }

            stmt.execute("SELECT * FROM T_PRE_STMT_TEST");
            Assert.assertFalse(stmt.getMoreResults(Statement.CLOSE_CURRENT_RESULT));
        } finally {
            JdbcUtils.close(rs);
            JdbcUtils.close(stmt);
            JdbcUtils.close(conn);
        }
    }
}
