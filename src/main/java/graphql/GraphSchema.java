package graphql;

import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLList.list;
import static graphql.schema.GraphQLObjectType.newObject;

import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

public class GraphSchema {

	public static GraphQL execute(){
		
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
	return graphQL;
	}
}
