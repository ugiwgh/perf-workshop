package com.epickrram.workshop.perf;

//////////////////////////////////////////////////////////////////////////////////
//   Copyright 2015   Mark Price     mark at epickrram.com                      //
//                                                                              //
//   Licensed under the Apache License, Version 2.0 (the "License");            //
//   you may not use this file except in compliance with the License.           //
//   You may obtain a copy of the License at                                    //
//                                                                              //
//       http://www.apache.org/licenses/LICENSE-2.0                             //
//                                                                              //
//   Unless required by applicable law or agreed to in writing, software        //
//   distributed under the License is distributed on an "AS IS" BASIS,          //
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   //
//   See the License for the specific language governing permissions and        //
//   limitations under the License.                                             //
//////////////////////////////////////////////////////////////////////////////////


import com.beust.jcommander.JCommander;
import com.epickrram.workshop.perf.app.AppMain;
import com.epickrram.workshop.perf.config.CommandLineArgs;
import com.epickrram.workshop.perf.reporting.PostProcess;
import com.epickrram.workshop.perf.setup.InputGenerator;

public final class UberMain
{
    public static void main(final String[] args) throws Exception
    {
        final CommandLineArgs commandLineArgs = new CommandLineArgs();
        final JCommander jCommander = new JCommander(commandLineArgs);
        jCommander.parse(args);
        if(commandLineArgs.isHelp())
        {
            jCommander.usage();
            System.exit(0);
        }

        InputGenerator.main(args);
        AppMain.main(args);
        PostProcess.main(args);
    }
}