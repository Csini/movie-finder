package hu.exercise.movie.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CALL_SEARCHMOVIE")
public class CallSearchMovie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "API_NAME")
	@NotNull
	@Enumerated(EnumType.STRING)
	private SearchMovieApiName apiName;

	@Column(name = "MOVIE_TITLE")
	@NotNull
	private String movieTitle;

	@Column(name = "CREATED_ON")
	@CreationTimestamp
	private LocalDateTime createdOn;
	
	public static CallSearchMovieBuilder omdb() {
		return builder().apiName(SearchMovieApiName.OMDB);
	}
	
	public static CallSearchMovieBuilder themoviedb() {
		return builder().apiName(SearchMovieApiName.THEMOVIEDB);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CallSearchMovie other = (CallSearchMovie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}