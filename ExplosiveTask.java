package me.nickrung.slimegrenades;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.scheduler.BukkitRunnable;

class ExplosiveTask extends BukkitRunnable

private Item ball;
	  
	public ExplosiveTask(Item ball) {

		this.ball = ball;
	}
  
	public void run() {

		Location loc = this.ball.getLocation();    
		loc.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 1.5F, false, true);
	}
}
