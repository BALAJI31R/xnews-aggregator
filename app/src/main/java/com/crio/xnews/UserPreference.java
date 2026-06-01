package com.crio.xnews;

public class UserPreference {

    private String name;
    private String query;
    private String language;
    private String sortBy;

    // ✅ REQUIRED by Jackson
    public UserPreference() {
    }

    // Optional: parameterized constructor
    public UserPreference(String name, String query, String language, String sortBy) {
        this.name = name;
        this.query = query;
        this.language = language;
        this.sortBy = sortBy;
    }

    // ✅ Getters
    public String getName() {
        return name;
    }

    public String getQuery() {
        return query;
    }

    public String getLanguage() {
        return language;
    }

    public String getSortBy() {
        return sortBy;
    }

    // ✅ Setters (IMPORTANT)
    public void setName(String name) {
        this.name = name;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public String toString() {
        return "UserPreference{" +
                "name='" + name + '\'' +
                ", query='" + query + '\'' +
                ", language='" + language + '\'' +
                ", sortBy='" + sortBy + '\'' +
                '}';
    }
}