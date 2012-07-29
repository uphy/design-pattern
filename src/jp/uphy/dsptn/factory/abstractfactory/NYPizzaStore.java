/**
 * Copyright (C) 2012 uphy.jp
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.uphy.dsptn.factory.abstractfactory;

/**
 * @author yuhi
 */
public class NYPizzaStore extends PizzaStore {

  /**
   * {@inheritDoc}
   */
  @Override
  protected Pizza createPizza(String type) {
    Pizza pizza = null;
    PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

    if (type.equals("cheese")) {
      pizza = new CheesePizza(ingredientFactory);
    } else if (type.equals("pepperoni")) {
      pizza = new PepperoniPizza(ingredientFactory);
    } else if (type.equals("veggie")) {
      pizza = new VeggiePizza(ingredientFactory);
    } else if (type.equals("clam")) {
      pizza = new ClamPizza(ingredientFactory);
    }
    return pizza;
  }

}
