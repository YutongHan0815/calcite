package org.apache.calcite.plan;

import org.apache.calcite.plan.volcano.VolcanoPlanner;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.metadata.RelMetadataQuery;

import java.io.IOException;

public class RuntimeCost {

    public RelMetadataQuery mq;
    public VolcanoPlanner planner;

    public RuntimeCost(RelMetadataQuery mq, RelOptPlanner planner) {
        this.mq = mq;
        this.planner = (VolcanoPlanner) planner;

    }

    public boolean isLe(RelNode left, RelNode right) {
        try {
            return planner.getCost(left, mq).isLe(planner.getCost(right));
        } catch (Exception e) {
            throw new RuntimeException("IO errors");
        }

    }

    public boolean isLt(RelNode left, RelNode right) {
        try {
            return planner.getCost(left, mq).isLt(planner.getCost(right));
        } catch (Exception e) {
            throw new RuntimeException("IO errors");
        }
    }

    public boolean equals(RelNode left, RelNode right) {
        try {
            return planner.getCost(left, mq).equals(planner.getCost(right));
        } catch (Exception e) {
            throw new RuntimeException("IO errors");
        }
    }

    public boolean isEqWithEpsilon(RelNode left, RelNode right) {
        try {
            return planner.getCost(left, mq).isEqWithEpsilon(planner.getCost(right));
        } catch (Exception e) {
            throw new RuntimeException("IO errors");
        }
    }
}
