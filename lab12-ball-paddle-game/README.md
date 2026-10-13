# Lab 12 – Ball & Paddle Game (JavaFX Animation)

A simple arcade-style game built with JavaFX. A ball bounces around the screen, and the player moves a paddle with the mouse to keep it in play and earn points.

![Gameplay](gameplay.gif)

## How it works
- The ball is animated with a JavaFX `Timeline` that updates its position every 10 ms.
- It bounces off the side and top walls by reversing its direction.
- Hitting the ball with the paddle bounces it back and adds 1 point to the score.
- Missing the ball ends the round and disables the paddle.
- **Play** and **Stop** buttons start and pause the animation.

## My extensions
- [Extension 1, e.g. a Reset button that repositions the ball and sets the score back to 0]
- [Extension 2, e.g. the ball speeds up every 5 points]
- [Extension 3, if any]

**Concepts:** JavaFX animation with `Timeline` and `KeyFrame`, mouse event handling with lambdas, collision detection, `BorderPane` and `FlowPane` layouts, buttons and labels

## Running
Requires the JavaFX SDK to be configured in your project.
