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
package jp.uphy.dsptn.singleton;

/**
 * オブジェクトの生成箇所を、自分自身のクラスオブジェクト(唯一)なものでロックする例です。<br>
 * 毎回ロックすることはコストが高いため二重に(一回目はコストは低いが不確実な確認、二回目はコストが高く確実な確認)確認しています。
 * <p>
 * volatileを外した確認をやってみたが私の環境ではどちらも正しく動作した。
 * 
 * @author Yuhi Ishikura
 */
public class ConcurrentExample2 {

  private static volatile ConcurrentExample2 ex;

  public static ConcurrentExample2 getInstance() {
    if (ex == null) {
      synchronized (ConcurrentExample2.class) {
        if (ex == null) {
          ex = new ConcurrentExample2();
        }
      }
    }
    return ex;
  }

  /**
   * {@link ConcurrentExample2}オブジェクトを構築します。
   */
  public ConcurrentExample2() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Instantiated.");
  }

  public static void main(String[] args) {
    Util.getInstanceParallelly(ConcurrentExample2.class, 30);
  }

}
