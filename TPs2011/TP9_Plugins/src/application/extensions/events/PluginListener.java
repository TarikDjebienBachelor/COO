package application.extensions.events;

import java.util.EventListener;

public abstract interface PluginListener extends EventListener
{
  public abstract void pluginAdded(PluginEvent paramPluginEvent);

  public abstract void pluginRemoved(PluginEvent paramPluginEvent);
}