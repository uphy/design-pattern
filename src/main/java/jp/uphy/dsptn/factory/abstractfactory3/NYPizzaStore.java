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
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;


/**
 * {@link Pizza}を生成するクラスです。
 * <p>
 * {@link jp.uphy.dsptn.factory.abstractfactory2} との比較のために残してあります。<br>
 * Guiceを用いることで、もはやこのクラスは必要なくなっています。 {@link _Sample2_FieldInjection}を参照してください。
 * 
 * @author yuhi
 */
public class NYPizzaStore extends PizzaStore {

  private Injector injector;

  /**
   * {@link NYPizzaStore}オブジェクトを構築します。
   */
  public NYPizzaStore() {
    this.injector = Guice.createInjector(new NYStylePizzaModule());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Pizza createPizza(String type) {
    final Key<Pizza> key = Key.get(Pizza.class, Names.named(type));
    return this.injector.getInstance(key);
  }

}
