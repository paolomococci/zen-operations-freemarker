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

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import org.ojalgo.optimisation.Variable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DietProblemTests {

    private final Variable variableBread = Variable.make("variableBread")
            .lower(0.0).upper(10.0).weight(0.05);
    private final Variable variableCorn = Variable.make("variableCorn")
            .lower(0.0).upper(10.0).weight(0.18);
    private final Variable variableMilk = Variable.make("variableMilk")
            .lower(0.0).upper(10.0).weight(0.23);

    private final ExpressionsBasedModel expressionsBasedModel = new ExpressionsBasedModel();

    private final Expression expressionVitaminA = expressionsBasedModel.addExpression("expressionVitaminA")
            .lower(5000.0).upper(50000.0);
    private final Expression expressionCalories = expressionsBasedModel.addExpression("expressionCalories")
            .lower(2000.0).upper(2250.0);

    private Optimisation optimisation;

    @Test
    public void scalarConstraintsTest() {
        expressionsBasedModel.addVariable(variableBread);
        expressionsBasedModel.addVariable(variableCorn);
        expressionsBasedModel.addVariable(variableMilk);
        expressionVitaminA.set(variableBread, 0.0).set(variableCorn, 107.0).set(variableMilk, 500.0);
        expressionCalories.set(variableBread, 65.0).set(variableCorn, 72.0).set(variableMilk, 121.0);
        optimisation = expressionsBasedModel.minimise();
        Assert.assertEquals("", ((Optimisation.Result) optimisation).getState(), Optimisation.State.OPTIMAL);
        Assert.assertEquals(3.149, ((Optimisation.Result) optimisation).getValue(), 0.001);
        Assert.assertEquals(10.0, ((Optimisation.Result) optimisation).doubleValue(0), 0.001);
        Assert.assertEquals(1.944, ((Optimisation.Result) optimisation).doubleValue(1), 0.001);
        Assert.assertEquals(10.0, ((Optimisation.Result) optimisation).doubleValue(2), 0.0);
    }

    @Test
    public void integerConstraintsTest() {
        variableBread.integer(true);
        variableCorn.integer(true);
        variableMilk.integer(true);
        expressionsBasedModel.addVariable(variableBread);
        expressionsBasedModel.addVariable(variableCorn);
        expressionsBasedModel.addVariable(variableMilk);
        expressionVitaminA.set(variableBread, 0.0).set(variableCorn, 107.0).set(variableMilk, 500.0);
        expressionCalories.set(variableBread, 65.0).set(variableCorn, 72.0).set(variableMilk, 121.0);
        optimisation = expressionsBasedModel.minimise();
        Assert.assertEquals("", ((Optimisation.Result) optimisation).getState(), Optimisation.State.OPTIMAL);
        Assert.assertEquals(3.16, ((Optimisation.Result) optimisation).getValue(), 0.0);
        Assert.assertEquals(10.0, ((Optimisation.Result) optimisation).doubleValue(0), 0.0);
        Assert.assertEquals(2.0, ((Optimisation.Result) optimisation).doubleValue(1), 0.0);
        Assert.assertEquals(10.0, ((Optimisation.Result) optimisation).doubleValue(2), 0.0);
    }
}
