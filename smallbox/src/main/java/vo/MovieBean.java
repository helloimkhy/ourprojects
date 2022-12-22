package vo;

import java.sql.Date;

public class MovieBean {
	private int movie_idx;
	private String movie_title;
	private String movie_grade;
	private String movie_genre;
	private Date movie_open_date;
	private int movie_runtime;
	private String movie_intro; // TEXT를 뭐로 골라야하지.. sql TEXT가 없네
	private String movie_actors;
	private String movie_picture;
	private int movie_viewer;
	
	public int getMovie_idx() {
		return movie_idx;
	}
	public void setMovie_idx(int movie_idx) {
		this.movie_idx = movie_idx;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public String getMovie_grade() {
		return movie_grade;
	}
	public void setMovie_grade(String movie_grade) {
		this.movie_grade = movie_grade;
	}
	public String getMovie_genre() {
		return movie_genre;
	}
	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}
	public Date getMovie_open_date() {
		return movie_open_date;
	}
	public void setMovie_open_date(Date movie_open_date) {
		this.movie_open_date = movie_open_date;
	}
	public int getMovie_runtime() {
		return movie_runtime;
	}
	public void setMovie_runtime(int movie_runtime) {
		this.movie_runtime = movie_runtime;
	}
	public String getMovie_intro() {
		return movie_intro;
	}
	public void setMovie_intro(String movie_intro) {
		this.movie_intro = movie_intro;
	}
	public String getMovie_actors() {
		return movie_actors;
	}
	public void setMovie_actors(String movie_actors) {
		this.movie_actors = movie_actors;
	}
	public String getMovie_picture() {
		return movie_picture;
	}
	public void setMovie_picture(String movie_picture) {
		this.movie_picture = movie_picture;
	}
	public int getMovie_viewer() {
		return movie_viewer;
	}
	public void setMovie_viewer(int movie_viewer) {
		this.movie_viewer = movie_viewer;
	}
	
	@Override
	public String toString() {
		return "MovieDTO [movie_idx=" + movie_idx + ", movie_title=" + movie_title + ", movie_grade=" + movie_grade
				+ ", movie_genre=" + movie_genre + ", movie_open_date=" + movie_open_date + ", movie_runtime="
				+ movie_runtime + ", movie_intro=" + movie_intro + ", movie_actors=" + movie_actors + ", movie_picture="
				+ movie_picture + ", movie_viewer=" + movie_viewer + "]";
	}
	
	
}
