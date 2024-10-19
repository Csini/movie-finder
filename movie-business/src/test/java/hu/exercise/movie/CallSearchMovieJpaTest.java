package hu.exercise.movie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hu.exercise.movie.entity.CallSearchMovie;
import hu.exercise.movie.entity.SearchMovieApiName;
import hu.exercise.movie.repository.CallSearchMovieRepository;

@DataJpaTest
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { SpringTestConfiguration.class })
public class CallSearchMovieJpaTest {

	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private CallSearchMovieRepository repository;

	@Test
	public void testFindByFirstNameMethod_usingEntityManager() {
		CallSearchMovie expectedCallSearchMovie = new CallSearchMovie();
		expectedCallSearchMovie.setApiName(SearchMovieApiName.OMDB);
		expectedCallSearchMovie.setMovieTitle("bla bla");

		CallSearchMovie actual = repository.save(expectedCallSearchMovie);
		Assertions.assertNotNull(actual.getId());
		Assertions.assertNotNull(actual.getCreatedOn());
		Assertions.assertEquals(expectedCallSearchMovie.getApiName(), actual.getApiName());
		Assertions.assertEquals(expectedCallSearchMovie.getMovieTitle(), actual.getMovieTitle());

	}

}
