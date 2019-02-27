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
public class ProductionAndWorkforceProblemTests {

    @Test
    public void maximizationTest() {
        Variable one = Variable.make("one").lower(200).weight(30).integer(true).relax();
        Variable two = Variable.make("two").lower(200).weight(20).integer(true).relax();
        Variable three = Variable.make("three").lower(150).weight(50).integer(true).relax();
        ExpressionsBasedModel model = new ExpressionsBasedModel();
        Expression supplierOne = model.addExpression().upper(40000);
        Expression supplierTwo = model.addExpression().upper(6000);
        Expression workPower = model.addExpression().upper(700);
        model.addVariable(one);
        model.addVariable(two);
        model.addVariable(three);
        supplierOne.set(one, 2).set(two, 3).set(three, 5);
        supplierTwo.set(one, 4).set(two, 2).set(three, 7);
        workPower.set(one, 1).set(two, 0.5).set(three, 0.333);
        Optimisation optimisation = model.maximise();
        Assert.assertEquals("", ((Optimisation.Result) optimisation).getState(), Optimisation.State.OPTIMAL);
        Assert.assertEquals(46708, Double.valueOf(((Optimisation.Result) optimisation).getValue()).longValue());
        Assert.assertEquals(200, Double.valueOf(((Optimisation.Result) optimisation).doubleValue(0)).longValue());
        Assert.assertEquals(623, Double.valueOf(((Optimisation.Result) optimisation).doubleValue(1)).longValue());
        Assert.assertEquals(564, Double.valueOf(((Optimisation.Result) optimisation).doubleValue(2)).longValue());
    }
}
