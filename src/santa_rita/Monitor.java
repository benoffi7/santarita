package santa_rita;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class Monitor implements Runnable
{
    private Thread hilo;
    private WatchService wService;
    private WatchKey key;
    Path directoryPath = Paths.get("C:/Users/Maica/workspace/SANTA_RITA");

    public Monitor() throws Exception
    {
	wService = FileSystems.getDefault().newWatchService();
	directoryPath.register(wService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
		StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.OVERFLOW);
    }

    public void processEvents() throws Exception
    {
	while (true)
	{
	    System.out.println("Waiting...");
	    key = wService.take();
	    if (key.isValid())
	    {
		List<WatchEvent<?>> events = key.pollEvents();
		for (WatchEvent<?> event : events)
		{
		    /*
		     * In the case of ENTRY_CREATE, ENTRY_DELETE, and
		     * ENTRY_MODIFY events the context is a relative
		     */
		    Path path = (Path) event.context();
		    Kind<?> kindOfEvent = event.kind();
		    System.out.println(
			    String.format("Event '%s' detected in file/direcotry '%s'", kindOfEvent.name(), path));
		}
	    }
	    /* once an key has been processed, */
	    boolean valid = key.reset();
	    System.out.println(String.format("Return value from key.reset() : %s", valid));
	}
    }

    @Override
    public void run()
    {
	if (!Files.exists(directoryPath))
	{
	    System.out.println(String.format("The directory %s must be a real directory !", directoryPath.toString()));
	}
	try
	{
	    Monitor wDirectory = new Monitor();
	    wDirectory.processEvents();
	} catch (Exception e)
	{
	    System.out.println("Error en el monitoreo...");
	}
    }

    public void start()
    {
	System.out.println("Iniciando monitoreo...");
	if (hilo == null)
	{
	    hilo = new Thread(this);
	    hilo.start();
	}
    }
}
