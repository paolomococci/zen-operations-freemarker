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
import org.ojalgo.optimisation.Optimisation.Result;
import org.ojalgo.optimisation.Variable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.ojalgo.optimisation.Optimisation.State.OPTIMAL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalizationStrategyOfHealthServicesProblemTests {

    @Test
    public void minimizationTest() {
        Variable [] sanitaryDistricts = {
                new Variable("district1").lower(0).weight(1).integer(true).relax(),
                new Variable("district2").lower(0).weight(1).integer(true).relax(),
                new Variable("district3").lower(0).weight(1).integer(true).relax(),
                new Variable("district4").lower(0).weight(1).integer(true).relax(),
                new Variable("district5").lower(0).weight(1).integer(true).relax(),
                new Variable("district6").lower(0).weight(1).integer(true).relax()
        };
        ExpressionsBasedModel model = new ExpressionsBasedModel();
        model.addVariables(sanitaryDistricts);
        Expression needsOfTheDistrict1 = model.addExpression().lower(1);
        Expression needsOfTheDistrict2 = model.addExpression().lower(1);
        Expression needsOfTheDistrict3 = model.addExpression().lower(1);
        Expression needsOfTheDistrict4 = model.addExpression().lower(1);
        Expression needsOfTheDistrict5 = model.addExpression().lower(1);
        Expression needsOfTheDistrict6 = model.addExpression().lower(1);
        needsOfTheDistrict1.set(0, 1).set(1, 1);
        needsOfTheDistrict2.set(0, 1).set(1, 1).set(5, 1);
        needsOfTheDistrict3.set(2, 1).set(3, 1);
        needsOfTheDistrict4.set(0, 1).set(1, 1).set(4, 1);
        needsOfTheDistrict5.set(3, 1).set(4, 1).set(5, 1);
        needsOfTheDistrict6.set(1, 1).set(4, 1).set(5, 1);
        Result result = model.minimise();
        assertEquals("", result.getState(), OPTIMAL);
        assertEquals(2, Double.valueOf(result.getValue()).longValue());
        assertEquals(0, Double.valueOf(result.doubleValue(0)).longValue());
        assertEquals(1, Double.valueOf(result.doubleValue(1)).longValue());
        assertEquals(0, Double.valueOf(result.doubleValue(2)).longValue());
        assertEquals(1, Double.valueOf(result.doubleValue(3)).longValue());
        assertEquals(0, Double.valueOf(result.doubleValue(4)).longValue());
        assertEquals(0, Double.valueOf(result.doubleValue(5)).longValue());
    }
}
