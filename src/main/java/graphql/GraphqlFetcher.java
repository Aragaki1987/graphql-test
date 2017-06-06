package graphql;

import java.util.List;

import entities.WatchList;
import entities.mock.WatchListMock;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

public class GraphqlFetcher {

	/**
	 * single watchList data fetcher	
	 */
	public static DataFetcher<WatchList> singleWatchListMockDF = new DataFetcher<WatchList>() {

		//@Override
		public WatchList get(DataFetchingEnvironment environment) {
			// environment.getSource() is the value of the surrounding
			// object. In this case described by objectType
		//List<WatchList> result = [];	
	    //watchList = getExampleWatchList(); // Perhaps getting from a DB or whatever 
		WatchList result = WatchListMock.oneWatchList();	
		return result;
		}	
	};
	
	/**
	 * list of watchList data fetcher	
	 */
	public static DataFetcher<List<WatchList>> WatchListsMockDF = new DataFetcher<List<WatchList>>() {

		//@Override
		public List<WatchList> get(DataFetchingEnvironment environment) {
			// environment.getSource() is the value of the surrounding
			// object. In this case described by objectType
		//List<WatchList> result = [];	
	    //watchList = getExampleWatchList(); // Perhaps getting from a DB or whatever 
		List<WatchList> result = WatchListMock.fewWatchList();	
		return result;
		}	
	};
	
	
	// create id fetcher	
	static DataFetcher<Integer> idDataFetcher = new DataFetcher<Integer>() {

		//@Override
		public Integer get(DataFetchingEnvironment environment) {
			// environment.getSource() is the value of the surrounding
			// object. In this case described by objectType
			//watchList = getExampleWatchList(); // Perhaps getting from a DB or whatever 
		return WatchListMock.oneWatchList().getId();
		}	

	};

	// create name fetcher	
	static DataFetcher<String> stringDataFetcher = new DataFetcher<String>() {

		//@Override
		public String get(DataFetchingEnvironment environment) {
		// 	environment.getSource() is the value of the surrounding
		// 	object. In this case described by objectType
		//watchList = getExampleWatchList(); // Perhaps getting from a DB or whatever 
		return WatchListMock.oneWatchList().getName();
		}	
	};			
}
