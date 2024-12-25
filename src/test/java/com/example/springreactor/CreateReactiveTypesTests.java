package com.example.springreactor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CreateReactiveTypesTests {

    @Test
    public void createAFlux_just() {
        Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");
        fruitFlux.subscribe(System.out::println);
        StepVerifier.create(fruitFlux).expectNext("Apple", "Orange", "Grape", "Banana", "Strawberry").verifyComplete();
    }

    @Test
    public void createAFlux_fromArray() {
        String[] fruits = new String[] {"Apple", "Orange", "Grape", "Banana", "Strawberry"};
        Flux<String> fruitFlux = Flux.fromArray(fruits);
        StepVerifier.create(fruitFlux).expectNext("Apple", "Orange", "Grape", "Banana", "Strawberry").verifyComplete();
    }

    @Test
    public void createAFlux_fromIterable() {
        List<String> fruitList = new ArrayList<>();
        fruitList.add("Apple");
        fruitList.add("Orange");
        fruitList.add("Grape");
        fruitList.add("Banana");
        fruitList.add("Strawberry");
        Flux<String> fruitFlux = Flux.fromIterable(fruitList);
        StepVerifier.create(fruitFlux).expectNext("Apple", "Orange", "Grape", "Banana", "Strawberry").verifyComplete();
    }

    @Test
    public void createAFlux_range() {
        Flux<Integer> integerFlux = Flux.range(1, 5);
        StepVerifier.create(integerFlux).expectNext(1, 2, 3, 4, 5).verifyComplete();
    }

    @Test
    public void createAFlux_interval() {
        Flux<Long> integerFlux = Flux.interval(Duration.ofSeconds(1)).take(5);
        StepVerifier.create(integerFlux).expectNext(0L, 1L, 2L, 3L, 4L).verifyComplete();
    }

}
