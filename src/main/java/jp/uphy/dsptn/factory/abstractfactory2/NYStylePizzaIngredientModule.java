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

import com.google.inject.AbstractModule;


/**
 * @author yuhi
 */
public class NYStylePizzaIngredientModule extends AbstractModule {

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure() {
    bind(Sauce.class).to(MarinaraSauce.class);
    bind(Dough.class).to(ThinCrustDough.class);
    bind(Cheese.class).to(ReggianoCheese.class);
    bind(Veggies[].class).toInstance(new Veggies[] {new Garlic(), new Mushroom(), new RedPepper()});
    bind(Pepperoni.class).to(SlicedPepperoni.class);
    bind(Clams.class).to(FreshClams.class);
  }
}
