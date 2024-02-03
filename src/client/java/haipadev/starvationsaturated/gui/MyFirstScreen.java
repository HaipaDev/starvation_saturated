package haipadev.starvationsaturated.gui;

import io.wispforest.owo.ui.base.BaseOwoScreen;
import io.wispforest.owo.ui.base.BaseUIModelScreen;
import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.OwoUIAdapter;
import io.wispforest.owo.ui.core.Surface;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

//public class MyFirstScreen extends BaseOwoScreen<FlowLayout> {
//
//    @Override
//    protected @NotNull OwoUIAdapter<FlowLayout> createAdapter() {
//        return OwoUIAdapter.create(this, Containers::verticalFlow);
//    }
//
//    @Override
//    protected void build(FlowLayout rootComponent) {
//        rootComponent.surface(Surface.VANILLA_TRANSLUCENT);
//    }
//}
public class MyFirstScreen extends BaseUIModelScreen<FlowLayout> {

    public MyFirstScreen() {
        super(FlowLayout.class, DataSource.asset(new Identifier("starvationsaturated", "my_ui_model")));
    }

    @Override
    protected void build(FlowLayout rootComponent) {
        Objects.requireNonNull(rootComponent.childById(ButtonComponent.class, "the-button")).onPress(button -> {
            System.out.println("click");
        });
    }
}