package kz.example.currencylimit.endpoint;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.example.currencylimit.model.dto.LimitCreateDto;
import kz.example.currencylimit.model.dto.LimitResponseDto;
import kz.example.currencylimit.service.LimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static kz.example.currencylimit.constants.swagger.LimitSwaggerConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/limit")
@Tag(name = NAME_OF_LIMIT_SERVICE,description = DESCRIPTION_OF_LIMIT_CONTROLLER)
public class LimitController {

    private final LimitService service;
    @PostMapping
    @Operation(description = DESCRIPTION_OF_FOR_CREATING_LIMIT)
    public ResponseEntity<LimitResponseDto> create(@RequestBody LimitCreateDto limitCreateDto){
        return ResponseEntity.ok(service.createLimit(limitCreateDto));
    }
    @GetMapping("/all")
    @Operation(description = DESCRIPTION_OF_FOR_GET_ALL_LIMITS)
    public ResponseEntity<List<LimitResponseDto>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

}
