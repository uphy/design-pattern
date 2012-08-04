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
package jp.uphy.dsptn.factory.abstractfactory3;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;


/**
 * @author yuhi
 */
public class _Sample2_MethodInjection {

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
   * @author yuhi
   */
  static class PizzaConsumer {

    Pizza cheesePizza;

    Pizza clamPizza;

    Pizza veggiePizza;

    Pizza pepperoniPizza;

    /**
     * cheesePizzaを設定します。
     * 
     * @param cheesePizza cheesePizza
     */
    @Inject
    void setCheesePizza(@Named("cheese") Pizza cheesePizza) {
      this.cheesePizza = cheesePizza;
    }

    /**
     * clamPizzaを設定します。
     * 
     * @param clamPizza clamPizza
     */
    @Inject
    void setClamPizza(@Named("clam") Pizza clamPizza) {
      this.clamPizza = clamPizza;
    }

    /**
     * veggiePizzaを設定します。
     * 
     * @param veggiePizza veggiePizza
     */
    @Inject
    void setVeggiePizza(@Named("veggie") Pizza veggiePizza) {
      this.veggiePizza = veggiePizza;
    }

    /**
     * pepperoniPizzaを設定します。
     * 
     * @param pepperoniPizza pepperoniPizza
     */
    @Inject
    void setPepperoniPizza(@Named("pepperoni") Pizza pepperoniPizza) {
      this.pepperoniPizza = pepperoniPizza;
    }

  }

}
