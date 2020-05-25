package com.stepik.lesson5;

public class Robot {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        int i = 0;
        boolean isRobotReachThePoint = false;
        while (i < 3){
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()){
                robotConnection.moveRobotTo(toX, toY);
                isRobotReachThePoint = true;
                i = 3;
            } catch (RobotConnectionException rce) {
                if (isRobotReachThePoint) {
                    i = 3;
                }
                else {
                    i++;
                    if (i == 3) {
                        throw new RobotConnectionException("3", rce);
                    }
                }
            } catch (Throwable e) {
                throw e;
            }
        }
    }

//    // Соединение с роботом
//    RobotConnection robotConnection = robotConnectionManager.getConnection();
//    // Команда на перемещение
//        robotConnection.moveRobotTo(toX,toY);
//    // Закрытие соединения
//        robotConnection.close();


    public static void main(String[] args) {

    }
}
