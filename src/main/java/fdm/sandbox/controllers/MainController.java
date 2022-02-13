package fdm.sandbox.controllers;

import fdm.sandbox.domain.Parcel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/v1/parcels")
@Validated
public class MainController {

    @PostMapping()
    public ResponseEntity<?> postParcel(@Valid @RequestBody Parcel parcel){

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getParcel(@RequestParam @NotBlank String test){

        return ResponseEntity.ok().build();
    }

}
