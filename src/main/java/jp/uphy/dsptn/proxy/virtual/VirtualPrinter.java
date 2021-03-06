/**
 * Copyright (C) 2013 uphy.jp
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
package jp.uphy.dsptn.proxy.virtual;

/**
 * @author yuhi
 */
public class VirtualPrinter implements Printer {

  private String nameCache;
  private Printer realPrinter;

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {
    if (this.nameCache != null) {
      return this.nameCache;
    }
    this.nameCache = getPrinter().getName();
    return this.nameCache;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void print(String message) {
    getPrinter().print(message);
  }

  private Printer getPrinter() {
    if (this.realPrinter == null) {
      this.realPrinter = new RealPrinter();
    }
    return this.realPrinter;
  }

}
