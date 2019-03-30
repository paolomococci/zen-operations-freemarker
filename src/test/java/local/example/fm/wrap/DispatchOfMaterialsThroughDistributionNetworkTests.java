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

@RunWith(SpringRunner.class)
@SpringBootTest
public class DispatchOfMaterialsThroughDistributionNetworkTests {

    @Test
    public void minimizationTest() {
        Variable factoryOneToFactoryTwo = Variable.make("X_f1-f2")
                .lower(0).upper(10).weight(200).integer(true).relax();
        Variable factoryOneToDispatchCentre = Variable.make("X_f1-dc")
                .lower(0).weight(400).integer(true).relax();
        Variable factoryOneToWarehouseOne = Variable.make("X_f1-w1")
                .lower(0).weight(900).integer(true).relax();
        Variable factoryTwoToDispatchCentre = Variable.make("X_f2-dc")
                .lower(0).weight(300).integer(true).relax();
        Variable dispatchCentreToWarehouseTwo = Variable.make("X_dc-w2")
                .lower(0).upper(80).weight(100).integer(true).relax();
        Variable warehouseOneToWarehouseTwo = Variable.make("X_w1-w2")
                .lower(0).weight(300).integer(true).relax();
        Variable warehouseTwoToWarehouseOne = Variable.make("X_w2-w1")
                .lower(0).weight(200).integer(true).relax();
        ExpressionsBasedModel model = new ExpressionsBasedModel();
        Expression factoryOne = model.addExpression().level(50);
        Expression factoryTwo = model.addExpression().level(40);
        Expression dispatchCentre = model.addExpression().level(0);
        Expression warehouseOne = model.addExpression().level(-30);
        Expression warehouseTwo = model.addExpression().level(-60);
        // TODO
    }
}
