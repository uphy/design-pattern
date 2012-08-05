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
package jp.uphy.dsptn.factory.abstractfactory3;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;


/**
 * @author Yuhi Ishikura
 */
public class _Sample2_FieldInjection {

  public static void main(String[] args) {
    final Injector injector = Guice.createInjector(new NYStylePizzaModule());

    PizzaConsumer target = injector.getInstance(PizzaConsumer.class);
    _Sample.printPizza(target.cheesePizza);
    _Sample.printPizza(target.clamPizza);
    _Sample.printPizza(target.veggiePizza);
    _Sample.printPizza(target.pepperoniPizza);
  }

  /**
   * 注入対象のクラスです。
   * 
   * @author Yuhi Ishikura
   */
  static class PizzaConsumer {

    @Inject
    @Named("cheese")
    Pizza cheesePizza;
    @Inject
    @Named("clam")
    Pizza clamPizza;
    @Inject
    @Named("veggie")
    Pizza veggiePizza;
    @Inject
    @Named("pepperoni")
    Pizza pepperoniPizza;

  }

}
