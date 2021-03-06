/*
 * FXGL - JavaFX Game Library. The MIT License (MIT).
 * Copyright (c) AlmasB (almaslvl@gmail.com).
 * See LICENSE for details.
 */

package s03entities;

import com.almasb.fxgl.animation.Animation;
import com.almasb.fxgl.animation.ParallelAnimation;
import com.almasb.fxgl.app.DSLKt;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.settings.GameSettings;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Shows how to init a basic game object and attach it to the world
 * using fluent API.
 *
 * @author Almas Baimagambetov (AlmasB) (almaslvl@gmail.com)
 */
public class AnimationSample4 extends GameApplication {

    // 1. define types of entities in the game using Enum
    private enum Type {
        PLAYER
    }

    // make the field instance level
    // but do NOT init here for properly functioning save-load system
    private Entity player;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("AnimationSample4");
        settings.setVersion("0.1");






    }

    @Override
    protected void initGame() {
        Rectangle rect1 = new Rectangle(40, 40);
        rect1.setTranslateY(50);

        Rectangle rect2 = new Rectangle(40, 40);
        rect2.setTranslateY(100);

        Rectangle rect3 = new Rectangle(40, 40);
        rect3.setTranslateY(150);

        getGameScene().addUINodes(rect1, rect2, rect3);

        Animation<?> anim1 = DSLKt.translate(rect1, new Point2D(100, 50), Duration.seconds(1));
        Animation<?> anim2 = DSLKt.translate(rect2, new Point2D(100, 100), Duration.seconds(1.5));
        Animation<?> anim3 = DSLKt.translate(rect3, new Point2D(100, 150), Duration.seconds(0.4));

        ParallelAnimation anim = new ParallelAnimation(anim1, anim2, anim3);
        //SequentialAnimation anim = new SequentialAnimation(anim1, anim2, anim3);
        anim.setCycleCount(2);
        anim.setAutoReverse(true);
        anim.setOnFinished(() -> System.out.println("finished"));
        anim.start(getStateMachine().getPlayState());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
