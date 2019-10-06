package com.harrisburgU.search.pojos;

public class SearchPlacesResponse {
    private Results[] results;
    private String[] html_attributions;


    public Results[] getResults() { return results; }

    public String[] getHtml_attributions() { return html_attributions; }

    public void setResults(Results[] results) { this.results = results; }

    public void setHtml_attributions(String[] html_attributions) { this.html_attributions = html_attributions; }
}
