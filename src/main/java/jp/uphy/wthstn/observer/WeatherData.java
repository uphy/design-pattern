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
package jp.uphy.wthstn.observer;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Yuhi Ishikura Ishikura
 */
public class WeatherData implements Subject {

  private List<Observer> observers;
  private float temperature;
  private float humidity;
  private float pressure;

  /**
   * {@link WeatherData}オブジェクトを構築します。
   */
  public WeatherData() {
    this.observers = new ArrayList<Observer>();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void addObserver(Observer observer) {
    if (this.observers.contains(observer)) throw new IllegalArgumentException("already registered!");
    this.observers.add(observer);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void removeObserver(Observer observer) {
    if (this.observers.contains(observer) == false) throw new IllegalArgumentException("not registered!");
    this.observers.remove(observer);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void notifyObservers() {
    for (final Observer observer : this.observers) {
      observer.update(this.temperature, this.humidity, this.pressure);
    }
  }

  /**
   * 気象情報を設定します。
   * 
   * @param temperature 気温
   * @param humidity 湿度
   * @param pressure 気圧
   */
  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }

  /**
   * 気象情報が変更されたときに呼び出されます。
   */
  public void measurementsChanged() {
    notifyObservers();
  }

}
