/**
 * Copyright (C) 2012 Koga Laboratory (mklab.org)
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
package jp.uphy.dsptn.factory.abstractfactory2;

import java.util.Arrays;


/**
 * @author yuhi
 */
public class _Sample {

  public static void main(String[] args) {
    final PizzaStore pizzaStore = new NYPizzaStore();
    for (String pizzaType : new String[] {"cheese", "pepperoni", "veggie", "clam"}) {
      System.out.printf("*** %s ***%n", pizzaType);
      printPizza(pizzaStore.createPizza(pizzaType));
      System.out.println();
    }
  }

  private static void printPizza(final Pizza pizza) {
    System.out.printf("Cheese\t: %s%n", pizza.cheese);
    System.out.printf("Clam\t: %s%n", pizza.clam);
    System.out.printf("Dough\t: %s%n", pizza.dough);
    System.out.printf("Pepperoni\t: %s%n", pizza.pepperoni);
    System.out.printf("Sauce\t: %s%n", pizza.sauce);
    System.out.printf("Veggies\t: %s%n", Arrays.toString(pizza.veggies));
  }

}
