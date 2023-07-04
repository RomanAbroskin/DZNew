package org.top.dznew.Service;

import org.springframework.stereotype.Service;
import org.top.dznew.Records.Records;

@Service
public class StandartSolver implements SolverInputOutput{
    @Override
    public Records.OutputDataMessage solver(Records.InputDataMessage inputDataMessage) {

        Double a=inputDataMessage.metor();
        Double b=inputDataMessage.killometr();
        Double c=inputDataMessage.mille();

        Double MetorKillometr=a/1000;
        Double KillometrMetor=b*1000.0;
        Double MilleKillometr=c*1.609;

        return new Records.OutputDataMessage(MetorKillometr,KillometrMetor,MilleKillometr);
    }
}
