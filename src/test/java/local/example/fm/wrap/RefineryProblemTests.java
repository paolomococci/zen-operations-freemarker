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
        /*
        Xij: matrix of decision variables,
        associates the quantities of barrels of crude oils purchased
        to the quantities of diesel fuel barrels produced
         */
        Variable [] objectiveFunction = {
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
        model.addVariables(objectiveFunction);
        Expression applicationConstraintOfDieselFuelTypeOne = model.addExpression().level(3000);
        Expression applicationConstraintOfDieselFuelTypeTwo = model.addExpression().level(2000);
        Expression applicationConstraintOfDieselFuelTypeThree = model.addExpression().level(1000);
        Expression applicationConstraintOfCrudeOilTypeOne = model.addExpression().upper(5000);
        Expression applicationConstraintOfCrudeOilTypeTwo = model.addExpression().upper(5000);
        Expression applicationConstraintOfCrudeOilTypeThree = model.addExpression().upper(5000);
        Expression applicationConstraintProductionOfTheRefinery = model.addExpression().upper(14000);
        Expression applicationConstraintOfQualityOnTheMinimumNumberOfOctane1 = model.addExpression().lower(0);
        Expression applicationConstraintOfQualityOnTheMinimumNumberOfOctane2 = model.addExpression().lower(0);
        Expression applicationConstraintOfQualityOnTheMinimumNumberOfOctane3 = model.addExpression().lower(0);
        Expression applicationConstraintOfMaximumSulfurContentInCrudeOilType1 = model.addExpression().upper(0);
        Expression applicationConstraintOfMaximumSulfurContentInCrudeOilType2 = model.addExpression().upper(0);
        Expression applicationConstraintOfMaximumSulfurContentInCrudeOilType3 = model.addExpression().upper(0);
        applicationConstraintOfDieselFuelTypeOne.set(0,1).set(1,1).set(2,1);
        applicationConstraintOfDieselFuelTypeTwo.set(3,1).set(4,1).set(5,1);
        applicationConstraintOfDieselFuelTypeThree.set(6,1).set(7,1).set(8,1);
        applicationConstraintOfCrudeOilTypeOne.set(0,1).set(3,1).set(6,1);
        applicationConstraintOfCrudeOilTypeTwo.set(1,1).set(4,1).set(7,1);
        applicationConstraintOfCrudeOilTypeThree.set(2,1).set(5,1).set(8,1);
        applicationConstraintProductionOfTheRefinery.set(0,1).set(1,1).set(2,1).set(3,1).set(4,1).set(5,1).set(6,1).set(7,1).set(8,1);
        applicationConstraintOfQualityOnTheMinimumNumberOfOctane1.set(0,2).set(1,-4).set(2,-2);
        applicationConstraintOfQualityOnTheMinimumNumberOfOctane2.set(3,4).set(4,-2);
        applicationConstraintOfQualityOnTheMinimumNumberOfOctane3.set(6,6).set(8,2);
        applicationConstraintOfMaximumSulfurContentInCrudeOilType1.set(0,-0.005).set(1,0.01).set(2,0.02);
        applicationConstraintOfMaximumSulfurContentInCrudeOilType2.set(3,-0.015).set(5,0.01);
        applicationConstraintOfMaximumSulfurContentInCrudeOilType3.set(6,-0.005).set(7,0.01).set(8,0.02);
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
