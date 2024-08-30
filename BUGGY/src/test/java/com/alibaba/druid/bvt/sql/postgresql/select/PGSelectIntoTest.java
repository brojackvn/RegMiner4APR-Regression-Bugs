/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
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
package com.alibaba.druid.bvt.sql.postgresql.select;

import java.util.List;

import org.junit.Assert;

import com.alibaba.druid.sql.PGTest;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.postgresql.parser.PGSQLStatementParser;
import com.alibaba.druid.sql.dialect.postgresql.visitor.PGSchemaStatVisitor;
import com.alibaba.druid.stat.TableStat;
import com.alibaba.druid.stat.TableStat.Column;

public class PGSelectIntoTest extends PGTest {
	public void test_0() throws Exception {
		String sql = "SELECT * INTO films_recent FROM films WHERE date_prod >= '2002-01-01';";
		
        PGSQLStatementParser parser = new PGSQLStatementParser(sql);
        List<SQLStatement> statementList = parser.parseStatementList();
        SQLStatement stmt = statementList.get(0);
//        print(statementList);

        Assert.assertEquals(1, statementList.size());

        PGSchemaStatVisitor visitor = new PGSchemaStatVisitor();
        stmt.accept(visitor);
        
//        System.out.println("Tables : " + visitor.getTables());
//        System.out.println("fields : " + visitor.getColumns());
//        System.out.println("coditions : " + visitor.getConditions());
        
        Assert.assertTrue(visitor.getTables().containsKey(new TableStat.Name("films_recent")));
        Assert.assertTrue(visitor.getTables().containsKey(new TableStat.Name("films")));
        
        Assert.assertTrue(visitor.getColumns().contains(new Column("films", "*")));
        Assert.assertTrue(visitor.getColumns().contains(new Column("films", "date_prod")));
        
        String result = SQLUtils.toPGString(stmt);
        Assert.assertEquals(result,"SELECT *" //
                + "\nINTO films_recent" //
                + "\nFROM films" //
                + "\nWHERE date_prod >= '2002-01-01';");
        
        String result_lcase = SQLUtils.toPGString(stmt, SQLUtils.DEFAULT_LCASE_FORMAT_OPTION);
        Assert.assertEquals(result_lcase,"select *" //
                + "\ninto films_recent" //
                + "\nfrom films" //
                + "\nwhere date_prod >= '2002-01-01';");
	}
}
