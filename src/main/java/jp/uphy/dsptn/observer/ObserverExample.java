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
package jp.uphy.dsptn.observer;

/**
 * @author Yuhi Ishikura Ishikura
 */
public class ObserverExample {

  public static void main(String[] args) {
    ConcreteSubject subject = new ConcreteSubject();
    Observer observer = new ConcreteObserver();

    subject.addObserver(observer);
    System.out.println("--- An observer was registered ---");
    subject.setState(10);
    subject.setState(100);

    subject.removeObserver(observer);
    System.out.println("--- An observer was unregistered ---");
    subject.setState(1000);
  }

}
