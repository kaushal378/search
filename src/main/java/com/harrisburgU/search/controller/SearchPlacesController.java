package com.harrisburgU.search.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harrisburgU.search.pojos.SearchPlacesRequest;
import com.harrisburgU.search.service.SearchPlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchPlacesController {

    @Autowired
    SearchPlacesService searchService;

    @Autowired
    SearchPlacesRequest jsonInput;
    String fileName;


    @RequestMapping("/search")
    @ResponseBody
    public String search(SearchPlacesRequest request){
        String out = "";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode output = objectMapper.readTree(this.getClass().getResourceAsStream("/searchPlacesOutput.json"));
            return output.toString();
            //out  = searchService.searchPlaces(request);
        }catch(Exception e){
            e.printStackTrace();
        }
        return out;
    }
}
