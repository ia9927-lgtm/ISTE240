// Adil Nurmagambetov UID:415002457
package com.group.f1stats.controller;


import com.group.f1stats.model.Result;
import com.group.f1stats.service.ResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {
    private final ResultService resultService;

    public ResultController(ResultService resultService){
        this.resultService = resultService;
    }

    @GetMapping
    public List<Result> findAll(){
        return resultService.findAll();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id){
        return resultService.findById(id);
    }


    @GetMapping("/search")
    public List<Result> findByDriverId(@RequestParam Long driverId){
        return resultService.findByDriverId(driverId);
    }

    @PostMapping
    public Result createResult(@RequestBody Result result){
        return resultService.createResult(result);
    }

    @PutMapping("/{id}")
    public Result updateResult(@PathVariable Long id, @RequestBody Result result){
        return resultService.updateResult(id, result);
    }

    @DeleteMapping("/{id}")
    public void deleteResult(@PathVariable Long id){
        resultService.deleteById(id);
    }







}
