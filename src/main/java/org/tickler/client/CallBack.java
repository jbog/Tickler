package client;

/**
 * Created by jasper on 21/10/18.
 */
public interface CallBack<T> {
    public void callback(CommandResult<T> result);
}
