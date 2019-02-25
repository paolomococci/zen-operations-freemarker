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
public class RemoteControlBuilderProblemTests {

    @Test
    public void maximizationTest() {
        Variable remoteControlOne = Variable.make("one").lower(0).weight(3).integer(true).relax();
        Variable remoteControlTwo = Variable.make("two").lower(0).weight(8).integer(true).relax();
        ExpressionsBasedModel model = new ExpressionsBasedModel();
        Expression displayModules = model.addExpression().upper(10);
        Expression navigationModule = model.addExpression().upper(9);
        Expression miniKeypadModules = model.addExpression().upper(21);
        Expression controlLogicModules = model.addExpression().upper(18);
        Expression transmissionModules = model.addExpression().upper(12);
        Expression ledModules = model.addExpression().upper(10);
        model.addVariable(remoteControlOne);
        model.addVariable(remoteControlTwo);
        displayModules.set(remoteControlOne, 1).set(remoteControlTwo, 2);
        navigationModule.set(remoteControlOne, 1);
        miniKeypadModules.set(remoteControlOne, 2).set(remoteControlTwo, 3);
        controlLogicModules.set(remoteControlOne, 2).set(remoteControlTwo, 2);
        transmissionModules.set(remoteControlOne, 1).set(remoteControlTwo, 3);
        ledModules.set(remoteControlOne,1);
        Optimisation optimisation = model.maximise();
        Assert.assertEquals("", ((Optimisation.Result) optimisation).getState(), Optimisation.State.OPTIMAL);
        Assert.assertEquals(34, Double.valueOf(((Optimisation.Result) optimisation).getValue()).longValue());
        Assert.assertEquals(5, Double.valueOf(((Optimisation.Result) optimisation).doubleValue(0)).longValue());
        Assert.assertEquals(2, Double.valueOf(((Optimisation.Result) optimisation).doubleValue(1)).longValue());
    }
}
