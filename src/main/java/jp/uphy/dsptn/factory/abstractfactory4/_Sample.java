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
package jp.uphy.dsptn.factory.abstractfactory4;

import java.util.Arrays;

import jp.uphy.dsptn.factory.abstractfactory4.ny.NYStylePizzaModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;


/**
 * @author Yuhi Ishikura
 */
public class _Sample {

  public static void main(String[] args) {
    final Injector injector = Guice.createInjector(new NYStylePizzaModule());
    for (String pizzaType : new String[] {"cheese", "pepperoni", "veggie", "clam"}) {
      System.out.printf("*** %s ***%n", pizzaType);
      final Pizza pizza = injector.getInstance(Key.get(Pizza.class, Names.named(pizzaType)));
      printPizza(pizza);
      System.out.println();
    }
  }

  static void printPizza(final Pizza pizza) {
    System.out.printf("Cheese\t: %s%n", pizza.cheese);
    System.out.printf("Clam\t: %s%n", pizza.clam);
    System.out.printf("Dough\t: %s%n", pizza.dough);
    System.out.printf("Pepperoni\t: %s%n", pizza.pepperoni);
    System.out.printf("Sauce\t: %s%n", pizza.sauce);
    System.out.printf("Veggies\t: %s%n", Arrays.toString(pizza.veggies));
  }

}
