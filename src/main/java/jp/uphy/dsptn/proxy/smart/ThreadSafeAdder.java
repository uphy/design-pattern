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
package jp.uphy.dsptn.proxy.smart;

/**
 * @author yuhi
 */
public class ThreadSafeAdder implements Adder {

  private Adder adder;

  /**
   * {@link ThreadSafeAdder}オブジェクトを構築します。
   * 
   * @param adder
   */
  public ThreadSafeAdder(Adder adder) {
    this.adder = adder;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public synchronized void add(int num) {
    this.adder.add(num);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getSum() {
    return this.adder.getSum();
  }

}
