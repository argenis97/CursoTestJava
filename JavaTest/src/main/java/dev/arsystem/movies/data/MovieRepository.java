package dev.arsystem.movies.data;

import java.util.Collection;

import dev.arsystem.movies.entity.Movie;

public interface MovieRepository {
	
	public Movie findById(int id);
	public Collection<Movie> getAll();
	public void saveOrUpdate(Movie movie);
}
