package net.marx.graphql;

import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLList.list;
import static graphql.schema.GraphQLObjectType.newObject;

import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

public class GraphSchema {

	public static GraphQL execute() throws Exception{
		
		GraphQLObjectType queryType = newObject()
			.name("queryType")
			.description("Root object contains watchlists with depends")
			.field(newFieldDefinition()
					.name("WatchLists")
					.description("list of watchLists")
					.type(GraphqlObjects.WatchList)
					.dataFetcher(GraphqlFetcher.singleWatchListMockDF))
			.build();

	// create schema	
	GraphQLSchema schema = GraphQLSchema.newSchema()
        .query(queryType)
        .build();

	GraphQL graphQL = GraphQL.newGraphQL(schema).build();
	return graphQL;
	}
}
