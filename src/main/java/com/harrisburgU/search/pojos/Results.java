package com.harrisburgU.search.pojos;

public class Results {
    private String id;
    private String icon;
    private String name;
    private Opening_hours hours;
    private String rating;
    private Photos[] photos;
    private String[] types;
    private String vicinity;
    private String place_id;
    private String scope;
    private String user_ratings_total;


    public String getId() { return id; }

    public String getIcon() { return icon; }

    public String getName() { return name; }

    public Opening_hours getHours() { return hours; }

    public String getRating() { return rating;}

    public Photos[] getPhotos() { return photos; }

    public String[] getTypes() { return types; }

    public String getVicinity() { return vicinity; }

    public String getPlace_id() { return place_id; }

    public void setId(String id) { this.id = id;}

    public void setIcon(String icon) { this.icon = icon; }

    public void setName(String name) { this.name = name; }

    public void setHours(Opening_hours hours) { this.hours = hours; }

    public void setRating(String rating) { this.rating = rating; }

    public void setPhotos(Photos[] photos) { this.photos = photos; }

    public void setTypes(String[] types) { this.types = types; }

    public void setVicinity(String vicinity) { this.vicinity = vicinity; }

    public void setPlace_id(String place_id) { this.place_id = place_id; }

    public String getScope() { return scope; }

    public String getUser_ratings_total() { return user_ratings_total; }

    public void setScope(String scope) { this.scope = scope; }

    public void setUser_ratings_total(String user_ratings_total) { this.user_ratings_total = user_ratings_total; }

    class Opening_hours{
        private String open_now;

        public String getOpen_now() { return open_now; }

        public void setOpen_now(String open_now) { this.open_now = open_now; }
    }
}
