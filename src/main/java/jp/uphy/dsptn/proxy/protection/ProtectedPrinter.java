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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.uphy.dsptn.proxy.virtual.Printer;


/**
 * @author yuhi
 */
public class ProtectedPrinter implements Printer {

  private Printer printer;

  /**
   * {@link ProtectedPrinter}オブジェクトを構築します。
   * 
   * @param printer
   */
  public ProtectedPrinter(Printer printer) {
    super();
    this.printer = printer;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {
    if (confirm("プリンタ名の取得を要求されています。許可しますか？")) {
      return this.printer.getName();
    }
    return "";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void print(String message) {
    if (confirm("印刷を要求されています。許可しますか？")) {
      this.printer.print(message);
    }
  }

  private boolean confirm(String message) {
    System.out.print(message + "(Y/N)>");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
      String answer = br.readLine().trim().toLowerCase();
      if (answer.equals("y")) {
        return true;
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return false;
  }

}
