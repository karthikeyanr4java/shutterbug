package com.kk.project.shutterbug.controller;

import com.kk.project.shutterbug.dto.ResponseDto;
import com.kk.project.shutterbug.dto.ShutterbugDto;
import com.kk.project.shutterbug.utils.MonoUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@RequestMapping("api")
public class ShutterbugController {

    @GetMapping(value = "/getimages", produces = "application/json")
    public Mono<ResponseEntity<ResponseDto>> getImages() {
        log.info("Inside Get image");
        return MonoUtils.exceptionToError(() -> getResponse());
    }

    private Mono<ResponseEntity<ResponseDto>> getResponse() {
        final var shutterbugDto = ShutterbugDto.builder()
                .message("Good Response").build();
        return Mono.just(new ResponseEntity<>(shutterbugDto, HttpStatus.OK));
    }
}
