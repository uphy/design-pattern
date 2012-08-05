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
 * 複数スレッドから {@link #getInstance()}を呼び出し、シングルトンであるにも関わらずオブジェクトが複数回生成されてしまう例です。
 * 
 * @author Yuhi Ishikura
 */
public class ConcurrentProblemExample {

  private static ConcurrentProblemExample INSTANCE;

  public static ConcurrentProblemExample getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ConcurrentProblemExample();
    }
    return INSTANCE;
  }

  private ConcurrentProblemExample() {
    System.out.println("Instantiated.");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    Util.getInstanceParallelly(ConcurrentProblemExample.class, 3);
  }
}
