package graphql;

import static graphql.Scalars.GraphQLInt;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import graphql.schema.GraphQLObjectType;

public class GraphqlObjects {
	
	public static GraphQLObjectType WatchList = newObject()
			.name("WatchList")
			.description("Watch List Object - row of the table WatchList")
			.field(newFieldDefinition()
					.name("id")
					.description("fiend Id of the watchList")
					.type(GraphQLInt))
			.field(newFieldDefinition()
					.name("name")
					.description("field Name of the watchList")
					.type(GraphQLString))
			.field(newFieldDefinition()
					.name("list")
					.description("field list of the watchList")
					.type(GraphQLString))
			.field(newFieldDefinition()
					.name("owner_id")
					.description("Field owner_id of the watchList")
					.type(GraphQLString))
			.field(newFieldDefinition()
					.name("company_id")
					.description("Field company_id of the watchList")
					.type(GraphQLString))	
			.build();		
	

}
