package hu.exercise.movie.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@Configuration
public class RedisConfiguration {

	public static final String OMDB_CACHE_NAME = "omdbCache";
	public static final String TMDB_CACHE_NAME = "tmdbCache";
	
	@Value(value = "${cache.duration.minutes.omdb}")
	Integer omdbDuration = 60;
	
	@Value(value = "${cache.duration.minutes.tmdb}")
	Integer tmdbDuration = 60;

	@Bean
	public RedisCacheConfiguration cacheConfiguration() {
		return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(60)).disableCachingNullValues()
				.serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
	}

	@Bean
	public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
		return (builder) -> builder
				.withCacheConfiguration(OMDB_CACHE_NAME,
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(omdbDuration)))
				.withCacheConfiguration(TMDB_CACHE_NAME,
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(tmdbDuration)));
	}

}
