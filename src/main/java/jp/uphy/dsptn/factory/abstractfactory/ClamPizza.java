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
 * @author Yuhi Ishikura
 */
public class ClamPizza extends Pizza {

  private PizzaIngredientFactory ingredientFactory;

  /**
   * {@link ClamPizza}オブジェクトを構築します。
   * 
   * @param ingredientFactory
   */
  public ClamPizza(PizzaIngredientFactory ingredientFactory) {
    this.ingredientFactory = ingredientFactory;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  void prepare() {
    this.dough = ingredientFactory.createDough();
    this.sauce = ingredientFactory.createSauce();
    this.cheese = ingredientFactory.createCheese();
    this.clam = this.ingredientFactory.createClams();
  }

}
