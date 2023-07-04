package org.top.dznew.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.top.dznew.Records.Records;
import org.top.dznew.Service.SolverInputOutput;

import java.io.IOException;



@RestController
public class Main {

    private final SolverInputOutput solverInputOutput;

    public Main(SolverInputOutput solverInputOutput) {
        this.solverInputOutput = solverInputOutput;
    }

    @GetMapping("/ping")
    public Records.Message ping() throws IOException {
     String server = Runtime.getRuntime().exec("hostname").toString();
             return new Records.StringMessage("Server Name"+server);
    }

    @GetMapping("/status")
    public Records.Message status(){
        String status = ("the server is available and running");
        return new Records.StringMessage (status);
    }

    @PostMapping("/solve")
    public Records.Message solve (@RequestBody Records.InputDataMessage inputDataMessage){
        try {
            Records.OutputDataMessage result = solverInputOutput.solver(inputDataMessage);
            if (result == null) {
                return new Records.ErrorMessage("result is null, check data correctness");
            }
            return result;
        } catch (Exception ex) {
            return new Records.ErrorMessage(ex.getMessage());
        }
}}
