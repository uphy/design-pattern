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
public abstract class Pizza {

  protected String name;
  protected Dough dough;
  protected Sauce sauce;
  protected Veggies veggies[];
  protected Cheese cheese;
  protected Pepperoni pepperoni;
  protected Clams clam;

  abstract void prepare();

  void bake() {

  }

  void cut() {

  }

  void box() {

  }

  void setName(String name) {
    this.name = name;
  }

  String getName() {
    return this.name;
  }

}
