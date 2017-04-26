package com.foo.transformations;

public class Review {
    private String text;
    private Double rating;
    
    public Review(String text, double rating) {
        super();
        this.text = text;
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public Double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Review [text=" + text + ", rating=" + rating + "]";
    }
    
}
