package application.extensions;

public abstract interface Extension
{
  public abstract String transformer(String paramString);

  public abstract String toString();
}