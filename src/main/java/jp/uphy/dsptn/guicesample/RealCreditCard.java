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
package jp.uphy.dsptn.guicesample;

/**
 * @author Yuhi Ishikura
 */
public class RealCreditCard implements CreditCard {

  double left = 1000;

  /**
   * {@inheritDoc}
   */
  @Override
  public void pay(long money) throws Exception {
    if (this.left < money) {
      throw new Exception();
    }

    this.left -= money;
    System.out.println("残金:" + this.left); //$NON-NLS-1$
  }

}
