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
package jp.uphy.dsptn.factory.abstractfactory2;

import com.google.inject.Guice;
import com.google.inject.Injector;


/**
 * @author Yuhi Ishikura
 */
public class NYPizzaStore extends PizzaStore {

  private Injector injector;

  /**
   * {@link NYPizzaStore}オブジェクトを構築します。
   */
  public NYPizzaStore() {
    this.injector = Guice.createInjector(new NYStylePizzaIngredientModule());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Pizza createPizza(String type) {
    Pizza pizza = null;

    if (type.equals("cheese")) {
      pizza = this.injector.getInstance(CheesePizza.class);
    } else if (type.equals("pepperoni")) {
      pizza = this.injector.getInstance(PepperoniPizza.class);
    } else if (type.equals("veggie")) {
      pizza = this.injector.getInstance(VeggiePizza.class);
    } else if (type.equals("clam")) {
      pizza = this.injector.getInstance(ClamPizza.class);
    }
    return pizza;
  }

}
