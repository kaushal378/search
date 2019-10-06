package com.harrisburgU.search.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harrisburgU.search.httpBuilder.SearchQueryBuilder;
import com.harrisburgU.search.pojos.SearchPlacesRequest;
import com.harrisburgU.search.pojos.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@ComponentScan
public class SearchPlacesService {
    private static final String LOG_TAG = "ExampleApp";

    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    private static final String TYPE_SEARCH = "/search";

    private static final String OUT_JSON = "/json";

    @Value("${ga.key}")
    private String API_KEY;
    @Value("${ga.url}")
    private String url;

    @Autowired
    SearchQueryBuilder queryBuilder;

    private final String USER_AGENT = "Mozilla/5.0";

    public String searchPlaces(SearchPlacesRequest request) throws Exception{
        HttpURLConnection conn = null;
        StringBuilder jsonResults = new StringBuilder();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode input = objectMapper.readTree(this.getClass().getResourceAsStream("/searchPlacesInput.json"));
        SearchPlacesRequest pojo = objectMapper.convertValue(input, SearchPlacesRequest.class);

        pojo = populateInputFromRequest(request, pojo);

        String inputJson = queryBuilder.buildSearchUrl(pojo);

        URL url = new URL(inputJson);
        conn = (HttpURLConnection) url.openConnection();
        InputStreamReader in = new InputStreamReader(conn.getInputStream());

        int read;
        char[] buff = new char[1024];
        while ((read = in.read(buff)) != -1) {
            jsonResults.append(buff, 0, read);
        }

        return jsonResults.toString();
    }

    private SearchPlacesRequest populateInputFromRequest(SearchPlacesRequest request, SearchPlacesRequest pojo){
        if(StringUtils.isNotEmpty(request.getFields())){
            pojo.setFields(request.getFields());
        }

        if(StringUtils.isNotEmpty(request.getInput())){
            pojo.setInput(request.getInput());
        }

        if(StringUtils.isNotEmpty(request.getInputtype())){
            pojo.setInputtype(request.getInputtype());
        }

        if(StringUtils.isNotEmpty(request.getLocation())){
            pojo.setLocation(request.getLocation());
        }

        if(StringUtils.isNotEmpty(request.getLocationbias())){
            pojo.setLocationbias(request.getLocationbias());
        }

        if(StringUtils.isNotEmpty(request.getRadius())){
            pojo.setRadius(request.getRadius());
        }

        if(StringUtils.isNotEmpty(request.getType())){
            pojo.setType(request.getType());
        }

        if(StringUtils.isNotEmpty(request.getAddress())){
            pojo.setAddress(request.getAddress());
        }

        return pojo;
    }
}
