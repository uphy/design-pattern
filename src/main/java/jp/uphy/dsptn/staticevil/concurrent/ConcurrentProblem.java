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
package jp.uphy.dsptn.staticevil.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author Yuhi Ishikura
 */
public class ConcurrentProblem {

  static void computeFactorialNoLock(int n) {
    long res = 1;
    for (int i = n; i >= 1; i--) {
      res *= i;
      MessagePool.append(String.valueOf(i));
      if (i > 1) {
        MessagePool.append("*");
      }
    }
    MessagePool.append("=");
    MessagePool.append(String.valueOf(res));
    System.out.println(MessagePool.get());
    MessagePool.clear();
  }

  static void computeFactorialWithLock(int n) {
    long res = 1;
    synchronized (MessagePool.class) {
      for (int i = n; i >= 1; i--) {
        res *= i;
        MessagePool.append(String.valueOf(i));
        if (i > 1) {
          MessagePool.append("*");
        }
      }
      MessagePool.append("=");
      MessagePool.append(String.valueOf(res));
      System.out.println(MessagePool.get());
      MessagePool.clear();
    }
  }

  static class ComputeFactorialTask implements Runnable {

    private int n;

    ComputeFactorialTask(int n) {
      this.n = n;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
      computeFactorialNoLock(n);
    }

  }

  public static void main(String[] args) {
    System.out.println("直列で実行(問題無し)");
    for (int i = 0; i < 10; i++) {
      computeFactorialNoLock(i);
    }

    System.out.println("並列で実行(問題有り)");
    final ExecutorService executor = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 100; i++) {
      executor.execute(new ComputeFactorialTask((int)(Math.random() * 10 + 1)));
    }
    executor.shutdown();
  }
}
