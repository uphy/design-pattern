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
package jp.uphy.dsptn.factory.abstractfactory4.ny;

import jp.uphy.dsptn.factory.abstractfactory4.Cheese;
import jp.uphy.dsptn.factory.abstractfactory4.Clams;
import jp.uphy.dsptn.factory.abstractfactory4.Dough;
import jp.uphy.dsptn.factory.abstractfactory4.Garlic;
import jp.uphy.dsptn.factory.abstractfactory4.Mushroom;
import jp.uphy.dsptn.factory.abstractfactory4.Pepperoni;
import jp.uphy.dsptn.factory.abstractfactory4.Pizza;
import jp.uphy.dsptn.factory.abstractfactory4.Sauce;
import jp.uphy.dsptn.factory.abstractfactory4.Veggies;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;


/**
 * @author Yuhi Ishikura
 */
public class NYStylePizzaModule extends AbstractModule {

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

    bind(Pizza.class).annotatedWith(Names.named("cheese")).to(CheesePizza.class);
    bind(Pizza.class).annotatedWith(Names.named("pepperoni")).to(PepperoniPizza.class);
    bind(Pizza.class).annotatedWith(Names.named("veggie")).to(VeggiePizza.class);
    bind(Pizza.class).annotatedWith(Names.named("clam")).to(ClamPizza.class);
  }

}
