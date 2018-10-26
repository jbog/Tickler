import org.apache.commons.cli.Options;
import client.CallBack;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jasper on 12/10/18.
 */
public class CommandLine implements Callback<String> {
    private Options commandlineOptions;

    public final static Map<TickleOption, String> optionMapping = new HashMap<TickleOption, String>();

    static {
            optionMapping.put(TickleOption.help, "h");
            optionMapping.put(TickleOption.version, "v");
            optionMapping.put(TickleOption.operation, "o");
    };

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine();
    }

    public CommandLine() {
        this.commandlineOptions = new Options();

    }

    public Options getCommandlineOptions() {
        return this.commandlineOptions;
    }

    private CommandLine setOptions(Options options) {
        this.commandlineOptions = options;
        return this;
    }



}
