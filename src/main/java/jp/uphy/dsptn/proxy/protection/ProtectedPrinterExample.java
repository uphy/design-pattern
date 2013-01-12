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
package jp.uphy.dsptn.proxy.protection;

import jp.uphy.dsptn.proxy.virtual.RealPrinter;


/**
 * @author yuhi
 */
public class ProtectedPrinterExample {

  public static void main(String[] args) {
    final ProtectedPrinter printer = new ProtectedPrinter(new RealPrinter());
    System.out.println("プリンタ名:" + printer.getName());
    printer.print("Hello.");
  }

}
