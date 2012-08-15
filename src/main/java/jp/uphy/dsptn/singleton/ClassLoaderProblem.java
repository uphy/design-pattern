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
package jp.uphy.dsptn.singleton;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


/**
 * 複数のクラスローダでシングルトンのクラスを読み込んだ時にインスタンスが二回生成されてしまう現象の確認。
 * <p>
 * 参照しているライブラリ{@code "singleton-sample.jar"}は、{@code jp.uphy.dsptn.singleton.MySingleton}クラスを含んでいる。<br>
 * このクラスは、シングルトンパターンを純粋に実装し、static初期化子内で、{@code Instance created.}を標準出力に出力するものである。<br>
 * 正しく動作していればその出力は一回しか行われないが、別のクラスローダで読み込んでいるため同名ではあるが完全に別のクラスとなってしまい、インスタンス生成が複数回行われてしまう。
 * 
 * @author Yuhi Ishikura
 */
public class ClassLoaderProblem {

  static URL[] SAMPLE_JAR_URL;

  static {
    try {
      SAMPLE_JAR_URL = new URL[] {new File("singleton-sample/singleton-sample.jar").toURI().toURL()};
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    Class<?> c1 = loadWithNewClassLoader();
    Class<?> c2 = loadWithNewClassLoader();

    callGetInstance(c1);
    callGetInstance(c2);
  }

  /**
   * singleton-sample.jarに含まれるMySingletonクラスを新しいクラスローダで読み込み返します。
   * 
   * @return 新しいクラスローダで読み込んだsingleton-sample.jarに含まれるMySingletonクラス
   */
  private static Class<?> loadWithNewClassLoader() {
    try (URLClassLoader classLoader = new URLClassLoader(SAMPLE_JAR_URL)) {
      return Class.forName("jp.uphy.dsptn.singleton.MySingleton", true, classLoader);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e1) {
      throw new RuntimeException(e1);
    }
  }

  /**
   * 与えられたクラスのstaticメソッドgetInstance()を呼び出します。
   * 
   * @param c クラスオブジェクト
   */
  private static void callGetInstance(Class<?> c) {
    try {
      c.getMethod("getInstance").invoke(null);
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
      throw new RuntimeException(e);
    }
  }

}
