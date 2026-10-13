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
- **Animated starfield background:** 1,000 small stars drift down a black-to-purple gradient using a second `Timeline`, creating a space theme
- **Glowing ball:** a drop-shadow effect gives the ball a neon glow
- **Increasing difficulty:** every 5 points, the ball speeds up by 1.5× and changes to a random colour
- **Reset button:** repositions the ball, resets the score and speed, and re-enables the paddle

**Concepts:** JavaFX animation with `Timeline` and `KeyFrame`, mouse event handling with lambdas, collision detection, `BorderPane` and `FlowPane` layouts, buttons and labels

## Running
Requires the JavaFX SDK. If you're using a modular JavaFX project (for example, IntelliJ's JavaFX template), add your project's package declaration as the first line of each file, e.g.:

`package com.example.demo;`
