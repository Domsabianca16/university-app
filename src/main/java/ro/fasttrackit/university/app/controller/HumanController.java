package ro.fasttrackit.university.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.university.app.model.Human;
import ro.fasttrackit.university.app.service.HumanService;

import java.util.List;

@RestController
public class HumanController {

    private final HumanService humanService;

    public HumanController(HumanService service){
        this.humanService = service;
    }

   @GetMapping("api/humans/{id}")
    public ResponseEntity<List<Human>> getHumanById(@PathVariable("id") Long humanId){
       return ResponseEntity.ok(humanService.getHumanById(humanId));
    }

    @GetMapping("/api/humans")
    public ResponseEntity<List<Human>> getAllHumans(){
        return ResponseEntity.ok(humanService.getAllHumans());
    }

   @PutMapping("/api/humans/{id}")
    public ResponseEntity<String> updateById(@PathVariable("id") Long humanId,
                                             @RequestBody Human humanRequest){
        this.humanService.createOrUpdateHuman(humanRequest);
        return ResponseEntity.ok().build();
   }

   @PostMapping("/api/humans")
    public ResponseEntity createHumans(@RequestBody Human humanRequest){
        this.humanService.createOrUpdateHuman(humanRequest);
        return ResponseEntity.ok().build();
   }

   @DeleteMapping("/api/humans/{id}")
   public ResponseEntity<List<Human>> DeleteHumanById(@PathVariable("id") Long humanId){
       return ResponseEntity.ok(humanService.getHumanById(humanId));
   }



}
