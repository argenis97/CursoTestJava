package dev.arsystem.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import dev.arsystem.movies.data.MovieRepository;
import dev.arsystem.movies.entity.Genre;
import dev.arsystem.movies.entity.Movie;
import dev.arsystem.movies.service.MovieService;

public class MovieServiceTemplateTest {
	
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
				, new Movie(6, Genre.ACTION, "Matrix", 158, "John Wick :)")
				, new Movie(7, Genre.ACTION, "Matrix Recargado", 136, "John Wick :)")
				, new Movie(8, Genre.ACTION, "Avengers Age of Ultron", 168, "Avengers Director")
				, new Movie(9, Genre.HORROR, "Scream Part II", 135, "Director 2")
				, new Movie(10, Genre.HORROR, "Last Night Part II", 156, "Horror Director"))
			);
		
		service = new MovieService(repository);
	}
	
	@Test
	public void testByGenreAndDuration() {
		assertEquals(Arrays.asList(1, 7)
				, getMoviesIds(service.findMoviesByTemplate(new Movie(Genre.ACTION, null, 150, null))));
	}
	
	@Test
	public void testById() {
		assertEquals(Arrays.asList(2)
				, getMoviesIds(service.findMoviesByTemplate(new Movie(2, Genre.HORROR, "Scream", 135, "Director 1"))));
	}
	
	@Test
	public void testByDurationAndName() {
		assertEquals(Arrays.asList(1)
				, getMoviesIds(service.findMoviesByTemplate(new Movie(null, "aven", 150, null))));
	}
	
	@Test
	public void testByDirectorGenderAndDuration() {
		assertEquals(Arrays.asList(1, 7)
				, getMoviesIds(service.findMoviesByTemplate(new Movie(null, Genre.ACTION, null, 150, "jo"))));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testByNegativeDuration() {
		service.findMoviesByTemplate(new Movie(null, Genre.ACTION, null, -1, "jo"));
	}
	
	private static Collection<Integer> getMoviesIds(Collection<Movie> movies) {
		return movies.stream()
				.map(Movie::getId)
				.collect(Collectors.toList());
	}
	
	private MovieService service;
}
