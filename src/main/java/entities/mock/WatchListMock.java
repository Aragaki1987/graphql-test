package entities.mock;

import java.util.ArrayList;
import java.util.List;

import entities.WatchList;

public class WatchListMock {
	
	public static WatchList oneWatchList(){		
		WatchList wl = new WatchList(1, "Name of Watchlist #1", null,  2,  1);		
		return wl;
	}
	
	public static WatchList secondWatchList(){		
		WatchList wl = new WatchList(2, "Name of Watchlist #3332", null,  2,  1);		
		return wl;
	}
	
	public static List<WatchList> fewWatchList(){
		List<WatchList> wls = new ArrayList<WatchList>();
		wls.add(oneWatchList());
		wls.add(secondWatchList());
		
		return wls;
	}

}
