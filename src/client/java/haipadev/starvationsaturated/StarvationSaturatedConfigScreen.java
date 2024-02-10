package haipadev.starvationsaturated;

import haipadev.starvationsaturated.api.ItemValues;
import haipadev.starvationsaturated.api.ItemValuesMap;
import io.wispforest.owo.config.Option;
import io.wispforest.owo.config.ui.ConfigScreen;
import io.wispforest.owo.config.ui.OptionComponentFactory;
import io.wispforest.owo.config.ui.component.OptionValueProvider;
import io.wispforest.owo.config.ui.component.SearchAnchorComponent;
import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.Insets;
import io.wispforest.owo.ui.core.Positioning;
import io.wispforest.owo.ui.core.Sizing;
import io.wispforest.owo.ui.core.VerticalAlignment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StarvationSaturatedConfigScreen extends ConfigScreen {
    public StarvationSaturatedConfigScreen(@Nullable Screen parent) {
        super(DEFAULT_MODEL_ID, StarvationSaturated.CONFIG, parent);

        this.extraFactories.put(option -> option.backingField().field().getName().equals("itemValues"), ITEMS_CONFIG_FACTORY);
    }

    private static final OptionComponentFactory<Map<Item, ItemValues>> ITEMS_CONFIG_FACTORY = (model, option) -> {
        var container = new ItemsConfigContainer(option);
        return new OptionComponentFactory.Result<>(container, container);
    };

    private static class ItemsConfigContainer extends FlowLayout implements OptionValueProvider {
        protected Map<Item, ItemValues> backingMap;
        protected ItemsConfigContainer(Option<Map<Item, ItemValues>> option) {
            super(Sizing.fill(100), Sizing.content(), Algorithm.VERTICAL);
            this.backingMap = new HashMap<>(option.value());
                var optionGrid = Containers.grid(Sizing.fill(100), Sizing.content(), MathHelper.ceilDiv(backingMap.size(), 2), 10);
                for(int i=0;i<backingMap.size();i++){
//                    var layout = Containers.horizontalFlow(
//                        Sizing.content(), Sizing.content()
//                    );
                    var layout = Containers.collapsible(
                        Sizing.content(), Sizing.content(),
                        Text.of((String) backingMap.keySet().toArray()[i]),
                        true
                );
                    optionGrid.child(layout,0,i);
                }
                this.child(optionGrid);
//            for (var targetType : StarvationSaturated.TARGET_TYPE) {
//                var layout = Containers.collapsible(
//                        Sizing.content(), Sizing.content(),
//                        Text.translatable("targetType." + StarvationSaturated.TARGET_TYPE.getId(targetType).toTranslationKey()),
//                        true
//                );
//                this.child(layout);
//            }
        }

        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public Object parsedValue() {
            return this.backingMap;
        }
    }
}
