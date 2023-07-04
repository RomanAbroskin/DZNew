package org.top.dznew.Service;

import org.springframework.stereotype.Service;
import org.top.dznew.Records.Records;

@Service
public interface SolverInputOutput {
Records.OutputDataMessage solver(Records.InputDataMessage inputDataMessage);
}
