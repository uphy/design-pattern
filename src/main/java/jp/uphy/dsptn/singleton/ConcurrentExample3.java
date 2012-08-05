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
 * {@link ConcurrentExample1}、フィールドで初期化してしまう方法で、なおかつlazy initiationを実現した方法です。
 * <p>
 * シングルトンクラスである、 {@link ConcurrentExample3}
 * のクラスロード時には、そのフィールドの初期化は行いますが、インナークラスまではロードされません。 すなわち、 {@link #getInstance()}
 * を実行し、 {@link InstanceHolder}クラスを参照したときに初めて、そのフィールドであるINSTANCEが生成されます。<br>
 * また、クラスは一度しかロードされないことがVMによって保証されている(はず)なので、複数回生成されることもありません。
 */
public class ConcurrentExample3 {

  private static class InstanceHolder {

    private static final ConcurrentExample3 INSTANCE = new ConcurrentExample3();

  }

  public static ConcurrentExample3 getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * {@link ConcurrentExample3}オブジェクトを構築します。
   */
  public ConcurrentExample3() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Instantiated.");
  }

  public static void main(String[] args) {
    Util.getInstanceParallelly(ConcurrentExample3.class, 30);
  }

}
