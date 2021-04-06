package ns.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;



public class Handler implements Listener {
	private MainClass plugin;
	public static int NowSleep;
	long Time;
	long Time2;
	public int PlayersOnline;
	public static float Half;
	public Handler(MainClass plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void PlayerIsSleeping(PlayerBedEnterEvent e) {
		PlayersOnline = Bukkit.getOnlinePlayers().size();
		Time = Bukkit.getServer().getWorld("world").getTime(); 

		if(Time >= 12544 && Time <= 23460) {
			NowSleep = NowSleep + 1;
			Player p = e.getPlayer();
			Half = PlayersOnline/2;
			if(PlayersOnline != 1) {
			Bukkit.getServer().broadcastMessage("["+ NowSleep + "/" + (int)Half + "] " + p.getName() + ChatColor.YELLOW + " now sleeping");
			}else {
			Bukkit.getServer().broadcastMessage("["+ PlayersOnline + "/" + "1" + "] " + p.getName() + ChatColor.YELLOW + " now sleeping");
			}
		}
			
	}
	@EventHandler
	public void onPlayerBedEnter(PlayerBedLeaveEvent e) {
	    NowSleep = NowSleep - 1;
	}

}
