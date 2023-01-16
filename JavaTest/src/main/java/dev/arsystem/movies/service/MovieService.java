package dev.arsystem.movies.service;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import dev.arsystem.movies.data.MovieRepository;
import dev.arsystem.movies.entity.Genre;
import dev.arsystem.movies.entity.Movie;
import dev.arsystem.util.PredicateUtil;

public class MovieService {
	
	public MovieService(MovieRepository repository) {
		this.repository = repository;
	}
	
	public Collection<Movie> getMoviesByGenre(Genre genre) {
		return repository
				.getAll()
				.stream()
				.filter(movie -> movie.getGenre() == genre)
				.collect(Collectors.toList());
	}
	
	public Collection<Integer> getMoviesIdByGenre(Genre genre) {
		return getMoviesByGenre(genre)
				.stream()
				.map(Movie::getId)
				.collect(Collectors.toList());
	}
	
	public Collection<Movie> getMoviesByDuration(int minutes) {
		return repository.getAll()
				.stream()
				.filter(movie -> movie.getMinutes() == minutes)
				.collect(Collectors.toList());
	}
	
	public Collection<Integer> getMoviesIdByDuration(int minutes) {
		return getMoviesByDuration(minutes)
				.stream()
				.map(Movie::getId)
				.collect(Collectors.toList());
	}
	
	private Collection<Movie> findMoviesByFilter(Predicate<Movie> predicate) {
		return repository.getAll()
				.stream()
				.filter(predicate)
				.collect(Collectors.toList());
	}
	
	public Collection<Movie> findMoviesByTemplate(Movie movie) {
		if (movie.getId() != null)
			return findMoviesByFilter(mov -> mov.getId() == movie.getId());
		
		Predicate<Movie> predicate = null;
		
		if (movie.getMinutes() != null && movie.getMinutes().compareTo(0) < 0)
			throw new IllegalArgumentException("Los minutos no deben ser negativos");
		else if (movie.getMinutes() != null)
			predicate = PredicateUtil.addPredicate(predicate, mov -> mov.getMinutes().compareTo(movie.getMinutes()) < 0);
		
		if (movie.getName() != null)
			predicate = PredicateUtil.addPredicate(predicate
					, mov -> mov.getName().toUpperCase().contains(movie.getName().toUpperCase()));
		
		if (movie.getGenre() != null)
			predicate = PredicateUtil.addPredicate(predicate, mov -> mov.getGenre() == movie.getGenre());
		
		if (movie.getDirector() != null)
			predicate = PredicateUtil.addPredicate(predicate
					, mov -> mov.getDirector().toUpperCase().contains(movie.getDirector().toUpperCase()));
		
		return findMoviesByFilter(predicate);
	}
	
	public Collection<Movie> findMoviesByName(String name) {
		return findMoviesByFilter(movie -> movie.getName().toUpperCase().contains(name.toUpperCase()));
	}
	
	public Collection<Movie> findMoviesByDirector(String director) {
		return findMoviesByFilter(movie -> movie.getDirector().toUpperCase().contains(director.toUpperCase()));
	}
	
	private MovieRepository repository;
}
