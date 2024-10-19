package hu.exercise.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.exercise.movie.entity.CallSearchMovie;

@Repository
public interface CallSearchMovieRepository extends JpaRepository<CallSearchMovie, Integer> {

}
