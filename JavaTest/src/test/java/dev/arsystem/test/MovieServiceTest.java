package dev.arsystem.test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import dev.arsystem.movies.data.MovieRepository;
import dev.arsystem.movies.entity.Genre;
import dev.arsystem.movies.entity.Movie;
import dev.arsystem.movies.service.MovieService;

public class MovieServiceTest {
	
	@Before
	public void setup() {
		MovieRepository repository = Mockito.mock(MovieRepository.class);
		
		Mockito
			.when(repository.getAll())
			.thenReturn(Arrays.asList(
				new Movie(1, Genre.ACTION, "Avengers", 120, "")
				, new Movie(2, Genre.HORROR, "Scream", 135, "")
				, new Movie(3, Genre.THRILLER, "Memento", 136, "")
				, new Movie(4, Genre.COMEDY, "There's Someting About Mary", 110, "")
				, new Movie(5, Genre.HORROR, "IT", 156, "")
				, new Movie(6, Genre.ACTION, "Matrix", 136, "")));
		
		service = new MovieService(repository);
	}
	
	@Test
	public void return_movies_by_gender() {
		
		assertThat(service.getMoviesIdByGenre(Genre.HORROR)
				, is(Arrays.asList(2, 5)));
		
		assertThat(service.getMoviesIdByGenre(Genre.ACTION)
				, is(Arrays.asList(1, 6)));
	}
	
	@Test
	public void test_movie_by_duration() {
		
		assertThat(service.getMoviesIdByDuration(136), is(Arrays.asList(3, 6)));
		assertThat(service.getMoviesIdByDuration(120), is(Arrays.asList(1)));
		assertThat(service.getMoviesIdByDuration(135), is(Arrays.asList(2)));
		assertThat(service.getMoviesIdByDuration(110), is(Arrays.asList(4)));
		assertThat(service.getMoviesIdByDuration(156), is(Arrays.asList(5)));
	}
	
	private MovieService service;
}
