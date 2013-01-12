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
 * @author Yuhi Ishikura
 */
public class RealPrinter implements Printer {

  /**
   * {@link RealPrinter}オブジェクトを構築します。
   */
  public RealPrinter() {
    System.out.println("Initializing...");
    accessToDevice(5000);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void print(String message) {
    System.out.println("RealPrinter.print()");
    accessToDevice(3000);
    System.out.println(message);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {
    System.out.println("RealPrinter.getName()");
    accessToDevice(3000);
    return "RealPrinter";
  }

  private void accessToDevice(long time) {
    try {
      System.out.println("Accessing to the device...");
      Thread.sleep(time);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
