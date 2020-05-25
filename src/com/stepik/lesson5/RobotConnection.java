package com.stepik.lesson5;

public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
    void close();
}
