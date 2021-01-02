package com.raigarak.apm_god.huds;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class BaseHud {
    protected Stage stage;
    protected Viewport viewport;

    public abstract void update(float dt);

    public Stage getStage() {
        return stage;
    }
}
