/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amertkara.multiplerunners;

import org.apache.commons.cli.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * What is this class for?
 *
 * @author Mert Kara (github.com/amertkara)
 * @since 0.1.0
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        if (args.length == 0) {
            Options options = new Options();
            CommandLineParser parser = new DefaultParser();
            HelpFormatter formatter = new HelpFormatter();

            Option parserOpt = Option.builder("parse").desc("Parser").build();
            Option analyzerOpt = Option.builder("analyze").desc("Analyzer").build();

            options.addOption(analyzerOpt);
            options.addOption(parserOpt);

            formatter.printHelp("sample", options);
        } else {
            SpringApplication.run(Application.class, args);
        }
    }
}
