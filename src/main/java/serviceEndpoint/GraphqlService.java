package serviceEndpoint;

import static graphql.Scalars.GraphQLInt;


import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entities.mock.WatchListMock;
import graphql.GraphqlFetcher;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.GraphSchema;
import graphql.GraphqlObjects;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import static graphql.schema.GraphQLList.list;

@Path("/graphql")
public class GraphqlService {
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String getStringTest(){
		
        GraphQLObjectType queryType = newObject()
                .name("helloWorldQuery")
                .field(newFieldDefinition()
                        .type(GraphQLString)
                        .name("hello")
                        .staticValue("world"))
                .build();

        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();
        
        GraphQL graphQL = GraphQL.newGraphQL(schema).build();

        Map<String, Object> result = graphQL.execute("{ hello}").getData();
        
        String s = String.valueOf(result);
        
        return s;
	}
	
	
	@GET
	@Path("/oneWatchList")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> oneWatchListTest(){	
	
		// create id fetcher	
		DataFetcher<Integer> idDataFetcher = new DataFetcher<Integer>() {
	
			//@Override
			public Integer get(DataFetchingEnvironment environment) {
				// environment.getSource() is the value of the surrounding
				// object. In this case described by objectType
				//watchList = getExampleWatchList(); // Perhaps getting from a DB or whatever 
			return WatchListMock.oneWatchList().getId();
			}	
		};
	
		// create name fetcher	
		DataFetcher<String> stringDataFetcher = new DataFetcher<String>() {
	
			//@Override
			public String get(DataFetchingEnvironment environment) {
			// 	environment.getSource() is the value of the surrounding
			// 	object. In this case described by objectType
			//watchList = getExampleWatchList(); // Perhaps getting from a DB or whatever 
			return WatchListMock.oneWatchList().getName();
			}
	
		};			

		// create new object type	
		GraphQLObjectType WatchListObject = newObject()
				.name("WatchListObject")
				.description("Watch List Object")
				.field(newFieldDefinition()
						.name("id")
						.description("Id of the watchList")
						.type(GraphQLInt)
						.dataFetcher(idDataFetcher))
				.field(newFieldDefinition()
						.name("name")
						.description("Name of the watchList")
						.type(GraphQLString)
						.dataFetcher(stringDataFetcher))
				.build();		


		GraphQLFieldDefinition.Builder WatchListObj = newFieldDefinition()
				.name("wl")
				.type(WatchListObject)
				.staticValue("aaaaa");		

		// create schema	
		GraphQLSchema schema = GraphQLSchema.newSchema()
            .query(newObject()
            		.name("wlo")
            		.field(WatchListObj))
            .build();

		GraphQL graphQL = GraphQL.newGraphQL(schema).build();

		Map<String, Object> wl = graphQL.execute("{ wl {id, name}  }").getData();;
		return wl;

	}

	/**
	 * here work without DB (Mock data)
	 * @return
	 */
	@GET
	@Path("/root")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> getWatchListsMock(){

		GraphQLObjectType queryType = newObject()
				.name("queryType")
				.description("Root object contains watchlists with depends")
				.field(newFieldDefinition()
						.name("WatchLists")
						.description("list of watchLists")
						.type(list(GraphqlObjects.WatchList))
						.dataFetcher(GraphqlFetcher.WatchListsMockDF))
				.build();

		// create schema	
		GraphQLSchema schema = GraphQLSchema.newSchema()
            .query(queryType)
            .build();

		GraphQL graphQL = GraphQL.newGraphQL(schema).build();

		Map<String, Object> wl = graphQL.execute("{ WatchLists {id, name, owner_id} }").getData();
		
		return wl;				
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String testPostMethod(){
		return "post works!";
	}
	
	
	/**
	 * here work without DB (Mock data)
	 * @return
	 */
	@POST
	@Path("/root")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Object getWatchListsMockPost(Map<String, Object> query){
		
        String query1 = (String) query.get("query");
        //Map<String, Object> variables = (Map<String, Object>) body.get("variables");       


        GraphQL graphQL = GraphSchema.execute();
	//	query = "{ WatchLists {id, name} }";
        ExecutionResult executionResult = graphQL.execute(query1);
		Map<String, Object> result = new LinkedHashMap<>();
		if (executionResult.getErrors().size() > 0) {
	            result.put("errors", executionResult.getErrors());
	           // log.error("Errors: {}", executionResult.getErrors());
	        }
		
		result.put("data", executionResult.getData());
		return result;				
	}	
	
	@POST
	@Path("/test")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Object getWatchListsMockPost(String query){
		
       // String query1 = (String) query.get("query");
        //Map<String, Object> variables = (Map<String, Object>) body.get("variables");       


        GraphQL graphQL = GraphSchema.execute();
	//	query = "{ WatchLists {id, name} }";
        ExecutionResult executionResult = graphQL.execute(query);
		Map<String, Object> result = new LinkedHashMap<>();
		if (executionResult.getErrors().size() > 0) {
	            result.put("errors", executionResult.getErrors());
	           // log.error("Errors: {}", executionResult.getErrors());
	        }
		
		result.put("data", executionResult.getData());
		return result;				
	}		

}
