package com.course.oop.threadprac.threadhw.model;

import java.util.*;

public class Scientist {

    private final Map<RobotDetail, Integer> robotDetail = new EnumMap<>(RobotDetail.class);
    private final String name;

    public Scientist(String name) {
        this.name = name;
    }

    public void addRobotDetail(List<RobotDetail> list) {
        list.forEach(detail -> robotDetail.merge(detail, 1, Integer::sum));
    }

    public List<Robot> buildRobots() {
        List<Robot> robots = new ArrayList<>();
        Optional<Integer> robotsCount = robotDetail.values().stream().min(Integer::compareTo);
        robotsCount.ifPresent(count -> {
            for (int i = 0; i < count; i++) {
                robotDetail.forEach((k, v) -> robotDetail.merge(k, -1, Integer::sum));
                robots.add(new Robot());
            }
        });
        return robots;
    }

    public String getName() {
        return name;
    }
}
