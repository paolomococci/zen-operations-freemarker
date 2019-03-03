/**
 *
 * Copyright 2019 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.fm.wrap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Variable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.ojalgo.optimisation.Optimisation.Result;
import static org.ojalgo.optimisation.Optimisation.State;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffTurnoverProblemTests {

    @Test
    public void minimizationOfMorningStaffTest() {
        Variable [] weak = {
                new Variable("monday").lower(0).weight(1).integer(true).relax(),
                new Variable("tuesday").lower(0).weight(1).integer(true).relax(),
                new Variable("wednesday").lower(0).weight(1).integer(true).relax(),
                new Variable("thursday").lower(0).weight(1).integer(true).relax(),
                new Variable("friday").lower(0).weight(1).integer(true).relax(),
                new Variable("saturday").lower(0).weight(1).integer(true).relax(),
                new Variable("sunday").lower(0).weight(1).integer(true).relax()
        };
        ExpressionsBasedModel model = new ExpressionsBasedModel();
        Expression mon = model.addExpression().lower(17);
        Expression tue = model.addExpression().lower(13);
        Expression wed = model.addExpression().lower(15);
        Expression thu = model.addExpression().lower(19);
        Expression fri = model.addExpression().lower(14);
        Expression sat = model.addExpression().lower(16);
        Expression sun = model.addExpression().lower(11);
        model.addVariables(weak);
        mon.set(0, 1).set(3, 1).set(4, 1).set(5, 1).set(6, 1);
        tue.set(0, 1).set(1, 1).set(4, 1).set(5, 1).set(6, 1);
        wed.set(0, 1).set(1, 1).set(2, 1).set(5, 1).set(6, 1);
        thu.set(0, 1).set(1, 1).set(2, 1).set(3, 1).set(6, 1);
        fri.set(0, 1).set(1, 1).set(2, 1).set(3, 1).set(4, 1);
        sat.set(1, 1).set(2, 1).set(3, 1).set(4, 1).set(5, 1);
        sun.set(2, 1).set(3, 1).set(4, 1).set(5, 1).set(6, 1);
        Result result = model.minimise();
        assertEquals("", result.getState(), State.OPTIMAL);
        assertEquals(22, Double.valueOf(result.getValue()).longValue());
        assertEquals(1, Double.valueOf(result.doubleValue(0)).longValue());
        assertEquals(3, Double.valueOf(result.doubleValue(1)).longValue());
        assertEquals(2, Double.valueOf(result.doubleValue(2)).longValue());
        assertEquals(7, Double.valueOf(result.doubleValue(3)).longValue());
        assertEquals(0, Double.valueOf(result.doubleValue(4)).longValue());
        assertEquals(3, Double.valueOf(result.doubleValue(5)).longValue());
        assertEquals(5, Double.valueOf(result.doubleValue(6)).longValue());
    }
}
