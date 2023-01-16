package dev.arsystem.movies.data;

import java.util.Collection;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dev.arsystem.movies.entity.Genre;
import dev.arsystem.movies.entity.Movie;

public class MovieRepositoryJdbc implements MovieRepository {
	
	public MovieRepositoryJdbc(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public Movie findById(int id) {
		return template.queryForObject("SELECT * FROM Movies WHERE id = ?", mapper, id);
	}
	
	@Override
	public Collection<Movie> getAll() {
		return template.query("SELECT * FROM Movies"
				, (rs, rowNum) -> new Movie(rs.getInt("id")
						, Genre.valueOf(rs.getString("Genre"))
						, rs.getString("Name"), rs.getInt("Minutes"), ""));
	}
	
	@Override
	public void saveOrUpdate(Movie movie) {
		if (movie.getId() == null)
			insert(movie);
		else
			update(movie);
	}
	
	private void update(Movie movie) {
		StringBuilder sql = new StringBuilder("UPDATE Movies SET name = ?, genre = ?, minutes = ?")
				.append(" WHERE id = ?");
		
		template.update(sql.toString(), movie.getName()
				, movie.getGenre().name()
				, movie.getMinutes(), movie.getId());
	}
	
	private void insert(Movie movie) {
		StringBuilder sql = new StringBuilder("INSERT INTO Movies (name, genre, minutes)")
				.append(" VALUES (?, ?, ?)");
		
		template.update(sql.toString(), movie.getName()
				, movie.getGenre().name()
				, movie.getMinutes());
	}
	
	private JdbcTemplate template;
	
	private RowMapper<Movie> mapper = (rs, rowNum) -> new Movie(rs.getInt("id")
			, Genre.valueOf(rs.getString("genre"))
			, rs.getString("name"), rs.getInt("minutes"), "");
}
