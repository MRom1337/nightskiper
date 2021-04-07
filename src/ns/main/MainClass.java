package ns.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin{
    public boolean TS;
	int Task;
    long Time;
    long Time2;
	public void onEnable() {
		TS = false;
		getLogger().info("Plugin ready to work");
		Bukkit.getPluginManager().registerEvents(new Handler(this), this);
		Task = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
            Time = Bukkit.getServer().getWorld("world").getTime(); 
            int PlayersOnline = Bukkit.getOnlinePlayers().size();
            int Half = PlayersOnline/2;
            if(Handler.NowSleep >= Half && PlayersOnline > 1) {
				if(TS == false) {
             	Time2 = Time + 80;
             	TS = true;
				}
            	if(Time > Time2) {
            	Bukkit.getServer().getWorld("world").setTime(0);
            	TS = false;
            	Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "Good morning world!");
            }
            }
            }
        }, 0, 10);
	}
}
