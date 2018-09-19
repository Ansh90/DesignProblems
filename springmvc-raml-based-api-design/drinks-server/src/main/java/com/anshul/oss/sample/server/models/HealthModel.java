/**
 * The MIT License
 * Copyright (c) 2018 Anshul Mohil
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.anshul.oss.sample.server.models;

import com.anshul.oss.sample.server.models.enums.HealthStatusEnum;
import org.joda.time.DateTime;

/**
 * Simple representation of a server's health status
 * to assert successfulness of server's
 * boot-up
 */
public class HealthModel {

  private DateTime timeStamp;

  private HealthStatusEnum healthStatus;

  public HealthModel() {

  }

  public HealthModel(HealthStatusEnum healthStatus) {
    super();
    this.timeStamp = new DateTime();
    this.healthStatus = healthStatus;
  }


  public DateTime getTimeStamp() {
    return timeStamp;
  }


  public void setTimeStamp(DateTime timeStamp) {
    this.timeStamp = timeStamp;
  }


  public HealthStatusEnum getHealthStatus() {
    return healthStatus;
  }


  public void setHealthStatus(HealthStatusEnum healthStatus) {
    this.healthStatus = healthStatus;
  }


}
