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
package com.amertkara.multiplerunners.subcommands.analyzer;

import org.apache.commons.cli.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Analyzes a given file
 *
 * @author Mert Kara (github.com/amertkara)
 * @since 0.1.0
 */
@Component
public class AnalyzerCommand implements CommandLineRunner {

    private Options options;
    private CommandLineParser parser;
    private CommandLine cmd;
    private HelpFormatter formatter;

    /**
     * Initiates the sub-command
     */
    @PostConstruct
    public void init () {
        options = new Options();
        parser = new DefaultParser();
        formatter = new HelpFormatter();

        final Option fileOption = Option.builder("f")
                .argName("file")
                .hasArg()
                .desc("File to be analyzed")
                .build();

        options.addOption(fileOption);
    }

    @Override
    public void run(String... args) throws Exception {
        if ("analyze".equals(args[0])) {
            try {
                cmd = parser.parse(options, args);
                cmd = parser.parse(options, args);
            } catch (UnrecognizedOptionException | MissingArgumentException  e) {
                formatter.printHelp("sample", options);
                System.exit(1);
            }

            if (cmd.hasOption("f") && !cmd.getOptionValue("f").isEmpty()) {
                System.out.println("AnalyzerCommand is running on the file: " + cmd.getOptionValue("f"));
                // Call the analyzer core
            }
        }
    }
}
