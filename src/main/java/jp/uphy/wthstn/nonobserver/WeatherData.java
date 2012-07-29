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
package jp.uphy.wthstn.nonobserver;

/**
 * @author Yuhi Ishikura
 */
public class WeatherData {

  private float temperature;
  private float humidity;
  private float pressure;
  private CurrentConditionDisplay currentConditionDisplay;
  private StatisticsDisplay statisticsDisplay;
  private ForecastDisplay forecastDisplay;

  /**
   * {@link WeatherData}オブジェクトを構築します。
   * 
   * @param currentConditionDisplay
   * @param statisticsDisplay
   * @param forecastDisplay
   */
  public WeatherData(CurrentConditionDisplay currentConditionDisplay, StatisticsDisplay statisticsDisplay, ForecastDisplay forecastDisplay) {
    this.currentConditionDisplay = currentConditionDisplay;
    this.statisticsDisplay = statisticsDisplay;
    this.forecastDisplay = forecastDisplay;
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
    this.currentConditionDisplay.display(this.temperature, this.humidity, this.pressure);
    this.statisticsDisplay.display(this.temperature, this.humidity, this.pressure);
    this.forecastDisplay.display(this.temperature, this.humidity, this.pressure);
  }

}
