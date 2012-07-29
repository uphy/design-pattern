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
package jp.uphy.dsptn.factory.simple;

/**
 * @author yuhi
 */
public class PizzaStore {

  private SimplePizzaFactory factory;

  /**
   * {@link PizzaStore}オブジェクトを構築します。
   * 
   * @param factory
   */
  public PizzaStore(SimplePizzaFactory factory) {
    this.factory = factory;
  }
  
  public Pizza orderPizza(String type){
    Pizza pizza;
    
    pizza = factory.createPizza(type);
    
    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();
    
    return pizza;
  }

}