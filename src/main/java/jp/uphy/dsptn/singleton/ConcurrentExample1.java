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
 * staticフィールドで初期化しているため、クラスロード時に1度生成されることが保証されている例です。
 * <p>
 * コンストラクタの処理に時間がかかる場合は、クラスロードにも時間がかかってしまうことになり好ましくありません。
 * 
 * @author Yuhi Ishikura
 */
public class ConcurrentExample1 {

  private static ConcurrentExample1 ex = new ConcurrentExample1();

  public static ConcurrentExample1 getInstance() {
    return ex;
  }

  /**
   * {@link ConcurrentExample1}オブジェクトを構築します。
   */
  public ConcurrentExample1() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Instantiated.");
  }

  public static void main(String[] args) {
    Util.getInstanceParallelly(ConcurrentExample1.class, 3);
  }

}
