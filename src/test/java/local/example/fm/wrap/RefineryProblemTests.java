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
import static org.ojalgo.optimisation.Optimisation.State.OPTIMAL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RefineryProblemTests {

    @Test
    public void maximizationWithoutAdvertisingTest() {
        Variable [] x = {
                new Variable("x11").lower(0).weight(21),
                new Variable("x12").lower(0).weight(11),
                new Variable("x13").lower(0).weight(1),
                new Variable("x21").lower(0).weight(31),
                new Variable("x22").lower(0).weight(21),
                new Variable("x23").lower(0).weight(11),
                new Variable("x31").lower(0).weight(41),
                new Variable("x32").lower(0).weight(31),
                new Variable("x33").lower(0).weight(21)
        };
        ExpressionsBasedModel model = new ExpressionsBasedModel();
        model.addVariables(x);
        Expression c1 = model.addExpression().level(3000);
        Expression c2 = model.addExpression().level(2000);
        Expression c3 = model.addExpression().level(1000);
        Expression c4 = model.addExpression().upper(5000);
        Expression c5 = model.addExpression().upper(5000);
        Expression c6 = model.addExpression().upper(5000);
        Expression c7 = model.addExpression().upper(14000);
        Expression c8 = model.addExpression().lower(0);
        Expression c9 = model.addExpression().lower(0);
        Expression c10 = model.addExpression().lower(0);
        Expression c11 = model.addExpression().upper(0);
        Expression c12 = model.addExpression().upper(0);
        Expression c13 = model.addExpression().upper(0);
        c1.set(0,1).set(1,1).set(2,1);
        c2.set(3,1).set(4,1).set(5,1);
        c3.set(6,1).set(7,1).set(8,1);
        c4.set(0,1).set(3,1).set(6,1);
        c5.set(1,1).set(4,1).set(7,1);
        c6.set(2,1).set(5,1).set(8,1);
        c7.set(0,1).set(1,1).set(2,1).set(3,1).set(4,1).set(5,1).set(6,1).set(7,1).set(8,1);
        c8.set(0,2).set(1,-4).set(2,-2);
        c9.set(3,4).set(4,-2);
        c10.set(6,6).set(8,2);
        c11.set(0,-0.005).set(1,0.01).set(2,0.02);
        c12.set(3,-0.015).set(5,0.01);
        c13.set(6,-0.005).set(7,0.01).set(8,0.02);
        Result result = model.maximise();
        assertEquals("", result.getState(), OPTIMAL);
        assertEquals(156000.0, result.getValue(), 0.01);
        assertEquals(3000.0, result.doubleValue(0), 0.01);
        assertEquals(0.0, result.doubleValue(1), 0.01);
        assertEquals(0.0, result.doubleValue(2), 0.01);
        assertEquals(1000.0, result.doubleValue(3), 0.01);
        assertEquals(1000.0, result.doubleValue(4), 0.01);
        assertEquals(0.0, result.doubleValue(5), 0.01);
        assertEquals(1000.0, result.doubleValue(6), 0.01);
        assertEquals(0.0, result.doubleValue(7), 0.01);
        assertEquals(0.0, result.doubleValue(8), 0.01);
    }
}
