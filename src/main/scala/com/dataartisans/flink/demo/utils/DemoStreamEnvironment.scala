/*
 * Copyright 2015 data Artisans GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dataartisans.flink.demo.utils

import org.apache.flink.configuration.{ConfigConstants, Configuration, WebOptions}
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

object DemoStreamEnvironment {

  def env: StreamExecutionEnvironment = {
    val config = new Configuration()
    // start the web dashboard
    config.setBoolean(ConfigConstants.LOCAL_START_WEBSERVER, true)
    // required to start the web dashboard
    config.setString(WebOptions.LOG_PATH, "./data/dummyLogFile.txt")

    // create a local stream execution environment, 2 represent parallelism, it's the core number of my machine
    StreamExecutionEnvironment.createLocalEnvironment(2, config)
  }
}
