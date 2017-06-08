package net.marx.serviceEndpoint;

import static graphql.Scalars.GraphQLInt;


import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import java.util.LinkedHashMap;
import java.util.Map;

import net.marx.entities.mock.WatchListMock;
import net.marx.graphql.GraphqlFetcher;
import graphql.ExecutionResult;
import graphql.GraphQL;
import net.marx.graphql.GraphSchema;
import net.marx.graphql.GraphqlObjects;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static graphql.schema.GraphQLList.list;

@RestController
@RequestMapping("/rest")
public class GraphqlService {

    @GetMapping("/test")
    @ResponseBody
    public String getStringTest() {

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

    @PostMapping("/test")
    @ResponseBody
    public Object getWatchListsMockPost(@RequestBody String query) throws Exception {

        System.out.println("Query : " + query);
        GraphQL graphQL = GraphSchema.execute();
        ExecutionResult executionResult = graphQL.execute(query);
        Map<String, Object> result = new LinkedHashMap<>();
        if (executionResult.getErrors().size() > 0) {
            result.put("errors", executionResult.getErrors());
        }

        result.put("", executionResult.getData());
        return result;
    }

}
