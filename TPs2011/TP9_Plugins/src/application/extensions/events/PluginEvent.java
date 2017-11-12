package application.extensions.events;

import java.util.EventObject;

import application.extensions.Extension;



public class PluginEvent extends EventObject
{
  
  private final Extension extension;

  public PluginEvent(Object source, Extension extension)
  {
    super(source);
    this.extension = extension;
  }

  public Extension getExtension()
  {
    return this.extension;
  }
}
