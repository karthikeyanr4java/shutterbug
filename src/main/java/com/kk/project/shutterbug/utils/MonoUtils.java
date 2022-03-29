package com.kk.project.shutterbug.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MonoUtils {

    public static <T> Mono<T> exceptionToError(final Supplier<Mono<T>> responseEntityMono) {
        try {
            return responseEntityMono.get();
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

}
