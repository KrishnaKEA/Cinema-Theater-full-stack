package kodak.cinemaapp.configuration;

import java.util.List;

public class MovieApiDTO {
List<MovieDetails> results;
int page;

    public List<MovieDetails> getResults() {
        return results;
    }

    public void setResults(List<MovieDetails> results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieDetails> getMovieDetails() {
        return results;
    }

    public void setMovieDetails(List<MovieDetails> movieDetails) {
        this.results = movieDetails;
    }}


