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
 * @author Yuhi Ishikura Ishikura
 */
public class WeatherStationApp {

  public static void main(String[] args) {
    CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay();
    StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
    ForecastDisplay forecastDisplay = new ForecastDisplay();
    WeatherData data = new WeatherData(currentConditionDisplay, statisticsDisplay, forecastDisplay);

    data.setMeasurements(30, 0.7f, 1024);
  }

}
