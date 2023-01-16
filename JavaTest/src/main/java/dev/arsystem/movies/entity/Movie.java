package dev.arsystem.movies.entity;

public class Movie {
	
	public Movie(Integer id, Genre genre, String name, Integer minutes, String director) {
		this.id = id;
		this.genre = genre;
		this.name = name;
		this.minutes = minutes;
		this.director = director;
	}
	
	public Movie(Genre genre, String name, int minutes, String director) {
		this(null, genre, name, minutes, director);
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getMinutes() {
		return minutes;
	}
	
	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Movie))
			return false;
		
		Movie movie = (Movie) obj;
		
		return getId().equals(movie.getId());
	}
	
	private Integer id;
	
	private Genre genre;
	
	private String name;
	
	private Integer minutes;
	
	private String director;
}
