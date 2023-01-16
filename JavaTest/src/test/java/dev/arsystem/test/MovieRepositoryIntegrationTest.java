package dev.arsystem.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dev.arsystem.movies.data.MovieRepository;
import dev.arsystem.movies.data.MovieRepositoryJdbc;
import dev.arsystem.movies.entity.Genre;
import dev.arsystem.movies.entity.Movie;

/**
 * 
 * @author Argenis Rodríguez
 * Esta Prueba de Integracion se hizo tomando como base una base de datos SQL de postgresql
 * pero lo correcto es hacerlas con una base de datos de prueba h2
 *
 */
public class MovieRepositoryIntegrationTest {
	
	@Before
	public void setup() {
		repository = new MovieRepositoryJdbc(getTemplate());
	}
	
	@Test
	public void testAllMovies() {
		assertThat(repository.getAll(), is(Arrays.asList(
			new Movie(1, Genre.ACTION, "Dark Knight", 152, "")
			, new Movie(2, Genre.THRILLER, "Memento", 113, "")
			, new Movie(3, Genre.ACTION, "Matrix", 136, "")
			, new Movie(4, Genre.THRILLER, "Super 8", 112, "")
		)));
	}
	
	@Test
	public void testMovieById() {
		assertEquals(new Movie(3, Genre.ACTION, "Matrix", 136, ""), repository.findById(3));
	}
	
	public void insert_a_movie() {
		Movie movie = new Movie(Genre.THRILLER, "Super 8", 112, "");
		
		repository.saveOrUpdate(movie);
	}
	
	private JdbcTemplate getTemplate() {
		if (template != null)
			return template;
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USER, PASSWORD);
		dataSource.setDriverClassName(DRIVERCLASSNAME);
		
		template = new JdbcTemplate(dataSource);
		
		return template;
	}
	
	private MovieRepository repository;
	private JdbcTemplate template;
	
	private static final String URL = "jdbc:postgresql://localhost:5432/curso-junit";
	private static final String USER = "arodriguez";
	private static final String PASSWORD = "Argenis273481541997";
	private static final String DRIVERCLASSNAME = "org.postgresql.Driver";
}
