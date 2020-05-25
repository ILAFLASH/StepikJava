/*На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y. Ось X
        смотрит слева направо, ось Y — снизу вверх. (Помните, как рисовали графики функций в школе?)

        В начальный момент робот находится в некоторой позиции на поле. Также известно, куда робот смотрит: вверх, вниз,
        направо или налево. Ваша задача — привести робота в заданную точку игрового поля.

        Робот описывается классом Robot. Вы можете пользоваться следующими его методами (реализация вам неизвестна):*/

package com.stepik.lesson2;

public class Robot {
    int x = 0;
    int y = 0;
    Direction direction = Direction.UP;

    public Direction getDirection() {
        // текущее направление взгляда
        return direction;
    }

    public int getX() {
        // текущая координата X
        return x;
    }

    public int getY() {
        // текущая координата Y
        return y;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        if (toX > robot.getX()) {
            while (robot.getDirection() != Direction.RIGHT) {
                robot.turnRight();
            }
            while (robot.getX() != toX) {
                robot.stepForward();
            }
        } else {
            if (toX < robot.getX()) {
                while (robot.getDirection() != Direction.LEFT) {
                    robot.turnRight();
                }
                while (robot.getX() != toX) {
                    robot.stepForward();
                }
            }
        }
        if (toY > robot.getY()) {
            while (robot.getDirection() != Direction.UP) {
                robot.turnRight();
            }
            while (robot.getY() != toY) {
                robot.stepForward();
            }
        } else {
            if (toY < robot.getY()) {
                while (robot.getDirection() != Direction.DOWN) {
                    robot.turnRight();
                }
                while (robot.getY() != toY) {
                    robot.stepForward();
                }
            }
        }
    }

    public static void main(String[] args) {
        Robot r2d2 = new Robot();
        moveRobot(r2d2, 3, 7);
    }
}