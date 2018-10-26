package org.tickler;

import org.apache.commons.cli.*;
import org.tickler.client.CallBack;
import org.tickler.client.CommandResult;
import org.tickler.client.commands.CommandLineCommand;
import org.tickler.client.commands.HelpCommand;
import org.tickler.client.commands.OrientationCommand;
import org.tickler.client.commands.VersionCommand;

import java.util.*;

/**
 * Created by jasper on 12/10/18.
 */
public class CommandLine implements CallBack<String> {
    private Options commandLineOptions;
    private CommandLineParser commandLineParser;

    final static Map<OptionGroup, CommandLineCommand<String>> optionMapping = new HashMap<OptionGroup, CommandLineCommand<String>>();
    static {
        Option helpOption = new Option("h", "help", false, "display this help and exit");
        OptionGroup helpOptionGroup = new OptionGroup();
        helpOptionGroup.addOption(helpOption);
        Option versionOption = new Option("v", "version", false, "output version information and exit");
        OptionGroup versionOptionGroup = new OptionGroup();
        versionOptionGroup.addOption(versionOption);
        OptionGroup orientationOption = new OptionGroup();
        Option serverOption = new Option("s", "server", false, "attempt execution as server");
        Option clientOption = new Option("c", "client", false, "attempt execution as client");
        orientationOption.addOption(serverOption);
        orientationOption.addOption(clientOption);
        orientationOption.setRequired(true);


        optionMapping.put(helpOptionGroup, new HelpCommand());
        optionMapping.put(versionOptionGroup, new VersionCommand());
        optionMapping.put(orientationOption, new OrientationCommand());
    };

    {
        Runnable r = () -> System.out.println("HI");
        new Thread(r).start();
    }

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine();
        commandLine.process(args);
    }


    public CommandLine() {
        this.setOptions(new Options());
        for (OptionGroup next: optionMapping.keySet()) {
            this.commandLineOptions.addOptionGroup(next);
        }
        this.commandLineParser = new DefaultParser();
    }

    public Options getCommandLineOptions() {
        return this.commandLineOptions;
    }

    public void process(String[] args) {
        try {
            org.apache.commons.cli.CommandLine cmd = commandLineParser.parse(commandLineOptions, args);
            for (Option next: this.commandLineOptions.getOptions()) {
                if (cmd.hasOption(next.getOpt())) {
                    OptionGroup parent = this.commandLineOptions.getOptionGroup(next);
                    if (parent == null) {
                        assert (false); // Should not happen - this means that there is an option that was not put into an option group.
                    }
                    if (!optionMapping.containsKey(parent)) {
                        assert (false); // Again, should not happen - this means that there is an option group not added to the mapping in the appropriate way
                    }
                    Optional<Collection<String>> arguments = Optional.empty();
                    if (cmd.getOptionValues(next.getOpt()).length != 0) {
                        arguments = Optional.of(Arrays.asList(cmd.getOptionValues(next.getOpt())));
                    }
                    optionMapping.get(parent).run(this, arguments);
                }
            }
        } catch (ParseException e) {
            new HelpCommand().run(this, Optional.empty());
        }
    }

    private CommandLine setOptions(Options options) {
        this.commandLineOptions = options;
        return this;
    }


    @Override
    public void callback(Optional<CommandResult<String>> result) {
        // LATER this should be fed to an outputstream, that can output it in various ways (e.g., log file as well as normal sysout, other listeners, ...)
        result.ifPresent(o -> o.stream().forEach(System.out::println));
    }
}
