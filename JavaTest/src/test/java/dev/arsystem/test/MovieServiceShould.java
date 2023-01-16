package dev.arsystem.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import dev.arsystem.movies.data.MovieRepository;
import dev.arsystem.movies.entity.Genre;
import dev.arsystem.movies.entity.Movie;
import dev.arsystem.movies.service.MovieService;

public class MovieServiceShould {
	
	@Before
	public void setUp() throws Exception {
		MovieRepository repository = Mockito.mock(MovieRepository.class);
		
		Mockito.when(repository.getAll())
			.thenReturn(Arrays.asList(
				new Movie(1, Genre.ACTION, "Avengers", 120, "Joss Whedon")
				, new Movie(2, Genre.HORROR, "Scream", 135, "Director 1")
				, new Movie(3, Genre.THRILLER, "Memento", 136, "Director 2")
				, new Movie(4, Genre.COMEDY, "There's Someting About Mary", 110, "Josh 2")
				, new Movie(5, Genre.HORROR, "Last Night", 156, "Horror Director")
				, new Movie(6, Genre.ACTION, "Matrix", 136, "John Wick :)")
				, new Movie(7, Genre.ACTION, "Matrix Recargado", 136, "John Wick :)")
				, new Movie(8, Genre.ACTION, "Avengers Age of Ultron", 120, "Avengers Director")
				, new Movie(9, Genre.HORROR, "Scream Part II", 135, "Director 2")
				, new Movie(10, Genre.HORROR, "Last Night Part II", 156, "Horror Director"))
			);
		
		service = new MovieService(repository);
	}
	
	@Test
	public void testMovieByName() {
		assertEquals(Arrays.asList(
			new Movie(1, Genre.ACTION, "Avengers", 120, "Joss Whedon")
			, new Movie(8, Genre.ACTION, "Avengers Age of Ultron", 120, "Avengers Director"))
		, service.findMoviesByName("avengers"));
		
		assertEquals(Arrays.asList(
			new Movie(2, Genre.HORROR, "Scream", 135, "Director 1")
			, new Movie(9, Genre.HORROR, "Scream Part II", 135, "Director 2"))
		, service.findMoviesByName("scream"));
		
		assertEquals(Arrays.asList(
			new Movie(5, Genre.HORROR, "Last Night", 156, "Horror Director")
			, new Movie(10, Genre.HORROR, "Last Night Part II", 156, "Horror Director"))
		, service.findMoviesByName("night"));
	}
	
	@Test
	public void testMovieByDirector() {
		assertEquals(Arrays.asList(
			new Movie(2, Genre.HORROR, "Scream", 135, "Director 1")
			, new Movie(3, Genre.THRILLER, "Memento", 136, "Director 2")
			, new Movie(5, Genre.HORROR, "Last Night", 156, "Horror Director")
			, new Movie(8, Genre.ACTION, "Avengers Age of Ultron", 120, "Avengers Director")
			, new Movie(9, Genre.HORROR, "Scream Part II", 135, "Director 2")
			, new Movie(10, Genre.HORROR, "Last Night Part II", 156, "Horror Director")
		), service.findMoviesByDirector("director"));
		
		assertEquals(Arrays.asList(
			new Movie(1, Genre.ACTION, "Avengers", 120, "Joss Whedon")
			, new Movie(4, Genre.COMEDY, "There's Someting About Mary", 110, "Josh 2")
			, new Movie(6, Genre.ACTION, "Matrix", 136, "John Wick :)")
			, new Movie(7, Genre.ACTION, "Matrix Recargado", 136, "John Wick :)")
		), service.findMoviesByDirector("jo"));
	}
	
	private MovieService service;
}
