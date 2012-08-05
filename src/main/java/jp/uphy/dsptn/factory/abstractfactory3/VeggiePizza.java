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

import com.google.inject.Inject;


/**
 * @author Yuhi Ishikura
 */
public class VeggiePizza extends Pizza {

  /**
   * {@link VeggiePizza}オブジェクトを構築します。
   */
  @Inject
  VeggiePizza(Veggies[] veggies) {
    this.veggies = veggies;
  }

}
